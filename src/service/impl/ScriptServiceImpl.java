package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import dao.ScriptDAO;
import model.Publisher;
import model.Script;
import service.ScriptService;

/**
 * 		
 *@Project superedit 
 *@ClassName ScriptServiceImpl
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月3日 下午7:11:58
 */
public class ScriptServiceImpl implements ScriptService{
	@Autowired
	ScriptDAO scriptDAO;
	@Autowired
	AssistDAO assistDAO;
	
	@Override
	public List<Script> findPassUnSetByPubliser(Publisher publisher) {
		return assistDAO.findPassUnSetByPubliser(publisher);
	}

	@Override
	public Script get(Integer id) {
		return scriptDAO.findById(id);
	}

	@Override
	public void update(Script script) {
		scriptDAO.merge(script);
		
	}

	@Override
	public List<Script> findUnpayByPubliser(Publisher publisher) {
		return assistDAO.findUnpayByPubliser(publisher);
	}

	@Override
	public List<Script> findPayedByPubliser(Publisher publisher) {
		return assistDAO.findPayedByPubliser(publisher);
	}

}