package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import model.Message;
import service.MessageService;
/**
 * 
 *@Project superedit 
 *@ClassName MessageServiceImpl
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年12月5日 下午9:12:52
 */
public class MessageServiceImpl implements MessageService {
	@Autowired
	AssistDAO assistDAO;
	
	@Override
	public Message findLastMessage(Integer id, Integer id2) {
		List<Message> messages= assistDAO.findLastMessage(id,id2);
		if (messages.size()==0) {
			return null;
		}
		return messages.get(0);
		
	}

	
	
}
