package com.invest.service.impl;

import com.invest.common.ServerResponse;
import com.invest.dao.NewsMapper;
import com.invest.pojo.News;
import com.invest.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CJ on 2018-02-01.
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public ServerResponse create(News
                                             news) {
        int count  = newsMapper.insertSelective(news);
        if (count > 0 ){
            return ServerResponse.createBySuccessMessage("创建成功");
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }

    @Override
    public ServerResponse<News> update(News news) {
        int count  = newsMapper.updateByPrimaryKeySelective(news);
        if (count>0){
            return ServerResponse.createBySuccess("更新成功",news);
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }

    @Override
    public ServerResponse delete(Integer id) {
        int count = newsMapper.deleteByPrimaryKey(id);
        if (count > 0 ){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<News> findOne(Integer id) {
        News news = newsMapper.selectByPrimaryKey(id);
        if (news != null){
            return ServerResponse.createBySuccess(news);
        }
        return ServerResponse.createByErrorMessage("查询错误");
    }

    @Override
    public ServerResponse<List<News>> list() {
        List<News> newsList = newsMapper.findAll();
        if (newsList==null || newsList.size()==0){
            return ServerResponse.createBySuccessMessage("没有信息");
        }
        return ServerResponse.createBySuccess(newsList);
    }

    @Override
    public ServerResponse<List<News>> findByCondition(News news) {
        List<News> newsList = newsMapper.findByCondition(news);
        return ServerResponse.createBySuccess(newsList);
    }
}
