/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.WarehouseLoction.WarehouseLocation;
import java.util.ArrayList;
import javax.tools.JavaFileManager.Location;

/**
 *
 * @author hyf
 */
public class Network {

    String name;
    ArrayList<Enterprise> EnterpriseList = new ArrayList<>();

    public ArrayList<Enterprise> getEnterpriseList() {
        return EnterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> EnterpriseList) {
        this.EnterpriseList = EnterpriseList;
    }

    public Enterprise createSupplier(String name) {
        Supplier supplier = new Supplier(name);
      //  supplier.setLocation(location);
        EnterpriseList.add(supplier);
        return supplier;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enterprise getMostRateSuupplier() {
        Enterprise testEnterprise = new Supplier("");
        for (Enterprise e : this.EnterpriseList) {
            if (((Supplier) e).rate() > ((Supplier) testEnterprise).rate()) {
                testEnterprise = e;
            }
        }
        return testEnterprise;
    }
    public ArrayList<Enterprise> getMostRateEnterprise(Network network) {
        Enterprise tmp = new Supplier("");
        ArrayList<Enterprise> a=network.getEnterpriseList();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 1; j > a.size() - i; j++) {
                if (((Supplier)a.get(i)).getRate()< ((Supplier)a.get(j - 1)).getRate()) {
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
        return name;
    }
}
