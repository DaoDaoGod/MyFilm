package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Download entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.myfilm.data.Download
 * @author MyEclipse Persistence Tools
 */
public class DownloadDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(DownloadDAO.class);
	// property constants
	public static final String DOWLOAD_LINK = "dowloadLink";

	protected void initDao() {
		// do nothing
	}

	public void save(Download transientInstance) {
		log.debug("saving Download instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Download persistentInstance) {
		log.debug("deleting Download instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Download findById(com.myfilm.data.DownloadId id) {
		log.debug("getting Download instance with id: " + id);
		try {
			Download instance = (Download) getHibernateTemplate().get(
					"com.myfilm.data.Download", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Download instance) {
		log.debug("finding Download instance by example");
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
		log.debug("finding Download instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Download as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDowloadLink(Object dowloadLink) {
		return findByProperty(DOWLOAD_LINK, dowloadLink);
	}

	public List findAll() {
		log.debug("finding all Download instances");
		try {
			String queryString = "from Download";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Download merge(Download detachedInstance) {
		log.debug("merging Download instance");
		try {
			Download result = (Download) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Download instance) {
		log.debug("attaching dirty Download instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Download instance) {
		log.debug("attaching clean Download instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DownloadDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DownloadDAO) ctx.getBean("DownloadDAO");
	}
}