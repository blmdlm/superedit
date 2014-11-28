package dao;

import java.util.List;
import java.util.Set;

import model.Magazine;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Magazine entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Magazine
 * @author MyEclipse Persistence Tools
 */
public class MagazineDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MagazineDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Magazine transientInstance) {
		log.debug("saving Magazine instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Magazine persistentInstance) {
		log.debug("deleting Magazine instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Magazine findById(java.lang.Integer id) {
		log.debug("getting Magazine instance with id: " + id);
		try {
			Magazine instance = (Magazine) getHibernateTemplate().get(
					"model.Magazine", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Magazine> findByExample(Magazine instance) {
		log.debug("finding Magazine instance by example");
		try {
			List<Magazine> results = (List<Magazine>) getHibernateTemplate()
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
		log.debug("finding Magazine instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Magazine as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Magazine> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Magazine instances");
		try {
			String queryString = "from Magazine";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Magazine merge(Magazine detachedInstance) {
		log.debug("merging Magazine instance");
		try {
			Magazine result = (Magazine) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Magazine instance) {
		log.debug("attaching dirty Magazine instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Magazine instance) {
		log.debug("attaching clean Magazine instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MagazineDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MagazineDAO) ctx.getBean("MagazineDAO");
	}
}