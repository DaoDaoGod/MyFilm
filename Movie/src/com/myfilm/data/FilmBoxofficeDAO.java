package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * FilmBoxoffice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.myfilm.data.FilmBoxoffice
 * @author MyEclipse Persistence Tools
 */
public class FilmBoxofficeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FilmBoxofficeDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(FilmBoxoffice transientInstance) {
		log.debug("saving FilmBoxoffice instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FilmBoxoffice persistentInstance) {
		log.debug("deleting FilmBoxoffice instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmBoxoffice findById(com.myfilm.data.FilmBoxofficeId id) {
		log.debug("getting FilmBoxoffice instance with id: " + id);
		try {
			FilmBoxoffice instance = (FilmBoxoffice) getHibernateTemplate()
					.get("com.myfilm.data.FilmBoxoffice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FilmBoxoffice instance) {
		log.debug("finding FilmBoxoffice instance by example");
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
		log.debug("finding FilmBoxoffice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FilmBoxoffice as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all FilmBoxoffice instances");
		try {
			String queryString = "from FilmBoxoffice";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FilmBoxoffice merge(FilmBoxoffice detachedInstance) {
		log.debug("merging FilmBoxoffice instance");
		try {
			FilmBoxoffice result = (FilmBoxoffice) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmBoxoffice instance) {
		log.debug("attaching dirty FilmBoxoffice instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmBoxoffice instance) {
		log.debug("attaching clean FilmBoxoffice instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmBoxofficeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (FilmBoxofficeDAO) ctx.getBean("FilmBoxofficeDAO");
	}
}