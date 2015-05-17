package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import dao.ScriptDAO;
import model.Author;
import model.Payment;
import model.Publisher;
import model.Script;
import service.PaymentService;
import service.ScriptService;

/**
 * 
 * @Project superedit
 * @ClassName ScriptServiceImpl
 * @Description TODO
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年12月3日 下午7:11:58
 */
public class ScriptServiceImpl implements ScriptService {
	@Autowired
	ScriptDAO scriptDAO;
	@Autowired
	AssistDAO assistDAO;
	@Autowired
	PaymentService paymentService;
	
	@Override
	public Script get(Integer id) {
		return scriptDAO.findById(id);
	}

	@Override
	public void update(Script script) {
		scriptDAO.merge(script);

	}

	@Override
	public Long getSendSumByAuthor(Author author) {
		return assistDAO.getSendSumByAuthor(author).get(0);
	}

	@Override
	public Long getPassSumByAuthor(Author author) {
		return assistDAO.getPassSumByAuthor(author).get(0);
	}

	@Override
	public List<Script> getAllScriptsByAuthorid(int authorid) {
		return assistDAO.getAllScriptsByAuthodid(authorid);
	}

	@Override
	public List<Script> getAllScriptsByAuthoridAndMagazineid(int authorid,
			int magazineid) {
		return assistDAO.getAllScriptsByAuthodidAndMagazineid(authorid,
				magazineid);
	}

	@Override
	public List<Script> queryByTitleAndMagazineid(String title, int magazineid) {
		return assistDAO.queryByScriptTitle(title, magazineid);
	}

	@Override
	public List<Script> getAllScriptsByAuthoridAndPublisher(int authorid,
			Publisher publisher) {
		return assistDAO.getAllScriptsByAuthodidAndPublisher(authorid,
				publisher);
	}

	@Override
	public List<Script> queryByTitleInPublisher(String title,
			Publisher publisher) {
		return assistDAO.queryByScriptTitleInPublisher(title, publisher);
	}

	@Override
	public String[][] listToArray(List<Script> scripts) {
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

	@Override
	public String[] ObjectDetailToArray(Script script) {

		String result[] = new String[9];
		String state = null;

		result[0] = script.getId().toString(); 
		result[1] = script.getTitle();
		result[2] = script.getAuthor().getId().toString();
		result[3] = script.getAuthor().getName(); 
		result[4] = script.getMagazine().getId().toString();
		result[5] = script.getMagazine().getName();
		result[6] = script.getDate().toString();

		switch (script.getState()) {
		case 1:
			state = "审核中";
			break;
		case 2:
			state = "通过";
			break;
		case 3:
			state = "不通过";
			break;
		}
		result[7] = state;
		result[8] = script.getSummary();

		return result;

	}

	@Override
	public String[] getPaymentState(Script script) {
		String result = "";
		switch (script.getState()) {
		case 1:
			result="请等待审核通过";
			break;
		case 2:
			Payment payment=paymentService.getByScriptid(script.getId());
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

}
