package com.invest.service;

import com.invest.common.ServerResponse;
import com.invest.pojo.User;

/**
 * Created by CJ on 2017/11/16.
 */
public interface IUserService {
    ServerResponse<User> login(User user);
    ServerResponse<String> register(User user);
    ServerResponse<User> updateInformation(User user);
/*    ServerResponse<String> checkValid(String str, String type);
    ServerResponse<String> forgetGetQuestion(String username);
    ServerResponse<String> forgetCheckAnswer(String username, String question, String answer);
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
    ServerResponse<User> checkAdminRole(User user);*/
    ServerResponse<User> findOne(Integer id);


}
