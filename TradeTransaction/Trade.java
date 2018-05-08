package TradeTransaction;

import Companies.CompositeCompany;

import Products.Products;

/**
 * This class is a combination of the Seller and the Buyer class together to
 * make a transaction if the conditions are true
 *
 * @author Felipe, Luciene and Vagner
 */
public class Trade {

    private final CompositeCompany buyer;
    private final CompositeCompany seller;
    private final int buyerDepotNumber;
    private final int sellerDepotNumber;
    private final Products product;

    /**
     *
     * @param buyer company that is buying
     * @param buyerDepotNumber the depot of the company that is buying
     * @param seller company that is selling
     * @param sellerDepotNumber the depot of the company that is selling
     * @param product Object type of Products
     */
    public Trade(CompositeCompany buyer, int buyerDepotNumber, 
            CompositeCompany seller, int sellerDepotNumber,
            Products product) {
        this.buyer = buyer;
        this.buyerDepotNumber = buyerDepotNumber;
        this.seller = seller;
        this.sellerDepotNumber = sellerDepotNumber;
        this.product = product;
    }

    /**
     * This method calls the methods addProduct(), removeProduct(), doPayment()
     */
    public void trade() {
        addProduct();
        removeProduct();
        doPayment();

    }

    /**
     * it adds the product the product bought into the buyers list
     */
    public void addProduct() {
        // it will check the product name
        // to add it in the right list.
        switch (getProduct().getProductName()) {
            case "productA":
                //add to list of productsA
                buyer.getListOfDepots().get(buyerDepotNumber).getListOfProducts().getProductsA().add(getProduct());
                break;
            case "productB":
                //add to list of productsB
                buyer.getListOfDepots().get(buyerDepotNumber).getListOfProducts().getProductsB().add(getProduct());
                break;
            case "productC":
                //add to list of productsC
                buyer.getListOfDepots().get(buyerDepotNumber).getListOfProducts().getProductsC().add(getProduct());
                break;
            default:
                System.out.println("Error adding the product into the buyers list");
        }
    }

    /**
     * it removes the product sold from the sellers list
     */
    public void removeProduct() {
        //it will check what type of product was sold,
        // then it will remove it from it's list
        switch (getProduct().getProductName()) {
            case "productA":
                //remove product from the list of productsA
                seller.getListOfDepots().get(sellerDepotNumber).getListOfProducts().getProductsA().remove(getProduct());
                break;
            case "productB":
                //remove product from the list of productsB
                seller.getListOfDepots().get(sellerDepotNumber).getListOfProducts().getProductsB().remove(getProduct());
                break;
            case "productC":
                //remove product from the list of productsC
                seller.getListOfDepots().get(sellerDepotNumber).getListOfProducts().getProductsC().remove(getProduct());
                break;
            default:
                System.out.println("Error adding the product into the buyers list");
        }
    }

    /**
     * it makes the payment transaction.
     * it add the total price to the balance of the sellers depot
     * it subtracts the balance with  total price if products from the buyers depots.
     */
    public void doPayment() {
        int amount;
        amount = getProduct().getTotalPrice();
        seller.getListOfDepots().get(sellerDepotNumber).sold(amount);
        buyer.getListOfDepots().get(buyerDepotNumber).pay(amount);
    }

    /**
     * @return the buyer
     */
    public CompositeCompany getBuyer() {
        return buyer;
    }

    /**
     * @return the seller
     */
    public CompositeCompany getSeller() {
        return seller;
    }

    /**
     * @return the buyerDepotNumber
     */
    public int getBuyerDepotNumber() {
        return buyerDepotNumber;
    }

    /**
     * @return the sellerDepotNumber
     */
    public int getSellerDepotNumber() {
        return sellerDepotNumber;
    }

    /**
     * @return the product
     */
    public Products getProduct() {
        return product;
    }

}
