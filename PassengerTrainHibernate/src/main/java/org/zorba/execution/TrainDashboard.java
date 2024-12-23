package org.zorba.execution;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zorba.entity.trainType.*;
import org.zorba.utility.DataBaseConnectivity;

import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class TrainDashboard {
    public static void main(String[] args) {
        Train train = new Train();
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory= DataBaseConnectivity.getSessionFactory();
        Session session = sessionFactory.openSession();

       /* I. Fetch all the train details based on the weekly schedule. (For ex. If
        we select Sunday, then all the train running on Sunday should be visible to
        dashboard)*/
        System.out.println("Enter a day to see what trains are available that day");
        String day = scanner.next();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();


        CriteriaQuery<Train> userCriteriaQuery = criteriaBuilder.createQuery(Train.class);
        //Root Of the Query
        Root<Train> fromTrain = userCriteriaQuery.from(Train.class);
        //Select clause
        userCriteriaQuery.select(fromTrain)
                .where(criteriaBuilder.like(fromTrain.get("trainWeeklyDaysSchedule"), day));

        Query query1 = session.createQuery(userCriteriaQuery);
        List<Train> trainList = query1.list();
        System.out.println("The list of trains running on "+day::);
        System.out.println(trainList);
       /* II. Fetch all the train details of Local train for a specific start station.
        (For ex. Start station is ‘ABC’ then all the Local train starting from that station
        would be listed)
        */
        System.out.println(
                "Enter a start station for a local train"
        );
        String start_station = scanner.next();
        String selectQuery = "from Train";
        List<Train> trainList1 = session.createQuery(selectQuery).getResultList();
        for (Train local: trainList1) {
            if (local instanceof LocalTrain) {
                LocalTrain localTrain = (LocalTrain) local;
            }
        }
        CriteriaQuery<LocalTrain> userCriteriaQueryLocal = criteriaBuilder.createQuery(LocalTrainTrain.class);
        //Root Of the Query
        Root<LocalTrain> fromLocalTrain = userCriteriaQuery.from(LocalTrainTrain.class);
        //Select clause
        userCriteriaQueryLocal.select(fromLocalTrain)
                .where(criteriaBuilder.like(fromLocalTrainTrain.get("startStation"), start_station));

        query1 = session.createQuery(userCriteriaQuery);
        List<Train> trainListLocal = query1.list();
        System.out.println("Local trains starting at station "+ start_station+" are::");
        System.out.println(trainListLocal);



        /*III. Fetch all the Goods train based fare charges.*/

        CriteriaQuery<GoodsTrain> userCriteriaQueryGoods = criteriaBuilder.createQuery(GoodsTrain.class);
        //Root Of the Query
        Root<GoodsTrain> fromGoodsTrain = userCriteriaQuery.from(GoodsTrain.class);
        //Select clause
        userCriteriaQueryLocal.select(fromLocalTrain)
                .where(criteriaBuilder.like(fromGoodsTrain.get("startStation"), fareCharger));

        query1 = session.createQuery(userCriteriaQuery);
        List<GoodsTrain> trainListGoods = query1.list();


        /*Iv. Fetch train details based on the selected type (for ex. If train_type
        selected Local then all local train, if select super fast then all the super fast
        train should be listed)
         */

        System.out.println("Select a train_type::");
        System.out.println("1. Local Train::");
        System.out.println("2. Goods Train::");
        System.out.println("3. Inter City::");
        System.out.println("4. Super Fast::");
        int train_type= scanner.nextInt();
        //String trainType=null;
        selectQuery = "from Train";
        List<Train> trainList2 = session.createQuery(selectQuery).getResultList();
        for (Train train1: trainList1) {
            if (train1 instanceof LocalTrain) {
                LocalTrain localTrain1 = (LocalTrain) local;
            }
            if (train1 instanceof GoodsTrain) {
                GoodsTrain goodsTrain = (GoodsTrain) local;
            }
            if (train1 instanceof InterCityTrain) {
                InterCityTrain interCityTrain = (InterCityTrain) local;
            }
            if (train1 instanceof SuperFast) {
                SuperFast superFast = (SuperFast) local;
            }
        }
        switch(train_type){
            case 1:
                System.out.println(localTrain1);
                break;
            case 2:
                System.out.println(goodsTrain);
                break;
            case 3:
                System.out.println(interCityTrain);
                break;
            case 4:
                System.out.println(superFast);
                break;


        }

        v. Fetch all the Super fast train based on the schedule date and avg.




    }
}
