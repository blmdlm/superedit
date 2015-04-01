package controller.financial;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Payment;
import model.Publisher;
import model.Script;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.PaymentService;
import service.ScriptService;
import service.StaffService;

/**
 * 
 * @Project superedit
 * @ClassName FinancialController
 * @Description 财务管理员的控制器
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年12月3日 下午4:10:54
 */
@Controller
@RequestMapping("/financial/paymentmanager")
public class PaymentManagerController {
	private static Logger logger = Logger.getLogger(PaymentManagerController.class);
	@Autowired
	StaffService staffService;
	@Autowired
	ScriptService scriptService;
	@Autowired
	PaymentService paymentService;

	/**
	 * 访问设置稿费界面
	 * 
	 * @return
	 */
	@RequestMapping("/set")
	public String paymentManagerSet(HttpSession session, Model model) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该杂志社所有通过的未支付的记录
		List<Payment> payments = paymentService.findPassUnSetByPubliser(staff
				.getPublisher());
		// 构造结果
		int count = payments.size();
		String results[][] = new String[count][7];
		Script script;
		Payment payment;
		for (int i = 0; i < count; i++) {
			payment = payments.get(i);
			script=scriptService.get(payment.getScriptId());
			
			
			results[i][0] = script.getId().toString(); // 稿件id
			results[i][1] = script.getMagazine().getName(); // 杂志
			results[i][2] = script.getTitle(); // 标题
			results[i][3] = script.getAuthor().getName();// 作者
			results[i][4] = script.getDate().toString(); // 时间
			results[i][5] = String.valueOf(i % 4); // 样式id
			results[i][6] = payment.getId().toString(); // 稿费记录id
		}

		logger.info(count);
		// 设置到请求属性中
		model.addAttribute("results", results);

		String styles[] = { "success", "warning", "danger", "info" };
		model.addAttribute("styles", styles);

		return "/financial/paymentmanager/set";

	}

	/**
	 * 处理设置稿费的请求
	 * 
	 * @return
	 */
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	@ResponseBody
	public String paymentManagerSetPayment(HttpSession session, Integer id,
			Integer content) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该稿费记录
		Payment payment = paymentService.get(id);
		// 设置属性
		payment.setCost(content);
		payment.setState(1);
		payment.setStaffId(staff.getId());
		// 更新
		paymentService.update(payment);
		//
		return "OK";

	}

	/**
	 * 访问待支付稿件页面
	 * 
	 * @return
	 */
	@RequestMapping("/unpay")
	public String paymentManagerUnpay(HttpSession session, Model model) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该杂志社所有待支付的稿费记录
		List<Payment> payments = paymentService.findUnpayByPubliserAndStaff(staff
				.getPublisher(),staff.getId());
		// 构造结果
		int count = payments.size();
		String results[][] = new String[count][8];
		Script script;
		Payment payment;
		for (int i = 0; i < count; i++) {
			payment = payments.get(i);
			script=scriptService.get(payment.getScriptId());
			results[i][0] = script.getId().toString(); // 稿件id
			results[i][1] = script.getMagazine().getName(); // 杂志
			results[i][2] = script.getTitle(); // 标题
			results[i][3] = script.getAuthor().getName();// 作者
			results[i][4] = script.getDate().toString(); // 投递时间
			results[i][5] = payment.getCost().toString(); // 稿费
			results[i][6] = String.valueOf(i % 4); // 样式id
			results[i][7] = payment.getId().toString(); // 稿费记录id
		}

		logger.info(count);
		// 设置到请求属性中
		model.addAttribute("results", results);

		String styles[] = { "success", "warning", "danger", "info" };
		model.addAttribute("styles", styles);

		return "/financial/paymentmanager/unpay";
	}

	/**
	 * 处理确认支付请求
	 * 
	 * @return
	 */
	@RequestMapping(value ="/unpay", method = RequestMethod.POST)
	@ResponseBody
	public String paymentManagerConfirmpay(Integer id) {
		// 获取该稿费记录
		Payment payment=paymentService.get(id);
		// 设置属性
		payment.setState(2);
		payment.setPayDate(new Date());
		// 更新
		paymentService.update(payment);
		//
		return "OK";
	}

	/**
	 * 访问已完成支付稿件页面
	 * 
	 * @return
	 */
	@RequestMapping("/payed")
	public String paymentManagerPayed(HttpSession session, Model model) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该杂志社所有已完成支付的稿费记录
		List<Payment> payments = paymentService.findPayedByPubliserAndStaff(staff
				.getPublisher(),staff.getId());
		// 构造结果
		int count = payments.size();
		String results[][] = new String[count][8];
		Script script;
		Payment payment;
		for (int i = 0; i < count; i++) {
			payment = payments.get(i);
			script=scriptService.get(payment.getScriptId());
			results[i][0] = script.getId().toString(); // 稿件id

			results[i][1] = script.getMagazine().getName(); // 杂志
			results[i][2] = script.getTitle(); // 标题
			results[i][3] = script.getAuthor().getName();// 作者
			results[i][4] = script.getDate().toString(); // 投递时间
			results[i][5] = payment.getCost().toString(); // 稿费
			results[i][6] = String.valueOf(i % 4); // 样式id
			results[i][7] = payment.getPayDate().toString(); // 支付时间
		}

		logger.info(count);
		// 设置到请求属性中
		model.addAttribute("results", results);

		String styles[] = { "success", "warning", "danger", "info" };
		model.addAttribute("styles", styles);

		return "/financial/paymentmanager/payed";
	}

}
