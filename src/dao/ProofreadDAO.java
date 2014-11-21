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
 * Proofread entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Proofread
 * @author MyEclipse Persistence Tools
 */
public class ProofreadDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProofreadDAO.class);
	// property constants
	public static final String PROOF_ADDR = "proofAddr";
	public static final String PROOF_RANK = "proofRank";
	public static final String PROOF_STATE = "proofState";

	protected void initDao() {
		// do nothing
	}

	public void save(Proofread transientInstance) {
		log.debug("saving Proofread instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Proofread persistentInstance) {
		log.debug("deleting Proofread instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Proofread findById(dao.ProofreadId id) {
		log.debug("getting Proofread instance with id: " + id);
		try {
			Proofread instance = (Proofread) getHibernateTemplate().get(
					"dao.Proofread", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Proofread> findByExample(Proofread instance) {
		log.debug("finding Proofread instance by example");
		try {
			List<Proofread> results = (List<Proofread>) getHibernateTemplate()
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
		log.debug("finding Proofread instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Proofread as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Proofread> findByProofAddr(Object proofAddr) {
		return findByProperty(PROOF_ADDR, proofAddr);
	}

	public List<Proofread> findByProofRank(Object proofRank) {
		return findByProperty(PROOF_RANK, proofRank);
	}

	public List<Proofread> findByProofState(Object proofState) {
		return findByProperty(PROOF_STATE, proofState);
	}

	public List findAll() {
		log.debug("finding all Proofread instances");
		try {
			String queryString = "from Proofread";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Proofread merge(Proofread detachedInstance) {
		log.debug("merging Proofread instance");
		try {
			Proofread result = (Proofread) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Proofread instance) {
		log.debug("attaching dirty Proofread instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Proofread instance) {
		log.debug("attaching clean Proofread instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProofreadDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProofreadDAO) ctx.getBean("ProofreadDAO");
	}
}