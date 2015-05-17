package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import dao.MagazineDAO;
import model.Magazine;
import model.Publisher;
import service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	@Autowired
	MagazineDAO magazineDAO;
	@Autowired
	AssistDAO assistDAO;
	
	@Override
	public Magazine get(int id) {
		return magazineDAO.findById(id);
	}


	@Override
	public List<Magazine> getByPublisher(Publisher publisher) {

		return assistDAO.getAllMagazinesByPublisher(publisher);
		
	}


	@Override
	public String[][] listToArray(List<Magazine> magazines) {
		if (magazines==null) {
			return null;
		}		
		int count = magazines.size();	
		String results[][] = new String[count][2];
		Magazine magazine;		
		for (int i = 0; i < count; i++) {
			magazine = magazines.get(i);
			results[i][0] = magazine.getId().toString(); 
			results[i][1] = magazine.getName();	
		 }
	
	     return results;
	}
	
	

}
