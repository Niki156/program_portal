package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;

public class Order {

    private List<Product> products;
    private void removeUnavailableProducts()
    {
    	Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (!p.isAvailable())
                iterator.remove();
        }
        
    }
    private double getPriceOfProducts()
    {
    	double orderPrice=0.0;
    	for (Product p : products)
            orderPrice += p.getProductPrice();
    	return orderPrice;
    }
    public Double getPriceOfAvailableProducts() {
        removeUnavailableProducts();
        return getPriceOfProducts();
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
