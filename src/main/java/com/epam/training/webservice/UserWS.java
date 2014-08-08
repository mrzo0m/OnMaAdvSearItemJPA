package com.epam.training.webservice;

import com.epam.training.persistence.pojo.UserEntity;
import com.epam.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Oleg_Burshinov on 10.02.14.
 */
@WebService
public class UserWS extends SpringBeanAutowiringSupport {

    @Autowired
    private UserService userService;

    @WebMethod(action = "createByParam")
    public long createByParam(@WebParam(name = "fullName") String fullName, @WebParam(name = "billingAddress") String billingAddress, @WebParam(name = "login") String
            login, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "phone") String phone, @WebParam(name = "confirmPassword") String confirmPassword) {
        UserEntity user = new UserEntity();
        user.setFullName(fullName);
        user.setBillingAddress(billingAddress);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setConfirmPassword(confirmPassword);
        return userService.create(user);
    }

    @WebMethod(action = "create")
    public long create(@WebParam(name = "user") UserEntity user) {
        return userService.create(user);
    }

    @WebMethod(action = "authorizeByParam")
    public boolean authorizeByParam(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setPassword(password);
        return userService.authorize(user);
    }

    @WebMethod(action = "authorize")
    public boolean authorize(@WebParam(name = "user") UserEntity user) {
        return userService.authorize(user);
    }

    @WebMethod(action = "updateByParam")
    public boolean updateByParam(@WebParam(name = "userId") Integer userId, @WebParam(name = "fullName") String fullName, @WebParam(name = "billingAddress") String billingAddress, @WebParam(name = "login") String
            login, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "phone") String phone, @WebParam(name = "confirmPassword") String confirmPassword) {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        user.setFullName(fullName);
        user.setBillingAddress(billingAddress);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setConfirmPassword(confirmPassword);
        return userService.update(user);
    }

    @WebMethod(action = "readByParam")
    @WebResult(name = "user")
    public UserEntity readByParam(@WebParam(name = "userId") Integer userId, @WebParam(name = "login") String
            login) {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        user.setLogin(login);
        return userService.read(user);
    }

    @WebMethod(action = "read")
    @WebResult(name = "user")
    public UserEntity read(@WebParam(name = "user") UserEntity user) {
        return userService.read(user);
    }

    @WebMethod(action = "deleteByParam")
    public boolean deleteByParam(@WebParam(name = "userId") Integer userId) {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        return userService.delete(user);
    }

    @WebMethod(action = "delete")
    public boolean delete(@WebParam(name = "user") UserEntity user) {
        return userService.delete(user);
    }


}
