package ict4315.assignment6;

public class Customer {
    public static final double PRICE_FOR_DISCOUNT = 100.00d ; 

    private String m_address ;
    private String m_name ;
    
    private double m_discountInformation ;
    
    public Customer( String name, String address ) 
    {
        this.m_address = address ;
        this.m_name = name ;
    }

    public String getAddress() { return m_address ; }
    public void setAddress( String address ) { this.m_address = address ; }
    
    public String getName() { return m_name ; }
    
    public void setDiscountInformation( double discount )
    {
        m_discountInformation = discount ;
    }
    
    
    public double getDiscountInformation( double price )
    {
        if ( price >= PRICE_FOR_DISCOUNT )
        {
            return m_discountInformation ;
        }
        return 0 ;
    }

}
