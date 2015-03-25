package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import model.Compose;
import service.ComposeService;

public class ComposeServiceImpl implements ComposeService{
	@Autowired
	AssistDAO assistDAO;
	
	
	@Override
	public Compose getNewest(int scriptid) {
		// TODO Auto-generated method stub
		return assistDAO.getNewestCompose(scriptid).get(0);
	}

}
