package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Audit;
import model.Author;
import model.Compose;
import model.Magazine;
import model.Message;
import model.Messageboard;
import model.Payment;
import model.Proofread;
import model.Publisher;
import model.Script;
import model.Staff;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import service.ScriptService;

import com.mysql.fabric.xmlrpc.base.Value;
/**
 * 辅助DAO
 *@Project superedit 
 *@ClassName AssistDAO
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年11月28日 下午10:47:13
 */
public class AssistDAO extends HibernateDaoSupport{
	
	private static final Logger log = LoggerFactory.getLogger(AssistDAO.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	protected void initDao() {
		// do nothing
	}
	
	
	
	
	
	
	
	
	/**
	 * 通过parentid和role获取staff
	 * @param parentid
	 * @param role
	 * @return
	 */
	public List<Staff> findByParentidAndRole(Integer parentid,Integer role){
		try {
			String queryString = "from Staff as model where model.parentid= ? and role = ? and locked=0 ";
			return getHibernateTemplate().find(queryString, parentid,role);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}
	/**
	 *找到杂志社未审核的留言 
	 * @param publisher
	 * @return
	 */
	public List<Messageboard> findPostAuditMessageByPublisher(
			Publisher publisher) {
		try {
			String queryString = "from Messageboard as model where model.type= 0 and audit_status = 0 order by send_time";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 找到杂志社未回复的留言
	 * @param publisher
	 * @return
	 */
	public List<Messageboard> findUnreplyMessageByPublisher(Publisher publisher) {
		try {
			String queryString = "from Messageboard as model where model.type= 0 and audit_status = 2 and reply_status=0 order by send_time";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List<Messageboard> findAllPassed() {
		try {
			String queryString = "from Messageboard as model where model.type= 0 and audit_status = 2  order by send_time desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List<Messageboard> findByParentid(Integer parentid) {
		try {
			String queryString = "from Messageboard as model where model.type= 1 and parentid = ?";
			return getHibernateTemplate().find(queryString,parentid);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * 找到该出版社所有通过的未设置稿费的记录
	 * @param publisher
	 * @return
	 */
	public List<Payment> findPassUnSetByPubliser(Publisher publisher) {
		
		Set<Magazine> magazines=publisher.getMagazines();
		int count=magazines.size();
		List<Long> ids=new ArrayList<Long>();
		Magazine magazine;
		for (Iterator iterator = magazines.iterator(); iterator.hasNext();) {
			magazine = (Magazine) iterator.next();
			ids.add(Long.valueOf(magazine.getId()));
		}
			
		
		try {
			
			String queryString = "from Payment as model where  state=0 and magazine_id in (:listParam) order by deliver_date";
			String[] params={"listParam"};
			Object[] values={ids};
			return getHibernateTemplate().findByNamedParam(queryString, params, values);
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 找出该出版社某个员工所有设置了稿费，还没有完成支付的稿件
	 * @param publisher
	 * @return
	 */
	public List<Payment> findUnpayByPubliserAndStaff(Publisher publisher,int staffid) {
		Set<Magazine> magazines=publisher.getMagazines();
		int count=magazines.size();
		List<Long> ids=new ArrayList<Long>();
		Magazine magazine;
		for (Iterator iterator = magazines.iterator(); iterator.hasNext();) {
			magazine = (Magazine) iterator.next();
			ids.add(Long.valueOf(magazine.getId()));
		}
			
		
		try {
			
			String queryString = "from Payment as model where staff_id = "+staffid+" and state=1 and magazine_id in (:listParam) order by deliver_date";
			String[] params={"listParam"};
			Object[] values={ids};
			return getHibernateTemplate().findByNamedParam(queryString, params, values);
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 查找该杂志社某个员工所有已完成支付的稿费记录
	 * @param publisher
	 * @return
	 */
	public List<Payment> findPayedByPubliserAndStaff(Publisher publisher,int staffid) {
		Set<Magazine> magazines=publisher.getMagazines();
		int count=magazines.size();
		List<Long> ids=new ArrayList<Long>();
		Magazine magazine;
		for (Iterator iterator = magazines.iterator(); iterator.hasNext();) {
			magazine = (Magazine) iterator.next();
			ids.add(Long.valueOf(magazine.getId()));
		}
			
		
		try {
			
			String queryString = "from Payment as model where staff_id = "+staffid+" and state=2 and magazine_id in (:listParam) order by pay_date";
			String[] params={"listParam"};
			Object[] values={ids};
			return getHibernateTemplate().findByNamedParam(queryString, params, values);
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * 查询投递给该杂志社所有和该标题匹配的稿件
	 * @return
	 */
	public List<Script> queryByScriptTitleInPublisher(String title,Publisher publisher) {
		Set<Magazine> magazines=publisher.getMagazines();
		int count=magazines.size();
		List<Long> ids=new ArrayList<Long>();
		Magazine magazine;
		for (Iterator iterator = magazines.iterator(); iterator.hasNext();) {
			magazine = (Magazine) iterator.next();
			ids.add(Long.valueOf(magazine.getId()));
		}
		
		try {
			
			String queryString = "from Script as model where model.state != 0  and magazine_id in (:listParam) and title like '%"+title+"%' order by date";
			String[] params={"listParam"};
			Object[] values={ids};
			return getHibernateTemplate().findByNamedParam(queryString, params, values);
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	/**
	 * 查询投递给该杂志所有和该标题匹配的稿件
	 * @param title
	 * @param magazineid
	 * @return
	 */
	public List<Script> queryByScriptTitle(String title, int magazineid) {
		try {
			String queryString = "from Script as model  where title like '%"+title+"%' and magazine_id = ?";
			return getHibernateTemplate().find(queryString,magazineid);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 找出新注册的10个用户
	 * @return
	 */
	public List<Author> getTop10New() {
		try {
			String queryString = "from Author as model  order by registertime desc limit 10";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<Author> queryByName(String name) {
		try {
			log.info("name"+name);
			String queryString = "from Author as model  where name like '%"+name+"%' order by registertime desc ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	
	/**
	 * 找出一个作者的所有稿件
	 */
	public List<Script> getAllScriptsByAuthodid(int authorid) {
		try {
			String queryString = "from Script as model  where author_id = ?";
			return getHibernateTemplate().find(queryString,authorid);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
			
		}
	}
	/**
	 * 找出一个作者投递给一个杂志的所有稿件
	 * @param authorid
	 * @param magazineid
	 * @return
	 */
	public List<Script> getAllScriptsByAuthodidAndMagazineid(int authorid,
			int magazineid) {
		try {
			String queryString = "from Script as model  where author_id = ? and magazine_id = ?";
			return getHibernateTemplate().find(queryString,authorid,magazineid);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
			
		}
	}
	/**
	 * 找出一个作者投递给一个杂志社的所有稿件
	 * @param authorid
	 * @param publisher
	 * @return
	 */
	public List<Script> getAllScriptsByAuthodidAndPublisher(int authorid,
			Publisher publisher) {
		log.info("publisher="+publisher.getName());
		
		
		Set<Magazine> magazines=publisher.getMagazines();
		int count=magazines.size();
		List<Long> ids=new ArrayList<Long>();
		Magazine magazine;
		for (Iterator iterator = magazines.iterator(); iterator.hasNext();) {
			magazine = (Magazine) iterator.next();
			ids.add(Long.valueOf(magazine.getId()));
		}
		
		try {
			
			String queryString = "from Script as model where magazine_id in (:listParam) and author_id ="+authorid+" order by date";
			String[] params={"listParam"};
			Object[] values={ids};
			return getHibernateTemplate().findByNamedParam(queryString, params, values);
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * 找出一个作者所有投递的稿件数
	 * @param author
	 * @return
	 */
	public List<Long> getSendSumByAuthor(Author author) {
		try {
			String queryString = "select count(*) from Script   where author_id = ?";
			return getHibernateTemplate().find(queryString,author.getId());
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
			
		}
	}
	/**
	 * 找出一个作者所有通过的稿件数
	 * @param author
	 * @return
	 */
	public List<Long> getPassSumByAuthor(Author author) {
		try {
			String queryString = "select count(*) from Script   where author_id = ? and state = 2 ";
			return getHibernateTemplate().find(queryString,author.getId());
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 查找最新的约稿记录
	 * @param id
	 * @param id2
	 * @return
	 */
	public List<Message> findLastMessage(Integer id, Integer id2) {
		try {
			log.info("id="+id+"id2="+id2);
			String queryString = "from Message  as model where sendid = ? and sendstate=10 and recvstate=11 and recvid=? order by time desc";
			return  getHibernateTemplate().find(queryString,id,id2);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	/**
	 * 查询一个稿件的最新的审核记录
	 * @param scriptid
	 * @return
	 */
	public List<Audit> getNewestAudit(int scriptid) {
		try {
			String queryString = "from Audit as model where script_id ="+scriptid+" order by audit_rank desc ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}








	public List<Proofread> getNewestProofread(int scriptid) {
		try {
			String queryString = "from Proofread as model where script_id ="+scriptid+" order by proof_rank desc ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}








	public List<Compose> getNewestCompose(int scriptid) {
		try {
			String queryString = "from Compose as model where script_id ="+scriptid+" order by proofread_rank desc ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}







	/**
	 * 找出某个出版社某个职员的留言记录
	 * @param publisher
	 * @param id
	 * @return
	 */
	public List<Messageboard> findReocrdByPublisherAndStaff(
			Publisher publisher, Integer id) {
		
		log.info("pid="+publisher.getId()+" staffid="+id);
		try {
			String queryString = "from Messageboard as model where model.type= 1  and send_id="+id+" and publisher_id="+publisher.getId()+" order by send_time";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}







	/**
	 * 获取某个出版社所有的杂志
	 * @param publisher
	 * @return
	 */
	public List<Magazine> getAllMagazinesByPublisher(Publisher publisher) {
		try {
			String queryString = "from Magazine as model where publisher_id ="+publisher.getId();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			
			throw re;
		}
	}







































	
	

}
