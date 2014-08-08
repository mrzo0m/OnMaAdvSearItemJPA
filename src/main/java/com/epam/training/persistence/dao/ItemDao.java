package com.epam.training.persistence.dao;

import com.epam.training.persistence.pojo.ItemsEntity;

import java.util.Map;
import java.util.Set;

/**
 * Created by Oleg_Burshinov on 12.02.14.
 */
public interface ItemDao {

    /**
     * @param pageNumber       Page number
     * @param itemsCountOnPage how many records on page
     * @return Set with all stored items
     */
    public Set<ItemsEntity> allItems(int pageNumber,
                              int itemsCountOnPage);

    /**
     * @param id unique number of items
     * @return Set of transfer objects
     */
    public ItemsEntity read(Long id);

    /**
     * @param title field to find
     * @return transfer object with this id
     */
    public Set<ItemsEntity> findItemsByTitle(String title);

    /**
     * @param description field to find
     * @return Set of transfer objects
     */
    public Set<ItemsEntity> findItemsByDescription(String description);

    /**
     * @param to Transfer Object to add in store
     * @return id from store or -1 if not added
     */
    public int create(ItemsEntity to) throws Exception;

    /**
     * @param id in store to delete
     * @return true if deleting complete
     */
    public boolean delete(Long id);

    /**
     * @param pageNumber                       Page number
     * @param itemsCountOnPage                 how many records on page
     * @param columnForOrderSpaceSortDirection array with column names and order direction separated by space
     *                                         Example: {"UID DESC", "TITLE"}
     * @param filter                           value for filtering
     * @param filterColumn                     column for adding filter
     * @param category
     * @return Set transfer objects with this parameters
     */
//    public List<FullInfo> getFullInfoItems(int pageNumber, int itemsCountOnPage, String[] columnForOrderSpaceSortDirection, String filter, String filterColumn, Integer category);

    /**
     * @param pageNumber                       Page number
     * @param itemsCountOnPage                 how many records on page
     * @param columnForOrderSpaceSortDirection array with column names and order direction separated by space
     *                                         Example: {"UID DESC", "TITLE"}
     * @param filterMap                        search parameters
     * @param category
     * @return Set transfer objects with this parameters
     */
//    public List<FullInfo> getAdvancedInfoItems(int pageNumber, int itemsCountOnPage, String[] columnForOrderSpaceSortDirection, Map<String, Object> filterMap, Integer category);


    /**
     * @param pageNumber       Page number
     * @param itemsCountOnPage how many records on page
     * @param userId           user id to show all items for this user
     * @return Set transfer objects with this parameters
     */
//    public List<FullInfo> getFullInfoMyItems(int pageNumber, int itemsCountOnPage, Integer userId);

    /**
     * @return Sold ItemsEntity <itemId, userId>
     */
    public Map<Integer, Integer> getSoldItems();

    /**
     * @param itemId ItemsEntity for checking
     * @return true if already send message
     */
    public boolean isInformationMessageSend(Integer itemId);

    /**
     * @param itemId set ItemsEntity complete biding
     * @return status to add mark
     */
    public boolean markAsSendedMessage(Integer itemId);

    /**
     * @param itemId ItemsEntity
     * @return Information about biding to this lot
     */
//    public List<History> getHistory(Integer itemId);

    /**
     * @return category information
     */
//    public List<Category> getCategory();

    /**
     * @param to
     * @return status true - success
     */
    public boolean update(ItemsEntity to);

}
