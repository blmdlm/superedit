package controller.proprieter;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Author;
import model.Staff;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AuthorService;
import service.MessageService;
import service.ScriptService;
import tool.MyEnum.Style;
import controller.editor.AuthorLibController;

@Controller("proprieterquerymanager")
@RequestMapping("/proprieter/querymanager")
public class QueryManagerController {

	private static final Logger log = LoggerFactory.getLogger(QueryManagerController.class);
	@Autowired
	MessageService messageService;
	@Autowired
	AuthorService authorService;
	@Autowired
	ScriptService scriptService;
	/**
	 * 访问查询作者页面
	 * @return
	 */
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String author(){
		return "/proprieter/querymanager/author";
	}
	/**
	 * 查询作者信息
	 */
	@RequestMapping(value="/author",method=RequestMethod.POST)
	@ResponseBody
	public String[][] queryAuthor(HttpSession session,String name,Model model){
		
		//获取当前登陆者的信息
		//Staff staff=(Staff) session.getAttribute("k_user");
		
		log.info("name"+name);
		//根据作者名模糊查询作者信息
		List<Author> authors= authorService.queryByName(name);
		
		log.info(authors.toString());
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
			
			
			// 样式
			String style=null;
			switch (i%4) {
			case 0:
				style="success";
				break;
			case 1:
				style="warning";
				break;
			case 2:
				style="danger";
				break;
			case 3:
				style="info";
				break;
			}
			
			results[i][10]=style;
		
	}
		return results;
	
	}
	}
	
	
//	@RequestMapping("/author")
//	public String check(HttpSession session,Model model){
//		//获取当前登陆者的信息
//		Staff staff=(Staff) session.getAttribute("k_user");
//		//查询最新注册的10个作者
//		List<Author> authors= authorService.getTop10New();
//		//构造结果集
//		int count = authors.size();
//		String results[][] = new String[count][11];
//		Author author;
//		Long send;
//		Long pass;
//		for (int i = 0; i < count; i++) {
//			author = authors.get(i);
//			results[i][0] = author.getId().toString(); // id
//
//			results[i][1] = author.getName();//姓名
//			if (author.getGender()==0) {  //性别
//				
//				results[i][2] = "男";
//			}else {
//				results[i][2] = "女";
//				
//			}
//					
//			results[i][3] = author.getPhone(); //手机
//			results[i][4] = author.getEmail();//邮箱
//			results[i][5] = author.getAddress();//地址
//			results[i][6] = author.getRegistertime().toString();//注册时间
//			send=scriptService.getSendSumByAuthor(author);
//			
//			if (send.intValue()==0) {
//				results[i][7] = "0"; //投递总数
//				results[i][8] = "0"; //录用总数
//				results[i][9] = "0"; //录用比
//			}else{
//				pass=scriptService.getPassSumByAuthor(author);
//				results[i][7] = send.toString(); //投递总数
//				results[i][8] = pass.toString(); //录用总数
//				results[i][9] = String.valueOf(pass.intValue()/send.intValue());
//			}
//			
//			results[i][10] = String.valueOf(i % 4); // 样式id
//		}
//		// 设置到请求属性中
//		model.addAttribute("results", results);
//
//		String styles[] = { "success", "warning", "danger", "info" };
//		model.addAttribute("styles", styles);
//		//设置到请求属性中
//		return "/editor/authorlib/check";
//	}
	
	

