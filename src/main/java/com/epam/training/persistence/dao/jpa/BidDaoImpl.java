package com.epam.training.persistence.dao.jpa;

import com.epam.training.persistence.dao.BidDao;
import com.epam.training.persistence.pojo.BidsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by Oleg_Burshinov on 12.02.14.
 */
@Repository
public class BidDaoImpl implements BidDao {

    @PersistenceUnit(unitName = "defaultPersistenceUnit")
    private EntityManagerFactory emf;
    Logger logger = LoggerFactory.getLogger(BidDaoImpl.class);


//    @Override
//    @Transactional(isolation = Isolation.DEFAULT,
            //Используется уровень изоляции по умолчанию,
            //зависящий от конкретного хранилища данных
//            propagation = Propagation.REQUIRED,
//            Указывает, что метод должен выполняться внутри
//            транзакции. Если к моменту вызова метода будет
//            запущена транзакция, он будет выполняться
//            в рамках этой транзакции. В противном случае
//            будет запущена новая транзакция
//            rollbackFor = Exception.class)
    public boolean addBid(BidsEntity to) {
        EntityManager em = this.emf.createEntityManager();
        try {
//            em.getTransaction().begin();
//            em.getTransaction().commit();


            logger.info("");
        } catch (Exception e) {
            logger.error("" + e.getLocalizedMessage());
            logger.error(e.getLocalizedMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return false;
    }
}
