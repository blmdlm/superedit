package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import model.Compose;
import service.ComposeService;
import service.StaffService;

public class ComposeServiceImpl implements ComposeService{
	@Autowired
	AssistDAO assistDAO;
	@Autowired
	StaffService staffService;
	
	@Override
	public Compose getNewest(int scriptid) {
		// TODO Auto-generated method stub
		return assistDAO.getNewestCompose(scriptid).get(0);
	}


	@Override
	public String[] getComposeState(Compose compose) {
		String result = null;
		switch (compose.getComposeState()) {
		case 0: // 待排版
			result = "待排版";
			break;
		case 1: // 排版中
			result = "排版中 " + staffService.get(compose.getStaffId()).getName()
					+ " " + compose.getComposeDate();
			break;
		case 2: // 排版完成
			result = "排版完成 " + staffService.get(compose.getStaffId()).getName()
					+ " " + compose.getComposeDate();
			break;
		default:
			break;
		}

		return new String[] { result };
	}

}
