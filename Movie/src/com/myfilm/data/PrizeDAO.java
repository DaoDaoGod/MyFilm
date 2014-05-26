package com.myfilm.data;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Prize
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.myfilm.data.Prize
 * @author MyEclipse Persistence Tools
 */
public class PrizeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PrizeDAO.class);
	// property constants
	public static final String PRIZENAME = "prizename";

	protected void initDao() {
		// do nothing
	}

	public void save(Prize transientInstance) {
		log.debug("saving Prize instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Prize persistentInstance) {
		log.debug("deleting Prize instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Prize findById(com.myfilm.data.PrizeId id) {
		log.debug("getting Prize instance with id: " + id);
		try {
			Prize instance = (Prize) getHibernateTemplate().get(
					"com.myfilm.data.Prize", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Prize> findByExample(Prize instance) {
		log.debug("finding Prize instance by example");
		try {
			List<Prize> results = (List<Prize>) getHibernateTemplate()
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
		log.debug("finding Prize instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Prize as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Prize> findByPrizename(Object prizename) {
		return findByProperty(PRIZENAME, prizename);
	}

	public List findAll() {
		log.debug("finding all Prize instances");
		try {
			String queryString = "from Prize";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Prize merge(Prize detachedInstance) {
		log.debug("merging Prize instance");
		try {
			Prize result = (Prize) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Prize instance) {
		log.debug("attaching dirty Prize instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Prize instance) {
		log.debug("attaching clean Prize instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PrizeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PrizeDAO) ctx.getBean("PrizeDAO");
	}
}