package dao;

import java.util.List;

import model.Messageboard;
import model.Publisher;
import model.Staff;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
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
			String queryString = "from Staff as model where model.parentid= ? and role = ? ";
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
			String queryString = "from Messageboard as model where model.type= 0 and audit_status = 0 ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	

}
