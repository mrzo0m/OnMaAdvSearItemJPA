package com.epam.training.persistence.dao;

import com.epam.training.persistence.pojo.BidsEntity;

/**
 * Created by Oleg_Burshinov on 12.02.14.
 */
public interface BidDao {
    /**
     * @param to Transfer object for bids
     * @return adding status: true if bid set or false
     */
    public boolean addBid(BidsEntity to);
}
