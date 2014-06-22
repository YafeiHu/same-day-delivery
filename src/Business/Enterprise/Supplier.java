/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.Product.Product;
import Business.Product.ProductCatalog;
import Business.Product.ProductDirectory;
import Business.Product.ProductSubDirectory;
import Business.Product.Review;
import java.util.ArrayList;
import javax.tools.JavaFileManager.Location;

/**
 *
 * @author hyf
 */
public class Supplier extends Enterprise {

    private float rate;
    private int flag;
    private ArrayList<Review> reviews = new ArrayList<>();
    private float profit;
    public Supplier(String name) {
        super(name);
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void Flag() {
        flag++;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public Review createReview(Review review) {
        reviews.add(review);
        return review;
    }

    public float rate() {
        int rate = 0;
        if (reviews.size()!=0) {
            for (Review review : reviews) {
                rate = rate + review.getStarForSupplier();

            }
            rate = rate / reviews.size();
        }
        return rate;
    }

    public float rateForProducts() {
        int r = 0;
        int size = 0;
        for (Organization o : this.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof WarehouseOrganization) {
                for (ProductDirectory directory : ((WarehouseOrganization) o).getProductCatalog().getProductDirectorys()) {
                    for (ProductSubDirectory subDirectory : directory.getSubDirectoryList()) {
                        for (Product p : subDirectory.getProductList()) {
                            for (Review review : p.getReviews()) {
                                r = r + review.getStarForSupplier();
                                size = size + p.getReviews().size();
                            }

                        }
                    }
                }
            }

        }
        rate = r / size;
        return rate;
    }

    public ArrayList<WarehouseOrganization> getAllWarehouses(int i) {
        ArrayList<WarehouseOrganization> warehouseOrganizations = new ArrayList<>();
        for (Organization o : this.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof WarehouseOrganization) {
                for (ProductDirectory directory : ((WarehouseOrganization) o).getProductCatalog().getProductDirectorys()) {
                    for (ProductSubDirectory d : directory.getSubDirectoryList()) {
                        if (d.findItem(i) != null) {
                            warehouseOrganizations.add(((WarehouseOrganization) o));
                            System.out.println("00000000" + ((WarehouseOrganization) o).getName());
                        }
                    }
                }
            }
        }
        return warehouseOrganizations;
    }
}
