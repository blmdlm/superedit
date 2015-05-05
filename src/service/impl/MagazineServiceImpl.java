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
	
	

}
