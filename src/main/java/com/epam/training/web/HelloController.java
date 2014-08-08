package com.epam.training.web;

import com.epam.training.persistence.pojo.UsersEntity;
import com.epam.training.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String printWelcome() {
        UsersEntity user = new UsersEntity();
        user.setFullName("Efim");
        user.setLogin("Ef");
        user.setPassword("12345678");
        user.setBillingAddress("LOLOLOL LOLOLO LOLOLO 33");
        user.setEmail("user@user.com");
        userService.create(user);
        return "hello";
    }

    @RequestMapping(value = "/ajaxtest", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Set<String> ajaxTest() {
        Set<String> records = new HashSet<String>();
        records.add("Record #1");
        records.add("Record #2");

        return records;
    }
}