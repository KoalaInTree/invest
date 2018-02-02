package com.invest.service;

import com.invest.common.ServerResponse;
import com.invest.pojo.News;

import java.util.List;

/**
 * Created by CJ on 2018-02-01.
 */
public interface INewsService {
    ServerResponse create (News news);
    ServerResponse<News> update (News news);
    ServerResponse delete (Integer id);
    ServerResponse<News> findOne(Integer id);
    ServerResponse<List<News>> list();
    ServerResponse<List<News>> findByCondition(News news);
}
