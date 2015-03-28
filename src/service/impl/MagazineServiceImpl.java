package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.MagazineDAO;
import model.Magazine;
import service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	@Autowired
	MagazineDAO magazineDAO;
	
	
	@Override
	public Magazine get(int id) {
		return magazineDAO.findById(id);
	}

}
