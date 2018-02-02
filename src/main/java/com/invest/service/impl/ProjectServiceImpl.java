package com.invest.service.impl;

import com.invest.common.ServerResponse;
import com.invest.dao.ProjectMapper;
import com.invest.pojo.Project;
import com.invest.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CJ on 2018-02-01.
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public ServerResponse<Project> create(Project project) {
        int count = projectMapper.insertSelective(project);
        if (count > 0){
            return ServerResponse.createBySuccess("项目创建成功",project);
        }
        return ServerResponse.createByErrorMessage("项目创建失败");
    }

    @Override
    public ServerResponse<Project> update(Project project) {
        Project validProject = projectMapper.selectByPrimaryKey(project.getId());
        if (validProject == null){
            return ServerResponse.createByErrorMessage("更新的项目不存在或者失效");
        }
        int count = projectMapper.updateByPrimaryKey(project);
        project.setUserId(validProject.getUserId());
        return ServerResponse.createBySuccess(project);
    }

    @Override
    public ServerResponse<Project> findByPrimaryKey(Integer id) {
        Project db_project = projectMapper.selectByPrimaryKey(id);
        if (db_project == null){
            return ServerResponse.createByErrorMessage("更新的项目不存在或者失效");
        }
        return ServerResponse.createBySuccess(db_project);
    }

    @Override
    public ServerResponse<List<Project>> findByUserId(Integer userId) {
        List<Project> projectList = projectMapper.selectByUserId(userId);
        if (projectList == null || projectList.size() == 0){
            return ServerResponse.createByErrorCodeMessage(2,"查询成功,查询结果为空");
        }
        return ServerResponse.createBySuccess(projectList);
    }

    @Override
    public ServerResponse delete(Integer id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        if (project == null){
            return ServerResponse.createByErrorMessage("项目不存在");
        }
        return ServerResponse.createBySuccessMessage("删除项目成功");
    }

}
