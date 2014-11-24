package dao;

import java.util.Date;
import java.util.List;

import model.Audit;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Audit
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see model.Audit
 * @author MyEclipse Persistence Tools
 */
public class AuditDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AuditDAO.class);
	// property constants
	public static final String STAFF_ID = "staffId";
	public static final String AUDIT_PATH = "auditPath";
	public static final String AUDIT_RANK = "auditRank";
	public static final String AUDIT_STATE = "auditState";

	protected void initDao() {
		// do nothing
	}

	public void save(Audit transientInstance) {
		log.debug("saving Audit instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Audit persistentInstance) {
		log.debug("deleting Audit instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Audit findById(java.lang.Integer id) {
		log.debug("getting Audit instance with id: " + id);
		try {
			Audit instance = (Audit) getHibernateTemplate()
					.get("dao.Audit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Audit> findByExample(Audit instance) {
		log.debug("finding Audit instance by example");
		try {
			List<Audit> results = (List<Audit>) getHibernateTemplate()
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
		log.debug("finding Audit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Audit as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Audit> findByStaffId(Object staffId) {
		return findByProperty(STAFF_ID, staffId);
	}

	public List<Audit> findByAuditPath(Object auditPath) {
		return findByProperty(AUDIT_PATH, auditPath);
	}

	public List<Audit> findByAuditRank(Object auditRank) {
		return findByProperty(AUDIT_RANK, auditRank);
	}

	public List<Audit> findByAuditState(Object auditState) {
		return findByProperty(AUDIT_STATE, auditState);
	}

	public List findAll() {
		log.debug("finding all Audit instances");
		try {
			String queryString = "from Audit";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Audit merge(Audit detachedInstance) {
		log.debug("merging Audit instance");
		try {
			Audit result = (Audit) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Audit instance) {
		log.debug("attaching dirty Audit instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Audit instance) {
		log.debug("attaching clean Audit instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AuditDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AuditDAO) ctx.getBean("AuditDAO");
	}
}