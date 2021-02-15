package com.epam.engx.cleancode.naming.task4.service.impl;


import com.epam.engx.cleancode.naming.task4.service.CustomerDetails;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContactDAO;

public class CustomerContactService implements CustomerDetails {

    private CustomerContactDAO customerContactDAO;

    public CustomerContact getCustomerDetails(Long customerId) {
        return customerContactDAO.findById(customerId);
    }

    public void updateCustomerDetails(CustomerContact newCustomerDetails) {
        customerContactDAO.update(newCustomerDetails);
    }
}
