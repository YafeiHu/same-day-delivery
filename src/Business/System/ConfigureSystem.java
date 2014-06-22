/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.System;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.WarehouseLoction.WarehouseLocation;
import Business.FinanceAccount.FinanceAccount;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Network.Network;
import Business.Order.ShippingAndTax;
import Business.Order.ShippingAndTaxDirectory;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.SysCustomerServiceOrganization;
import Business.Organization.FinanceOrganization;
import Business.Organization.SaleOrganization;
import Business.Organization.SysFinanceOrganization;
import Business.Organization.ShipOrganization;
import Business.Organization.SysSaleOrganization;
import Business.Organization.SysWarehouseOrganization;
import Business.Organization.WarehouseOrganization;
import Business.Organization.SystemAdminOrganization;
import Business.Payment.Payment;
import Business.Product.Product;
import Business.Product.ProductDirectory;
import Business.Product.ProductSubDirectory;
import Business.Role.CustomerRole;
import Business.Role.CustomerServiceRole;
import Business.Role.SysCustomerServiceRole;
import Business.Role.FinanceRole;
import Business.Role.SaleRole;
import Business.Role.SysFinanceRole;
import Business.Role.ShipRole;
import Business.Role.SysSaleRole;
import Business.Role.SysWarehouseRole;
import Business.Role.WarehouseRole;
import Business.UserAddress.ShippingAddress;
import com.db4o.User;
import javax.tools.JavaFileManager.Location;

/**
 *
 * @author hyf
 */
public class ConfigureSystem {

