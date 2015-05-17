package dao;

import java.util.List;

import model.Staff;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Staff
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see model.Staff
 * @author MyEclipse Persistence Tools
 */
public class StaffDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StaffDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String PARENTID = "parentid";
	public static final String ROLE = "role";
	public static final String LEVEL = "level";
	public static final String NAME = "name";
	public static final String GENDER = "gender";
	public static final String PHONE = "phone";
	public static final String MAGAZINE_ID = "magazineId";
	public static final String LOCKED = "locked";

	protected void initDao() {
		// do nothing
	}

	public void save(Staff transientInstance) {
		log.debug("saving Staff instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Staff persistentInstance) {
		log.debug("deleting Staff instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Staff findById(java.lang.Integer id) {
		log.debug("getting Staff instance with id: " + id);
		try {
			Staff instance = (Staff) getHibernateTemplate().get("model.Staff",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Staff> findByExample(Staff instance) {
		log.debug("finding Staff instance by example");
		try {
			List<Staff> results = (List<Staff>) getHibernateTemplate()
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
		log.debug("finding Staff instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Staff as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Staff> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Staff> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Staff> findByParentid(Object parentid) {
		return findByProperty(PARENTID, parentid);
	}

	public List<Staff> findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List<Staff> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<Staff> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Staff> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<Staff> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Staff> findByMagazineId(Object magazineId) {
		return findByProperty(MAGAZINE_ID, magazineId);
	}

	public List<Staff> findByLocked(Object locked) {
		return findByProperty(LOCKED, locked);
	}

	public List findAll() {
		log.debug("finding all Staff instances");
		try {
			String queryString = "from Staff";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Staff merge(Staff detachedInstance) {
		log.debug("merging Staff instance");
		try {
			Staff result = (Staff) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Staff instance) {
		log.debug("attaching dirty Staff instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Staff instance) {
		log.debug("attaching clean Staff instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StaffDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StaffDAO) ctx.getBean("StaffDAO");
	}
}