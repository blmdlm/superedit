package service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Staff> getChiefEditors(Staff proprieter) {
		return assistDAO.findByParentidAndRole(proprieter.getId(), 6);
	}

	@Override
	public List<Staff> getFinancials(Staff proprieter) {
		return assistDAO.findByParentidAndRole(proprieter.getId(), 9);
	}

	@Override
	public List<Staff> getMessageManagers(Staff proprieter) {
		return assistDAO.findByParentidAndRole(proprieter.getId(), 8);
	}

	@Override
	public List<Staff> getEditors(Staff chiefEditor) {
		return assistDAO.findByParentidAndRole(chiefEditor.getId(), 10);
	}

	@Override
	public List<Staff> getAuditors(Staff chiefEditor) {
		return assistDAO.findByParentidAndRole(chiefEditor.getId(), 3);
	}

	@Override
	public List<Staff> getProofreaders(Staff chiefEditor) {
		return assistDAO.findByParentidAndRole(chiefEditor.getId(), 5);
	}

	@Override
	public List<Staff> getComposers(Staff chiefEditor) {
		return assistDAO.findByParentidAndRole(chiefEditor.getId(), 4);
	}

	@Override
	public Staff updateTargetByOther(Staff target, Staff other) {
		target.setName(other.getName());
		target.setGender(other.getGender());
		target.setPhone(other.getPhone());
		target.setEmail(other.getEmail());
		update(target);
		return  get(target.getId());
	}


	@Override
	public boolean confirmPassword(Staff staff, String oldpassword) {
		return staff.getPassword().equals(oldpassword);
	}



	@Override
	public Staff changePasswordAndUpdate(Staff staff, String password) {
		staff.setPassword(password);
		update(staff);
		return get(staff.getId());
	}

	@Override
	public void deleteById(int id) {
		Staff staff=get(id);
		staff.setLocked(1);
		update(staff);
	}







}
