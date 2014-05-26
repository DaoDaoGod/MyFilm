package com.myfilm.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myfilm.bean.FilmBean;

public class TestDao {
	public static void main(final String[]args)
	{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	FilmDAO dao=(FilmDAO) ctx.getBean("FilmDAO");
	

	
	
	
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

}
}
