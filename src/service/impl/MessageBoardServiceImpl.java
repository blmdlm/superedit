package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import dao.MessageboardDAO;
import model.Messageboard;
import model.Publisher;
import service.MessageBoardService;
/**
 * 
 *@Project superedit 
 *@ClassName MessageBoardServiceImpl
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月2日 下午3:29:33
 */
public class MessageBoardServiceImpl implements MessageBoardService {
	@Autowired
	AssistDAO assistDAO;
	@Autowired
	MessageboardDAO messageboardDAO;
	@Override
	public List<Messageboard> findPostAuditMessageByPublisher(
			Publisher publisher) {
		return assistDAO.findPostAuditMessageByPublisher(publisher);
	}

	@Override
	public void update(Messageboard messageboard) {
		messageboardDAO.merge(messageboard);
		
	}

	@Override
	public Messageboard get(Integer id) {
		return messageboardDAO.findById(id);
	
		
	}

	@Override
	public List<Messageboard> findUnreplyMessageByPublisher(Publisher publisher) {
		return assistDAO.findUnreplyMessageByPublisher(publisher);
	}

	@Override
	public void save(Messageboard messageboard) {
		messageboardDAO.save(messageboard);
		
	}

	@Override
	public List<Messageboard> findAllPassed() {
		return assistDAO.findAllPassed();
		
	}

	@Override
	public List<Messageboard> findByParentid(Integer parentid) {
		return messageboardDAO.findByParentid(parentid); 
	}

}
