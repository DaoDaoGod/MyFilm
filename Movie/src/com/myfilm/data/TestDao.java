package com.myfilm.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {
	public static void main(final String[]args)
	{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	FilmDAO dao=(FilmDAO) ctx.getBean("FilmDAO");
	List<Film> films=dao.findByName("美国队长2");
	Film newFilm=dao.findById(17);
	Set<FilmActor> filmActors=newFilm.getFilmActors();
    Iterator acIterator=filmActors.iterator();
    Set<String> actorSet=new HashSet<String>();
     while(acIterator.hasNext())
      {
    	  FilmActor actor=(FilmActor) acIterator.next();
          actorSet.add(actor.getId().getActor().getActor());
          System.out.println(actor.getId().getActor().getActor());
      }
  
   
   Set<FilmType> filmTypes=newFilm.getFilmTypes();
    Iterator tyIterator=filmTypes.iterator();
    Set<String> typeSet=new HashSet<String>();
     while(tyIterator.hasNext())
      {
    	  FilmType type=(FilmType) tyIterator.next();
          typeSet.add(type.getId().getType().getType());
          System.out.println(type.getId().getType().getType());
      }
   
   
   Set<FilmPlace> filmPlaces=newFilm.getFilmPlaces();
   Iterator pcIterator=filmPlaces.iterator();
   Set<String> placeSet=new HashSet<String>();
   while(pcIterator.hasNext())
   {
	   FilmPlace place=(FilmPlace) pcIterator.next();
	   placeSet.add(place.getId().getPlace().getPlace());
	   System.out.println(place.getId().getPlace().getPlace());
   }

}
}
