package service;


import java.util.List;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
