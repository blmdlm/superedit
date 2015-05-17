package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import model.Proofread;
import service.ProofreadService;
import service.StaffService;

public class ProofreadServiceImpl implements ProofreadService{
	@Autowired
	AssistDAO assistDAO;
	@Autowired
	StaffService staffService;
	@Override
	public Proofread getNewest(int scriptid) {
		return assistDAO.getNewestProofread(scriptid).get(0);
	}
	@Override
	public String[] getProofreadState(Proofread proofread) {

		String result = null;
		switch (Integer.valueOf(proofread.getProofState()).intValue()) {
		case 0: // 待校对
			result = "待校对";
			break;
		case 1: // 校对中
			result = "校对中 "
					+ staffService.get(proofread.getStaffId()).getName() + " "
					+ proofread.getProofDate();
			break;
		case 2: // 校对完成
			result = "校对完成 "
					+ staffService.get(proofread.getStaffId()).getName() + " "
					+ proofread.getProofDate();
			break;

		default:
			break;
		}

		return new String[] { result };
	}

}
