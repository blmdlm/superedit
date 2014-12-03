package service;

import java.util.List;

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
	 * 查找该杂志社通过的没有设置稿费的稿件
	 * @param publisher
	 * @return
	 */
	List<Script> findPassUnSetByPubliser(Publisher publisher);
	
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
	 * 查找该杂志社待支付的稿件
	 * @param publisher
	 * @return
	 */
	List<Script> findUnpayByPubliser(Publisher publisher);
	/**
	 * 查找该杂志社已完成支付的稿件
	 * @param publisher
	 * @return
	 */
	List<Script> findPayedByPubliser(Publisher publisher);
	
}
