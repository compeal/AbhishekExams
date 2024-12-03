package org.zorba.execution;

import org.apache.poi.hpsf.Decimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.zorba.entity.Product_Type;
import org.zorba.utility.DataBaseConnectivity;

import java.util.List;
import java.util.Scanner;

public class ProductTypeExecution {
    SessionFactory sessionFactory = DataBaseConnectivity.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    Product_Type productType = new Product_Type();
    //System.out.println("Enter Product Type");
    Scanner scanner = new Scanner(System.in);
    List<Product_Type> products = new ArrayList<Product_Type>();
    System.out.println("How many product types you want to enter::")
    int n = scanner.nextInt();
    for(int i=0; i<n; i++){
        System.out.println("Enter the product type name::");
        String product_type = scanner.nextLine();
        productType.setProductType(product_type);
        System.out.println("Enter the product rate::");
        Decimal rate = scanner.nextDecimal();
        productType.setProductRate(rate);
        products.add(productType);
    }
    try {
        tx = session.beginTransaction();
        session.persist(productType);
        tx.commit();
    } catch (Exception e) {
        System.err.println(e.getMessage());
        tx.rollback();
    }
}
