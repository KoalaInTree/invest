package com.invest.service.impl;

import com.invest.common.Const;
import com.invest.common.ServerResponse;
import com.invest.common.TokenCache;
import com.invest.dao.UserMapper;
import com.invest.pojo.User;
import com.invest.service.IUserService;
import com.invest.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by CJ on 2017/11/16.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(User getUser) {

        User user = userMapper.selectByPhone(getUser.getPhone());
        if (user == null){
            return ServerResponse.createByErrorMessage("用户名不存在!");
        }


        if(!user.getPassword().equals(getUser.getPassword())){
            return ServerResponse.createByErrorMessage("密码错误!");
        }
        // todo 密码MD5

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("用户登录成功",user);
    }

    public ServerResponse<String> register(User user){
        User validUser = userMapper.selectByPhone(user.getPhone());
        if (validUser!=null){
            return ServerResponse.createByErrorMessage("用户名已存在!");
        }
        int count = userMapper.insert(user);
        if(count ==1 ){
            return ServerResponse.createBySuccessMessage("注册成功");
        }else{
            return ServerResponse.createByErrorMessage("注册失败");
        }
    }

    public ServerResponse<User> updateInformation(User user){

        int updateResultCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateResultCount > 0 ){
            return ServerResponse.createBySuccess("修改信息成功",user);
        }
        return ServerResponse.createByErrorMessage("修改信息失败");
    }

    @Override
    public ServerResponse<User> findOne(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null){
            return ServerResponse.createByErrorMessage("该id没有对应的用户");
        }
        return ServerResponse.createBySuccess(user);
    }

    /*public ServerResponse<String> checkValid(String str,String type){
        if(!StringUtils.isBlank(type)){
            if(Const.USERNAME.equals(type)){
                int count = userMapper.checkUsername(str);
                if (count > 0){
                    return ServerResponse.createByErrorMessage("用户名已经存在!");
                }
            }
            if(Const.EMAIL.equals(type)) {
                int count = userMapper.checkEmail(str);
                if (count > 0) {
                    return ServerResponse.createByErrorMessage("email已经存在!");
                }
            }
            //用户名或者email不存在时返回此结果
            System.out.println("校验成功!");
            return ServerResponse.createBySuccessMessage("校验成功!");
        }else{
            return ServerResponse.createByErrorMessage("参数错误");
        }
    }

    public ServerResponse<String> forgetGetQuestion(String username) {
        ServerResponse<String> validResponse = this.checkValid(username,Const.USERNAME);
        if (validResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }else{
            String question = userMapper.getQuestionByUsername(username);
            if(StringUtils.isBlank(question)){
                return ServerResponse.createByErrorMessage("用户问题为空");
            }
            return ServerResponse.createBySuccess(question);
        }
    }

    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        int resultCount = userMapper.forgetCheckAnswer(username,question,answer);
        if (resultCount >0){
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX+username,forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("答案错误");
    }

    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken){
        if (StringUtils.isBlank(forgetToken)){
            return ServerResponse.createByErrorMessage("参数错误,需要token");
        }
        ServerResponse<String> validResponse = this.checkValid(username,Const.USERNAME);
        if (validResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        String localCacheToken = TokenCache.getKey(TokenCache.TOKEN_PREFIX+username);
        if (StringUtils.equals(localCacheToken,forgetToken)){
            String passwordNewMd5 = MD5Util.MD5EncodeUtf8(passwordNew);
            System.out.println(passwordNew);
            int resultCount = userMapper.updatePasswordByUsername(username,passwordNewMd5);
            if (resultCount > 0){
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        }else {
            return ServerResponse.createByErrorMessage("token无效或者过期");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    public ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user){
        if (StringUtils.isBlank(passwordOld) || StringUtils.isBlank(passwordNew)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        String oldPasswordMD5 = MD5Util.MD5EncodeUtf8(passwordOld);
        int resultCount = userMapper.checkPasswordByUserId(oldPasswordMD5,user.getId());
        if (resultCount == 0 ){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        int updateResultCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateResultCount > 0){
            return ServerResponse.createBySuccessMessage("修改密码成功");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }


    @Override
    public ServerResponse<User> checkAdminRole(User user) {
        if (user != null && user.getRole().intValue() == Const.ROLE.ROLE_ADMIN){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }*/
}
