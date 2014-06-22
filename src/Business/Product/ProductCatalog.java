/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import Business.Enterprise.Supplier;
import Business.Product.ProductDirectory.DType;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class ProductCatalog {

    private ArrayList<ProductDirectory> productDirectorys = new ArrayList<>();

    public ArrayList<ProductDirectory> getProductDirectorys() {
        return productDirectorys;
    }

    public void setProductDirectorys(ArrayList<ProductDirectory> productDirectorys) {
        this.productDirectorys = productDirectorys;
    }

    public ProductDirectory create(DType dType) {
        ProductDirectory directory = new ProductDirectory();
        directory.setName(dType.getValue());
        directory.setDtype(dType);
        productDirectorys.add(directory);
        return directory;
    }

  
     public ArrayList<Product> search(String s){
         ArrayList<Product> products=new ArrayList<>();
         for(ProductDirectory directory:this.productDirectorys){
             for(ProductSubDirectory subDirectory:directory.getSubDirectoryList()){
             for(Product p:subDirectory.getProductList()){
                 if(p.getName().contains(s)){
                     products.add(p);
                 }
             }
         }
         }
         return products;
     }
    /*
     public ArrayList<Product> sort(ArrayList<Product> a,) {
     Product tmp=new Product();
     for (int i = 0; i < a.size(); i++) {
     for (int j = 1; j > a.size()-i; j++) {
     if (a.get(i).getRate() < a.get(j - 1).getRate()) {
     tmp = a.get(j - 1);
     a.set((j - 1), a.get(j));
     a.set(j,tmp);
     }
     }
     }
     return a;
     }
     */

    public void removeProduct(ProductDirectory directory) {
        productDirectorys.remove(directory);
    }
}
