package com.myfilm.data;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * GroupComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.myfilm.data.GroupComment
 * @author MyEclipse Persistence Tools
 */
public class GroupCommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(GroupCommentDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";
	public static final String CONTENT = "content";
	public static final String ADD_TIME = "addTime";

	protected void initDao() {
		// do nothing
	}

	public void save(GroupComment transientInstance) {
		log.debug("saving GroupComment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GroupComment persistentInstance) {
		log.debug("deleting GroupComment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GroupComment findById(com.myfilm.data.GroupCommentId id) {
		log.debug("getting GroupComment instance with id: " + id);
		try {
			GroupComment instance = (GroupComment) getHibernateTemplate().get(
					"com.myfilm.data.GroupComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<GroupComment> findByExample(GroupComment instance) {
		log.debug("finding GroupComment instance by example");
		try {
			List<GroupComment> results = (List<GroupComment>) getHibernateTemplate()
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
		log.debug("finding GroupComment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from GroupComment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<GroupComment> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<GroupComment> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<GroupComment> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<GroupComment> findByAddTime(Object addTime) {
		return findByProperty(ADD_TIME, addTime);
	}

	public List findAll() {
		log.debug("finding all GroupComment instances");
		try {
			String queryString = "from GroupComment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GroupComment merge(GroupComment detachedInstance) {
		log.debug("merging GroupComment instance");
		try {
			GroupComment result = (GroupComment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GroupComment instance) {
		log.debug("attaching dirty GroupComment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GroupComment instance) {
		log.debug("attaching clean GroupComment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GroupCommentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (GroupCommentDAO) ctx.getBean("GroupCommentDAO");
	}
}