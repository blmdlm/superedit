package controller.editor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Author;
import model.Message;
import model.Script;
import model.Staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AssistDAO;
import service.AuthorService;
import service.MessageService;
import service.ScriptService;

/**
 * 
 *@Project superedit 
 *@ClassName AuthorLibController
 *@Description  作者库系统的控制器 
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月4日 下午7:43:48
 */
@Controller
@RequestMapping("/editor/authorlib")
public class AuthorLibController {
	private static final Logger log = LoggerFactory.getLogger(AuthorLibController.class);
	@Autowired
	MessageService messageService;
	@Autowired
	AuthorService authorService;
	@Autowired
	ScriptService scriptService;
	/**
	 * 访问作者库系统页面
	 * @return
	 */
	@RequestMapping("/check")
	public String check(HttpSession session,Model model){
		//获取当前登陆者的信息
		Staff staff=(Staff) session.getAttribute("k_user");
		//查询最新注册的10个作者
		List<Author> authors= authorService.getTop10New();
		//构造结果集
		int count = authors.size();
		String results[][] = new String[count][11];
		Author author;
		Long send;
		Long pass;
		for (int i = 0; i < count; i++) {
			author = authors.get(i);
			results[i][0] = author.getId().toString(); // id

			results[i][1] = author.getName();//姓名
			if (author.getGender()==0) {  //性别
				
				results[i][2] = "男";
			}else {
				results[i][2] = "女";
				
			}
					
			results[i][3] = author.getPhone(); //手机
			results[i][4] = author.getEmail();//邮箱
			results[i][5] = author.getAddress();//地址
			results[i][6] = author.getRegistertime().toString();//注册时间
			send=scriptService.getSendSumByAuthor(author);
			
			if (send.intValue()==0) {
				results[i][7] = "0"; //投递总数
				results[i][8] = "0"; //录用总数
				results[i][9] = "0"; //录用比
			}else{
				pass=scriptService.getPassSumByAuthor(author);
				results[i][7] = send.toString(); //投递总数
				results[i][8] = pass.toString(); //录用总数
				results[i][9] = String.valueOf(pass.intValue()/send.intValue());
			}
			
			results[i][10] = String.valueOf(i % 4); // 样式id
		}
		// 设置到请求属性中
		model.addAttribute("results", results);

		String styles[] = { "success", "warning", "danger", "info" };
		model.addAttribute("styles", styles);
		//设置到请求属性中
		return "/editor/authorlib/check";
	}
	
	
	
	/**
	 * 查询最近的一次约稿记录
	 * @return
	 */
	@RequestMapping(value="/solicithistory",method=RequestMethod.POST)
	@ResponseBody
	public Message solicitHistory(HttpSession session,Integer id){
		//获得当前登陆者的信息
		Staff staff=(Staff) session.getAttribute("k_user");
		//查询最近的约稿记录
		Message message=messageService.findLastMessage(staff.getId(),id);
		
		if (message==null) {
			log.info("message=null");
			return null;
		}
		log.info("message="+message.toString());
		
		return message;
		
	}
	
	
	

	
	
	
	/**
	 * 进行约稿
	 * @param session
	 * @return
	 */
	@RequestMapping("/solicit")
	@ResponseBody
	public String solicit(HttpSession session,Integer id,String message){
		//获得当前登陆者的信息
		Staff staff=(Staff) session.getAttribute("k_user");
		//构造留言
		Message mess =new Message();
		mess.setContent(message);
		mess.setSendid(staff.getId());
		mess.setSendstate(10);
		mess.setRecvid(id);
		mess.setRecvstate(11);
		mess.setTime(new Date());
		//存储留言
		messageService.save(mess);
		
		return "OK";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
