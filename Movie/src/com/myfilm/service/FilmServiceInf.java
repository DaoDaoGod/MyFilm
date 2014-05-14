package com.myfilm.service;
import java.util.List;

import com.myfilm.bean.FilmBean;
import com.myfilm.bean.UserBean;
import com.myfilm.data.Film;

public interface FilmServiceInf {
  public List<FilmBean> getHotMovie();
}
