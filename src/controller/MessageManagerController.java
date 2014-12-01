package controller;

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
	public String gbookManagerCheck() {
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
		List<Messageboard> messes = staffService
				.findPostAuditMessageByPublisher(staff.getPublisher());
		// 设置到请求属性中
		model.addAttribute("messes", messes);

		return "/messagemanager/gbookmanager/postaudit";

	}
	/**
	 * 处理审核留言的请求
	 * @return
	 */
	@RequestMapping(value="/gbookmanager/handleaudit",method=RequestMethod.POST)
	@ResponseBody
	public String gbookManagerHandleAduit(Integer id,Integer status,HttpSession session){
		System.out.println("id+"+id+"status"+status);
		//暂时不考虑多人同时操作！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		// 获取当前登陆者的信息
		Staff staff = (Staff) session.getAttribute("i_user");
		//构建消息实体
		Messageboard mess=new Messageboard();
		mess.setId(id);
		mess.setStaffId(staff.getId());
		mess.setReplyStatus(0);
		if (status!=null) {
			mess.setAuditStatus(status);
		}else{
			//暂时不处理！！！！！！！！！！！！！
		}
		
		return "OK";
	}
	
	
	
	
	
	
	

}
