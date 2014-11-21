package test.dao;

import dao.Staff;
import dao.StaffDAO;

public class staffDAOTest {
	
	static StaffDAO staffDAO;
	public static void main(String[] args) {
		Staff staff=new Staff("asda", "1231",1,1, 1,"213", 1, "1231", "asd", null,null,null,null);
		staffDAO.save(staff);
		System.out.println("save");
	}
	
	
}
