package com.myfilm.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.GroupBean;
import com.myfilm.bean.TopicBean;
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
  public GroupBean getGroupById(Integer id);
  public TopicBean getTopicById(Integer topicid);
  public int addNewTopicComment(Integer groupid,Integer topicid,Integer userid,String content);
  public int addNewTopic(Integer groupid,Integer userid,String name,String content);
  public List<TopicBean> getNewestTopicbypage(Integer pagenum);
  public List<GroupBean> getNewestGroup();
  public int exitlogin(HttpSession session);
  public List<FilmBean> getFilmbyConditionbypage(String begin,String end,String type,String place,int sqe,int pagenum);
  public int joinAgroup(Integer userid,Integer groupid);
  public int addFilmlikestate(Integer filmId,Integer userId,Integer likestate);
  public int addFilmwatchsate(Integer filmId,Integer userId,Integer watchstate);
  public int updateuserinfo(Integer userId,String nickname,Integer gender,Integer year,
			Integer month,Integer day);
  public List<FilmBean> getuserlikemovie(Integer userid);
  public List<FilmBean> getuserwatchmovie(Integer userid);
  public List<FilmBean> getuserplanmovie(Integer userid);
  public int createAgroup(Integer useid,String name,String description);
  public List<GroupBean> getUserGroups(Integer userid);
  public UserBean getUserinfo(Integer userid);
  public List<FilmBean> getSearchValue(String text);
}
