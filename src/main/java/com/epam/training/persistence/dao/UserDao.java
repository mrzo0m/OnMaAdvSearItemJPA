package com.epam.training.persistence.dao;

import com.epam.training.persistence.UserCRUD;
import com.epam.training.persistence.pojo.UsersEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Oleg_Burshinov on 16.01.14.
 */
@Repository
public class UserDao extends AbstractJpaDAO<UsersEntity> implements UserCRUD {
    public UserDao() {
        super();
        setClazz(UsersEntity.class);
    }
}
