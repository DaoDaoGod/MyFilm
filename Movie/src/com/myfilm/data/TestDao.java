package com.myfilm.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.GroupBean;
import com.myfilm.bean.TopicBean;
import com.myfilm.bean.TopicCommentBean;
import com.myfilm.bean.UserBean;
import com.myfilm.service.FilmServiceImpl;

public class TestDao {
	
	public static int joinAgroup(Integer userid, Integer groupid) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserGroupDAO userGroupDaoq = (UserGroupDAO) ctx.getBean("UserGroupDAO");
		UserGroupId ugId=new UserGroupId();
		ugId.setGroupId(groupid);
		ugId.setUserId(userid);
	    UserGroup newgroup=new UserGroup();
	    newgroup.setId(ugId);
	    if(userGroupDaoq.findById(ugId)==null)
	    {
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
		session1.save(newgroup);
		tr.commit();
		session1.close();
		factory.close();
		return 0;
	    }
	    else 
	    {
			return 1;
		}
		
	}
	public static void main(final String[]args)
	{
	

	
		
		
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		 
			User newUser=userDao.findById(1);
			Set<UserGroup> sets=newUser.getUserGroups();
			List<GroupBean> list=new ArrayList<GroupBean>();
			Iterator iter=sets.iterator();
			while(iter.hasNext())
			{
				UserGroup newUserGroup=(UserGroup)iter.next();
				GroupBean newBean=new GroupBean();
				newBean.setGroupId(newUserGroup.getGroup().getGroupId());
				newBean.setGroupName(newUserGroup.getGroup().getGroupName());
				System.out.println(newUserGroup.getGroup().getGroupName());
				list.add(newBean);
			}
			//return list;
		 
/*		  Group newGroup=new Group();
		  newGroup.setGroupName("xxxxxxx");
		  newGroup.setGroupDescription("dahsfdlkjdsaflkadsfasdf");
		  SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		  Session  session1=factory.openSession();
		  Transaction  tr=session1.beginTransaction();
		  session1.save(newGroup);
	      tr.commit();
		  session1.close();
		  factory.close();
		  Integer groupid=groupDao.findByGroupName("xxxxxxx").get(0).getGroupId();
		  joinAgroup(1,groupid);
		  */
		  
		 
		/*    User newUser=userDao.findById(3);
		    Set<FilmUser> fuFilmUsers=newUser.getFilmUsers();
           
		    Set<FilmBean> fbBeans=new HashSet<FilmBean>();
		    List<FilmBean> listBeans=new ArrayList<FilmBean>();
		    Iterator  iter=fuFilmUsers.iterator();
		    while(iter.hasNext())
		    {
		    	FilmUser newFilmUser=(FilmUser )iter.next();
		    	if(newFilmUser.getLikestate()!=null&&newFilmUser.getLikestate()==1)
		    	{
		    	Film newFilm=newFilmUser.getFilm();
		    	FilmBean newFilmBean=new FilmBean();
		    	newFilmBean.setFilmId(newFilm.getFilmId());
		    	newFilmBean.setName(newFilm.getName());
		    	System.out.println(newFilm.getName());
		    	newFilmBean.setFilmupdate(newFilm.getUpdate().toLocaleString());
		    	listBeans.add(newFilmBean);
		    	}
		    }*/
		 
		 
		 
		/* User  user=userDao.findById(3);
		 System.out.println(user.getFilmUsers().size());*/
		
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		String hql="from FilmUser where film_id=1 and user_id=3";
		Query query = session.createQuery(hql);
		List<FilmUser> coms=query.list();
		System.out.println(coms.size());*/
/*		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		
		User updateuser=userDao.findById(1);
		updateuser.setNickname("嘻嘻哈哈的猫");
		int gender=1;
		if(gender==0)
		updateuser.setGender(true);
		else
		updateuser.setGender(false);
		
		String birthday="1992-03-04";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Date bir = null;
		try {
			bir = format.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		updateuser.setBirthday(bir);
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
		session1.update(updateuser);
		tr.commit();
		session1.close();
		factory.close();*/
		
		/*  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		    FilmUserDAO fuDao = (FilmUserDAO) ctx.getBean("FilmUserDAO");
		FilmUserId fuId=new FilmUserId();
		fuId.setFilmId(3);
		fuId.setUserId(3);
		FilmUser fuFilmUser=new FilmUser();
		fuFilmUser.setWatchstate(1);
		fuFilmUser.setId(fuId);
	    SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
			session1.save(fuFilmUser);
		
		tr.commit();
		session1.close();
		
		
	    SessionFactory  factory1=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session2=factory1.openSession();
		Transaction  tr1=session2.beginTransaction();
		fuFilmUser.setLikestate(2);
		session2.update(fuFilmUser);
		
		tr1.commit();
		session2.close();*/
		
/*		    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		    UserDAO userDao = (UserDAO) ctx.getBean("UserDAO");
		    User newuer=userDao.findById(1);
		    newuer.setNickname("luhao"); 
		    SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session  session1=factory.openSession();
			Transaction  tr=session1.beginTransaction();
			session1.update(newuer);
			tr.commit();
			session1.close();
			factory.close();
		*/
		
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		//String queryString="from Film where";
		
		Query query = session.createQuery("Select film from Film film,FilmType ftp,Type typ where FilmType.FilmTypeId.  typ.type='科幻'");
		List<Film> tops=query.list();
		for(int i=0;i<tops.size();i++)
			System.out.print(tops.get(i).getName());
		*/
 /*      ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmServiceImpl service = (FilmServiceImpl) ctx.getBean("FilmService");
		List<Film> list = service.getByCatalogue("2014","null","null","null");
		
		System.out.print(list.size());*/
		
	/*	Iterator<Film> iter = list.iterator();
		while(iter.hasNext()){
			Film f = iter.next();
			System.out.println(f.getName());
		}*/
		
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		Query query = session.createQuery("from Group where group_id>0");
		List<Group> tops=query.list();
		List<GroupBean> tbs=new ArrayList<GroupBean>();
		for(int i=0;i<tops.size();i++)
		{
			Group newgroup=tops.get(i);
			GroupBean newGroupBean=new GroupBean();
			newGroupBean.setGroupId(newgroup.getGroupId());
			newGroupBean.setGroupDescription(newgroup.getGroupDescription());
			System.out.print(newgroup.getGroupDescription());
			Integer groupid=newgroup.getGroupId();
			newGroupBean.setGroupName(newgroup.getGroupName());
			newGroupBean.setGroupOwner(newgroup.getGroupOwner());
			newGroupBean.setDroupNumber(newgroup.getDroupNumber());
			tbs.add(newGroupBean);
		}*/
		
		
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		Query query = session.createQuery("from Topic where topic_id>0");
		List<Topic> tops=query.list();
		List<TopicBean> tbs=new ArrayList<TopicBean>();
		for(int i=tops.size()-1;i>=0;i--)
		{
			Topic topic=tops.get(i);
			System.out.print(topic.getContent());
			TopicBean newtopicBean=new TopicBean();
			newtopicBean.setTopicId(topic.getId().getTopicId());
			newtopicBean.setName(topic.getName());
			newtopicBean.setContent(topic.getContent());
			newtopicBean.setUsername(topic.getUsername());
			newtopicBean.setAddtime(topic.getAddtime().toLocaleString().split(" ")[0]);
			tbs.add(newtopicBean);
		}*/
		
		
		
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		TopicId topicId=new TopicId();
		topicId.setGroupId(1);
		Topic newTopic=new Topic();
		newTopic.setId(topicId);
		newTopic.setName("今天是个好日子");
		newTopic.setUserId(1);
		newTopic.setContent("嘻嘻哈哈哈锣鼓腔");
		Transaction  tr=session1.beginTransaction();
		session1.save(newTopic);
		tr.commit();
		session1.close();
		factory.close();*/
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
	    TopicCommentId commentId=new TopicCommentId();

		commentId.setGroupId(1);
		commentId.setTopicId(1);
	    TopicComment tComment=new TopicComment();
	    tComment.setId(commentId);
	    tComment.setUserId(1);
	    tComment.setContent("今天天气真好");

		Transaction  tr=session1.beginTransaction();
		session1.save(tComment);
		tr.commit();
		session1.close();
		factory.close();*/
		
		
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		List<TopicCommentBean> tcbs=new ArrayList<TopicCommentBean>();
		List<TopicComment> tcs=new ArrayList<TopicComment>();
		Query query2=session.createQuery("from TopicComment where topic_id="+1);
		tcs=query2.list();
		System.out.print(tcs.get(0).getId().getTcommentId());*/
		/*Query query = session.createQuery("from Topic where topic_id=1");
		List<Topic> tops=query.list();
		Topic topic=tops.get(0);
		System.out.print(topic.getContent());
		TopicBean newtopicBean=new TopicBean();
		newtopicBean.setTopicId(topic.getId().getTopicId());
		newtopicBean.setName(topic.getName());
		newtopicBean.setContent(topic.getContent());
		newtopicBean.setUsername(topic.getUsername());
		newtopicBean.setAddtime(topic.getAddtime().toLocaleString().split(" ")[0]);*/
/*		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
     
		Query query = session.createQuery("from Topic where topic_id="+1);
		List<Topic> tops=query.list(); 
		            
		Topic topic=tops.get(0);
		TopicBean newtopicBean=new TopicBean();
		newtopicBean.setTopicId(topic.getId().getTopicId());
		newtopicBean.setName(topic.getName());
		newtopicBean.setContent(topic.getContent());
		newtopicBean.setUsername(topic.getUsername());
		newtopicBean.setAddtime(topic.getAddtime().toLocaleString().split(" ")[0]);

		System.out.print(topic.getContent());*/
	/*	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserGroupDAO userGroupDao = (UserGroupDAO) ctx.getBean("UserGroupDAO");
   		
		
	UserGroupId ugId=new UserGroupId();
	ugId.setGroupId(1);
	ugId.setUserId(3);
    UserGroup newgroup=new UserGroup();
    newgroup.setId(ugId);
    if(userGroupDao.findById(ugId)==null)
    {
	SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
	Session  session1=factory.openSession();
	Transaction  tr=session1.beginTransaction();
	session1.save(newgroup);
	tr.commit();
	session1.close();
	factory.close();
    }
    */
	
	/*
	Topic topic=new Topic();
	TopicId tid=new TopicId();
	tid.setTopicId(1);
	tid.setGroupId(1);
	topic=topicDao.findById(tid);
	if(topic==null) System.out.print("sdsd");
	TopicBean newtopicBean=new TopicBean();
	newtopicBean.setTopicId(topic.getId().getTopicId());
	newtopicBean.setName(topic.getName());
	newtopicBean.setContent(topic.getContent());
	newtopicBean.setUsername(topic.getUsername());
	newtopicBean.setAddtime(topic.getAddtime().toLocaleString().split(" ")[0]);
	System.out.print(topic.getContent());*/
	/*Group group=groupDao.findById(1);
	System.out.print(group.getGroupName());
	
	SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
	Session  session=factory.openSession();
	Query query = session.createQuery("from Topic where group_id="+1);
	List<Topic> tops=query.list();
	System.out.print(tops.size());*/
	/*List<Film> list=filmDao.findAll();
	for(int i=0;i<list.size();i++)
		System.out.println(list.get(i).getDescription());*/
/*	UserDAO userDao=(UserDAO)ctx.getBean("UserDAO");
	User newuser=userDao.findById(19);
	UserBean ub=new UserBean();
	ub.setEmail(newuser.getEmail());
	ub.setNickname(newuser.getNickname());
	ub.setUserId(newuser.getUserId());
	ub.setBirthday(newuser.getBirthday().toLocaleString());
	ub.setGender(newuser.getGender());
	System.out.println(ub.getEmail());*/

/*	CommentDAO commentDao=(CommentDAO)ctx.getBean("CommentDAO");
	
	CommentId  commid=new CommentId();
	commid.setFilmId(1);
	SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
	Session  session=factory.openSession();
	Query query = session.createQuery("from Comment where film_id=1");
	List<Comment> coms=query.list();
	System.out.print(coms.size());
	*/
	
/*	commid.setUserId(1);
	Comment comm=new Comment();
	comm.setId(commid);
	comm.setContent("嘻嘻哈哈的猪");
	SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
	Session  session1=factory.openSession();
	Transaction  tr=session1.beginTransaction();
	session1.save(comm);
	tr.commit();
	session1.close();
	factory.close();*/
	/*FilmDAO filmDao=(FilmDAO)ctx.getBean("FilmDAO");
	Film film=filmDao.findById(1);
	Set<Comment> comments=film.getComments();
	 Iterator acIterator=comments.iterator();
	    
	     while(acIterator.hasNext())
	      {
	    	  Comment comment=(Comment)acIterator.next();
	         
	          System.out.println(comment.getUser().getEmail());
	      }
	  */

	/*UserDAO userDao=(UserDAO) ctx.getBean("UserDAO");
	if(userDao.findByEmail("290024136@qq.com")!=null)
	{
		System.out.print("ok1");
	}
	    if(userDao.findByEmail("ashdk")!=null)
	    {
	    	System.out.println("Exist");
	    	
	    }
        User newuser=new User();//insert a user
		newuser.setEmail("290024136@1234.com");
		newuser.setPassword("290024136@163.com");
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		Transaction  tr=session.beginTransaction();
		session.save(newuser);
		tr.commit();
		session.close();
		factory.close();
		System.out.println(newuser.getUserId());
		
	    List<User> user=userDao.findAll();
	    System.out.println("the num of user"+user.size());
*/
	  
	    
	
  /*
	
List<Film> films=dao.findByName("美国队长2");
	Film newFilm=dao.findById(1);
	Set<FilmActor> filmActors=newFilm.getFilmActors();
    Iterator acIterator=filmActors.iterator();
    Set<String> actorSet=new HashSet<String>();
     while(acIterator.hasNext())
      {
    	  FilmActor actor=(FilmActor) acIterator.next();
          actorSet.add(actor.getActor().getActor());
          System.out.println(actor.getActor().getActor());
      }
  
   
   Set<FilmType> filmTypes=newFilm.getFilmTypes();
    Iterator tyIterator=filmTypes.iterator();
    Set<String> typeSet=new HashSet<String>();
     while(tyIterator.hasNext())
      {
    	  FilmType type=(FilmType) tyIterator.next();
          typeSet.add(type.getType().getType());
          System.out.println(type.getType().getType());
      }
   
   
   Set<FilmPlace> filmPlaces=newFilm.getFilmPlaces();
   Iterator pcIterator=filmPlaces.iterator();
   Set<String> placeSet=new HashSet<String>();
   while(pcIterator.hasNext())
   {
	   FilmPlace place=(FilmPlace) pcIterator.next();
	   placeSet.add(place.getPlace().getPlace());
	   System.out.println(place.getPlace().getPlace());
   }
   Set<Comment> comments=newFilm.getComments();
   Iterator csIter=comments.iterator();
   while(csIter.hasNext())
   {
	   Comment com=(Comment)csIter.next();
   }*/

}
}
