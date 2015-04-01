package dao;

import java.util.Date;
import java.util.List;

import model.Payment;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Payment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Payment
 * @author MyEclipse Persistence Tools
 */
public class PaymentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PaymentDAO.class);
	// property constants
	public static final String SCRIPT_ID = "scriptId";
	public static final String STAFF_ID = "staffId";
	public static final String MAGAZINE_ID = "magazineId";
	public static final String COST = "cost";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public void save(Payment transientInstance) {
		log.debug("saving Payment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Payment persistentInstance) {
		log.debug("deleting Payment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Payment findById(java.lang.Integer id) {
		log.debug("getting Payment instance with id: " + id);
		try {
			Payment instance = (Payment) getHibernateTemplate().get(
					"model.Payment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Payment> findByExample(Payment instance) {
		log.debug("finding Payment instance by example");
		try {
			List<Payment> results = (List<Payment>) getHibernateTemplate()
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
		log.debug("finding Payment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Payment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Payment> findByScriptId(Object scriptId) {
		return findByProperty(SCRIPT_ID, scriptId);
	}

	public List<Payment> findByStaffId(Object staffId) {
		return findByProperty(STAFF_ID, staffId);
	}

	public List<Payment> findByMagazineId(Object magazineId) {
		return findByProperty(MAGAZINE_ID, magazineId);
	}

	public List<Payment> findByCost(Object cost) {
		return findByProperty(COST, cost);
	}

	public List<Payment> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Payment instances");
		try {
			String queryString = "from Payment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Payment merge(Payment detachedInstance) {
		log.debug("merging Payment instance");
		try {
			Payment result = (Payment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Payment instance) {
		log.debug("attaching dirty Payment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Payment instance) {
		log.debug("attaching clean Payment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PaymentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PaymentDAO) ctx.getBean("PaymentDAO");
	}
}