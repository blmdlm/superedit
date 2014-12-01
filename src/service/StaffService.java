package service;


import java.util.List;

import model.Messageboard;
import model.Publisher;
import model.Staff;

/**
 * 
 * @Project superedit
 * @ClassName StaffService
 * @Description
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年11月21日 下午11:19:51
 */

public interface StaffService {

	/**
	 * 通过id获取职员
	 * 
	 * @param id
	 * @return
	 */
	Staff get(Integer id);

	/**
	 * 增加职员
	 * 
	 * @param staff
	 */
	void save(Staff staff);

	/**
	 * 更新职员
	 * 
	 * @param staff
	 */
	void update(Staff staff);

	/**
	 * 删除职员
	 * 
	 * @param staff
	 */
	void delete(Staff staff);
	/**
	 * 判断职员是否存在
	 * @param staff
	 * @return
	 */
	boolean isExist(Staff staff);
	
	

	
	/**
	 * 通过parentid找到职员
	 * @param parentid
	 * @return
	 */
	List<Staff> findByParentid(Integer parentid);
	/**
	 * 通过parentid和role找到职员
	 * @param parentid
	 * @param role
	 * @return
	 */
	List<Staff> findByParentidAndRole(Integer parentid,Integer role);
	/**
	 * 查找杂志社的未审核留言
	 * @param publisher
	 * @return
	 */
	List<Messageboard> findPostAuditMessageByPublisher(Publisher publisher);
	
	
	
	
	
	
	
	
	
}
