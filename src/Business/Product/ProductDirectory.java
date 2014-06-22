/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import Business.Enterprise.Supplier;
import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class ProductDirectory {
    
    private ArrayList<ProductSubDirectory> subDirectoryList=new ArrayList<>();
    String name;
    DType dtype;
    public enum DType {
        Books("Books"), Clothing("Clothing"), Electronics("Electronics"), Grocery("Grocery"), Beauty("Beauty"),
        Kids("Kids"), Sports("Sports"),Computer("Computer");
        private String value;

        private DType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public ArrayList<ProductSubDirectory> getSubDirectoryList() {
        return subDirectoryList;
    }

    public void setSubDirectoryList(ArrayList<ProductSubDirectory> subDirectoryList) {
        this.subDirectoryList = subDirectoryList;
    }
  
    public ProductSubDirectory newSubDirectory(ProductSubDirectory.PType p) {
        ProductSubDirectory subDirectory = new ProductSubDirectory();
        subDirectory.setPtype(p);
        subDirectory.setName(p.getValue());
        subDirectoryList.add(subDirectory);
        return subDirectory;
    }
     public ProductSubDirectory newSubDirectory(ProductSubDirectory prod ) {
        subDirectoryList.add(prod);
        return prod;
    }

   

    public void removeSubDirectory(ProductSubDirectory p) {
        subDirectoryList.remove(p);
    }
    
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DType getDtype() {
        return dtype;
    }

    public void setDtype(DType dtype) {
        this.dtype = dtype;
    }

     /*  public ArrayList<Product> getMostPopularProduct(ProductDirectory directory) {
       Product tmp = new Product();
        ArrayList<Product> a=directory.getSubDirectoryList().getProductList();
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
    */
    @Override
    public String toString() {
        return  name;
    }
    
}
