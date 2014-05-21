package com.myfilm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.SystemUtils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.UserBean;
import com.myfilm.data.Film;
import com.myfilm.data.FilmDAO;
import com.myfilm.data.Photo;
import com.myfilm.data.PhotoDAO;

public class FilmServiceImpl implements FilmServiceInf {
	private FilmDAO filmDao;
	private PhotoDAO photoDao;
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
		float hotgrade = 3;
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
	public List<FilmBean> getHotMovieByPage(int pagenum) {
		// TODO Auto-generated method stub
		float hotgrade = 3;
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
}
