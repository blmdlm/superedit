package controller.editor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Audit;
import model.Author;
import model.Compose;
import model.Magazine;
import model.Message;
import model.Payment;
import model.Proofread;
import model.Script;
import model.Staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AuditService;
import service.AuthorService;
import service.ComposeService;
import service.MagazineService;
import service.MessageService;
import service.PaymentService;
import service.ProofreadService;
import service.ScriptService;
import service.StaffService;

@Controller("editorquerymanager")
@RequestMapping("/editor/querymanager")
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
		return "/editor/querymanager/scriptsearch";
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
		Staff staff = (Staff) session.getAttribute("k_user");
		int magazineid = staff.getMagazineId();
		// 模糊查询稿件信息
		List<Script> scripts = scriptService.queryByTitleAndMagazineid(title,
				magazineid);
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
		String result[] = new String[10];
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
			result[9]="请等待审核通过";
			break;
		case 2:
			state = "通过 " + auditService.getNewest(id).getAuditDate();
			Payment payment=paymentService.getByScriptid(id);
			switch (payment.getState()) {
			case 0:
				result[9]="稿费待设置中";
				break;
			case 1:
				result[9]="待支付稿费"+payment.getCost()+"RMB";
				break;
			case 2:
				result[9]="已支付稿费"+payment.getCost()+"RMB";
				break;
			
			default:
				break;
			}
			break;
		case 3:
			state = "不通过 " + auditService.getNewest(id).getAuditDate();
			result[9]="审核不通过，没有稿费";
			break;
		}
		result[7] = state;// 处理状态
		result[8] = script.getSummary(); // 摘要

		model.addAttribute("result", result);
		return "/editor/querymanager/scriptdetail";

	}
//	/**
//	 * 查询一个稿件的稿费记录
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value = "/payment", method = RequestMethod.POST)
//	@ResponseBody
//	public String[] payment(int id) {
//		String result = "";
//		Script script=scriptService.get(id);
//		
//		switch (script.getState()) {
//		case 1:
//			result="请等待审核通过";
//			break;
//		case 2:
//			Payment payment=paymentService.getByScriptid(id);
//			switch (payment.getState()) {
//			case 0:
//				result="稿费待设置中";
//				break;
//			case 1:
//				result="待支付稿费"+payment.getCost()+"RMB";
//				break;
//			case 2:
//				result="已支付稿费"+payment.getCost()+"RMB";
//				break;
//			
//			default:
//				break;
//			}
//			
//			break;
//		case 3:
//			result="审核不通过，没有稿费";
//			break;
//
//		default:
//			break;
//		}
//
//		return new String[] { result };
//
//	}
//	/**
//	 * 查询一个稿件最新的审核记录
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value = "/audit", method = RequestMethod.POST)
//	@ResponseBody
//	public String[] audit(int id) {
//		Audit audit = auditService.getNewest(id);
//		String result = null;
//		switch (audit.getAuditState()) {
//		case 0: // 待审核
//			result = "待审核";
//			break;
//		case 1: // 审核中
//			result = "审核中 " + staffService.get(audit.getStaffId()).getName()
//					+ " " + audit.getAuditDate();
//			break;
//		case 2: // 审核通过
//			result = "审核通过 " + staffService.get(audit.getStaffId()).getName()
//					+ " " + audit.getAuditDate();
//			break;
//		case 3: // 审核不通过
//			result = "审核不通过 " + staffService.get(audit.getStaffId()).getName()
//					+ " " + audit.getAuditDate();
//			break;
//
//		default:
//			break;
//		}
//
//		return new String[] { result };
//
//	}
//
//	/**
//	 * 查询一个稿件最新的校对记录
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value = "/proofread", method = RequestMethod.POST)
//	@ResponseBody
//	public String[] proofread(int id) {
//		Proofread proofread;
//		try {
//			proofread = proofreadService.getNewest(id);
//		} catch (Exception e) {
//			return null;
//		}
//
//		String result = null;
//		switch (Integer.valueOf(proofread.getProofState()).intValue()) {
//		case 0: // 待校对
//			result = "待校对";
//			break;
//		case 1: // 校对中
//			result = "校对中 "
//					+ staffService.get(proofread.getStaffId()).getName() + " "
//					+ proofread.getProofDate();
//			break;
//		case 2: // 校对完成
//			result = "校对完成 "
//					+ staffService.get(proofread.getStaffId()).getName() + " "
//					+ proofread.getProofDate();
//			break;
//
//		default:
//			break;
//		}
//
//		return new String[] { result };
//
//	}
//
//	/**
//	 * 查询一个稿件最新的排版记录
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value = "/compose", method = RequestMethod.POST)
//	@ResponseBody
//	public String[] compose(int id) {
//		Compose compose;
//		try {
//			compose = composeService.getNewest(id);
//		} catch (Exception e) {
//			return null;
//		}
//
//		String result = null;
//		switch (compose.getComposeState()) {
//		case 0: // 待排版
//			result = "待排版";
//			break;
//		case 1: // 排版中
//			result = "排版中 " + staffService.get(compose.getStaffId()).getName()
//					+ " " + compose.getComposeDate();
//			break;
//		case 2: // 排版完成
//			result = "排版完成 " + staffService.get(compose.getStaffId()).getName()
//					+ " " + compose.getComposeDate();
//			break;
//		default:
//			break;
//		}
//
//		return new String[] { result };
//
//	}

	/**
	 * 访问作者查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/authorsearch", method = RequestMethod.GET)
	public String authorsearch() {
		return "/editor/querymanager/authorsearch";
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

		return "/editor/querymanager/authordetail";
	}

	/**
	 * 返回该作者的所有投递给固定杂志的稿件
	 * 
	 * @param authorid
	 * @return
	 */
	@RequestMapping(value = "/allscripts", method = RequestMethod.POST)
	@ResponseBody
	public String[][] allscripts(HttpSession session, int authorid) {
		Staff staff = (Staff) session.getAttribute("k_user");
		log.info("staff=" + staff.toString());
		int magazineid = staff.getMagazineId();
		List<Script> scripts = scriptService
				.getAllScriptsByAuthoridAndMagazineid(authorid, magazineid);
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

	/**
	 * 查询最近的一次约稿记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/solicithistory", method = RequestMethod.POST)
	@ResponseBody
	public Message solicitHistory(HttpSession session, Integer id) {
		// 获得当前登陆者的信息
		Staff staff = (Staff) session.getAttribute("k_user");
		// 查询最近的约稿记录
		Message message = messageService.findLastMessage(staff.getId(), id);

		if (message == null) {
			log.info("message=null");
			return null;
		}
		log.info("message=" + message.toString());

		return message;

	}

	/**
	 * 进行约稿
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/solicit")
	@ResponseBody
	public String solicit(HttpSession session, Integer id, String message) {
		// 获得当前登陆者的信息
		Staff staff = (Staff) session.getAttribute("k_user");
		// 构造留言
		Message mess = new Message();
		mess.setContent(message);
		mess.setSendid(staff.getId());
		mess.setSendrole(10);
		mess.setRecvid(id);
		mess.setRecvrole(11);
		mess.setTime(new Date());
		// 存储留言
		messageService.save(mess);

		return "OK";
	}

}
