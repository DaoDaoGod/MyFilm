package com.myfilm.data;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TopicComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.myfilm.data.TopicComment
 * @author MyEclipse Persistence Tools
 */
public class TopicCommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TopicCommentDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	public void save(TopicComment transientInstance) {
		log.debug("saving TopicComment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TopicComment persistentInstance) {
		log.debug("deleting TopicComment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TopicComment findById(com.myfilm.data.TopicCommentId id) {
		log.debug("getting TopicComment instance with id: " + id);
		try {
			TopicComment instance = (TopicComment) getHibernateTemplate().get(
					"com.myfilm.data.TopicComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TopicComment> findByExample(TopicComment instance) {
		log.debug("finding TopicComment instance by example");
		try {
			List<TopicComment> results = (List<TopicComment>) getHibernateTemplate()
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
		log.debug("finding TopicComment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TopicComment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TopicComment> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<TopicComment> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all TopicComment instances");
		try {
			String queryString = "from TopicComment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TopicComment merge(TopicComment detachedInstance) {
		log.debug("merging TopicComment instance");
		try {
			TopicComment result = (TopicComment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TopicComment instance) {
		log.debug("attaching dirty TopicComment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TopicComment instance) {
		log.debug("attaching clean TopicComment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TopicCommentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TopicCommentDAO) ctx.getBean("TopicCommentDAO");
	}
}