package controller.proprieter;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Audit;
import model.Author;
import model.Compose;
import model.Payment;
import model.Proofread;
import model.Publisher;
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
import service.PaymentService;
import service.ProofreadService;
import service.ScriptService;
import service.StaffService;
import tool.MyEnum.Style;
import controller.editor.AuthorLibController;

@Controller("proprieterquerymanager")
@RequestMapping("/proprieter/querymanager")
public class QueryManagerController {

	private static final Logger log = LoggerFactory
			.getLogger(QueryManagerController.class);
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
	@Autowired
	PaymentService paymentService;

	/**
	 * 访问查询稿件页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/scriptsearch", method = RequestMethod.GET)
	public String script() {
		return "/proprieter/querymanager/scriptsearch";
	}

	/**
	 * 模糊查询稿件
	 * 
	 * @param session
	 * @param title
	 * @return
	 */
	@RequestMapping(value = "/scriptsearch", method = RequestMethod.POST)
	@ResponseBody
	public String[][] script(HttpSession session, String title) {

		// 获取当前登陆者的信息
		Staff staff = (Staff) session.getAttribute("h_user");
		// 模糊查询稿件信息
		List<Script> scripts = scriptService.queryByTitle(staff.getPublisher(),
				title);
		// 构建结果集
		int count = scripts.size();
		String results[][] = new String[count][7];
		Script script;
		String state = null;
		for (int i = 0; i < count; i++) {
			script = scripts.get(i);

			results[i][0] = script.getId().toString(); // id
			results[i][1] = script.getTitle();// 标题
			results[i][2] = script.getAuthor().getId().toString(); // 作者id
			results[i][3] = script.getAuthor().getName(); // 作者名称
			results[i][4] = script.getDate().toString();// 投递时间
			results[i][5] = script.getSummary();// 摘要

			// 样式
			String style = null;
			switch (i % 5) {
			case 0:
				style = "panel-primary";
				break;
			case 1:
				style = "panel-success";
				break;
			case 2:
				style = "panel-info";
				break;
			case 3:
				style = "panel-warning";
				break;
			case 4:
				style = "panel-danger";
				break;
			}

			results[i][6] = style;

		}
		return results;

	}

	/**
	 * 查看稿件详细信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/scriptdetail", method = RequestMethod.GET)
	public String scriptdetail(Model model, int id) {
		// 这里有bug 可能可以看到其他人不在其杂志社的消息！！！！！！！！！！！！！！

		Script script = scriptService.get(id);
		// 构建结果集
		String result[] = new String[9];
		String state = null;

		result[0] = script.getId().toString(); // id
		result[1] = script.getTitle();// 标题
		result[2] = script.getAuthor().getId().toString(); // 作者id
		result[3] = script.getAuthor().getName(); // 作者名称
		result[4] = script.getMagazine().getId().toString();// 杂志id
		result[5] = script.getMagazine().getName();// 杂志名称
		result[6] = script.getDate().toString();// 投递时间

		switch (script.getState()) {
		case 1:
			// 表示处理中
			state = "审核中";
			break;
		case 2:
			state = "通过";
			break;
		case 3:
			state = "不通过";
			break;
		}
		result[7] = state;// 处理状态
		result[8] = script.getSummary(); // 摘要
//		if (script.getState() == 3) {
//			result[9] = "";
//		} else {
//			if (script.getPay() == null) {
//				result[9] = "未知";
//			} else if (script.getPay() == 0) {
//				result[9] = "待设置稿费";
//			} else if (script.getPay() == 1) {
//				result[9] = "待支付稿费 " + script.getPayment() + " RMB";
//			} else if (script.getPay() == 2) {
//				result[9] = "已支付稿费 " + script.getPayment() + " RMB";
//			}
//		}

		model.addAttribute("result", result);
		return "/proprieter/querymanager/scriptdetail";

	}

	// /**
	// * 查询稿件基本信息
	// * @param session
	// * @param title
	// * @return
	// */
	// @RequestMapping(value="/script",method=RequestMethod.POST)
	// @ResponseBody
	// public String[][] script(HttpSession session,String title){
	//
	// log.info("title: "+title);
	// //获取当前登陆者的信息
	// Staff staff=(Staff) session.getAttribute("h_user");
	// //模糊查询稿件信息
	// List<Script>
	// scripts=scriptService.queryByTitle(staff.getPublisher(),title);
	// //构建结果集
	// int count = scripts.size();
	// String results[][] = new String[count][9];
	// Script script;
	// String state=null;
	// for (int i = 0; i < count; i++) {
	// script = scripts.get(i);
	//
	// results[i][0] = script.getId().toString(); // id
	// results[i][1] = script.getTitle();//标题
	// results[i][2] = script.getAuthor().getId().toString(); //作者id
	// results[i][3] = script.getAuthor().getName(); //作者名称
	// results[i][4] = script.getMagazine().getId().toString();//杂志id
	// results[i][5] = script.getMagazine().getName();//杂志名称
	// results[i][6] = script.getDate().toString();//投递时间
	//
	// switch (script.getState()) {
	// case 1:
	// //表示处理中
	// state="审核中";
	// break;
	// case 2:
	// state="通过";
	// break;
	// case 3:
	// state="不通过";
	// break;
	// }
	// results[i][7] = state;//处理状态
	//
	//
	// // 样式
	// String style=null;
	// switch (i%4) {
	// case 0:
	// style="success";
	// break;
	// case 1:
	// style="warning";
	// break;
	// case 2:
	// style="danger";
	// break;
	// case 3:
	// style="info";
	// break;
	// }
	//
	// results[i][8]=style;
	//
	// }
	// return results;
	//
	//
	// }

