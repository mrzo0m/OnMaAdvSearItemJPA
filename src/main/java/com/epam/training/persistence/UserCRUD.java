package com.epam.training.persistence;

import com.epam.training.persistence.pojo.UsersEntity;

import java.util.List;

/**
 * Created by Oleg_Burshinov on 16.01.14.
 */
public interface UserCRUD {

    UsersEntity findOne(long id);

    List<UsersEntity> findAll();

    void create(UsersEntity entity);

    UsersEntity update(UsersEntity entity);

    void delete(UsersEntity entity);

    void deleteById(long entityId);
}
