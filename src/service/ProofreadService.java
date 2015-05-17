package service;

import model.Proofread;

public interface ProofreadService {
	/**
	 * 查询最新的稿件校对记录
	 * @param id
	 * @return
	 */
	Proofread getNewest(int id) throws RuntimeException;

	String[] getProofreadState(Proofread proofread);

}
