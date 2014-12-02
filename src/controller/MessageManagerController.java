package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Messageboard;
import model.Publisher;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AuthorService;
import service.MessageBoardService;
import service.StaffService;

/**
 * 留言管理人员的控制器
 * 
 * @Project superedit
 * @ClassName MessageManagerController
 * @Description TODO
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年11月29日 下午9:21:15
 */
@Controller
@RequestMapping("/messagemanager")
public class MessageManagerController {
	private static Logger logger = Logger
			.getLogger(MessageManagerController.class);
	@Autowired
	StaffService staffService;
	@Autowired
	MessageBoardService messageBoardService;
	@Autowired
	AuthorService authorService;
	/**
	 * 个人首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/messagemanager/index";
	}

	/**************************************** 用户中心 **************************************/

	/**
	 * 用户中心首页
	 * 
	 * @return
	 */
	@RequestMapping("/usercenter")
	public String userCenter() {
		return "/messagemanager/usercenter/index";
	}

	/**
	 * 查看个人资料
	 * 
	 * @return
	 */
	@RequestMapping("/usercenter/check")
	public String userCenterCheck(HttpSession session, Model model) {
		return "/messagemanager/usercenter/check";

	}

	/**
	 * 修改资料界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/usercenter/update", method = RequestMethod.GET)
	public String userCenterUpdate(Model model) {
		model.addAttribute("staff", new Staff());
		return "/messagemanager/usercenter/update";
	}

	/**
	 * 处理修改资料
	 * 
	 * @param staff
	 * @return
	 */
	@RequestMapping(value = "/usercenter/update", method = RequestMethod.POST)
	public String userCenterUpdate(Staff staff, HttpSession session) {

		staff.setId(((Staff) session.getAttribute("i_user")).getId());
		Publisher publisher = new Publisher();
		publisher.setId(1);
		staff.setPublisher(publisher);
		// 更新一次
		staffService.update(staff);
		// 重新取一次
		staff = staffService.get(staff.getId());
		// 刷新session
		session.setAttribute("i_user", staff);
		return "redirect:/messagemanager/usercenter/check";
	}

	/**************************************** 留言管理 **************************************************/
	/**
	 * 访问查看留言板界面
	 * 
	 * @return
	 */
	@RequestMapping("/gbookmanager/check")
	public String gbookManagerCheck(Model model) {
		//查询所有的留言
		List<Messageboard> messes=messageBoardService.findAllPassed();
		//构建results 和replys
		int count=messes.size();
		String results[][]=new String [count][5];
		String replys[][]=new String [count][3];
		Messageboard mess;
		Messageboard reply;
		for (int i = 0; i < count; i++) {
			mess=messes.get(i);
			results[i][0]=authorService.get(mess.getSendId()).getName(); //姓名
			results[i][1]=mess.getSendTime().toString();  //发送时间
			results[i][2]=mess.getContent();//留言内容
			
			if (mess.getReplyStatus()==1) {//如果有回复
				results[i][3]="1";  //标志位有回复
				results[i][4]=String.valueOf(i);   //条数
				//通过parentid找到回复
				List<Messageboard> replysList=messageBoardService.findByParentid(mess.getId());
				//暂时不考虑多条回复的问题！！！！！！！！！！！！！！！！！！！！！！！
				reply=replysList.get(0);
				replys[i][0]=staffService.get(reply.getSendId()).getName();//回复者姓名
				replys[i][1]=reply.getSendTime().toString();//发送时间
				replys[i][2]=reply.getContent();//回复内容
				
			}
			
		}
		//设置为request属性
		model.addAttribute("results", results);
		model.addAttribute("replys", replys);
		return "/messagemanager/gbookmanager/check";
	}

	/**
	 * 访问待审核留言界面
	 * 
	 * @return
	 */
	@RequestMapping("/gbookmanager/postaudit")
	public String gbookManagerPostAduit(HttpSession session, Model model) {
		// 获取当前登陆者的信息
		Staff staff = (Staff) session.getAttribute("i_user");
		// 查找该杂志社未审核的留言记录
		List<Messageboard> messes = messageBoardService
				.findPostAuditMessageByPublisher(staff.getPublisher());
		//构建结果
		int count=messes.size();
		String results[][]=new String[count][4];
		Messageboard mess;
		for (int i = 0; i < count; i++) {
			mess=messes.get(i);
			results[i][0]=mess.getId().toString();    //id
			results[i][1]=mess.getSendTime().toString();  //时间
			results[i][2]=mess.getContent();//留言内容
			results[i][3]=String.valueOf(i%4); //样式id
		}
		//设置到request属性中
		model.addAttribute("results", results);

		String styles[]={"success","warning","danger","info"};
		model.addAttribute("styles", styles);

		return "/messagemanager/gbookmanager/postaudit";

	}
	/**
	 * 处理审核留言的请求
	 * @return
	 */
	@RequestMapping(value="/gbookmanager/handleaudit",method=RequestMethod.POST)
	@ResponseBody
	public String gbookManagerHandleAduit(Integer id,Integer status,HttpSession session){
		//暂时不考虑多人同时操作！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		// 获取当前登陆者的信息
		
		logger.info("id"+id+" status"+status);
		Staff staff = (Staff) session.getAttribute("i_user");
		//构建消息实体
		Messageboard mess=messageBoardService.get(id);
		mess.setStaffId(staff.getId());
		mess.setReplyStatus(0);
		if (status!=null) {
			mess.setAuditStatus(status);
		}else{
			//暂时不处理！
		}
		//持久化
		messageBoardService.update(mess);
		return "OK";
	}
	/**
	 * 访问未回复留言页面
	 * @return
	 */
	@RequestMapping(value="/gbookmanager/unreply")
	public String gbookManagerUnreply(HttpSession session,Model model){
		//获取当前登陆者信息
		Staff staff = (Staff) session.getAttribute("i_user");
		//获取该杂志社未回复留言
		List<Messageboard> messes = messageBoardService
				.findUnreplyMessageByPublisher(staff.getPublisher());
		//构建结果
		int count=messes.size();
		String results[][]=new String[count][5];
		for (int i = 0; i < count; i++) {
			results[i][0]=messes.get(i).getId().toString();
			results[i][1]=messes.get(i).getSendTime().toString();
			results[i][2]=authorService.get(messes.get(i).getSendId()).getName();
			results[i][3]=messes.get(i).getContent();
			results[i][4]=String.valueOf(i%4);
		}
		//设置到request属性中
		model.addAttribute("results", results);

		String styles[]={"success","warning","danger","info"};
		model.addAttribute("styles", styles);
		//返回页面
		return "/messagemanager/gbookmanager/unreply";
	}
	/**
	 * 处理回复留言请求
	 * @return
	 */
	@RequestMapping(value="/gbookmanager/reply",method=RequestMethod.POST)
	@ResponseBody
	public String gbookManagerReply(HttpSession session,Integer id,String content){
		//获取当前登陆者信息
		Staff staff = (Staff) session.getAttribute("i_user");
		//构建消息实体
		Messageboard oldmess=messageBoardService.get(id);
		oldmess.setReplyStatus(1);
		messageBoardService.update(oldmess);
		
		Messageboard mess=new Messageboard();
		mess.setSendId(staff.getId());
		mess.setContent(content);
		mess.setSendTime(new Date());
		mess.setParentid(id);
		mess.setType(1);
		messageBoardService.save(mess);
		
		return "OK";
		
	}
	
	
	

}
