package service;

import model.Author;

/**
 * 
 *@Project superedit 
 *@ClassName AuthorService
 *@Description 
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月2日 下午6:54:41
 */
public interface AuthorService {
	/**
	 * 通过id获取作者
	 * @param id
	 * @return
	 */
	Author get(Integer id);
	
}
