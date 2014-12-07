package service;

import model.Message;

/**
 * 
 *@Project superedit 
 *@ClassName MessageService
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月5日 下午9:12:08
 */
public interface MessageService {
	/**
	 * 找到最近的一条约稿记录
	 * @param id
	 * @param id2
	 * @return
	 */
	Message findLastMessage(Integer id, Integer id2);
	/**
	 * 保存一条消息
	 * @param mess
	 */
	void save(Message mess);

	
	
	
	
	
}
