package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class uses Composite Design Pattern to grouping the products in its
 * respective ArrayList. It set the rules of number of products created by each
 * company according program requirements
 *
 * @author Felipe, Luciene and Vagner
 *  * @ref https://www.tutorialspoint.com/design_pattern/composite_pattern.htm
 */
public class CompositeProducts {

    // crates a product factory
    private final ProductFactory productFactory;
    // crates one products from each type
    private Products productA, productB, productC;
    // max amount of product that should be created of each type
    private int productAMax, productBMax, productCMax;

    // min amount of product that should be created of each type
    private int producAMin, productBMin, productCMin;
    // creates lists to store each type of products
    private final List<Products> productsA, productsB, productsC;
    // creates a list with companies names    

    List<String> companiesName;

    /**
     * Constructor that Initializes a new Product Factory and Array Lists group
     * to store the products based on the company name It takes a String as a
     * companyName
     *
     * @param companyName company name - BigA, BigB or BigC
     */
    public CompositeProducts(String companyName) {
        productFactory = new ProductFactory();
        productsA = new ArrayList<>();
        productsB = new ArrayList<>();
        productsC = new ArrayList<>();
        companiesName = new ArrayList<>();
        generateProducts(companyName);
    }

    /**
     * Generates the products depending on the @companyName parameter by the
     * method that called it
     *
     * @param companyName name of the company that you want to create a list of
     * products - BigA, BigB or BigC
     */
    private void generateProducts(String companyName) {
        companiesName.add("BigA");  // adds BigA to the company names List
        companiesName.add("BigB");  // adds BigB to the company names List
        companiesName.add("BigC");  // adds BigC to the company names List
        // switch statement which determines which product will be  generates

        switch (companyName) {
            // in case the company name String is BigA
            case "BigA":
                // the program will set max, min amount of native productA
                // and max, min of purchase productsB and productC for Big A
                setProductAMax(50);
                setProductAMin(15);
                setProductBMax(40);
                setProductBMin(3);
                setProductCMax(40);
                setProductCMin(3);
                // then calls the method createListOfProducts() 
                // @see createListOfProducts() bellow
                createListOfProduct(getProductsA(), productA, "a", getProductAMax(), getProductAMin());
                createListOfProduct(getProductsB(), productB, "b", getProductBMax(), getProductBMin());
                createListOfProduct(getProductsC(), productC, "c", getProductCMax(), getProductCMin());
                break;
            // in case the company name String is BigB
            case "BigB":
                // the program will set max, min amount of native productB
                // and max, min of purchase productsA and productC for Big B  
                setProductAMax(40);
                setProductAMin(3);
                setProductBMax(50);
                setProductBMin(15);
                setProductCMax(40);
                setProductCMin(3);
                // then calls the method createListOfProducts() 
                // @see createListOfProducts() bellow                    
                createListOfProduct(getProductsA(), productA, "a", getProductAMax(), getProductAMin());
                createListOfProduct(getProductsB(), productB, "b", getProductBMax(), getProductBMin());
                createListOfProduct(getProductsC(), productC, "c", getProductCMax(), getProductCMin());
                break;
            // in case the company name String is BigC
            case "BigC":
                // the program will set the max amount of native productA
                // and max of purchase productsB and productC A for Big A
                setProductAMax(40);
                setProductAMin(3);
                setProductBMax(40);
                setProductBMin(3);
                setProductCMax(50);
                setProductCMin(15);
                // then calls the method createListOfProducts() 
                // @see createListOfProducts() bellow
                createListOfProduct(getProductsA(), productA, "a", getProductAMax(), getProductAMin());
                createListOfProduct(getProductsB(), productB, "b", getProductBMax(), getProductBMin());
                createListOfProduct(getProductsC(), productC, "c", getProductCMax(), getProductCMin());
                break;

            default:
                //if none of the cases match 
                System.out.println(companyName + " does not exist, please create a company with the input name,"
                        + " or choose one of the companies avaliable in the list");
                for (int i = 0; i < companiesName.size(); i++) {
                    System.out.println(companiesName.get(i));
                }
                break;
        }
    }

    /**
     * Display complete information of the product
     * @param product type of Products
     * @return a Product which the details will be displayed
     */
    public String displayProduct(Products product) {
        return product.toString();
    }

    /**
     * Gets the price for the product sent as parameter
     *
     * @param product Object product that identifies a specific product
     * @return product.getProductPrice() a int with the price
     */
    public int getProductPrice(Products product) {
        return product.getProductPrice();
    }

    /**
     * Gets the price of delivery for the product sent as parameter
     *
     * @param product Object Product that identifies a specific product
     * @return product.getDeliveryPrice() int with the price
     */
    public int getProductDeliveryPrice(Products product) {
        return product.getDeliveryPrice();
    }

