package com.myfilm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.jms.Session;
import javax.swing.text.AbstractDocument.LeafElement;

import org.apache.commons.lang.SystemUtils;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.UserBean;
import com.myfilm.data.Actor;
import com.myfilm.data.Film;
import com.myfilm.data.FilmActor;
import com.myfilm.data.FilmActorDAO;
import com.myfilm.data.FilmDAO;
import com.myfilm.data.FilmPlace;
import com.myfilm.data.FilmType;
import com.myfilm.data.Photo;
import com.myfilm.data.PhotoDAO;

public class FilmServiceImpl implements FilmServiceInf {
	private FilmDAO filmDao;
	private PhotoDAO photoDao;
	private FilmActorDAO filmActorDao;
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
		float hotgrade = 4;
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
	public List<FilmBean> getHotMovieByPage(int pagenum,float hotgrade) {
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
		float hotgrade=4;
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
		filmBean.setName(newFilm.getName());
		filmBean.setDblink(newFilm.getDblink());

		Set<FilmActor> filmActors=newFilm.getFilmActors();
	    Iterator acIterator=filmActors.iterator();
	    Set<String> actorSet=new HashSet<String>();
	     while(acIterator.hasNext())
	      {
	    	  FilmActor actor=(FilmActor) acIterator.next();
	          actorSet.add(actor.getId().getActor().getActor());
	      }
	   filmBean.setFilmactor(actorSet);
	   
	   Set<FilmType> filmTypes=newFilm.getFilmTypes();
	    Iterator tyIterator=filmTypes.iterator();
	    Set<String> typeSet=new HashSet<String>();
	     while(tyIterator.hasNext())
	      {
	    	  FilmType type=(FilmType) tyIterator.next();
	          typeSet.add(type.getId().getType().getType());
	          
	      }
	   filmBean.setFilmtype(typeSet);
	   
	   Set<FilmPlace> filmPlaces=newFilm.getFilmPlaces();
	   Iterator pcIterator=filmPlaces.iterator();
	   Set<String> placeSet=new HashSet<String>();
	   while(pcIterator.hasNext())
	   {
		   FilmPlace place=(FilmPlace) pcIterator.next();
		   placeSet.add(place.getId().getPlace().getPlace());
	   }
	   
	   filmBean.setFilmplace(placeSet); 
	   filmBean.setPhotoset(newFilm.getPhotos());
		return filmBean;
	}
}
