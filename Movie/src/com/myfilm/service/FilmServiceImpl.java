package com.myfilm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
import com.myfilm.data.Photo;
import com.myfilm.data.PhotoDAO;
import com.myfilm.data.User;
import com.myfilm.data.UserDAO;

public class FilmServiceImpl implements FilmServiceInf {
	private FilmDAO filmDao;
	private PhotoDAO photoDao;
	private FilmActorDAO filmActorDao;
	private UserDAO userDao;
	private CommentDAO commentDao;
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
			System.out.println(newuser.getUserId());
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
			if(u!=null&&u.getPassword().equals(pass))
			{
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
				return getUserById(19);
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
}
