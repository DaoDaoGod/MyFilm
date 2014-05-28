package com.myfilm.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.UserBean;
import com.myfilm.data.Film;
import com.myfilm.data.User;

public interface FilmServiceInf {
  public List<FilmBean> getHotMovie();
  public List<FilmBean> getHotMovieByPage(int pagenum,int hotgrade);
  public List<FilmBean> getUpComings();
  public FilmBean getFilmById(Integer id);
  public int createUser(String email,String pass,HttpSession session) throws Exception;
  public boolean valid(String email);
  public int login(String user,String pass,HttpSession session);
  public UserBean isLogin(HttpSession session);
  public UserBean getUserById(Integer id);
  public int addNewComment(Integer filmid,Integer Userid,String content);
  
}
