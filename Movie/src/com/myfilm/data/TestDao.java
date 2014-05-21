package com.myfilm.data;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {
	public static void main(final String[]args)
	{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	FilmDAO dao=(FilmDAO) ctx.getBean("FilmDAO");
	List<Film> films=dao.findByName("美国队长2");
	System.out.print(films.get(0).getPhotos().size());
	
	}
}