    public static AmazonSystem configure() {
        AmazonSystem system = AmazonSystem.getInstance();

        Employee employee1 = new Employee();
        employee1.setName("SystemAdmin");
        UserAccount account1 = new UserAccount();
        account1.setUsername("s");
        account1.setPassword("s");
        account1.setRole(new SystemAdminRole());
        account1.setEmployee(employee1);
        SystemAdminOrganization systemAdminOrganization = new SystemAdminOrganization();
        system.getOrganizationDirectory().getOrganizationList().add(systemAdminOrganization);
        systemAdminOrganization.getEmployeeDirectory().getEmployeeList().add(employee1);
        systemAdminOrganization.getUserAccountDirectory().getUserAccountList().add(account1);
        systemAdminOrganization.getShippingAndTaxDirectory().addShippingAndTax(ShippingAndTaxDirectory.SType.Massachusetts, 7f, 0.0625f);
        systemAdminOrganization.getShippingAndTaxDirectory().addShippingAndTax(ShippingAndTaxDirectory.SType.Califonia, 13f, 0.07f);

        Employee employee6 = new Employee();
        employee6.setName("f");
        UserAccount account6 = new UserAccount();
        account6.setUsername("f");
        account6.setPassword("f");
        account6.setRole(new SysFinanceRole());
        account6.setEmployee(employee6);
        SysFinanceOrganization sysFinanceOrganization = new SysFinanceOrganization();
        system.getOrganizationDirectory().getOrganizationList().add(sysFinanceOrganization);
        sysFinanceOrganization.getEmployeeDirectory().getEmployeeList().add(employee6);
        sysFinanceOrganization.getUserAccountDirectory().getUserAccountList().add(account6);
        FinanceAccount f = sysFinanceOrganization.getFinanceAccountDirectory().createFinanceAccount(FinanceAccount.FinanceAccountType.TrasactionAccount);
        f.setRemaining(6000);
        f.setName("amazon");

        Employee employee8 = new Employee();
        employee8.setName("SystemWarehouse");
        UserAccount account8 = new UserAccount();
        account8.setUsername("s");
        account8.setPassword("s");
        account8.setRole(new SysWarehouseRole());
        account8.setEmployee(employee8);
        SysWarehouseOrganization sysWarehouseOrganization = new SysWarehouseOrganization();
        system.getOrganizationDirectory().getOrganizationList().add(sysWarehouseOrganization);
        sysWarehouseOrganization.setNation("US");
        sysWarehouseOrganization.setName("amazon warehouse");
        sysWarehouseOrganization.getEmployeeDirectory().getEmployeeList().add(employee8);
        sysWarehouseOrganization.getUserAccountDirectory().getUserAccountList().add(account8);

        Employee employee10 = new Employee();
        employee10.setName("SystemSale");
        UserAccount account10 = new UserAccount();
        account10.setUsername("sa");
        account10.setPassword("sa");
        account10.setRole(new SysSaleRole());
        account10.setEmployee(employee10);
        SysSaleOrganization sysSaleOrganization = new SysSaleOrganization();
        system.getOrganizationDirectory().getOrganizationList().add(sysSaleOrganization);
        sysSaleOrganization.getEmployeeDirectory().getEmployeeList().add(employee10);
        sysSaleOrganization.getUserAccountDirectory().getUserAccountList().add(account10);

        Employee employee14 = new Employee();
        employee14.setName("SystemCustomerService");
        UserAccount account14 = new UserAccount();
        account14.setUsername("sc");
        account14.setPassword("sc");
        account14.setRole(new SysCustomerServiceRole());
        account14.setEmployee(employee14);
        SysCustomerServiceOrganization sysCustomerServiceOrganization = new SysCustomerServiceOrganization();
        system.getOrganizationDirectory().getOrganizationList().add(sysCustomerServiceOrganization);
        sysCustomerServiceOrganization.getEmployeeDirectory().getEmployeeList().add(employee14);
        sysCustomerServiceOrganization.getUserAccountDirectory().getUserAccountList().add(account14);

        Employee employee3 = new Employee();
        employee3.setName("customer");
        UserAccount account3 = new UserAccount();
        account3.setUsername("customer");
        account3.setPassword("customer");
        account3.setRole(new CustomerRole());
        account3.setEmployee(employee3);
        ShippingAddress shippingAddress = account3.getShippingAddressDirectory().createShippingAddress("home", "yafei", "hu", "40 cedar street", "unit 2", "malden", "Massachusetts", "02148", "a");
        ShippingAddress shippingAddress1 = account3.getShippingAddressDirectory().createShippingAddress("home1", "yafei", "hu", "Califonia Civil Lawyer", "unit 2", "Los Angeles", "Califonia", "05421", "a");
        SysCustomerServiceOrganization customerOrganization = new SysCustomerServiceOrganization();
        system.getOrganizationDirectory().getOrganizationList().add(customerOrganization);
        customerOrganization.getEmployeeDirectory().getEmployeeList().add(employee3);
        customerOrganization.getUserAccountDirectory().getUserAccountList().add(account3);
        FinanceAccount f3 = account3.getFinanceAccountDirectory().createFinanceAccount(FinanceAccount.FinanceAccountType.Personal);
        f3.setCardNumber("304390458056321");
        f3.setCardType("debit card");
        f3.setExpiresMonth("09");
        f3.setExpiresYear("18");
        f3.setName("debit card");
        f3.setNameOnCard("YAFEI HU");
        f3.setRemaining(50000);
        f3.setSecurityCode("3");


        Network china = system.createNetwork();
        china.setName("US");

        Enterprise enterprise1 = china.createSupplier("bestbuy");
        ((Supplier) enterprise1).setProfit(0.9f);

        Employee employee4 = new Employee();
        employee4.setName("ShipAdmin");
        UserAccount account4 = new UserAccount();
        account4.setUsername("ship");
        account4.setPassword("ship");
        account4.setRole(new ShipRole());
        account4.setEmployee(employee4);

        Employee employee5 = new Employee();
        employee5.setName("FinanceAdmin");
        UserAccount account5 = new UserAccount();
        account5.setUsername("finance");
        account5.setPassword("finance");
        account5.setRole(new FinanceRole());
        account5.setEmployee(employee5);

        Employee employee7 = new Employee();
        employee7.setName("WarehouseAdmin");
        UserAccount account7 = new UserAccount();
        account7.setUsername("warehouse");
        account7.setPassword("warehouse");
        account7.setRole(new WarehouseRole());
        account7.setEmployee(employee7);

        Employee employee20 = new Employee();
        employee20.setName("WarehouseAdmin");
        UserAccount account20 = new UserAccount();
        account20.setUsername("warehouse1");
        account20.setPassword("warehouse1");
        account20.setRole(new WarehouseRole());
        account20.setEmployee(employee20);

        Employee employee9 = new Employee();
        employee9.setName("customerservice");
        UserAccount account9 = new UserAccount();
        account9.setUsername("customerservice");
        account9.setPassword("customerservice");
        account9.setRole(new CustomerServiceRole());
        account9.setEmployee(employee9);

        Employee employee11 = new Employee();
        employee11.setName("sale");
        UserAccount account11 = new UserAccount();
        account11.setUsername("sale");
        account11.setPassword("sale");
        account11.setRole(new SaleRole());
        account11.setEmployee(employee11);

        Employee employee12 = new Employee();
        employee12.setName("admin");
        UserAccount account12 = new UserAccount();
        account12.setUsername("admin");
        account12.setPassword("admin");
        account12.setRole(new AdminRole());
        account12.setEmployee(employee12);
       

        WarehouseLocation location1 = new WarehouseLocation();
        location1.setExactLocation("new google.maps.LatLng(42.3011, -71.0869)");
        WarehouseOrganization wareOrganization = (WarehouseOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Warehouse);
        wareOrganization.setLocation(location1);
        wareOrganization.setName("boylston");
        wareOrganization.getEmployeeDirectory().add(employee20);
        wareOrganization.getUserAccountDirectory().getUserAccountList().add(account20);
        ProductDirectory productDirectory = wareOrganization.getProductCatalog().create(ProductDirectory.DType.Electronics);
        ProductSubDirectory productSubDirectory = productDirectory.newSubDirectory(ProductSubDirectory.PType.TV);
        Product product = productSubDirectory.create("LG TV", 1000, 3, (Supplier) enterprise1);
        product.setPicture("F:\\A\\5100\\lab\\RELab7Demo\\Hu_Yafei_FinalProject-13\\Hu_Yafei_FinalProject-4\\Hu_Yafei_FinalProject\\src\\1.jpg");
        Product product5 = productSubDirectory.create(" Sony TV", 2000, 6, (Supplier) enterprise1);
        product5.setPicture("F:\\A\\5100\\lab\\RELab7Demo\\Hu_Yafei_FinalProject-13\\Hu_Yafei_FinalProject-4\\Hu_Yafei_FinalProject\\src\\1.jpg");
        ProductDirectory sysProductDirectory = sysWarehouseOrganization.getProductCatalog().create(ProductDirectory.DType.Electronics);
        ProductSubDirectory sysproductSubDirectory = sysProductDirectory.newSubDirectory(ProductSubDirectory.PType.TV);
        sysproductSubDirectory.newProduct(product);
        sysproductSubDirectory.newProduct(product5);

        ProductSubDirectory productSubDirectory4 = productDirectory.newSubDirectory(ProductSubDirectory.PType.CellPhones);
        Product product4 = productSubDirectory4.create("Iphone", 199, 25, (Supplier) enterprise1);
        product4.setPicture("F:\\A\\5100\\lab\\RELab7Demo\\Hu_Yafei_FinalProject-13\\Hu_Yafei_FinalProject-4\\Hu_Yafei_FinalProject\\src\\1.jpg");
        ProductSubDirectory sysproductSubDirectory4 = sysProductDirectory.newSubDirectory(ProductSubDirectory.PType.CellPhones);
        sysproductSubDirectory.newProduct(product4);

        WarehouseLocation location3 = new WarehouseLocation();
        location3.setExactLocation("'198 Massachusetts Ave, Boston, Massachusetts'");
        WarehouseOrganization wareOrganization3 = (WarehouseOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Warehouse);
        wareOrganization3.setLocation(location3);
        wareOrganization3.setName("semphony");
        wareOrganization3.getEmployeeDirectory().add(employee7);
        wareOrganization3.getUserAccountDirectory().getUserAccountList().add(account7);
        ProductDirectory productDirectory3 = wareOrganization3.getProductCatalog().create(ProductDirectory.DType.Electronics);
        ProductSubDirectory productSubDirectory3 = productDirectory3.newSubDirectory(ProductSubDirectory.PType.TV);
        Product product3 = productSubDirectory.findItem(product.getProductId());
        productSubDirectory3.newProduct(product3);
        Product p = sysproductSubDirectory.findItem(product.getProductId());
        p.setAvailable(p.getAvailable() + 3);

        SaleOrganization saleOrganization = (SaleOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Sale);
        saleOrganization.getEmployeeDirectory().getEmployeeList().add(employee11);
        saleOrganization.getUserAccountDirectory().getUserAccountList().add(account11);

        AdminOrganization adminOrganization = (AdminOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
        adminOrganization.getEmployeeDirectory().getEmployeeList().add(employee12);
        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account12);


        ShipOrganization ShipOrganization = (ShipOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Ship);
        ShipOrganization.getEmployeeDirectory().getEmployeeList().add(employee4);
        ShipOrganization.getUserAccountDirectory().getUserAccountList().add(account4);

        CustomerServiceOrganization customerServiceOrganization = (CustomerServiceOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.CustomerService);
        customerServiceOrganization.getEmployeeDirectory().getEmployeeList().add(employee9);
        customerServiceOrganization.getUserAccountDirectory().getUserAccountList().add(account9);


        FinanceOrganization financeOrganization = (FinanceOrganization) enterprise1.getOrganizationDirectory().createOrganization(Organization.Type.Finance);
        financeOrganization.getEmployeeDirectory().getEmployeeList().add(employee5);
        financeOrganization.getUserAccountDirectory().getUserAccountList().add(account5);
        FinanceAccount f2 = financeOrganization.getFinanceAccountDirectory().createFinanceAccount(FinanceAccount.FinanceAccountType.TrasactionAccount);
        f2.setRemaining(2000);
        f2.setName("bestbuy");

        WarehouseLocation location2 = new WarehouseLocation();
        location2.setExactLocation("'43 cedar street,malden'");
        Enterprise enterprise2 = china.createSupplier("sephora");
        ((Supplier) enterprise2).setProfit(0.9f);

        Employee employee13 = new Employee();
        employee13.setName("admin2");
        UserAccount account13 = new UserAccount();
        account13.setUsername("admin2");
        account13.setPassword("admin2");
        account13.setRole(new AdminRole());
        account13.setEmployee(employee13);

        Employee employee15 = new Employee();
        employee15.setName("ShipAdmin");
        UserAccount account15 = new UserAccount();
        account15.setUsername("ship2");
        account15.setPassword("ship2");
        account15.setRole(new ShipRole());
        account15.setEmployee(employee15);

        Employee employee16 = new Employee();
        employee16.setName("FinanceAdmin");
        UserAccount account16 = new UserAccount();
        account16.setUsername("finance2");
        account16.setPassword("finance2");
        account16.setRole(new FinanceRole());
        account16.setEmployee(employee16);

        Employee employee17 = new Employee();
        employee17.setName("WarehouseAdmin");
        UserAccount account17 = new UserAccount();
        account17.setUsername("warehouse2");
        account17.setPassword("warehouse2");
        account17.setRole(new WarehouseRole());
        account17.setEmployee(employee17);

        Employee employee18 = new Employee();
        employee18.setName("customerservice");
        UserAccount account18 = new UserAccount();
        account18.setUsername("customerservice2");
        account18.setPassword("customerservice2");
        account18.setRole(new CustomerServiceRole());
        account18.setEmployee(employee18);

        Employee employee19 = new Employee();
        employee19.setName("sale");
        UserAccount account19 = new UserAccount();
        account19.setUsername("sale2");
        account19.setPassword("sale2");
        account19.setRole(new SaleRole());
        account19.setEmployee(employee19);

        WarehouseOrganization wareOrganization2 = (WarehouseOrganization) enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Warehouse);
        wareOrganization2.setLocation(location2);
        wareOrganization2.setName("ruggles");
        ProductDirectory productDirectory1 = wareOrganization2.getProductCatalog().create(ProductDirectory.DType.Beauty);
        ProductDirectory productDirectory2 = wareOrganization2.getProductCatalog().create(ProductDirectory.DType.Kids);
        ProductSubDirectory productSubDirectory1 = productDirectory1.newSubDirectory(ProductSubDirectory.PType.LuxuryBeauty);
        Product product1 = productSubDirectory1.create("Lancome", 80, 10, (Supplier) enterprise2);
        ProductSubDirectory productSubDirectory2 = productDirectory2.newSubDirectory(ProductSubDirectory.PType.BabyCareBeauty);
        product1.setPicture("F:\\A\\5100\\lab\\RELab7Demo\\Hu_Yafei_FinalProject-13\\Hu_Yafei_FinalProject-4\\Hu_Yafei_FinalProject\\src\\1.jpg");
        Product product2 = productSubDirectory2.create("Beli", 200, 50, (Supplier) enterprise2);
        product2.setPicture("F:\\A\\5100\\lab\\RELab7Demo\\Hu_Yafei_FinalProject-13\\Hu_Yafei_FinalProject-4\\Hu_Yafei_FinalProject\\src\\1.jpg");
        ProductDirectory sysProductDirectory1 = sysWarehouseOrganization.getProductCatalog().create(ProductDirectory.DType.Beauty);
        ProductSubDirectory sysproductSubDirectory1 = sysProductDirectory1.newSubDirectory(ProductSubDirectory.PType.LuxuryBeauty);
        sysproductSubDirectory1.newProduct(product1);
        ProductDirectory sysProductDirectory2 = sysWarehouseOrganization.getProductCatalog().create(ProductDirectory.DType.Kids);
        ProductSubDirectory sysproductSubDirectory2 = sysProductDirectory2.newSubDirectory(ProductSubDirectory.PType.BabyCareBeauty);
        sysproductSubDirectory2.newProduct(product2);
        wareOrganization2.getEmployeeDirectory().getEmployeeList().add(employee17);
        wareOrganization2.getUserAccountDirectory().getUserAccountList().add(account17);

