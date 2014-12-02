package service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.ProprieterController;
import dao.AssistDAO;
import dao.StaffDAO;
import model.Messageboard;
import model.Publisher;
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
	private static Logger logger = Logger.getLogger(StaffServiceImpl.class);
	@Autowired
	private StaffDAO staffDAO;
	@Autowired
	private AssistDAO assistDAO;

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

	@Override
	public boolean isExist(Staff staff) {
		List<Staff> staffs= staffDAO.findByEmail(staff.getEmail());
		if (staffs.size()!=0) {
			
			
			return true;
		}
		return false;
	}



	@Override
	public List<Staff> findByParentid(Integer parentid) {
		List<Staff> staffs=staffDAO.findByParentid(parentid);
		return staffs;
	}

	@Override
	public List<Staff> findByParentidAndRole(Integer parentid, Integer role) {
		List<Staff> staffs=assistDAO.findByParentidAndRole(parentid, role);
		return staffs;
	}



}
