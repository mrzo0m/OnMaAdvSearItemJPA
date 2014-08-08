package com.epam.training.persistence.dao.jpa;

import com.epam.training.persistence.dao.ItemDao;
import com.epam.training.persistence.pojo.ItemsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Map;
import java.util.Set;

/**
 * Created by Oleg_Burshinov on 13.02.14.
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @PersistenceUnit(unitName = "defaultPersistenceUnit")
    private EntityManagerFactory emf;
    Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);


    @Override
    public Set<ItemsEntity> allItems(int pageNumber, int itemsCountOnPage) {
        return null;
    }


    @Override
    @Transactional(isolation = Isolation.DEFAULT,
            //Используется уровень изоляции по умолчанию,
            //зависящий от конкретного хранилища данных
            propagation = Propagation.MANDATORY,
//            Указывает, что метод должен выполняться внутри
//            транзакции. Если к моменту вызова метода будет
//            запущена транзакция, он будет выполняться
//            в рамках этой транзакции. В противном случае
//            будет запущена новая транзакция
            rollbackFor = Exception.class)
    public int create(ItemsEntity to) throws Exception {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.persist(to);
            logger.info("Create item: " + to.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return 0;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,
            //Используется уровень изоляции по умолчанию,
            //зависящий от конкретного хранилища данных
            propagation = Propagation.MANDATORY,
//            Указывает, что метод должен выполняться внутри
//            транзакции. Если к моменту вызова метода будет
//            запущена транзакция, он будет выполняться
//            в рамках этой транзакции. В противном случае
//            будет запущена новая транзакция
            rollbackFor = Exception.class)
    public ItemsEntity read(Long id) {
        EntityManager em = this.emf.createEntityManager();
        ItemsEntity item = null;
        try {
            item = em.find(ItemsEntity.class, id);
            logger.info("Read item: " + item.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return item;
    }


    @Override
    public boolean update(ItemsEntity to) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Set<ItemsEntity> findItemsByTitle(String title) {
        return null;
    }

    @Override
    public Set<ItemsEntity> findItemsByDescription(String description) {
        return null;
    }


    @Override
    public Map<Integer, Integer> getSoldItems() {
        return null;
    }

    @Override
    public boolean isInformationMessageSend(Integer itemId) {
        return false;
    }

    @Override
    public boolean markAsSendedMessage(Integer itemId) {
        return false;
    }


}
