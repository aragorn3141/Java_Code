package ict4315.assignment6;

public class Product {
    
    private final String m_productId ;
    private final String m_description ;
    private double m_price ;
    
    public Product ( String id, String description, double price )
    {
        m_productId = id ;
        m_description = description ;
        setPrice ( price ) ;
    }
    
    public String getProductId() { return m_productId ; }
    public String getDescription() { return m_description ; }
         
    public void setPrice ( double price ) { m_price = price ; }
    public double getPrice () { return m_price ; }

}
