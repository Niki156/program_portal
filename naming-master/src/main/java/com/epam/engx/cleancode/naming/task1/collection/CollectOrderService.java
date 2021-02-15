package com.epam.engx.cleancode.naming.task1.collection;


import com.epam.engx.cleancode.naming.task1.IOrderService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Order;

public class CollectOrderService implements IOrderService {

    private CollectionService collectionService;
    private NotificationManager notificationManager;
    private int infoNotificationLevel = 4;
    private int criticalNotificationLevel=1;
    public void submitOrder(Order orderName) {
        if (collectionService.isEligibleForCollection(orderName))
            notificationManager.notifyCustomer(Message.READY_FOR_COLLECT, infoNotificationLevel); 
        else
            notificationManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, criticalNotificationLevel); 
    }

    public void setCollectionService(CollectionService collectionServiceName) {
        this.collectionService = collectionServiceName;
    }

    public void setNotificationManager(NotificationManager notificationManagerName) {
        this.notificationManager = notificationManagerName;
    }
}
