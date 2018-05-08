
package Companies;

import Depots.Depots;
import java.util.List;

/**
 * This class represents a Company interface. 
 * To be considered a company, the class has to have a name,
 * to have depots to store its products and make Revenue by trading. 
 * @author Felipe, Luciene and Vagner
 */
public interface CompaniesInterface {

    /**
     * Those are the methods a Company must to have
     * @return a String
     */
    public String getCompanyName();
    public List<Depots> getListOfDepots();
    public int getRevenue();
    public int getStartRevenue();
    public int getIncome();
    public int getOutcome();
    public int getTotalSold();
    public int getTotalBought();
    public int getProductPrice(String productType, int depotIndex, int productIndex);
    
    
}