	/**
	 * 查询稿件的基本信息
	 * 
	 * @param id
	 * @return
	 */
	// @RequestMapping(value="/scriptbasicdetail",method=RequestMethod.POST)
	// @ResponseBody
	// public String[] basicDetail(HttpSession session,Integer id){
	// log.info("id"+id);
	// //获取当前登陆者的信息
	// Staff staff=(Staff) session.getAttribute("h_user");
	// //查询稿件信息
	// Script script=scriptService.get(id);
	// //构建结果
	// String result[]=new String [5];
	// //基本信息
	// result[0]=script.getTitle(); //标题
	// result[1]=script.getSummary(); //摘要
	// result[2]=script.getAuthor().getName(); //作者
	// result[3]=script.getAuthor().getId().toString(); //作者id
	//
	// if (script.getState()==3) {
	// result[4]="";
	// }else{
	// if (script.getPay()==null)
	// {
	// result[4]="未知";
	// }else if(script.getPay()==0){
	// result[4]="待设置稿费";
	// }
	// else if(script.getPay()==1){
	// result[4]="待支付稿费 "+script.getPayment()+" RMB";
	// }else if(script.getPay()==2){
	// result[4]="已支付稿费 "+script.getPayment()+" RMB";
	// }
	// }
	//
	//
	//
	//
	// return result;
	// }
	
	
	/**
	 * 查询一个稿件的稿费记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@ResponseBody
	public String[] payment(int id) {
		String result = "";
		Script script=scriptService.get(id);
		
		switch (script.getState()) {
		case 1:
			result="请等待审核通过";
			break;
		case 2:
			Payment payment=paymentService.getByScriptid(id);
			switch (payment.getState()) {
			case 0:
				result="稿费待设置中";
				break;
			case 1:
				result="待支付稿费"+payment.getCost()+"RMB";
				break;
			case 2:
				result="已支付稿费"+payment.getCost()+"RMB";
				break;
			
			default:
				break;
			}
			
			break;
		case 3:
			result="审核不通过，没有稿费";
			break;

		default:
			break;
		}

		return new String[] { result };

	}
	
	
	
	/**
	 * 查询一个稿件最新的审核记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
	@ResponseBody
	public String[] audit(int id) {
		Audit audit = auditService.getNewest(id);
		String result = null;
		switch (audit.getAuditState()) {
		case 0: // 待审核
			result = "待审核";
			break;
		case 1: // 审核中
			result = "审核中 " + staffService.get(audit.getStaffId()).getName()
					+ " " + audit.getAuditDate();
			break;
		case 2: // 审核通过
			result = "审核通过 " + staffService.get(audit.getStaffId()).getName()
					+ " " + audit.getAuditDate();
			break;
		case 3: // 审核不通过
			result = "审核不通过 " + staffService.get(audit.getStaffId()).getName()
					+ " " + audit.getAuditDate();
			break;

		default:
			break;
		}

		return new String[] { result };

	}

	/**
	 * 查询一个稿件最新的校对记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/proofread", method = RequestMethod.POST)
	@ResponseBody
	public String[] proofread(int id) {
		Proofread proofread;
		try {
			proofread = proofreadService.getNewest(id);
		} catch (Exception e) {
			return null;
		}

		String result = null;
		switch (Integer.valueOf(proofread.getProofState()).intValue()) {
		case 0: // 待校对
			result = "待校对";
			break;
		case 1: // 校对中
			result = "校对中 "
					+ staffService.get(proofread.getStaffId()).getName() + " "
					+ proofread.getProofDate();
			break;
		case 2: // 校对完成
			result = "校对完成 "
					+ staffService.get(proofread.getStaffId()).getName() + " "
					+ proofread.getProofDate();
			break;

		default:
			break;
		}

		return new String[] { result };

	}

	/**
	 * 查询一个稿件最新的排版记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/compose", method = RequestMethod.POST)
	@ResponseBody
	public String[] compose(int id) {
		Compose compose;
		try {
			compose = composeService.getNewest(id);
		} catch (Exception e) {
			return null;
		}

		String result = null;
		switch (compose.getComposeState()) {
		case 0: // 待排版
			result = "待排版";
			break;
		case 1: // 排版中
			result = "排版中 " + staffService.get(compose.getStaffId()).getName()
					+ " " + compose.getComposeDate();
			break;
		case 2: // 排版完成
			result = "排版完成 " + staffService.get(compose.getStaffId()).getName()
					+ " " + compose.getComposeDate();
			break;
		default:
			break;
		}

		return new String[] { result };

	}

	/**
	 * 访问作者查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/authorsearch", method = RequestMethod.GET)
	public String authorsearch() {
		return "/proprieter/querymanager/authorsearch";
	}

	/**
	 * 搜索作者
	 */
	@RequestMapping(value = "/authorsearch", method = RequestMethod.POST)
	@ResponseBody
	public String[][] authorsearch(HttpSession session, String name) {
		// 根据作者名模糊查询作者信息
		List<Author> authors = authorService.queryByName(name);
		// 构造结果集
		int count = authors.size();
		String results[][] = new String[count][3];
		Author author;

		for (int i = 0; i < count; i++) {
			author = authors.get(i);
			results[i][0] = author.getId().toString(); // id

			results[i][1] = author.getName();// 姓名
			if (author.getGender() == 0) { // 性别

				results[i][2] = "boy";
			} else {
				results[i][2] = "girl";

			}

		}
		return results;

	}

