package service;

import java.util.List;

import model.Author;
import model.Publisher;
import model.Script;

/**
 * 
 *@Project superedit 
 *@ClassName ScriptService
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月3日 下午7:11:14
 */
public interface ScriptService {

	
	/**
	 * 通过id获取稿件
	 * @param id
	 * @return
	 */
	Script get(Integer id);
	/**
	 * 更新稿件
	 * @param script
	 */
	void update(Script script);



	/**
	 * 查找一个作者投递的所有稿件数
	 * @return
	 */
	Long getSendSumByAuthor(Author author);
	/**
	 * 查找一个作者所有通过的稿件数
	 * @param author
	 * @return
	 */
	Long getPassSumByAuthor(Author author);

	/**
	 * 在一个杂志社模糊查询稿件
	 * @param publisher
	 * @param title
	 * @return
	 */
	List<Script> queryByTitle(Publisher publisher, String title);
	
	/**
	 * 模糊查询投递给一个杂志的的稿件
	 * @param title
	 * @param magazineid
	 * @return
	 */
	List<Script> queryByTitleAndMagazineid(String title, int magazineid);
	
	
	
	/**
	 * 找出一个作者的所有稿件
	 * @param authorid
	 * @return
	 */
	List<Script> getAllScriptsByAuthorid(int authorid);
	/**
	 * 找出一个作者投递给一个杂志的所有稿件
	 * @param authorid
	 * @param magazineid
	 * @return
	 */
	List<Script> getAllScriptsByAuthoridAndMagazineid(int authorid,
			int magazineid);
	/**
	 * 找出一个作者投递给一个杂志社的所有稿件
	 * @param authorid
	 * @param publisher
	 * @return
	 */
	List<Script> getAllScriptsByAuthoridAndPublisher(int authorid,
			Publisher publisher);


	
}
