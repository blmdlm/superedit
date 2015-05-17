package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import model.Audit;
import service.AuditService;
import service.StaffService;

/**
 * 
 * @author jym
 *
 */
public class AuditServiceImpl implements AuditService{
	@Autowired
	AssistDAO assitDAO;
	@Autowired
	StaffService staffService;
	
	@Override
	public Audit getNewest(int scriptid) {
		return assitDAO.getNewestAudit(scriptid).get(0);
	}
	@Override
	public String[] getAuditState(Audit audit) {
		String result = null;
		switch (audit.getAuditState()) {
		case 0: // 待审核
			result = "待审核";
			break;
		case 1: // 审核中
			result = "审核中 " + staffService.get(audit.getStaffId()).getName()
					+ " " + audit.getAuditDate();
			break;
		case 2: // 审核通过
			result = "审核通过 " + staffService.get(audit.getStaffId()).getName()
					+ " " + audit.getAuditDate();
			break;
		case 3: // 审核不通过
			result = "审核不通过 " + staffService.get(audit.getStaffId()).getName()
					+ " " + audit.getAuditDate();
			break;

		default:
			break;
		}

		return new String[] { result };
	}

}
