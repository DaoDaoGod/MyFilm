package com.myfilm.data;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Group
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.myfilm.data.Group
 * @author MyEclipse Persistence Tools
 */
public class GroupDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(GroupDAO.class);
	// property constants
	public static final String GROUP_NAME = "groupName";
	public static final String GROUP_DESCRIPTION = "groupDescription";
	public static final String GROUP_OWNER = "groupOwner";

	protected void initDao() {
		// do nothing
	}

	public void save(Group transientInstance) {
		log.debug("saving Group instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Group persistentInstance) {
		log.debug("deleting Group instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Group findById(java.lang.Integer id) {
		log.debug("getting Group instance with id: " + id);
		try {
			Group instance = (Group) getHibernateTemplate().get(
					"com.myfilm.data.Group", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Group instance) {
		log.debug("finding Group instance by example");
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
		log.debug("finding Group instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Group as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGroupName(Object groupName) {
		return findByProperty(GROUP_NAME, groupName);
	}

	public List findByGroupDescription(Object groupDescription) {
		return findByProperty(GROUP_DESCRIPTION, groupDescription);
	}

	public List findByGroupOwner(Object groupOwner) {
		return findByProperty(GROUP_OWNER, groupOwner);
	}

	public List findAll() {
		log.debug("finding all Group instances");
		try {
			String queryString = "from Group";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Group merge(Group detachedInstance) {
		log.debug("merging Group instance");
		try {
			Group result = (Group) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Group instance) {
		log.debug("attaching dirty Group instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Group instance) {
		log.debug("attaching clean Group instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GroupDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GroupDAO) ctx.getBean("GroupDAO");
	}
}