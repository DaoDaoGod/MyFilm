package com.myfilm.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.LeafElement;

import org.apache.commons.lang.SystemUtils;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.GroupBean;
import com.myfilm.bean.TopicBean;
import com.myfilm.bean.TopicCommentBean;
import com.myfilm.bean.UserBean;
import com.myfilm.bean.CommentBean;
import com.myfilm.data.Actor;
import com.myfilm.data.Comment;
import com.myfilm.data.CommentDAO;
import com.myfilm.data.CommentId;
import com.myfilm.data.Film;
import com.myfilm.data.FilmActor;
import com.myfilm.data.FilmActorDAO;
import com.myfilm.data.FilmDAO;
import com.myfilm.data.FilmPlace;
import com.myfilm.data.FilmType;
import com.myfilm.data.FilmUser;
import com.myfilm.data.FilmUserDAO;
import com.myfilm.data.FilmUserId;
import com.myfilm.data.Group;
import com.myfilm.data.GroupDAO;
import com.myfilm.data.Photo;
import com.myfilm.data.PhotoDAO;
import com.myfilm.data.Topic;
import com.myfilm.data.TopicComment;
import com.myfilm.data.TopicCommentId;
import com.myfilm.data.TopicDAO;
import com.myfilm.data.TopicId;
import com.myfilm.data.User;
import com.myfilm.data.UserDAO;
import com.myfilm.data.UserGroup;
import com.myfilm.data.UserGroupDAO;
import com.myfilm.data.UserGroupId;
import com.myfilm.search.SearchLogic;

