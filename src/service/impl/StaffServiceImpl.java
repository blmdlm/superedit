package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StaffDAO;
import model.Staff;
import service.StaffService;

/**
 * 
 * @Project superedit
 * @ClassName StaffServiceImpl
 * @Description TODO
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年11月21日 下午11:30:32
 */
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDAO staffDAO;

	@Override
	public Staff get(Integer id) {
		return staffDAO.findById(id);
	}

	@Override
	public void save(Staff staff) {
		System.out.println("staffDao" + staffDAO);
		staffDAO.save(staff);

	}

	@Override
	public void update(Staff staff) {
		staffDAO.merge(staff);

	}

	@Override
	public void delete(Staff staff) {
		staffDAO.delete(staff);

	}

}
