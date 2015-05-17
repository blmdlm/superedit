package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import dao.AuthorDAO;
import model.Author;
import service.AuthorService;
import service.ScriptService;
/**
 * 
 *@Project superedit 
 *@ClassName AuthorServiceImpl
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月2日 下午6:57:10
 */
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	AssistDAO assistDAO;
	@Autowired
	AuthorDAO authorDAO;
	@Autowired
	ScriptService scriptService;
	
	
	
	@Override
	public Author get(Integer id) {
		return authorDAO.findById(id);
	}
	@Override
	public List<Author> getTop10New() {
		return assistDAO.getTop10New();
	}
	@Override
	public List<Author> queryByName(String name) {
		return assistDAO.queryByName(name);
	}
	@Override
	public String[] getDetail(Author author) {
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
				
				return result;
	}

}
