package ict4315.assignment6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date m_date ;
    private String m_orderId ;
    private Customer m_customer ; 
    private List<OrderLineItem> m_orderLineItems ;
    
    public Order ( String id, Customer c )
    {
        m_date = new Date() ;
        this.m_orderId = id ;
        this.m_customer = c ;
        m_orderLineItems = new ArrayList<OrderLineItem>() ;
    }
    
    public void addOrderLineItem ( OrderLineItem item )
    {
        m_orderLineItems.add(item) ;
    }
    
    public double getTotal()
    {
        double currentPrice = calculateBasePrice() ;
        currentPrice = calculateDiscountPrice ( currentPrice ) ;
        return currentPrice ;
    }
    
    private double calculateDiscountPrice ( double currentPrice )
    {
        double discount = m_customer.getDiscountInformation(currentPrice) ;        
        return ( currentPrice - discount * currentPrice ) ;
    }

    private double calculateBasePrice()
    {
        double basePrice = 0 ;
        for ( OrderLineItem anOrderLineItem : m_orderLineItems )
        {
            int quantity = anOrderLineItem.getQuantity() ;
            Product product = anOrderLineItem.getProduct() ;
            double price = product.getPrice() ;
            basePrice += price * quantity ;
        }
        return basePrice ;
    }

}
