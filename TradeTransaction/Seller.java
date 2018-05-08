package TradeTransaction;

import Companies.CompositeCompany;
import Products.Products;

/** This class analyzes the depots to evaluate whether the company can sell or not
 * Checks if the depot has enough products to sell under the rule of min native
 * stock
 **
 * @author Felipe, Luciene and Vagner
 */
public class Seller {

    private CompositeCompany seller;
    private int sellerDepotNumber;
    private Products product;
    
    /**
     * Seller can only sell it's own product
     * @param seller CompositeCompany
     * @param sellerDepotNumber Integer
     */
    public Seller(CompositeCompany seller, int sellerDepotNumber){
        this.seller = seller;
        this.sellerDepotNumber = sellerDepotNumber;
        setProduct();
    }
    /**
     * This method checks if it has enough storage to sell 
     * a product and if the balance did not reach the limit
     * @return boolean 
     */
    public boolean depotCanSell(){
        return checkStock()== true && checkBalance()==true;
    }
    /**
     * 
     * @return true if the stock size is greater than the minimum stock 
     */
    public boolean checkStock(){
        int currentStock, minStock;
        switch(getSeller().getCompanyName()){
            case "BigA":
                currentStock = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductsA().size();
                minStock = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductAMin();        
                return currentStock > minStock;
            case "BigB":
                currentStock = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductsB().size();
                minStock = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductBMin();
                return currentStock > minStock;
            case "BigC":
                currentStock = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductsC().size();
                minStock = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductCMin();
                return currentStock > minStock;
            
        }
        return false;
    }
    /**
     * 
     * @return true if the company didn't reach the max cash allowance 
     */
    public boolean checkBalance(){
        int currentBalance = getSeller().getListOfDepots().get(sellerDepotNumber).getCurrentBalance();
        int maxBalance = getSeller().getListOfDepots().get(sellerDepotNumber).getMaxCashAllowance();
        int productTotalPrice = 0;
        switch(getSeller().getCompanyName()){
            case "BigA":
                productTotalPrice = getSeller().getListOfDepots().get(sellerDepotNumber).getListOfProducts().getProductsA().get(0).getTotalPrice();
                break;
            case "BigB":
                productTotalPrice = getSeller().getListOfDepots().get(sellerDepotNumber).getListOfProducts().getProductsB().get(0).getTotalPrice();
                break;
            case "BigC":
                productTotalPrice = getSeller().getListOfDepots().get(sellerDepotNumber).getListOfProducts().getProductsC().get(0).getTotalPrice();
                break;
        }
        
        return (currentBalance+productTotalPrice) < maxBalance;
    }

    /**
     * @return the seller
     */
    public CompositeCompany getSeller() {
        return seller;
    }

    /**
     * @return the sellerDepotNumber
     */
    public int getSellerDepotNumber() {
        return sellerDepotNumber;
    }
    /**
     * 
     * @param sellerDepotNumber integer depot number
     */
    public void setSellerDepotNumber(int sellerDepotNumber){
        this.sellerDepotNumber = sellerDepotNumber;
        
    }
    /**
     * 
     * @return product
     */
    public Products getProduct(){
        return product;
    }
    
    private void setProduct(){
        switch(getSeller().getCompanyName()){
            case "BigA":
                product = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductsA().get(1);
                break;
            case "BigB":
                product = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductsB().get(1);
                break;
            case "BigC":
                product = seller.getListOfDepots().get(getSellerDepotNumber()).getListOfProducts().getProductsC().get(1);
                break;
            default :
                System.out.println("Error trying in the method setProduct() class Seller.java");
                    
       }
    }
}
