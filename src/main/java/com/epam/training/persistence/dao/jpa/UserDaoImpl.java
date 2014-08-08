package com.epam.training.persistence.dao.jpa;

import com.epam.training.persistence.dao.UserDao;
import com.epam.training.persistence.pojo.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by Oleg_Burshinov on 04.02.14.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceUnit(unitName = "defaultPersistenceUnit")
    private EntityManagerFactory emf;
    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    WebSphereUowTransactionManager  transactionManager;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,
            //Используется уровень изоляции по умолчанию,
            //зависящий от конкретного хранилища данных
            propagation = Propagation.REQUIRED,
//            Указывает, что метод должен выполняться внутри
//            транзакции. Если к моменту вызова метода будет
//            запущена транзакция, он будет выполняться
//            в рамках этой транзакции. В противном случае
//            будет запущена новая транзакция
            rollbackFor = Exception.class)
    public long create(UserEntity user) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.persist(user);
            em.flush();
            logger.info("User: " + user.getLogin() + " added to db.");
        } catch (Exception e) {
            user.setUserId(null);
            logger.error("Error when user put in db " + e.getLocalizedMessage());
            logger.error(e.getLocalizedMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return (user.getUserId() != null) ? user.getUserId() : 0; // ???
    }

    @Override
    public UserEntity read(UserEntity user) {
        EntityManager em = this.emf.createEntityManager();
        UserEntity userInfo = null;
        try {
            if (user.getUserId() != null) {
                userInfo = em.find(UserEntity.class, user.getUserId());
                logger.info("get user: " + user.getUserId() + " from db");
            } else if (user.getLogin() != null) {
                String login = user.getLogin();
                userInfo = (UserEntity) em.createNamedQuery("findUsersByLogin").setParameter("login", login).getSingleResult();
                logger.info("get user: " + user.getLogin() + " from db");
            }
            userInfo.setPassword("");
            userInfo.setConfirmPassword("");
        } catch (Exception e) {
            logger.error("Error while get user from db " + e.getLocalizedMessage());
            logger.error(e.getLocalizedMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return userInfo;
    }

    @Override
    public boolean update(UserEntity user) {
        EntityManager em = this.emf.createEntityManager();
        boolean result = false;
        if (!authorize(user)) {
            return result;
        }
        try {
            if (user.getUserId() != null) {
                UserEntity updateUser = em.find(UserEntity.class, user.getUserId());
                em.getTransaction().begin();
                if (user.getLogin() != null) {
//                    UserEntity checkUserLogin = read(user)
                    updateUser.setLogin(user.getLogin()); //TODO not unique login check!
                }
                if (user.getFullName() != null) {
                    updateUser.setFullName(user.getFullName());
                }
                if (user.getBillingAddress() != null) {
                    updateUser.setBillingAddress(user.getBillingAddress());
                }
                if (user.getPassword() != null) {
                    updateUser.setPassword(user.getPassword());
                }
                if (user.getConfirmPassword() != null) {
                    updateUser.setConfirmPassword(user.getConfirmPassword());
                }
                if (user.getPhone() != null) {
                    updateUser.setPhone(user.getPhone());
                }
                if (user.getEmail() != null) {
                    updateUser.setEmail(user.getEmail());
                }
                em.getTransaction().commit();
                result = true;
                logger.info("User: " + updateUser.getLogin() + " update in db.");
            }

        } catch (Exception e) {
            logger.error("Error when user remove from db " + e.getLocalizedMessage());
            logger.error(e.getLocalizedMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return result;
    }

    @Override
    public boolean delete(UserEntity user) {
        EntityManager em = this.emf.createEntityManager();
        boolean result = false;
        try {
            UserEntity deleteUser = em.find(UserEntity.class, user.getUserId());
            em.getTransaction().begin();
            em.remove(deleteUser);
            em.getTransaction().commit();
            result = true;
            logger.info("User: " + user.getLogin() + " remove from db.");
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return result;
    }

    @Override
    public boolean authorize(UserEntity user) {
        EntityManager em = this.emf.createEntityManager();
        boolean result = false;
        if (user.getUserId() != null) {
            UserEntity byIdUser = em.find(UserEntity.class, user.getUserId());
            if (byIdUser.getPassword().equals(user.getPassword())) {
                result = true;
                logger.info("User: " + user.getUserId() + " Authorized success.");
                return result;
            }
        }
        try {
            UserEntity resultUser = (UserEntity) em.createNamedQuery("isUserAuthorized").setParameter("login", user.getLogin()).setParameter("password", user.getPassword()).getSingleResult();
            if (resultUser.getUserId() != null) {
                result = true;
                logger.info("User: " + user.getLogin() + " Authorized success.");
            } else {
                logger.info("User: " + user.getLogin() + " Authoriz filed.");
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return result;
    }
}
