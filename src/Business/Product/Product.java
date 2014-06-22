/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import Business.Enterprise.Supplier;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class Product {
    private  static int count=0;
    private  int  productId = 0;
    private  int Id = 0;
    private String name;
    private int price;
    private int available;
    private int soldNum;
    private Supplier supplier;
    private ArrayList<Review> reviews = new ArrayList<>();
    private float rate;
    private String picture;

    public Product() {
        productId=count;
        Id=count;
        count++;
    }

    public int totalSoldNum(int num) {
        return soldNum = soldNum + num;
    }

    public int avaliblility(int num) {
        return available = available - num;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Review createReview() {
        Review review = new Review();
        reviews.add(review);
        return review;
    }

    public Review createReview(Review review) {
        reviews.add(review);
        return review;
    }

    public float rate() {
        rate=0;
        for (Review review : reviews) {
            rate = rate + review.getStarForSupplier();
            
        }
        return rate /reviews.size();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return name;
    }
}
