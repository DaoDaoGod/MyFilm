package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FilmGroup entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.myfilm.data.FilmGroup
 * @author MyEclipse Persistence Tools
 */
public class FilmGroupDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FilmGroupDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(FilmGroup transientInstance) {
		log.debug("saving FilmGroup instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FilmGroup persistentInstance) {
		log.debug("deleting FilmGroup instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmGroup findById(com.myfilm.data.FilmGroupId id) {
		log.debug("getting FilmGroup instance with id: " + id);
		try {
			FilmGroup instance = (FilmGroup) getHibernateTemplate().get(
					"com.myfilm.data.FilmGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<FilmGroup> findByExample(FilmGroup instance) {
		log.debug("finding FilmGroup instance by example");
		try {
			List<FilmGroup> results = (List<FilmGroup>) getHibernateTemplate()
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
		log.debug("finding FilmGroup instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FilmGroup as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all FilmGroup instances");
		try {
			String queryString = "from FilmGroup";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FilmGroup merge(FilmGroup detachedInstance) {
		log.debug("merging FilmGroup instance");
		try {
			FilmGroup result = (FilmGroup) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmGroup instance) {
		log.debug("attaching dirty FilmGroup instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmGroup instance) {
		log.debug("attaching clean FilmGroup instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmGroupDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmGroupDAO) ctx.getBean("FilmGroupDAO");
	}
}