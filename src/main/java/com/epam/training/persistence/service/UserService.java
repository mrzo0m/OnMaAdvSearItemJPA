package com.epam.training.persistence.service;

import com.epam.training.persistence.UserCRUD;
import com.epam.training.persistence.pojo.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Oleg_Burshinov on 16.01.14.
 */
@Service
@Transactional
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserCRUD userDao;

    public UserService() {
        super();
    }

    public void create(final UsersEntity entity) {
        LOGGER.debug("Creating a new user with information: " + entity);
        userDao.create(entity);
    }
}
