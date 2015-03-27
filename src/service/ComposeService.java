package service;

import model.Compose;

public interface ComposeService {
	/**
	 * 查询最新的稿件排版记录
	 * @param id
	 * @return
	 */
	Compose getNewest(int id) throws RuntimeException;

}