public class FilmServiceImpl implements FilmServiceInf {
	private FilmDAO filmDao;
	private PhotoDAO photoDao;
	private FilmActorDAO filmActorDao;
	private UserDAO userDao;
	private CommentDAO commentDao;
	private GroupDAO groupDao;
	private TopicDAO topicDao;
	private UserGroupDAO userGroupDao;
	private FilmUserDAO fuDao;
	public FilmUserDAO getFuDao() {
		return fuDao;
	}
	public void setFuDao(FilmUserDAO fuDao) {
		this.fuDao = fuDao;
	}
	public UserGroupDAO getUserGroupDao() {
		return userGroupDao;
	}
	public void setUserGroupDao(UserGroupDAO userGroupDao) {
		this.userGroupDao = userGroupDao;
	}
	public TopicDAO getTopicDao() {
		return topicDao;
	}
	public void setTopicDao(TopicDAO topicDao) {
		this.topicDao = topicDao;
	}
	public GroupDAO getGroupDao() {
		return groupDao;
	}
	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}
	public CommentDAO getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDAO commentDao) {
		this.commentDao = commentDao;
	}
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public FilmActorDAO getFilmActorDao() {
		return filmActorDao;
	}
	public void setFilmActorDao(FilmActorDAO filmActorDao) {
		this.filmActorDao = filmActorDao;
	}
	public PhotoDAO getPhotoDao() {
		return photoDao;
	}
	public void setPhotoDao(PhotoDAO photoDao) {
		this.photoDao = photoDao;
	}

	private List<Film> hotFilms;
	public List<Film> getHotFilms() {
		return hotFilms;
	}

	public void setHotFilms(List<Film> hotFilms) {
		this.hotFilms = hotFilms;
	}

	public FilmDAO getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDAO filmDao) {
		this.filmDao = filmDao;
	}

	public FilmServiceImpl() {
	}

	public FilmServiceImpl(FilmDAO filmDao) {
		this.filmDao = filmDao;
	}

	@Override
	public List<FilmBean> getHotMovie() {
		int hotgrade = 3;
		List<Film> list = filmDao.findByHotgrade(hotgrade);
		List<FilmBean> result = new ArrayList<FilmBean>();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getPhotos().size());
			
			FilmBean filmBean = new FilmBean();
			filmBean.setFilmId(list.get(i).getFilmId());
			filmBean.setName(list.get(i).getName());
			filmBean.setDescription(list.get(i).getDescription());
			filmBean.setPhotoset(list.get(i).getPhotos());
			result.add(filmBean);
		}
		return result;
	}
	@Override
	public List<FilmBean> getHotMovieByPage(int pagenum,int hotgrade) {
		// TODO Auto-generated method stub
		List<Film> list = filmDao.findByHotgrade(hotgrade);
		List<FilmBean> result = new ArrayList<FilmBean>();
		for (int i = pagenum*4; i < list.size()&&i<pagenum*4+4; i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getPhotos().size());
			
			FilmBean filmBean = new FilmBean();
			filmBean.setFilmId(list.get(i).getFilmId());
			filmBean.setName(list.get(i).getName());
			filmBean.setDescription(list.get(i).getDescription());
			filmBean.setPhotoset(list.get(i).getPhotos());
			result.add(filmBean);
		}
		return result;

	}
	@Override
	public List<FilmBean> getUpComings() {
		// TODO Auto-generated method stub
		int hotgrade=3;
		List<Film> list = filmDao.findByHotgrade(hotgrade);
		List<FilmBean> result = new ArrayList<FilmBean>();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getPhotos().size());
			FilmBean filmBean = new FilmBean();
			filmBean.setFilmId(list.get(i).getFilmId());
			filmBean.setName(list.get(i).getName());
			filmBean.setDescription(list.get(i).getDescription());
			filmBean.setPhotoset(list.get(i).getPhotos());
			result.add(filmBean);
		}
		return result;
	}
	@Override
	public FilmBean getFilmById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id="+id);
		Film newFilm=filmDao.findById(id);
		FilmBean filmBean=new FilmBean();
		filmBean.setFilmId(newFilm.getFilmId());
		filmBean.setDescription(newFilm.getDescription());
		System.out.println(newFilm.getDescription());
		filmBean.setFilmdirector(newFilm.getDirector());
		filmBean.setFilmlength(newFilm.getDuration().toString());
		filmBean.setFilmupdate(newFilm.getUpdate().toString());
		filmBean.setFilmothername(newFilm.getOthername());
		filmBean.setDbgrade(newFilm.getDbgrade());
		filmBean.setName(newFilm.getName());
		filmBean.setDblink(newFilm.getDblink());
		System.out.println(newFilm.getDblink());
		Set<FilmActor> filmActors=newFilm.getFilmActors();
	    Iterator acIterator=filmActors.iterator();
	    Set<String> actorSet=new HashSet<String>();
	     while(acIterator.hasNext())
	      {
	    	  FilmActor actor=(FilmActor) acIterator.next();
	          actorSet.add(actor.getActor().getActor());
	          System.out.println(actor.getActor().getActor());
	      }
	   filmBean.setFilmactor(actorSet);
	   
	   Set<FilmType> filmTypes=newFilm.getFilmTypes();
	    Iterator tyIterator=filmTypes.iterator();
	    Set<String> typeSet=new HashSet<String>();
	     while(tyIterator.hasNext())
	      {
	    	  FilmType type=(FilmType) tyIterator.next();
	          typeSet.add(type.getType().getType());
	          System.out.println(type.getType().getType());
	      }
	   filmBean.setFilmtype(typeSet);
	   
	   Set<FilmPlace> filmPlaces=newFilm.getFilmPlaces();
	   Iterator pcIterator=filmPlaces.iterator();
	   Set<String> placeSet=new HashSet<String>();
	   while(pcIterator.hasNext())
	   {
		   FilmPlace place=(FilmPlace) pcIterator.next();
		   placeSet.add(place.getPlace().getPlace());
		   System.out.println(place.getPlace().getPlace());
		   
	   }
	   
	   filmBean.setFilmplace(placeSet); 
	   filmBean.setPhotoset(newFilm.getPhotos());
	   //filmBean.setCommentSet(newFilm.getComments());
	   
		CommentId  commid=new CommentId();
		commid.setFilmId(1);
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		String hql="from Comment where film_id="+id;
		Query query = session.createQuery(hql);
		List<Comment> coms=query.list();
		System.out.print(coms.size());
		List<CommentBean> cbs= new ArrayList<CommentBean>();
	    for(int i=0;i<coms.size();i++)
	    {
	    	   Comment comm=coms.get(i);
			   CommentBean cb=new CommentBean();
			   if(comm.getUser()==null)
			   cb.setNickname(comm.getUsername());
			   else
			   cb.setNickname(comm.getUser().getNickname());  
			   cb.setContent(comm.getContent());
			   cb.setAddTime(comm.getAddTime().toLocaleString());
			   cb.setContent(comm.getContent());
			   System.out.print(comm.getContent());
			   cbs.add(cb);    
	    }
	    System.out.print("the num of list"+cbs.size());
	   filmBean.setCommentlist(cbs);
