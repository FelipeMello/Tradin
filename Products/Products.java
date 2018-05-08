package Products;

import java.util.Random;

/**
 * This is the abstract class for create Products It has a set of method to
 * guide the creation of concrete products
 *
 * @author Felipe, Luciene and Vagner
 */
public abstract class Products {

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    private String productName;
    private int productPrice, deliveryPrice;
    private int max;
    private int min;

    /**
     * Constructor initialize the @productPrice and @deliveryPrice getting a
     * random number
     */
    public Products() {
        Random rand = new Random();
        int randomPrice = rand.nextInt(10) + 1;
        productPrice = randomPrice;
        deliveryPrice = randomPrice;
    }

    /**
     * Gets the product name
     *
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    ;
    /**
     * Gets the product Price 
     * @return String with productPrice
     */
    public int getProductPrice() {
        return productPrice;
    }

    ;
    /**
     * Gets the delivery price 
     * @return an integer deliveryPrice
     */
    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    ;
    /**
     * Gets the total sum for price and delivery together  
     * @return a integer with the total price
     */
    public int getTotalPrice() {
        return deliveryPrice + productPrice;
    }

    /**
     * Sets a String as Product name
     *
     * @param productName can be a, b or c
     * @see ProductFactory
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    @Override
    public String toString() {
        return ("-- Product Info --"
                + "\nName : " + getProductName()
                + "\nPrice :" + getProductPrice()
                + "\nDelivery : " + getDeliveryPrice()
                +"\nMax : "+ getMax()
                +"\nMin"+getMin());
    }

}