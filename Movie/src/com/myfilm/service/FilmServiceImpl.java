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

public class FilmServiceImpl implements FilmServiceInf{
     private FilmDAO filmDao;
     public FilmDAO getFilmDao() {
		return filmDao;
	}
	public void setFilmDao(FilmDAO filmDao) {
		this.filmDao = filmDao;
	}
	public FilmServiceImpl(){}
     public FilmServiceImpl(FilmDAO filmDao)
     {
    	 this.filmDao=filmDao;
     }
     
	@Override
	public List<FilmBean> getHotMovie() {

    	float hotgrade=1;
    	List<Film> list=filmDao.findByHotgrade(hotgrade);
    	List<FilmBean> result = new ArrayList<FilmBean>();
    	for(int i=0;i<list.size();i++)
    	{
    		System.out.println(list.get(i).getName());
    		FilmBean filmBean=new FilmBean();
    		filmBean.setFilmId(list.get(i).getFilmId());
    		filmBean.setName(list.get(i).getName());
    		filmBean.setDescription(list.get(i).getDescription());
    		result.add(filmBean);
    	}
    	return result;
	}
}
