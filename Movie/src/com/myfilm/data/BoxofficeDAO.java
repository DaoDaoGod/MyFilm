package com.myfilm.data;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Boxoffice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.myfilm.data.Boxoffice
 * @author MyEclipse Persistence Tools
 */
public class BoxofficeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BoxofficeDAO.class);
	// property constants
	public static final String BOXOFFICE_NAME = "boxofficeName";

	protected void initDao() {
		// do nothing
	}

	public void save(Boxoffice transientInstance) {
		log.debug("saving Boxoffice instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Boxoffice persistentInstance) {
		log.debug("deleting Boxoffice instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Boxoffice findById(com.myfilm.data.BoxofficeId id) {
		log.debug("getting Boxoffice instance with id: " + id);
		try {
			Boxoffice instance = (Boxoffice) getHibernateTemplate().get(
					"com.myfilm.data.Boxoffice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Boxoffice> findByExample(Boxoffice instance) {
		log.debug("finding Boxoffice instance by example");
		try {
			List<Boxoffice> results = (List<Boxoffice>) getHibernateTemplate()
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
		log.debug("finding Boxoffice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Boxoffice as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Boxoffice> findByBoxofficeName(Object boxofficeName) {
		return findByProperty(BOXOFFICE_NAME, boxofficeName);
	}

	public List findAll() {
		log.debug("finding all Boxoffice instances");
		try {
			String queryString = "from Boxoffice";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Boxoffice merge(Boxoffice detachedInstance) {
		log.debug("merging Boxoffice instance");
		try {
			Boxoffice result = (Boxoffice) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Boxoffice instance) {
		log.debug("attaching dirty Boxoffice instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Boxoffice instance) {
		log.debug("attaching clean Boxoffice instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BoxofficeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BoxofficeDAO) ctx.getBean("BoxofficeDAO");
	}
}