package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Script;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ScriptService;

/**
 * 
 * @Project superedit
 * @ClassName FinancialController
 * @Description 财务管理员的控制器
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年12月3日 下午4:10:54
 */
@Controller
@RequestMapping("/financial")
public class FinancialController {
	private static Logger logger = Logger.getLogger(FinancialController.class);
	@Autowired
	ScriptService scriptService;

	/**
	 * 个人首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/financial/index";
	}

	/**************************************** 用户中心 **************************************/

	/**************************************** 稿费管理 ***************************************/

	/**
	 * 访问设置稿费界面
	 * 
	 * @return
	 */
	@RequestMapping("/paymentmanager/set")
	public String paymentManagerSet(HttpSession session, Model model) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该杂志社所有通过的未支付的稿件
		List<Script> scripts = scriptService.findPassUnSetByPubliser(staff
				.getPublisher());
		// 构造结果
		int count = scripts.size();
		String results[][] = new String[count][6];
		Script script;
		for (int i = 0; i < count; i++) {
			script = scripts.get(i);
			results[i][0] = script.getId().toString(); // id

			results[i][1] = script.getMagazine().getName(); // 杂志
			results[i][2] = script.getTitle(); // 标题
			results[i][3] = script.getAuthor().getName();// 作者
			results[i][4] = script.getDate().toString(); // 时间
			results[i][5] = String.valueOf(i % 4); // 样式id
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
	@RequestMapping(value = "/paymentmanager/set", method = RequestMethod.POST)
	@ResponseBody
	public String paymentManagerSetPayment(HttpSession session, Integer id,
			Integer content) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该稿件信息
		Script script = scriptService.get(id);
		// 设置属性
		script.setPay(1);
		script.setPayment(content);
		// 更新
		scriptService.update(script);
		//
		return "OK";

	}

	/**
	 * 访问待支付稿件页面
	 * 
	 * @return
	 */
	@RequestMapping("/paymentmanager/unpay")
	public String paymentManagerUnpay(HttpSession session, Model model) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该杂志社所有待支付的稿件
		List<Script> scripts = scriptService.findUnpayByPubliser(staff
				.getPublisher());
		// 构造结果
		int count = scripts.size();
		String results[][] = new String[count][7];
		Script script;
		for (int i = 0; i < count; i++) {
			script = scripts.get(i);
			results[i][0] = script.getId().toString(); // id
			results[i][1] = script.getMagazine().getName(); // 杂志
			results[i][2] = script.getTitle(); // 标题
			results[i][3] = script.getAuthor().getName();// 作者
			results[i][4] = script.getDate().toString(); // 时间
			results[i][5] = script.getPayment().toString(); // 稿费
			results[i][6] = String.valueOf(i % 4); // 样式id
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
	@RequestMapping(value = "/paymentmanager/unpay", method = RequestMethod.POST)
	@ResponseBody
	public String paymentManagerConfirmpay(Integer id) {
		// 获取该稿件
		Script script = scriptService.get(id);
		// 设置属性
		script.setPay(2);
		// 更新
		scriptService.update(script);
		//
		return "OK";
	}

	/**
	 * 访问已完成支付稿件页面
	 * 
	 * @return
	 */
	@RequestMapping("/paymentmanager/payed")
	public String paymentManagerPayed(HttpSession session, Model model) {
		// 获取登陆者的信息
		Staff staff = (Staff) (session.getAttribute("j_user"));
		// 获取该杂志社所有已完成支付的稿件
		List<Script> scripts = scriptService.findPayedByPubliser(staff
				.getPublisher());
		// 构造结果
		int count = scripts.size();
		String results[][] = new String[count][7];
		Script script;
		for (int i = 0; i < count; i++) {
			script = scripts.get(i);
			results[i][0] = script.getId().toString(); // id

			results[i][1] = script.getMagazine().getName(); // 杂志
			results[i][2] = script.getTitle(); // 标题
			results[i][3] = script.getAuthor().getName();// 作者
			results[i][4] = script.getDate().toString(); // 时间
			results[i][5] = script.getPayment().toString(); // 稿费
			results[i][6] = String.valueOf(i % 4); // 样式id
		}

		logger.info(count);
		// 设置到请求属性中
		model.addAttribute("results", results);

		String styles[] = { "success", "warning", "danger", "info" };
		model.addAttribute("styles", styles);

		return "/financial/paymentmanager/payed";
	}

}
