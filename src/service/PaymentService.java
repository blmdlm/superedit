package service;

import java.util.List;

import model.Payment;
import model.Publisher;
import model.Script;

/**
 * 
 * @author jym
 *
 */
public interface PaymentService {
	/**
	 * 查找某个杂志社没有设置稿费的记录
	 * @param publisher
	 * @return
	 */
	List<Payment> findPassUnSetByPubliser(Publisher publisher);
	/**
	 * 获取一条稿费记录
	 * @param id
	 * @return
	 */
	Payment get(Integer id);
	/**
	 * 更新一条稿费记录
	 * @param payment
	 * @return
	 */
	 void update(Payment payment);
	 /**
	  * 查找某个杂志社某个员工已经设置了稿费但是待支付的记录
	  * @param publisher
	  * @return
	  */
	List<Payment> findUnpayByPubliserAndStaff(Publisher publisher,int staffid);
	/**
	 * 查找某个杂志社某个员工所有操作支付完成的稿费记录
	 * @param publisher
	 * @param staffid
	 * @return
	 */
	List<Payment> findPayedByPubliserAndStaff(Publisher publisher, int staffid);
	/**
	 * 通过稿件id找到稿费记录
	 * @param id
	 * @return
	 */
	Payment getByScriptid(int id);
	
}
