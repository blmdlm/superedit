package service;

import model.Audit;
import model.Script;

/**
 * 
 * @author gejing
 *
 */
public interface AuditService {
	/**
	 * 查询一个稿件的最新审核记录
	 * @param scriptid
	 * @return
	 */
	public Audit getNewest(int scriptid) throws RuntimeException;
}
