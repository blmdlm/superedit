package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AuthorDAO;
import model.Author;
import service.AuthorService;
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
	AuthorDAO authorDAO;
	@Override
	public Author get(Integer id) {
		return authorDAO.findById(id);
	}

}
