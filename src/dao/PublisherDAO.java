package dao;

import java.util.List;
import java.util.Set;

import model.Publisher;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Publisher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Publisher
 * @author MyEclipse Persistence Tools
 */
public class PublisherDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PublisherDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Publisher transientInstance) {
		log.debug("saving Publisher instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Publisher persistentInstance) {
		log.debug("deleting Publisher instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publisher findById(java.lang.Integer id) {
		log.debug("getting Publisher instance with id: " + id);
		try {
			Publisher instance = (Publisher) getHibernateTemplate().get(
					"dao.Publisher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Publisher> findByExample(Publisher instance) {
		log.debug("finding Publisher instance by example");
		try {
			List<Publisher> results = (List<Publisher>) getHibernateTemplate()
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
		log.debug("finding Publisher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Publisher as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Publisher> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Publisher instances");
		try {
			String queryString = "from Publisher";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Publisher merge(Publisher detachedInstance) {
		log.debug("merging Publisher instance");
		try {
			Publisher result = (Publisher) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Publisher instance) {
		log.debug("attaching dirty Publisher instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publisher instance) {
		log.debug("attaching clean Publisher instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PublisherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PublisherDAO) ctx.getBean("PublisherDAO");
	}
}