    /**
     * Gets total price adding up product and delivery prices of the product
     * sent as parameter
     *
     * @param product Object Product that identifies a specific product
     * @return deliveryPrice+productPrice int with the price sum
     */
    public int getTotalPrice(Products product) {
        return product.getDeliveryPrice() + product.getProductPrice();
    }

    /**
     * Creates a new products and Adds into the a List of products
     *
     * @param list when the new product will be added to
     * @param product the new Product Object
     * @param productName to define what type of product to be created
     * @param max - the maximum of products can be create
     * @param min - the min of products can be created
     */
    private void createListOfProduct(List<Products> list, Products product, String productName, int max, int min) {
        // random number between the min and max amount that a List can hold
        int randomLoop = new Random().nextInt(max - min + 1) + min;
        // the for loop will run the number of time specified in randonLoop
        // variable
        for (int i = 0; i < randomLoop; i++) {
            //For each time, will Call the factory method to create the new 
            //product, and add this product to the list.
            product = productFactory.makeProduct(productName);
            list.add(product);
        }
    }

    /**
     * Gets a list with all Products A
     *
     * @return a List of Products
     */
    public List<Products> getProductsA() {
        return productsA;
    }

    /**
     * Adds a product to the list of products A
     *
     * @param product the product to be added
     */
    public void addA(Products product) {
        productsA.add(product);
    }

    /**
     * Removes a product from the list of products A
     *
     * @param product the product to be removed
     */
    public void removeA(Products product) {
        productsA.remove(product);
    }

    /**
     * Gets a list with all Products B
     *
     * @return the productsB list
     */
    public List<Products> getProductsB() {
        return productsB;
    }

    /**
     * Adds a product to the list of products B
     *
     * @param product the product to be added
     */
    public void addB(Products product) {
        productsB.add(product);
    }

    /**
     * Removes a product from the list of products B
     *
     * @param product the product to be removed
     */
    public void removeB(Products product) {
        productsB.remove(product);
    }

    /**
     * Gets a list with all Products C
     *
     * @return the productsC list
     */
    public List<Products> getProductsC() {
        return productsC;
    }

    /**
     * Adds a product to the list of products C
     *
     * @param product the product to be added
     */
    public void addC(Products product) {
        productsC.add(product);
    }

    /**
     * Removes a product from the list of products C
     *
     * @param product the product to be removed
     */
    public void removeC(Products product) {
        productsC.remove(product);
    }

    /**
     * Gets the max number of product A that can have in the list
     *
     * @return the productAMax
     */
    public int getProductAMax() {
        return productAMax;
    }

    /**
     * Sets the max number of product A that can have in the list
     *
     * @param productAMax the productAMax to set
     */
    public void setProductAMax(int productAMax) {
        this.productAMax = productAMax;
    }

    /**
     * Gets the max number of product B that can have in the list
     *
     * @return the productBMax
     */
    public int getProductBMax() {
        return productBMax;
    }

    /**
     * Sets the max number of product B that can have in the list
     *
     * @param productBMax the productB Max to set
     */
    public void setProductBMax(int productBMax) {
        this.productBMax = productBMax;
    }

    /**
     * Gets the max number of product C that can have in the list
     *
     * @return int with the productC Max
     */
    public int getProductCMax() {
        return productCMax;
    }

    /**
     * Sets the max number of product C that can have in the list
     *
     * @param productCMax int the productCMax to set
     */
    public void setProductCMax(int productCMax) {
        this.productCMax = productCMax;
    }

    /**
     * Gets the min number of product A that can have in the list
     *
     * @return the producAMin
     */
    public int getProductAMin() {
        return producAMin;
    }

    /**
     * Sets the min number of product A that can have in the list
     *
     * @param producAMin the producAMin to set
     */
    public void setProductAMin(int producAMin) {
        this.producAMin = producAMin;
    }

    /**
     * Gets the min number of product A that can have in the list
     *
     * @return the productBMin
     */
    public int getProductBMin() {
        return productBMin;
    }

    /**
     * Sets the min number of product B that can have in the list
     *
     * @param productBMin the productBMin to set
     */
    public void setProductBMin(int productBMin) {
        this.productBMin = productBMin;
    }

    /**
     * Gets the min number of product C that can have in the list
     *
     * @return the productCMin
     */
    public int getProductCMin() {
        return productCMin;
    }

    /**
     * Sets the min number of product C that can have in the list
     *
     * @param productCMin the productCMin to set
     */
    public void setProductCMin(int productCMin) {
        this.productCMin = productCMin;
    }

}
