package com.invest.controller;

import com.invest.common.ServerResponse;
import com.invest.pojo.Project;
import com.invest.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CJ on 2018-02-01.
 */
@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    @RequestMapping("create")
    @ResponseBody
    public ServerResponse<Project> create(@Validated Project project, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for(ObjectError e: errorList){
                sb.append(e.getDefaultMessage());
            }
            return ServerResponse.createByErrorMessage(sb.toString());
        }
        return iProjectService.create(project);
    }

    @RequestMapping("update")
    @ResponseBody
    public ServerResponse update(Project project){
        if (project == null || project.getId() == null){
            return ServerResponse.createByErrorMessage("项目的id不能为空");
        }
        return iProjectService.update(project);
    }

    @RequestMapping("list")
    @ResponseBody
    public ServerResponse list(Integer userId){
        if (userId == null){
            return ServerResponse.createByErrorMessage("需要userId参数");
        }
        return iProjectService.findByUserId(userId);
    }

    @RequestMapping("find/{id}")
    @ResponseBody
    public ServerResponse findOne(@PathVariable(value = "id") Integer id){
        if (id == null){
            return ServerResponse.createByErrorMessage("需要id参数");
        }
        return iProjectService.findByPrimaryKey(id);
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public ServerResponse deleteOne(@PathVariable(value = "id")Integer id){
        if ( id == null){
            return ServerResponse.createByErrorMessage("需要id参数");
        }
        return iProjectService.delete(id);
    }

}
