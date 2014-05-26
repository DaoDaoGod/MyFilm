package com.myfilm.data;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Film
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.myfilm.data.Film
 * @author MyEclipse Persistence Tools
 */
public class FilmDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(FilmDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String DIRECTOR = "director";
	public static final String DURATION = "duration";
	public static final String DBLINK = "dblink";
	public static final String DBGRADE = "dbgrade";
	public static final String HOTGRADE = "hotgrade";
	public static final String OTHERNAME = "othername";

	protected void initDao() {
		// do nothing
	}

	public void save(Film transientInstance) {
		log.debug("saving Film instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Film persistentInstance) {
		log.debug("deleting Film instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Film findById(java.lang.Integer id) {
		log.debug("getting Film instance with id: " + id);
		try {
			Film instance = (Film) getHibernateTemplate().get(
					"com.myfilm.data.Film", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Film> findByExample(Film instance) {
		log.debug("finding Film instance by example");
		try {
			List<Film> results = (List<Film>) getHibernateTemplate()
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
		log.debug("finding Film instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Film as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Film> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Film> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<Film> findByDirector(Object director) {
		return findByProperty(DIRECTOR, director);
	}

	public List<Film> findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List<Film> findByDblink(Object dblink) {
		return findByProperty(DBLINK, dblink);
	}

	public List<Film> findByDbgrade(Object dbgrade) {
		return findByProperty(DBGRADE, dbgrade);
	}

	public List<Film> findByHotgrade(Object hotgrade) {
		return findByProperty(HOTGRADE, hotgrade);
	}

	public List<Film> findByOthername(Object othername) {
		return findByProperty(OTHERNAME, othername);
	}

	public List findAll() {
		log.debug("finding all Film instances");
		try {
			String queryString = "from Film";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Film merge(Film detachedInstance) {
		log.debug("merging Film instance");
		try {
			Film result = (Film) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Film instance) {
		log.debug("attaching dirty Film instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Film instance) {
		log.debug("attaching clean Film instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmDAO) ctx.getBean("FilmDAO");
	}
}