/*	   Set<CommentBean> cbs=new HashSet<CommentBean>();
	   Set<Comment> coms=newFilm.getComments();
	   Iterator iter=coms.iterator();
	   while(iter.hasNext())
	   {
		   Comment comm=(Comment)iter.next();
		   CommentBean cb=new CommentBean();
		   if(comm.getUser()==null)
		   cb.setNickname(comm.getUsername());
		   else
		   cb.setNickname(comm.getUser().getNickname());
		   
		   cb.setContent(comm.getContent());
		   cb.setAddTime(comm.getAddTime().toLocaleString());
		   cb.setContent(comm.getContent());
		   System.out.print(comm.getContent());
		   cbs.add(cb);
	   }
	   filmBean.setComments(cbs);*/
	   
	   return filmBean;
	}
	
	public int createUser(String email, String pass, HttpSession session) {
		// TODO Auto-generated method stub
		    
		if(userDao.findByEmail(email).size()==0)
	        try{ 
			User newuser=new User();
			newuser.setEmail(email);
			newuser.setPassword(pass);
			newuser.setNickname("xiaoyan");
			System.out.println(email);
			SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session  session1=factory.openSession();
			Transaction  tr=session1.beginTransaction();
			session1.save(newuser);
			tr.commit();
			session1.close();
			factory.close();
			session.setAttribute("user", newuser.getUserId());
			Object userId=session.getAttribute("user");
			System.out.println( );
			return 0;
	        }
	        catch(Exception e)
	        {
	        	return -1;
	        }
		else return 2;
		    
	}
	@Override
	public boolean valid(String email) {
		// TODO Auto-generated method stub
		try{
			
			if(userDao.findByEmail(email)==null)
			{
				return true;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return false;
	}
	@Override
	public int login(String email, String pass, HttpSession session) {
		// TODO Auto-generated method stub
		try
		{
			User u=userDao.findByEmail(email).get(0);
			System.out.println("current email="+u.getEmail());
			if(u!=null&&u.getPassword().equals(pass))
			{  
				System.out.println("current  pass="+u.getEmail());
				session.setAttribute("user", u.getUserId());
				return u.getUserId();
			}
		}
		catch (Exception e)
		{
			return -1;
		}
		return -1;
	}
	@Override
	public UserBean isLogin(HttpSession session) {
		// TODO Auto-generated method stub
		try
		{
			Object userId=session.getAttribute("user");
			
			if(userId!=null)
			{
				System.out.print("get the uid is"+(Integer)userId);
				return getUserById((Integer)userId);
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
		 
	}
	@Override
	public UserBean getUserById(Integer id) {
		// TODO Auto-generated method stub
		User newuser=userDao.findById(id);
		UserBean ub=new UserBean();
		ub.setEmail(newuser.getEmail());
		ub.setNickname(newuser.getNickname());
		ub.setUserId(id);
		return ub;
	}
	@Override
	public int addNewComment(Integer filmid, Integer Userid,String content) {
		// TODO Auto-generated method stub
		CommentId  commid=new CommentId();
		commid.setFilmId(filmid);
		commid.setUserId(Userid);
		Comment comm=new Comment();
		comm.setId(commid);
		comm.setContent(content);
		comm.setUsername("luhao");
		comm.setEmail("595135311@qq.com");//userDao.findById(Userid).getEmail()
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
		session1.save(comm);
		tr.commit();
		session1.close();
		factory.close();
		System.out.print("ÆÀÂÛÊýÁ¿"+commentDao.findAll().size());
		return 0;
	}
	@Override
	public GroupBean getGroupById(Integer id) {
		// TODO Auto-generated method stub
		Group newgroup=groupDao.findById(id);
		GroupBean newGroupBean=new GroupBean();
		newGroupBean.setGroupId(newgroup.getGroupId());
		newGroupBean.setGroupDescription(newgroup.getGroupDescription());
		Integer groupid=newgroup.getGroupId();
		newGroupBean.setGroupName(newgroup.getGroupName());
		newGroupBean.setGroupOwner(newgroup.getGroupOwner());
		newGroupBean.setDroupNumber(newgroup.getDroupNumber());
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
     
		Query query = session.createQuery("from Topic where group_id="+groupid);
		List<Topic> tops=query.list();
		List<TopicBean> tbs=new ArrayList<TopicBean>();
		for(int i=0;i<tops.size();i++)
		{
			TopicBean newtopicBean=new TopicBean();
			newtopicBean.setTopicId(tops.get(i).getId().getTopicId());
			newtopicBean.setGroupId(id);
			newtopicBean.setName(tops.get(i).getName());
			newtopicBean.setContent(tops.get(i).getContent());
			newtopicBean.setUsername(tops.get(i).getUsername());
			newtopicBean.setAddtime(tops.get(i).getAddtime().toLocaleString().split(" ")[0]);
			tbs.add(newtopicBean);
		}
		newGroupBean.setTopics(tbs);
		return newGroupBean;
	}
	@Override
	public TopicBean getTopicById(Integer topicid) {
		// TODO Auto-generated method stub
		System.out.print(topicid);
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session=factory.openSession();
		Query query = session.createQuery("from Topic where topic_id="+topicid);
		List<Topic> tops=query.list();
		Topic topic=tops.get(0);
		System.out.print(topic.getContent());
		TopicBean newtopicBean=new TopicBean();
		newtopicBean.setTopicId(topic.getId().getTopicId());
		newtopicBean.setGroupId(topic.getId().getGroupId());
		newtopicBean.setName(topic.getName());
		newtopicBean.setContent(topic.getContent());
		newtopicBean.setUsername(topic.getUsername());
		newtopicBean.setAddtime(topic.getAddtime().toLocaleString().split(" ")[0]);
	    
		
		List<TopicCommentBean> tcbs=new ArrayList<TopicCommentBean>();
		List<TopicComment> tcs=new ArrayList<TopicComment>();
		Query query2=session.createQuery("from TopicComment where topic_id="+topicid);
		tcs=query2.list();
		for(int i=0;i<tcs.size();i++)
		{
			TopicCommentBean new1=new TopicCommentBean();
			new1.setAddtime(tcs.get(i).getAddtime().toString());
			new1.setUserId(tcs.get(i).getUserId());
			new1.setContent(tcs.get(i).getContent());
			new1.setTopicCommentid(tcs.get(i).getId().getTcommentId());
			tcbs.add(new1);
		}
		newtopicBean.setTopComments(tcbs);
		return newtopicBean;
	}
	@Override
	public int addNewTopicComment(Integer groupid,Integer topicid, Integer userid,
			String content) {
		// TODO Auto-generated method stub

		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();	
	    TopicCommentId commentId=new TopicCommentId();
		commentId.setGroupId(groupid);
		commentId.setTopicId(topicid);
	    TopicComment tComment=new TopicComment();
	    tComment.setId(commentId);
	    tComment.setUserId(userid);
	    tComment.setContent(content);
	    System.out.print(content);
		Transaction  tr=session1.beginTransaction();
		session1.save(tComment);
		tr.commit();
		session1.close();
		factory.close();
		
		return 0;
	}
	@Override
	public int addNewTopic(Integer groupid, Integer userid, String name,
			String content) {
		// TODO Auto-generated method stub

		String username=userDao.findById(userid).getNickname();
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		TopicId topicId=new TopicId();
		topicId.setGroupId(groupid);
		Topic newTopic=new Topic();
		newTopic.setId(topicId);
		newTopic.setName(name);
		newTopic.setUserId(userid);
		newTopic.setContent(content);
		newTopic.setUsername(username);
		Transaction  tr=session1.beginTransaction();
		session1.save(newTopic);
		tr.commit();
		session1.close();
		factory.close();
		return 0;
	}
	@Override
	public List<TopicBean> getNewestTopicbypage(Integer pagenum) {
		// TODO Auto-generated method stub
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
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
			newtopicBean.setGroupId(tops.get(i).getId().getGroupId());
			newtopicBean.setName(topic.getName());
			newtopicBean.setContent(topic.getContent());
			newtopicBean.setUsername(topic.getUsername());
			newtopicBean.setAddtime(topic.getAddtime().toLocaleString().split(" ")[0]);
			tbs.add(newtopicBean);
		}
		
		return tbs;
	}
	@Override
	public List<GroupBean> getNewestGroup() {
		// TODO Auto-generated method stub
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
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
			Integer groupid=newgroup.getGroupId();
			newGroupBean.setGroupName(newgroup.getGroupName());
			newGroupBean.setGroupOwner(newgroup.getGroupOwner());
			newGroupBean.setDroupNumber(newgroup.getDroupNumber());
			tbs.add(newGroupBean);
		}
		
		return tbs;
	}
	@Override
	public int exitlogin(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
		System.out.print("safd");
		return 0;
	}
	@Override
	public List<FilmBean> getFilmbyConditionbypage(String begin, String end,
			String type, String place, int sqe,int pagenum) {
		// TODO Auto-generated method stub
		String  sque;
		if(sqe==2)  sque="update";
		else sque="dbgrade";
		List<Film> list=getByCatalogue(end,place,type,sque);
		List<FilmBean> result = new ArrayList<FilmBean>();
		System.out.print(pagenum);
		for (int i = pagenum*8; i < list.size()&&i<pagenum*8+8; i++) {
			FilmBean filmBean = new FilmBean();
			filmBean.setFilmId(list.get(i).getFilmId());
			filmBean.setName(list.get(i).getName());
			filmBean.setDescription(list.get(i).getDescription());
			filmBean.setPhotoset(list.get(i).getPhotos());
			result.add(filmBean);
		}
		return result;
		
	}
	private java.sql.Date[] yearParse(String year) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy");
		java.sql.Date low;
		java.sql.Date high;
		switch (year) {
		case "1950":
			low = new java.sql.Date(df.parse("1900").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2001":
			low = new java.sql.Date(df.parse("1950").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2006":
			low = new java.sql.Date(df.parse("2000").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2011":
			low = new java.sql.Date(df.parse("2006").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2012":
			low = new java.sql.Date(df.parse("2011").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2013":
			low = new java.sql.Date(df.parse("2012").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2014":
			low = new java.sql.Date(df.parse("2013").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		case "2015":
			low = new java.sql.Date(df.parse("2014").getTime());
			high = new java.sql.Date(df.parse(year).getTime() - 1);
			break;
		default:
			low = new java.sql.Date(df.parse("1900").getTime());
			high = new java.sql.Date(new java.util.Date().getTime());
			break;
		}

		return new java.sql.Date[] { low, high };
	}

	
	public List<Film> getByCatalogue(String date, String place, String type,
			String order) {
	
		java.sql.Date[] temp = null;
		if(date.equals("null")){
			date = "1000";
		}
		if(place.equals("null")){
			place = "%";
		}
		if(type.equals("null")){
			type = "%";
		}
		if(order.equals("null")){
			order = "update";
		}
		try {
			temp = yearParse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] data = {temp[0],temp[1],type,place};
		return filmDao.findByCatalogue(data, order);
	}
	@Override
	public int joinAgroup(Integer userid, Integer groupid) {
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
	@Override
	public int addFilmlikestate(Integer filmId, Integer userId,
			Integer likestate) {
		// TODO Auto-generated method stub
		FilmUserId fuId=new FilmUserId();
		fuId.setFilmId(filmId);
		fuId.setUserId(userId);
		FilmUser fuFilmUser=new FilmUser();
		fuFilmUser.setLikestate(likestate);
		fuFilmUser.setId(fuId);
	    SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
		String hql="from FilmUser where film_id="+filmId+" and user_id="+userId;
		Query query = session1.createQuery(hql);
		List<FilmUser> coms=query.list();
		FilmUser newFilmUser=coms.get(0);
		if(newFilmUser!=null)
		{
			newFilmUser.setLikestate(likestate);
			session1.update(newFilmUser);
		}
		else
		{
			session1.save(fuFilmUser);
		}
		tr.commit();
		session1.close();
		factory.close();
		return 0;
	}
	@Override
	public int addFilmwatchsate(Integer filmId, Integer userId,
			Integer watchstate) {
		// TODO Auto-generated method stub
		FilmUserId fuId=new FilmUserId();
		fuId.setFilmId(filmId);
		fuId.setUserId(userId);
		FilmUser fuFilmUser=new FilmUser();
		fuFilmUser.setWatchstate(watchstate);
		fuFilmUser.setId(fuId);
	    SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
		String hql="from FilmUser where film_id="+filmId+" and user_id="+userId;
		Query query = session1.createQuery(hql);
		List<FilmUser> coms=query.list();
		FilmUser newFilmUser=coms.get(0);
		if(newFilmUser!=null)
		{
			newFilmUser.setWatchstate(watchstate);
			session1.update(newFilmUser);
		}
		else
		{
			session1.save(fuFilmUser);
		}
		tr.commit();
		session1.close();
		factory.close();
		return watchstate;
	}
	@Override
	public int updateuserinfo(Integer userId, String nickname,Integer gender,Integer year,
			Integer month,Integer day) {
		// TODO Auto-generated method stub
		User updateuser=userDao.findById(userId);
		updateuser.setNickname(nickname);
		if(gender==0)
		updateuser.setGender(true);
		else
		updateuser.setGender(false);
		System.out.println(year+""+month+""+day);
	    Date bir=new Date();
	    year=year%100;
	    bir.setYear(year);
	    bir.setMonth(month);
	    bir.setDate(day);
		updateuser.setBirthday(bir);
		SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session  session1=factory.openSession();
		Transaction  tr=session1.beginTransaction();
		session1.update(updateuser);
		tr.commit();
		session1.close();
		factory.close();
		 
		return 0;
	}
	@Override
	public List<FilmBean> getuserlikemovie(Integer userid) {
		// TODO Auto-generated method stub
		
	    User newUser=userDao.findById(userid);
	    if(newUser==null) System.out.println("erro");
	    Set<FilmUser> fuFilmUsers=new HashSet<FilmUser>();
	    fuFilmUsers=newUser.getFilmUsers();
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
	    	newFilmBean.setFilmupdate(newFilm.getUpdate().toLocaleString().split(" ")[0]);
	    	listBeans.add(newFilmBean);
	    	}
	    }
		return listBeans;
	}
	@Override
	public List<FilmBean> getuserwatchmovie(Integer userid) {
		// TODO Auto-generated method stub
	    User newUser=userDao.findById(userid);
	    Set<FilmUser> fuFilmUsers=newUser.getFilmUsers();
	    Set<FilmBean> fbBeans=new HashSet<FilmBean>();
	    List<FilmBean> listBeans=new ArrayList<FilmBean>();
	    Iterator  iter=fuFilmUsers.iterator();
	    
	    while(iter.hasNext())
	    {
	    	FilmUser newFilmUser=(FilmUser )iter.next();
	    	if(newFilmUser.getWatchstate()!=null&&(newFilmUser.getWatchstate()==2))
	    	{
	    	Film newFilm=newFilmUser.getFilm();
	    	FilmBean newFilmBean=new FilmBean();
	    	newFilmBean.setFilmId(newFilm.getFilmId());
	    	newFilmBean.setName(newFilm.getName());
	    	newFilmBean.setFilmupdate(newFilm.getUpdate().toLocaleString().split(" ")[0]);
	    	listBeans.add(newFilmBean);
	    	}
	    }
		return listBeans;
	}
	@Override
	public int createAgroup(Integer userid, String name, String description) {
		// TODO Auto-generated method stub
		 
	    if(groupDao.findByGroupName(name).size()!=0)
	    {
	    	
	    	return 1;
	    }
	    else
	    {
		  Group newGroup=new Group();
		  newGroup.setGroupName(name);
		  newGroup.setGroupDescription(description);
		  SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
		  Session  session1=factory.openSession();
		  Transaction  tr=session1.beginTransaction();
		  session1.save(newGroup);
		  Integer groupid=newGroup.getGroupId();
	      tr.commit();
		  session1.close();
		  factory.close();
		//  Integer groupid=groupDao.findByGroupName(name).get(0).getGroupId();
		  joinAgroup(userid,groupid);
		}
	    
		return 0;
	}
	@Override
	public List<FilmBean> getuserplanmovie(Integer userid) {
		// TODO Auto-generated method stub
	    User newUser=userDao.findById(userid);
	    Set<FilmUser> fuFilmUsers=newUser.getFilmUsers();
	   
	    List<FilmBean> listBeans=new ArrayList<FilmBean>();
	    Iterator  iter=fuFilmUsers.iterator();
	    
	    while(iter.hasNext())
	    {
	    	FilmUser newFilmUser=(FilmUser )iter.next();
	    	if(newFilmUser.getWatchstate()!=null&&(newFilmUser.getWatchstate()==1))
	    	{
	    	Film newFilm=newFilmUser.getFilm();
	    	FilmBean newFilmBean=new FilmBean();
	    	newFilmBean.setFilmId(newFilm.getFilmId());
	    	newFilmBean.setName(newFilm.getName());
	    	System.out.println(newFilm.getName());
	    	newFilmBean.setFilmupdate(newFilm.getUpdate().toLocaleString().split(" ")[0]);
	    	listBeans.add(newFilmBean);
	    	}
	    }
	    System.out.println("the num of list "+listBeans.size());
		return listBeans;
	}
	@Override
	public List<GroupBean> getUserGroups(Integer userid) {
		// TODO Auto-generated method stub
		User newUser=userDao.findById(userid);
		Set<UserGroup> sets=newUser.getUserGroups();
		List<GroupBean> list=new ArrayList<GroupBean>();
		Iterator iter=sets.iterator();
		while(iter.hasNext())
		{
			UserGroup newUserGroup=(UserGroup)iter.next();
			GroupBean newBean=new GroupBean();
			newBean.setGroupId(newUserGroup.getGroup().getGroupId());
			newBean.setGroupName(newUserGroup.getGroup().getGroupName());
			list.add(newBean);
		}
		return list;
	}
	@Override
	public UserBean getUserinfo(Integer userid) {
		// TODO Auto-generated method stub
		
		  SessionFactory  factory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session  session1=factory.openSession();
			Transaction  tr=session1.beginTransaction();
			String hql="from User where user_id="+userid;
			Query query = session1.createQuery(hql);
			List<User> coms=query.list();
		
		User newUser=coms.get(0);
		UserBean newbean=new UserBean();
		newbean.setNickname(newUser.getNickname());
		newbean.setEmail(newUser.getEmail());
		newbean.setBirthday(newUser.getBirthday().toLocaleString().split(" ")[0]);
		return newbean;
 	}
	@Override
	public List<FilmBean> getSearchValue(String text) {
		// TODO Auto-generated method stub
		SearchLogic logic = new SearchLogic();   
		List<FilmBean> list=new ArrayList<FilmBean>();
		list=logic.getsearchvalue(text);
		return list;
	}
   
}


