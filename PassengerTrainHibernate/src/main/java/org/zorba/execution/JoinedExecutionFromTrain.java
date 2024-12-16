package org.zorba.execution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.zorba.utility.DataBaseConnectivity;

public class JoinedExecutionFromTrain {
    public static void main(String[] args){
        SessionFactory sessionFactory= DataBaseConnectivity.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx=null;


    }
}
