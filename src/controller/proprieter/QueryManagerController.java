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
		Staff staff = (Staff) session.getAttribute("h_user");
		List<Script> scripts = scriptService.queryByTitleInPublisher(
				title,staff.getPublisher());
		
		return scriptService.listToArray(scripts);
		

	}

	/**
	 * 查看稿件详细信息
	 */
	@RequestMapping(value = "/scriptdetail", method = RequestMethod.GET)
	public String scriptdetail(Model model, int id) {
		// 这里有bug 可能可以看到其他人不在其杂志社的消息！！！！！！！！！！！！！！
		Script script = scriptService.get(id);
		String result[]=scriptService.ObjectDetailToArray(script);
		model.addAttribute("result", result);
		return "/proprieter/querymanager/scriptdetail";

	}


	/**
	 * 查询一个稿件的稿费记录
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@ResponseBody
	public String[] payment(int id) {
		Script script=scriptService.get(id);	
		return scriptService.getPaymentState(script);
	}
	
	
	
	/**
	 * 查询一个稿件最新的审核状态
	 */
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
	@ResponseBody
	public String[] audit(int id) {
		Audit audit = auditService.getNewest(id);		
		return auditService.getAuditState(audit);
		
	}

	/**
	 * 查询一个稿件最新的校对状态
	 */
	@RequestMapping(value = "/proofread", method = RequestMethod.POST)
	@ResponseBody
	public String[] proofread(int id) {
		Proofread proofread= proofreadService.getNewest(id);		
		return proofreadService.getProofreadState(proofread);

	}

	/**
	 * 查询一个稿件最新的排版状态
	 */
	@RequestMapping(value = "/compose", method = RequestMethod.POST)
	@ResponseBody
	public String[] compose(int id) {
		Compose compose= composeService.getNewest(id);
		return composeService.getComposeState(compose);

	}

	/**
	 * 访问作者查询页面
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
	 */
	@RequestMapping(value = "/authordetail", method = RequestMethod.GET)
	public String authordetail(Model model, int id) {
		Author author = authorService.get(id);
		String result[]= authorService.getDetail(author);
		model.addAttribute("result", result);
		return "/proprieter/querymanager/authordetail";
	}

	/**
	 * 返回该作者的所有投递到本杂志社的稿件
	 */
	@RequestMapping(value = "/allscripts", method = RequestMethod.POST)
	@ResponseBody
	public String[][] allscripts(HttpSession session, int authorid) {

		Staff staff = (Staff) session.getAttribute("h_user");
		List<Script> scripts = scriptService.getAllScriptsByAuthoridAndPublisher(authorid, staff.getPublisher());
		return scriptService.listToArray(scripts);
	}

}
