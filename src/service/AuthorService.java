package service;

import java.util.List;

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
	/**
	 * 查找新注册的10个作者
	 * @return
	 */
	List<Author> getTop10New();
	/**
	 * 模糊查询作者信息
	 * @param name
	 * @return
	 */
	List<Author> queryByName(String name);
	
	
	
	
}
