package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FilmPlace entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.myfilm.data.FilmPlace
 * @author MyEclipse Persistence Tools
 */
public class FilmPlaceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FilmPlaceDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(FilmPlace transientInstance) {
		log.debug("saving FilmPlace instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FilmPlace persistentInstance) {
		log.debug("deleting FilmPlace instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmPlace findById(com.myfilm.data.FilmPlaceId id) {
		log.debug("getting FilmPlace instance with id: " + id);
		try {
			FilmPlace instance = (FilmPlace) getHibernateTemplate().get(
					"com.myfilm.data.FilmPlace", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<FilmPlace> findByExample(FilmPlace instance) {
		log.debug("finding FilmPlace instance by example");
		try {
			List<FilmPlace> results = (List<FilmPlace>) getHibernateTemplate()
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
		log.debug("finding FilmPlace instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FilmPlace as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all FilmPlace instances");
		try {
			String queryString = "from FilmPlace";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FilmPlace merge(FilmPlace detachedInstance) {
		log.debug("merging FilmPlace instance");
		try {
			FilmPlace result = (FilmPlace) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmPlace instance) {
		log.debug("attaching dirty FilmPlace instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmPlace instance) {
		log.debug("attaching clean FilmPlace instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmPlaceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmPlaceDAO) ctx.getBean("FilmPlaceDAO");
	}
}