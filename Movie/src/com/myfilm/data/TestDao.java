package com.myfilm.data;

import java.util.ArrayList;
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
import com.myfilm.bean.UserBean;

public class TestDao {
	public static void main(final String[]args)
	{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserDAO userDao=(UserDAO)ctx.getBean("UserDAO");
	User newuser=userDao.findById(19);
	UserBean ub=new UserBean();
	ub.setEmail(newuser.getEmail());
	ub.setNickname(newuser.getNickname());
	ub.setUserId(newuser.getUserId());
	ub.setBirthday(newuser.getBirthday().toLocaleString());
	ub.setGender(newuser.getGender());
	System.out.println(ub.getEmail());

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
