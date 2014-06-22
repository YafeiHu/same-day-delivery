/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import Business.Enterprise.Supplier;
import Business.Order.OrderItem;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class ProductSubDirectory {
    
    private ArrayList<Product> productList;
    String name;
    PType ptype;
    String productType;
    public enum PType {

        Books("Books"),Beauty("Beauty"),Electronics("Electronics"),BabyCareBeauty("BabyCareBeauty"), CellPhones("CellPhones"),TV("TV"),
        HomeAudio("HomeAudio"), Camera("Camera"),  LuxuryBeauty("LuxuryBeauty"),MenGrooming("MenGrooming"), Toys("Toys"), 
        Clothing("Clothing"),Grocery("Grocery"), Kids("Kids"), Sports("Sports"), Computer("Computer");
        private String value;

        private PType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public ProductSubDirectory() {
        productList = new ArrayList<>();
    }
    
    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public Product newProduct() {
        Product prod = new Product();
        productList.add(prod);
        return prod;
    }
     public Product newProduct(Product prod) {
        productList.add(prod);
        return prod;
    }

    public Product create(String name, int price,int available,Supplier supplier) {
        //reuse exitinfg method to maintain
        Product prod = newProduct();
        prod.setName(name);
        prod.setPrice(price);
        prod.setAvailable(available);
        prod.setSupplier(supplier);
        return prod;
    }

    public void removeProduct(Product p) {
        productList.remove(p);
    }
    
  public Product findItem(int id) {
        
        for (Product p : productList) {
            if (p.getProductId() ==id) {
                return p;
            }
        }
        return null;
    }
    public ArrayList<Product> findByName(String name) {
        
        for (Product p : productList) {
            if (p.getName() == name) {
                return productList;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PType getPtype() {
        return ptype;
    }

    public void setPtype(PType ptype) {
        this.ptype = ptype;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }


      public ArrayList<Product> getMostPopularProduct(ArrayList<Product> directory) {
        Product tmp = new Product();
        ArrayList<Product> a=directory;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 1; j > a.size() - i; j++) {
                if (a.get(i).getSoldNum() < a.get(j - 1).getSoldNum()) {
                    tmp = a.get(j - 1);
                    a.set((j - 1), a.get(j));
                    a.set(j, tmp);
                }
            }
        }
        return a;
    }
      public ArrayList<Product> getMostPopularProduct(ProductSubDirectory directory) {
        Product tmp = new Product();
        ArrayList<Product> a=directory.getProductList();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 1; j > a.size() - i; j++) {
                if (a.get(i).getSoldNum() < a.get(j - 1).getSoldNum()) {
                    tmp = a.get(j - 1);
                    a.set((j - 1), a.get(j));
                    a.set(j, tmp);
                }
            }
        }
        return a;
    }
    public ArrayList<Product> getMostRateProduct(ArrayList<Product> directory) {
        Product tmp = new Product();
        ArrayList<Product> a=directory;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 1; j > a.size() - i; j++) {
                if (a.get(i).getRate() < a.get(j - 1).getRate()) {
                    tmp = a.get(j - 1);
                    a.set((j - 1), a.get(j));
                    a.set(j, tmp);
                }
            }
        }
        return a;
    }
      public ArrayList<Product> getMostRateProduct(ProductSubDirectory directory) {
        Product tmp = new Product();
        ArrayList<Product> a=directory.getProductList();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 1; j > a.size() - i; j++) {
                if (a.get(i).getRate() < a.get(j - 1).getRate()) {
                    tmp = a.get(j - 1);
                    a.set((j - 1), a.get(j));
                    a.set(j, tmp);
                }
            }
        }
        return a;
    }
    @Override
    public String toString() {
        return  name;
    }
    
}
