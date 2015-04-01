package service;

import java.util.List;

import model.Messageboard;
import model.Publisher;

/**
 * 
 *@Project superedit 
 *@ClassName MessageBoardService
 *@Description 留言板的服务层接口
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月2日 下午3:25:27
 */
public interface MessageBoardService {
	
	
	
	
	/**
	 * 查找杂志社的未审核留言
	 * @param publisher
	 * @return
	 */
	List<Messageboard> findPostAuditMessageByPublisher(Publisher publisher);
	
	/**
	 * 更新留言
	 * @param messageboard
	 */
	void update(Messageboard messageboard);
	/**
	 * 通过id获取留言
	 * @param id
	 * @return
	 */
	Messageboard get(Integer id);
	/**
	 * 查找杂志社未回复留言
	 * @param publisher
	 * @return
	 */
	List<Messageboard> findUnreplyMessageByPublisher(Publisher publisher);
	/**
	 * 保存留言
	 * @param messageboard
	 */
	void save(Messageboard messageboard);
	/**
	 * 查询所有的已通过的留言
	 */
	List<Messageboard> findAllPassed();
	/**
	 * 通过parentid找到回复留言
	 * @param parentid
	 * @return
	 */
	List<Messageboard> findByParentid(Integer parentid);
	/**
	 * 查找某个杂志社的某个职员的留言记录
	 * @param publisher
	 * @param id
	 * @return
	 */
	List<Messageboard> findReocrdByPublisherAndStaff(Publisher publisher,
			Integer id);
	
	
}