        AdminOrganization adminOrganization1 = (AdminOrganization) enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
        adminOrganization1.getEmployeeDirectory().getEmployeeList().add(employee13);
        adminOrganization1.getUserAccountDirectory().getUserAccountList().add(account13);

        ShipOrganization ShipOrganization1 = (ShipOrganization) enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Ship);
        ShipOrganization1.getEmployeeDirectory().getEmployeeList().add(employee15);
        ShipOrganization1.getUserAccountDirectory().getUserAccountList().add(account15);

        CustomerServiceOrganization customerServiceOrganization1 = (CustomerServiceOrganization) enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.CustomerService);
        customerServiceOrganization1.getEmployeeDirectory().getEmployeeList().add(employee18);
        customerServiceOrganization1.getUserAccountDirectory().getUserAccountList().add(account18);


        FinanceOrganization financeOrganization1 = (FinanceOrganization) enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Finance);
        financeOrganization1.getEmployeeDirectory().getEmployeeList().add(employee16);
        financeOrganization1.getUserAccountDirectory().getUserAccountList().add(account16);
        FinanceAccount f4 = financeOrganization1.getFinanceAccountDirectory().createFinanceAccount(FinanceAccount.FinanceAccountType.TrasactionAccount);
        f4.setRemaining(2000);
        f4.setName("sephora");

        SaleOrganization saleOrganization1 = (SaleOrganization) enterprise2.getOrganizationDirectory().createOrganization(Organization.Type.Sale);
        saleOrganization1.getEmployeeDirectory().getEmployeeList().add(employee19);
        saleOrganization1.getUserAccountDirectory().getUserAccountList().add(account19);

        for (Organization Org : enterprise1.getOrganizationDirectory().getOrganizationList()) {
            System.out.println(Org.getName());
        }

        for (Organization Org : enterprise2.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount u : Org.getUserAccountDirectory().getUserAccountList()) {
                System.out.println("aaaa" + u.getUsername());
                System.out.println("aaaa" + u.getPassword());
            }
        }



        for (Organization systemOrg : system.getOrganizationDirectory().getOrganizationList()) {
            System.out.println(systemOrg.getName());
        }

        return system;
    }
}