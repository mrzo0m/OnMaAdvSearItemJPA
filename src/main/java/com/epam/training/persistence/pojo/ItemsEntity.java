package com.epam.training.persistence.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Oleg_Burshinov on 13.02.14.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "ITEMS", schema = "OMPTEST", catalog = "")
public class ItemsEntity {

    /**
     * JPA
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID", referencedColumnName = "USER_ID", nullable = false)
    private UserEntity user;

    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ITEM_ID_G")
    @SequenceGenerator(name = "ITEM_ID_G", sequenceName = "UID_GEN")
    private Long itemId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "START_PRICE")
    private BigDecimal startPrice;
    @Basic
    @Column(name = "TIME_LEFT")
    private Integer timeLeft;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_BIDDING_DATE")
    private Calendar startBiddingDate;
    @Basic
    @Column(name = "BUY_IT_NOW")
    private Integer buyItNow;
    @Basic
    @Column(name = "BID_INCREMENT")
    private Long bidIncrement;
    @Basic
    @Column(name = "CATEGORY")
    private Long category;


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }


    public Integer getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Integer timeLeft) {
        this.timeLeft = timeLeft;
    }


    public Calendar getStartBiddingDate() {
        return startBiddingDate;
    }

    public void setStartBiddingDate(Calendar startBiddingDate) {
        this.startBiddingDate = startBiddingDate;
    }


    public Integer getBuyItNow() {
        return buyItNow;
    }

    public void setBuyItNow(Integer buyItNow) {
        this.buyItNow = buyItNow;
    }


    public Long getBidIncrement() {
        return bidIncrement;
    }

    public void setBidIncrement(Long bidIncrement) {
        this.bidIncrement = bidIncrement;
    }


    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsEntity that = (ItemsEntity) o;

        if (bidIncrement != null ? !bidIncrement.equals(that.bidIncrement) : that.bidIncrement != null) return false;
        if (buyItNow != null ? !buyItNow.equals(that.buyItNow) : that.buyItNow != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (startBiddingDate != null ? !startBiddingDate.equals(that.startBiddingDate) : that.startBiddingDate != null)
            return false;
        if (startPrice != null ? !startPrice.equals(that.startPrice) : that.startPrice != null) return false;
        if (timeLeft != null ? !timeLeft.equals(that.timeLeft) : that.timeLeft != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startPrice != null ? startPrice.hashCode() : 0);
        result = 31 * result + (timeLeft != null ? timeLeft.hashCode() : 0);
        result = 31 * result + (startBiddingDate != null ? startBiddingDate.hashCode() : 0);
        result = 31 * result + (buyItNow != null ? buyItNow.hashCode() : 0);
        result = 31 * result + (bidIncrement != null ? bidIncrement.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
