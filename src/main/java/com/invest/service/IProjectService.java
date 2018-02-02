package com.invest.service;

import com.invest.common.ServerResponse;
import com.invest.pojo.Project;

import java.util.List;

/**
 * Created by CJ on 2018-02-01.
 */
public interface IProjectService {
    ServerResponse<Project> create(Project project);
    ServerResponse<Project> update(Project project);
    ServerResponse<Project> findByPrimaryKey(Integer id);
    ServerResponse<List<Project>> findByUserId(Integer userId);
    ServerResponse delete(Integer id);
}
