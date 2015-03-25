package controller.proprieter;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Audit;
import model.Author;
import model.Compose;
import model.Proofread;
import model.Script;
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

import service.AuditService;
import service.AuthorService;
import service.ComposeService;
import service.MessageService;
import service.ProofreadService;
import service.ScriptService;
import service.StaffService;
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
	@Autowired
	AuditService auditService;
	@Autowired
	StaffService staffService;
	@Autowired
	ProofreadService proofreadService;
	@Autowired
	ComposeService composeService;
	
	/**
	 * 访问查询稿件页面
	 * @return
	 */
	@RequestMapping(value="/script",method=RequestMethod.GET)
	public String script(){
		return "/proprieter/querymanager/script";
	}
	
	/**
	 * 查询稿件基本信息
	 * @param session
	 * @param title
	 * @return
	 */
	@RequestMapping(value="/script",method=RequestMethod.POST)
	@ResponseBody
	public String[][] script(HttpSession session,String title){
		
		log.info("title: "+title);
		//获取当前登陆者的信息
		Staff staff=(Staff) session.getAttribute("h_user");
		//模糊查询稿件信息
		List<Script> scripts=scriptService.queryByTitle(staff.getPublisher(),title);
		//构建结果集
		int count = scripts.size();
		String results[][] = new String[count][9];
		Script script;
		String state=null;
		for (int i = 0; i < count; i++) {
			script = scripts.get(i);
			
			results[i][0] = script.getId().toString(); // id
			results[i][1] = script.getTitle();//标题		
			results[i][2] = script.getAuthor().getId().toString(); //作者id
			results[i][3] = script.getAuthor().getName(); //作者名称
			results[i][4] = script.getMagazine().getId().toString();//杂志id
			results[i][5] = script.getMagazine().getName();//杂志名称
			results[i][6] = script.getDate().toString();//投递时间

			switch (script.getState()) {
			case 1:
				//表示处理中
				state="审核中";
				break;
			case 2:
				state="通过";
				break;
			case 3:	
				state="不通过";
				break;
			}
			results[i][7] = state;//处理状态
			
			
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
			
			results[i][8]=style;
		
	}
		return results;
	

	}
	
	/**
	 * 查询稿件的详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/scriptbasicdetail",method=RequestMethod.POST)
	@ResponseBody
	public String[] basicDetail(HttpSession session,Integer id){
		log.info("id"+id);
		//获取当前登陆者的信息
		Staff staff=(Staff) session.getAttribute("h_user");
		//查询稿件信息
		Script script=scriptService.get(id);
		//构建结果
		String result[]=new String [10];
		//基本信息
		result[0]=script.getTitle();    //标题
		result[1]=script.getSummary();    //摘要
		result[2]=script.getAuthor().getName();    //作者
		result[3]=script.getState().toString();  //状态
		return result;		
	}
	
	/**
	 * 查询一个稿件最新的审核记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/audit",method=RequestMethod.POST)
	@ResponseBody
	public String audit(int id){
		Audit audit=auditService.getNewest(id);
		String result=null;
		switch (audit.getAuditState()) {
		case 0:            //待审核
			result="待审核";
			break;
		case 1:            //审核中
			result="审核中\t"+staffService.get(audit.getStaffId()).getName()+"\t"+audit.getAuditDate();
			break;
		case 2:            //审核通过
			result="审核通过\t"+staffService.get(audit.getStaffId()).getName()+"\t"+audit.getAuditDate();
			break;
		case 3:            //审核不通过
			result="审核不通过\t"+staffService.get(audit.getStaffId()).getName()+"\t"+audit.getAuditDate();
			break;

		default:			
			break;
		}
				
		return result;
		
	}
	/**
	 * 查询一个稿件最新的校对记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/proofread",method=RequestMethod.POST)
	@ResponseBody
	public String proofread(int id){
		Proofread  proofread;
		try {
			proofread=proofreadService.getNewest(id);
		} catch (Exception e) {
			return "";
		}
	
		String result=null;
		switch (Integer.valueOf(proofread.getProofState()).intValue()) {
		case 0:            //待校对
			result="待校对";
			break;
		case 1:            //校对中
			result="校对中\t"+staffService.get(proofread.getStaffId()).getName()+"\t"+proofread.getProofDate();
			break;
		case 2:            //校对完成
			result="校对完成\t"+staffService.get(proofread.getStaffId()).getName()+"\t"+proofread.getProofDate();
			break;
	
		default:			
			break;
		}
		
		return result;
		
	}
	/**
	 * 查询一个稿件最新的排版记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/compose",method=RequestMethod.POST)
	@ResponseBody
	public String compose(int id){
		Compose compose;
		try {
			compose=composeService.getNewest(id);
		} catch (Exception e) {
			return "";
		}
		
		String result=null;
		switch (compose.getComposeState()) {
		case 0:            //待排版
			result="待排版";
			break;
		case 1:            //排版中
			result="排版中\t"+staffService.get(compose.getStaffId()).getName()+"\t"+compose.getComposeDate();
			break;
		case 2:            //排版完成
			result="排版完成\t"+staffService.get(compose.getStaffId()).getName()+"\t"+compose.getComposeDate();
			break;			
		default:			
			break;
		}
		
		return result;
		
	}
	
	
	
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
	public String[][] author(HttpSession session,String name){
		//根据作者名模糊查询作者信息
		List<Author> authors= authorService.queryByName(name);
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
	
	

	
	

