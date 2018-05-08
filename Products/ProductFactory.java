package Products;

/**
 * This class is a Factory Design Pattern to create Products.
 * It is responsible for indicate which type of product should be made.
 * assigning the label the product 
 * It will be called by the CompositeProduct 
 * @author Felipe, Luciene and Vagner
 */
public class ProductFactory {
    
    /**
     * Makes a Product according the type required by the method that called it
     * @param productType gets a String with the type of products, we only have 
     * three types of products a, b and c, then 
     * @return a new Object of Products type
     */
    public Products makeProduct(String productType){
        // the switch statement creare the appropiate product
        switch (productType) {
            case "a":
                return new ProductA();
            case "b":
                return new ProductB();
            case "c":
                return new ProductC();
            default:
                return null;
        }
    }
}

