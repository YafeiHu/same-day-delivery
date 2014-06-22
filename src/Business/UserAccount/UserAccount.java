/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.FinanceAccount.FinanceAccountDirectory;
import Business.Order.MasterOrder;
import Business.Payment.PaymentDirectory;
import Business.Role.Role;
import Business.UserAddress.BillAddressDirectory;
import Business.UserAddress.ShippingAddressDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author hyf
 */
public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private MasterOrder OrderHistory = new MasterOrder();
    private FinanceAccountDirectory financeAccountDirectory = new FinanceAccountDirectory();
    private BillAddressDirectory BillAddressDirectory = new BillAddressDirectory();
    private ShippingAddressDirectory ShippingAddressDirectory = new ShippingAddressDirectory();
    private WorkQueue workQueue = new WorkQueue();
    private PaymentDirectory PaymentDirectory = new PaymentDirectory();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BillAddressDirectory getBillAddressDirectory() {
        return BillAddressDirectory;
    }

    public void setBillAddressDirectory(BillAddressDirectory BillAddressDirectory) {
        this.BillAddressDirectory = BillAddressDirectory;
    }

    public ShippingAddressDirectory getShippingAddressDirectory() {
        return ShippingAddressDirectory;
    }

    public void setShippingAddressDirectory(ShippingAddressDirectory ShippingAddressDirectory) {
        this.ShippingAddressDirectory = ShippingAddressDirectory;
    }

    public MasterOrder getOrderHistory() {
        return OrderHistory;
    }

    public void setOrderHistory(MasterOrder OrderHistory) {
        this.OrderHistory = OrderHistory;
    }

    public FinanceAccountDirectory getFinanceAccountDirectory() {
        return financeAccountDirectory;
    }

    public void setFinanceAccountDirectory(FinanceAccountDirectory financeAccountDirectory) {
        this.financeAccountDirectory = financeAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PaymentDirectory getPaymentDirectory() {
        return PaymentDirectory;
    }

    public void setPaymentDirectory(PaymentDirectory PaymentDirectory) {
        this.PaymentDirectory = PaymentDirectory;
    }

    @Override
    public String toString() {
        return username;
    }
}