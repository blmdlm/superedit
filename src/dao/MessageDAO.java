package dao;

import java.util.List;

import model.Message;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Message entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Message
 * @author MyEclipse Persistence Tools
 */
public class MessageDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(MessageDAO.class);
	// property constants
	public static final String SENDID = "sendid";
	public static final String SENDSTATE = "sendstate";
	public static final String RECVID = "recvid";
	public static final String RECVSTATE = "recvstate";
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	public void save(Message transientInstance) {
		log.debug("saving Message instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Message persistentInstance) {
		log.debug("deleting Message instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Message findById(java.lang.Integer id) {
		log.debug("getting Message instance with id: " + id);
		try {
			Message instance = (Message) getHibernateTemplate().get(
					"dao.Message", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Message> findByExample(Message instance) {
		log.debug("finding Message instance by example");
		try {
			List<Message> results = (List<Message>) getHibernateTemplate()
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
		log.debug("finding Message instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Message as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Message> findBySendid(Object sendid) {
		return findByProperty(SENDID, sendid);
	}

	public List<Message> findBySendstate(Object sendstate) {
		return findByProperty(SENDSTATE, sendstate);
	}

	public List<Message> findByRecvid(Object recvid) {
		return findByProperty(RECVID, recvid);
	}

	public List<Message> findByRecvstate(Object recvstate) {
		return findByProperty(RECVSTATE, recvstate);
	}

	public List<Message> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Message instances");
		try {
			String queryString = "from Message";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Message merge(Message detachedInstance) {
		log.debug("merging Message instance");
		try {
			Message result = (Message) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Message instance) {
		log.debug("attaching dirty Message instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Message instance) {
		log.debug("attaching clean Message instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MessageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MessageDAO) ctx.getBean("MessageDAO");
	}
}