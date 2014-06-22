/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Payment;

import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class PaymentDirectory {

    ArrayList<Payment> paymentlist = new ArrayList<>();

    public ArrayList<Payment> getPaymentlist() {
        return paymentlist;
    }

    public void setPaymentlist(ArrayList<Payment> paymentlist) {
        this.paymentlist = paymentlist;
    }

    public Payment add() {
        Payment payment = new Payment();
        paymentlist.add(payment);
        return payment;

    }
      public Payment add(Payment payment) {
        paymentlist.add(payment);
        return payment;

    }
}
