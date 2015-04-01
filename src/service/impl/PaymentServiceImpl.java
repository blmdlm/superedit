package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AssistDAO;
import dao.PaymentDAO;
import model.Payment;
import model.Publisher;
import model.Script;
import service.PaymentService;
/**
 * 
 * @author jym
 *
 */
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	AssistDAO assitDAO;
	@Autowired
	PaymentDAO paymentDAO;
	
	@Override
	public List<Payment> findPassUnSetByPubliser(Publisher publisher) {
		return assitDAO.findPassUnSetByPubliser(publisher);
	}

	@Override
	public Payment get(Integer id) {
		return paymentDAO.findById(id);
	}

	@Override
	public void update(Payment payment) {
		paymentDAO.merge(payment);
	}

	@Override
	public List<Payment> findUnpayByPubliserAndStaff(Publisher publisher,int staffid) {
		return assitDAO.findUnpayByPubliserAndStaff(publisher,staffid);
	}

	@Override
	public List<Payment> findPayedByPubliserAndStaff(Publisher publisher,
			int staffid) {
		return assitDAO.findPayedByPubliserAndStaff(publisher,staffid);
	}

	@Override
	public Payment getByScriptid(int id) {
		return paymentDAO.findByScriptId(id).get(0);
	}

}
