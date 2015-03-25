package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import model.Audit;
import service.AuditService;

/**
 * 
 * @author jym
 *
 */
public class AuditServiceImpl implements AuditService{
	@Autowired
	AssistDAO assitDAO;
	@Override
	public Audit getNewest(int scriptid) {
		return assitDAO.getNewestAudit(scriptid).get(0);
	}

}
