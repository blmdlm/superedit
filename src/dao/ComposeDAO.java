package dao;

import java.util.Date;
import java.util.List;

import model.Compose;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Compose entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Compose
 * @author MyEclipse Persistence Tools
 */
public class ComposeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ComposeDAO.class);
	// property constants
	public static final String COMPOSE_PATH = "composePath";
	public static final String COMPOSE_STATE = "composeState";
	public static final String STAFF_ID = "staffId";

	protected void initDao() {
		// do nothing
	}

	public void save(Compose transientInstance) {
		log.debug("saving Compose instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Compose persistentInstance) {
		log.debug("deleting Compose instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Compose findById(java.lang.Integer id) {
		log.debug("getting Compose instance with id: " + id);
		try {
			Compose instance = (Compose) getHibernateTemplate().get(
					"model.Compose", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Compose> findByExample(Compose instance) {
		log.debug("finding Compose instance by example");
		try {
			List<Compose> results = (List<Compose>) getHibernateTemplate()
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
		log.debug("finding Compose instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Compose as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Compose> findByComposePath(Object composePath) {
		return findByProperty(COMPOSE_PATH, composePath);
	}

	public List<Compose> findByComposeState(Object composeState) {
		return findByProperty(COMPOSE_STATE, composeState);
	}

	public List<Compose> findByStaffId(Object staffId) {
		return findByProperty(STAFF_ID, staffId);
	}

	public List findAll() {
		log.debug("finding all Compose instances");
		try {
			String queryString = "from Compose";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Compose merge(Compose detachedInstance) {
		log.debug("merging Compose instance");
		try {
			Compose result = (Compose) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Compose instance) {
		log.debug("attaching dirty Compose instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Compose instance) {
		log.debug("attaching clean Compose instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComposeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ComposeDAO) ctx.getBean("ComposeDAO");
	}
}