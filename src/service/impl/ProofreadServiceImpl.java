package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;

import model.Proofread;
import service.ProofreadService;

public class ProofreadServiceImpl implements ProofreadService{
	@Autowired
	AssistDAO assistDAO;
	@Override
	public Proofread getNewest(int scriptid) {
		return assistDAO.getNewestProofread(scriptid).get(0);
	}

}
