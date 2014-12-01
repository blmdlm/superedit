package dao;

import java.util.Date;
import java.util.List;

import model.Messageboard;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Messageboard entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see model.Messageboard
 * @author MyEclipse Persistence Tools
 */
public class MessageboardDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MessageboardDAO.class);
	// property constants
	public static final String SEND_ID = "sendId";
	public static final String CONTENT = "content";
	public static final String PARENTID = "parentid";
	public static final String TYPE = "type";
	public static final String STAFF_ID = "staffId";
	public static final String AUDIT_STATUS = "auditStatus";
	public static final String REPLY_STATUS = "replyStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(Messageboard transientInstance) {
		log.debug("saving Messageboard instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Messageboard persistentInstance) {
		log.debug("deleting Messageboard instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Messageboard findById(java.lang.Integer id) {
		log.debug("getting Messageboard instance with id: " + id);
		try {
			Messageboard instance = (Messageboard) getHibernateTemplate().get(
					"model.Messageboard", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Messageboard> findByExample(Messageboard instance) {
		log.debug("finding Messageboard instance by example");
		try {
			List<Messageboard> results = (List<Messageboard>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Messageboard instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Messageboard as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Messageboard> findBySendId(Object sendId) {
		return findByProperty(SEND_ID, sendId);
	}

	public List<Messageboard> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Messageboard> findByParentid(Object parentid) {
		return findByProperty(PARENTID, parentid);
	}

	public List<Messageboard> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Messageboard> findByStaffId(Object staffId) {
		return findByProperty(STAFF_ID, staffId);
	}

	public List<Messageboard> findByAuditStatus(Object auditStatus) {
		return findByProperty(AUDIT_STATUS, auditStatus);
	}

	public List<Messageboard> findByReplyStatus(Object replyStatus) {
		return findByProperty(REPLY_STATUS, replyStatus);
	}

	public List findAll() {
		log.debug("finding all Messageboard instances");
		try {
			String queryString = "from Messageboard";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Messageboard merge(Messageboard detachedInstance) {
		log.debug("merging Messageboard instance");
		try {
			Messageboard result = (Messageboard) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Messageboard instance) {
		log.debug("attaching dirty Messageboard instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Messageboard instance) {
		log.debug("attaching clean Messageboard instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MessageboardDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (MessageboardDAO) ctx.getBean("MessageboardDAO");
	}
}