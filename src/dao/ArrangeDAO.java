package dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Arrange entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Arrange
 * @author MyEclipse Persistence Tools
 */
public class ArrangeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ArrangeDAO.class);
	// property constants
	public static final String ARRANGE_TITLE = "arrangeTitle";
	public static final String ARRANGE_CONTENT = "arrangeContent";

	protected void initDao() {
		// do nothing
	}

	public void save(Arrange transientInstance) {
		log.debug("saving Arrange instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Arrange persistentInstance) {
		log.debug("deleting Arrange instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Arrange findById(dao.ArrangeId id) {
		log.debug("getting Arrange instance with id: " + id);
		try {
			Arrange instance = (Arrange) getHibernateTemplate().get(
					"dao.Arrange", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Arrange> findByExample(Arrange instance) {
		log.debug("finding Arrange instance by example");
		try {
			List<Arrange> results = (List<Arrange>) getHibernateTemplate()
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
		log.debug("finding Arrange instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Arrange as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Arrange> findByArrangeTitle(Object arrangeTitle) {
		return findByProperty(ARRANGE_TITLE, arrangeTitle);
	}

	public List<Arrange> findByArrangeContent(Object arrangeContent) {
		return findByProperty(ARRANGE_CONTENT, arrangeContent);
	}

	public List findAll() {
		log.debug("finding all Arrange instances");
		try {
			String queryString = "from Arrange";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Arrange merge(Arrange detachedInstance) {
		log.debug("merging Arrange instance");
		try {
			Arrange result = (Arrange) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Arrange instance) {
		log.debug("attaching dirty Arrange instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Arrange instance) {
		log.debug("attaching clean Arrange instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArrangeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArrangeDAO) ctx.getBean("ArrangeDAO");
	}
}