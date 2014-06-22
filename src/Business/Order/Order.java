/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Enterprise.Supplier;
import Business.Invoice.Invoice;
import Business.Packaging.Packaging;
import Business.Payment.Payment;
import Business.Product.Product;
import Business.Shipment.Shipment;
import Business.UserAccount.UserAccount;
import Business.UserAddress.BillAddress;
import Business.UserAddress.ShippingAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class Order {

    private static int count = 0;
    private ArrayList<OrderItem> order = new ArrayList<OrderItem>();
    private ArrayList<Order> suborders = new ArrayList<Order>();
    private Order suborder ;
    private int OrderNum;
    private int subOrderquantity;
    private String status;
    private float totalPrice;
    private float money;
    private float subtotalPrice;
    private float tax;
    private float shipping;
    private int quantity;
    private UserAccount customer;
    private Shipment shipment;
    private Packaging packaging;
    private Payment payment;
    private Date orderDate;
    private Invoice invoice;
    private ShippingAndTax shippingAndTax;
    private int supplierNum;

    public Order() {
        OrderNum = count;
        count++;
    }

    public ArrayList<OrderItem> getOrder() {
        return order;

    }

    /*public int quantity() {
     for (OrderItem i : this.getOrder()) {
     quantity = quantity + i.getNumber();
     }
     return quantity;
     }*/
    public void setOrder(ArrayList<OrderItem> order) {
        this.order = order;
    }

    public static int getCount() {
        return count;
    }

    public void setOrderNum(int OrderNum) {
        this.OrderNum = OrderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(float subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserAccount getCustomer() {
        return customer;
    }

    public void setCustomer(UserAccount customer) {
        this.customer = customer;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public ShippingAndTax getShippingAndTax() {
        return shippingAndTax;
    }

    public void setShippingAndTax(ShippingAndTax shippingAndTax) {
        this.shippingAndTax = shippingAndTax;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getShipping() {
        return shipping;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public int getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(int supplierNum) {
        this.supplierNum = supplierNum;
    }
  public Order createSubOrder() {
        suborder=new Order();
        suborder.setOrderNum(OrderNum);
        suborders.add(suborder);
        return suborder;
    }
    public OrderItem createOrderItem() {
        OrderItem o = new OrderItem();
        order.add(o);
        return o;
    }
      public OrderItem createOrderItem(OrderItem o ) {
        order.add(o);
        return o;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public Order getSuborder() {
        return suborder;
    }

    public void setSuborder(Order suborder) {
        this.suborder = suborder;
    }

    public int getSubOrderquantity() {
        return subOrderquantity;
    }

    public void setSubOrderquantity(int subOrderquantity) {
        this.subOrderquantity = subOrderquantity;
    }

    public ArrayList<Order> getSuborders() {
        return suborders;
    }

    public void setSuborders(ArrayList<Order> suborders) {
        this.suborders = suborders;
    }



  


    public void reduceProductNum() {
        for (OrderItem o : this.order) {
            Product p = o.getProduct();
            p.setAvailable(p.getAvailable() - o.getNumber());
        }
    }

    public ArrayList<OrderItem> deleteOrderItem(OrderItem o) {
        order.remove(o);
        return order;
    }

    public OrderItem createOrderItem(Product product, int number) {
        OrderItem o = new OrderItem();
        order.add(o);
        o.setProduct(product);
        o.setNumber(number);
        return o;

    }

    public float totalPrice() {
        totalPrice = 0;
        /* for (OrderItem o : this.order) {
         totalPrice = totalPrice + o.getMoney() * o.getNumber();
         totalPrice=totalPrice+tax;
         }*/
        totalPrice = subtotalPrice() + tax();
        return totalPrice;

    }

    public float subtotalPrice() {
        subtotalPrice = 0;
        for (OrderItem o : this.order) {
            subtotalPrice = subtotalPrice + o.getMoney() * o.getNumber();
        }
        return subtotalPrice;

    }

    public float tax() {
        tax = 0;
        tax = subtotalPrice() * shippingAndTax.getTaxMoney();
        return tax;
    }

    public float singelShipping() {
        return shippingAndTax.getShippingMoney();
    }

    public float shipping() {
        shipping = 0;
        shipping = shippingAndTax.getShippingMoney() * SupplierNum();
        return shipping;
    }

    public float getSeparateTotal(Supplier supplier) {
        float separateTotal = 0;
        for (OrderItem item : order) {
            if (item.getProduct().getSupplier() == supplier) {
                separateTotal = separateTotal + item.getNumber() * item.getMoney();
                separateTotal = separateTotal + separateTotal * shippingAndTax.getTaxMoney();
            }
        }
        return separateTotal;
    }

    public float totalMoney() {
        money = 0;
        money = subtotalPrice() + tax() + shipping();
        return money;
    }

    public float SupplierNum() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        for (OrderItem item : order) {
            if (!suppliers.contains(item.getProduct().getSupplier())) {
                suppliers.add(item.getProduct().getSupplier());
            }
        }
        float f = suppliers.size();
        return f;
    }

    @Override
    public String toString() {
        return String.valueOf(OrderNum);
    }
}
