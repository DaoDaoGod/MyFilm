package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FilmPrize entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.myfilm.data.FilmPrize
 * @author MyEclipse Persistence Tools
 */
public class FilmPrizeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FilmPrizeDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(FilmPrize transientInstance) {
		log.debug("saving FilmPrize instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FilmPrize persistentInstance) {
		log.debug("deleting FilmPrize instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmPrize findById(com.myfilm.data.FilmPrizeId id) {
		log.debug("getting FilmPrize instance with id: " + id);
		try {
			FilmPrize instance = (FilmPrize) getHibernateTemplate().get(
					"com.myfilm.data.FilmPrize", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FilmPrize instance) {
		log.debug("finding FilmPrize instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding FilmPrize instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FilmPrize as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all FilmPrize instances");
		try {
			String queryString = "from FilmPrize";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FilmPrize merge(FilmPrize detachedInstance) {
		log.debug("merging FilmPrize instance");
		try {
			FilmPrize result = (FilmPrize) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmPrize instance) {
		log.debug("attaching dirty FilmPrize instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmPrize instance) {
		log.debug("attaching clean FilmPrize instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmPrizeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmPrizeDAO) ctx.getBean("FilmPrizeDAO");
	}
}