package org.zorba.execution;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.zorba.entity.Customer;
import org.zorba.entity.Product_Type;
import org.zorba.utility.DataBaseConnectivity;

import java.math.BigInteger;
import java.util.Scanner;

public class CustomerExecution {
    SessionFactory sessionFactory = DataBaseConnectivity.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Customer customers = new Customer();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Customer Information::")
    System.out.println("Enter Customer Name::")
    String name = scanner.nextLine();
    customers.setCustomerName(name);
    System.out.println("Enter Email::")
    String email = scanner.nextLine();
    customers.setCustomerEmail(email);
    BigInteger mobile = scanner.nextBigInteger();
    if(mobile.length()!=10) {
        throw new MyException("Mobile length has to be of 10");
    }
    customers.setCustomerMobile(mobile);
    System.out.println("select a product Type");
    String fetchProductType ="from Product_Type";
    try {
        Query query = session.createQuery(fetchProductType);
        List<Product_Type> product_types = query.list();
        String selectType= scanner.nextLine();
        String productType= "select product_type_id from Product_Type where product_type = '"+selectType+"'";
        query = session.createQuery(productType);
        Product_Type pr=query.list(query);

        System.out.println("Enter Product Quantity");
        int finalRate=pr.getProductTypeId() * pr.getProductRate();
        customers.setFinalProductPrice(finalRate);
        tx = session.beginTransaction();
        session.persist(customers);
        tx.commit();
    } catch (Exception e) {
        System.err.println(e.getMessage());
        tx.rollback();
    }

}
