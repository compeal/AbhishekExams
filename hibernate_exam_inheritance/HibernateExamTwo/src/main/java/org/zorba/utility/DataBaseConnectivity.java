package org.zorba.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.zorba.entity.GeneralPassenger;
import org.zorba.entity.Passenger;
import org.zorba.entity.PhysicallyHandicapped;
import org.zorba.entity.SeniorCitizen;

public class DataBaseConnectivity{
    public static SessionFactory getSessionFactory(){
        Configuration configuration= new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(GeneralPassenger.class);
        configuration.addAnnotatedClass(SeniorCitizen.class);
        configuration.addAnnotatedClass(PhysicallyHandicapped.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        System.out.println("Session Factory Execution Completed, " +
                "Connection established successfully, all the table created...");
        return sessionFactory;
    }
}

