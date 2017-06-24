package ict4315.assignment6;

public class OrderLineItem {
    
    private final int m_quantity ;
    private final Product m_product ;
    
    public OrderLineItem ( int quantity, Product product )
    {
        this.m_quantity = quantity ;
        this.m_product = product ;
    }
    
    public int getQuantity() { return m_quantity ; }
    public Product getProduct() { return m_product ; }

}
