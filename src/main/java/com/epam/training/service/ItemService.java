package com.epam.training.service;

import com.epam.training.persistence.dao.ItemDao;
import com.epam.training.persistence.dao.UserDao;
import com.epam.training.persistence.pojo.ItemsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Oleg_Burshinov on 13.02.14.
 */
@Service
public class ItemService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    //Создать транзакцию, нижний слой попадет в неё.
    public int create(ItemsEntity to) {
        int id = 0;
        try {
            to.setUser(userDao.read(to.getUser()));
            id = itemDao.create(to);
        } catch (Exception e) {
            logger.error("Error when try create item: " + e.getLocalizedMessage());
        }
        return id;
    }
}
