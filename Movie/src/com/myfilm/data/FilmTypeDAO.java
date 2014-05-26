package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FilmType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.myfilm.data.FilmType
 * @author MyEclipse Persistence Tools
 */
public class FilmTypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FilmTypeDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(FilmType transientInstance) {
		log.debug("saving FilmType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FilmType persistentInstance) {
		log.debug("deleting FilmType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmType findById(com.myfilm.data.FilmTypeId id) {
		log.debug("getting FilmType instance with id: " + id);
		try {
			FilmType instance = (FilmType) getHibernateTemplate().get(
					"com.myfilm.data.FilmType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<FilmType> findByExample(FilmType instance) {
		log.debug("finding FilmType instance by example");
		try {
			List<FilmType> results = (List<FilmType>) getHibernateTemplate()
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
		log.debug("finding FilmType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FilmType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all FilmType instances");
		try {
			String queryString = "from FilmType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FilmType merge(FilmType detachedInstance) {
		log.debug("merging FilmType instance");
		try {
			FilmType result = (FilmType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmType instance) {
		log.debug("attaching dirty FilmType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmType instance) {
		log.debug("attaching clean FilmType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmTypeDAO) ctx.getBean("FilmTypeDAO");
	}
}