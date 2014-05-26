package com.myfilm.data;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Place
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.myfilm.data.Place
 * @author MyEclipse Persistence Tools
 */
public class PlaceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PlaceDAO.class);
	// property constants
	public static final String PLACE = "place";

	protected void initDao() {
		// do nothing
	}

	public void save(Place transientInstance) {
		log.debug("saving Place instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Place persistentInstance) {
		log.debug("deleting Place instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Place findById(java.lang.Integer id) {
		log.debug("getting Place instance with id: " + id);
		try {
			Place instance = (Place) getHibernateTemplate().get(
					"com.myfilm.data.Place", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Place> findByExample(Place instance) {
		log.debug("finding Place instance by example");
		try {
			List<Place> results = (List<Place>) getHibernateTemplate()
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
		log.debug("finding Place instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Place as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Place> findByPlace(Object place) {
		return findByProperty(PLACE, place);
	}

	public List findAll() {
		log.debug("finding all Place instances");
		try {
			String queryString = "from Place";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Place merge(Place detachedInstance) {
		log.debug("merging Place instance");
		try {
			Place result = (Place) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Place instance) {
		log.debug("attaching dirty Place instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Place instance) {
		log.debug("attaching clean Place instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PlaceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PlaceDAO) ctx.getBean("PlaceDAO");
	}
}