	/**
	 * 查看作者详细信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/authordetail", method = RequestMethod.GET)
	public String authordetail(Model model, int id) {
		// 查询作者
		Author author = authorService.get(id);
		// 构造结果集
		String result[] = new String[10];
		Long send;
		Long pass;
		result[0] = author.getId().toString();// id
		result[1] = author.getName();// 姓名
		if (author.getGender() == 0) { // 性别

			result[2] = "男";
		} else {
			result[2] = "女";

		}

		result[3] = author.getPhone(); // 手机
		result[4] = author.getEmail();// 邮箱
		result[5] = author.getAddress();// 地址
		result[6] = author.getRegistertime().toString();// 注册时间
		send = scriptService.getSendSumByAuthor(author);

		if (send.intValue() == 0) {
			result[7] = "0"; // 投递总数
			result[8] = "0"; // 录用总数
			result[9] = "0"; // 录用比
		} else {
			pass = scriptService.getPassSumByAuthor(author);
			result[7] = send.toString(); // 投递总数
			result[8] = pass.toString(); // 录用总数
			result[9] = String.valueOf(pass.intValue() / send.intValue());
		}
		model.addAttribute("result", result);

		return "/proprieter/querymanager/authordetail";
	}

	/**
	 * 返回该作者的所有投递到本杂志社的稿件
	 * 
	 * @param authorid
	 * @return
	 */
	@RequestMapping(value = "/allscripts", method = RequestMethod.POST)
	@ResponseBody
	public String[][] allscripts(HttpSession session, int authorid) {
		// 获取当前登陆者的信息
		Staff staff = (Staff) session.getAttribute("h_user");
		Publisher publisher = staff.getPublisher();
		List<Script> scripts = scriptService
				.getAllScriptsByAuthoridAndPublisher(authorid, publisher);
		if (scripts == null || scripts.size() == 0) {
			return null;
		}
		int count = scripts.size();
		String[][] results = new String[count][3];
		for (int i = 0; i < count; i++) {
			results[i][0] = scripts.get(i).getId().toString();
			results[i][1] = scripts.get(i).getTitle();
			results[i][2] = scripts.get(i).getDate().toString();
		}

		return results;
	}

}
