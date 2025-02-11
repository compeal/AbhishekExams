package org.zorba.utility;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.zorba.annotationBased.entity.*;

public class DataBaseConnectivity {
    public static SessionFactory getSessionFactory() {
        //Read the Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


        //Create SessionFactory Object from configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("Session Factory Execution Completed, " +
                "Connection established successfully, all the table created...");
        return sessionFactory;
    }
}
