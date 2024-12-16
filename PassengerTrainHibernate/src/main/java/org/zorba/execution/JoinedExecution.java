package org.zorba.execution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.zorba.entity.GeneralPassenger;
import org.zorba.entity.Passenger;
import org.zorba.entity.PhysicallyHandicapped;
import org.zorba.entity.SeniorCitizen;
import org.zorba.utility.DataBaseConnectivity;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoinedExecution {
    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory= DataBaseConnectivity.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx=null;

        GeneralPassenger generalPassenger=new GeneralPassenger();
        generalPassenger.setPassengerName("Bibash Srestha");
        generalPassenger.setPassengerEmail("bibash@gmail.com");
        generalPassenger.setPassengerMobile(5084417235L);
        generalPassenger.setPassengerDestination("NYC");
        generalPassenger.setPassengerSeatNumber(35);
        generalPassenger.setCoachType(2);

        SeniorCitizen seniorCitizen=new SeniorCitizen();
        seniorCitizen.setPassengerName("Opal Shrestha");
        seniorCitizen.setPassengerEmail("opal@gmail.com");
        seniorCitizen.setPassengerMobile(5084417235L);
        seniorCitizen.setPassengerDestination("Nepal");
        seniorCitizen.setPassengerSeatNumber(39);
        seniorCitizen.setSeniorDiscount(15);
        seniorCitizen.setSeniorCitizenId(1);

        PhysicallyHandicapped physicallyHandicapped=new PhysicallyHandicapped();
        physicallyHandicapped.setPassengerName("Shreejana Ranabhat");
        physicallyHandicapped.setPassengerEmail("shreejana@gmail.com");
        physicallyHandicapped.setPassengerMobile(5084417235L);
        physicallyHandicapped.setPassengerDestination("NH");
        physicallyHandicapped.setPassengerSeatNumber(12);
        physicallyHandicapped.setProofOfDisability("dfkjs%sdf");
        List<GeneralPassenger> generalPassengerList = new ArrayList<GeneralPassenger>();
        List<SeniorCitizen> seniorCitizenList = new ArrayList<>();
        List<PhysicallyHandicapped> physicallyHandicappedList = new ArrayList<>();
        System.out.println("Select the passenger type to enter:");
        System.out.println("1. General Passenger");
        System.out.println("2. Senior Citizen");
        System.out.println("3. Physically Handicapped");
        Scanner scanner = new Scanner(System.in);

        int passenger_type= scanner.nextInt();
        System.out.println("Enter Train Details::");
        System.out.println("Select the passenger type to enter:");
        System.out.println("1. Local Train");
        System.out.println("2. Senior Citizen");
        System.out.println("3. Physically Handicapped");


        switch(passenger_type){
            case 1:
                GeneralPassenger generalPassenger1= new GeneralPassenger();
                System.out.println("Enter the number of  General Passengers you want to enter, Minimun 3 at a time");
                int number= scanner.nextInt();
                if(number<3){
                    throw new InvalidNumber("Minimum passenger number has to be 3");
                }
                for(int i=0;i<number;i++){
                    System.out.println("Enter information for general passenger number "+(i+1));
                    System.out.println("Enter passenger Name::");
                    generalPassenger1.setPassengerName(scanner.next());
                    System.out.println("Enter passenger Email::");
                    generalPassenger1.setPassengerEmail(scanner.next());
                    System.out.println("Enter passenger Mobile::");
                    generalPassenger1.setPassengerMobile(scanner.nextLong());
                    System.out.println("Enter passenger Destination::");
                    generalPassenger1.setPassengerDestination(scanner.next());
                    System.out.println("Enter passenger Seat Number::");
                    generalPassenger1.setPassengerSeatNumber(scanner.nextInt());
                    System.out.println("Enter Coach Type::");
                    generalPassenger1.setCoachType(scanner.nextInt());
//                    System.out.println("Enter passenger Train ID::");
//                    generalPassenger1.setTrain(scanner.nextInt());
                    generalPassengerList.add(generalPassenger1);
                    generalPassenger1=new GeneralPassenger();
                }
                break;
            case 2:
                SeniorCitizen seniorCitizen1= new SeniorCitizen();
                System.out.println("Enter the number of Senior Citizens you want to enter, Minimun 3 at a time");
                number= scanner.nextInt();
                if(number<3){
                    throw new InvalidNumber("Minimum passenger number has to be 3");
                }
                for(int i=0;i<number;i++) {
                    System.out.println("Enter information for senior citizen number "+(i+1));
                    System.out.println("Enter passenger Name::");
                    seniorCitizen1.setPassengerName(scanner.next());
                    System.out.println("Enter passenger Email::");
                    seniorCitizen1.setPassengerEmail(scanner.next());
                    System.out.println("Enter passenger Mobile::");
                    seniorCitizen1.setPassengerMobile(scanner.nextLong());
                    System.out.println("Enter passenger Destination::");
                    seniorCitizen1.setPassengerDestination(scanner.next());
                    System.out.println("Enter passenger Seat Number::");
                    seniorCitizen1.setPassengerSeatNumber(scanner.nextInt());
                    System.out.println("Enter  Senior Citizen Discount::");
                    seniorCitizen1.setSeniorDiscount(scanner.nextInt());
                    System.out.println("Enter Senior Citizen Id::");
                    seniorCitizen1.setSeniorCitizenId(scanner.nextInt());
                    seniorCitizenList.add(seniorCitizen1);
                    seniorCitizen1=new SeniorCitizen();
                }
                break;
            case 3:
                PhysicallyHandicapped physicallyHandicapped1= new PhysicallyHandicapped();
                System.out.println("Enter the number of Physically Handicapped Passengers you want to enter, Minimun 3 at a time");
                number= scanner.nextInt();
                if(number<3){
                    throw new InvalidNumber("Minimum passenger number has to be 3");
                }
                for(int i=0;i<number;i++) {
                    System.out.println("Enter information for physically handicapped passenger number "+(i+1));
                    System.out.println("Enter passenger Name::");
                    physicallyHandicapped1.setPassengerName(scanner.next());
                    System.out.println("Enter passenger Email::");
                    physicallyHandicapped1.setPassengerEmail(scanner.next());
                    System.out.println("Enter passenger Mobile::");
                    physicallyHandicapped1.setPassengerMobile(scanner.nextLong());
                    System.out.println("Enter passenger Destination::");
                    physicallyHandicapped1.setPassengerDestination(scanner.next());
                    System.out.println("Enter passenger Seat Number::");
                    physicallyHandicapped1.setPassengerSeatNumber(scanner.nextInt());
                    System.out.println("Enter Proof of Disability::");
                    physicallyHandicapped1.setProofOfDisability(scanner.next());
                    physicallyHandicappedList.add(physicallyHandicapped1);
                    physicallyHandicapped1=new PhysicallyHandicapped();
                }
                break;

            default:
                throw new InvalidNumber("You have to select the right passenger type from 1, 2, 3");

        }


        try{
            tx=session.beginTransaction();

            if(!generalPassengerList.isEmpty()) {
                for(GeneralPassenger genPassenger:generalPassengerList)
                    session.persist(genPassenger);
            }
            if(!seniorCitizenList.isEmpty()) {
                for(SeniorCitizen senior:seniorCitizenList )
                session.persist(senior);
            }
            if(!physicallyHandicappedList.isEmpty()) {
                for(PhysicallyHandicapped ph:physicallyHandicappedList)
                  session.persist(ph);
            }

//            for(GeneralPassenger passenger: generalPassengerList){
//                session.persist(passenger);
//            }
            tx.commit();
        }catch(Exception e){
            System.err.println(e.getMessage());
            tx.rollback();
        }


        String query = "from Passenger";
        List<Passenger> passengerList1= session.createQuery(query).getResultList();
        for(Passenger pass: passengerList1){
//            if(pass instanceof GeneralPassenger){
//                GeneralPassenger fetchGeneral= (GeneralPassenger) pass;
//                System.out.println(fetchGeneral.getPassengerId());
//                System.out.println(fetchGeneral.getPassengerName());
//                System.out.println(fetchGeneral.getPassengerEmail());
//                System.out.println(fetchGeneral.getPassengerMobile());
//                System.out.println(fetchGeneral.getPassengerSeatNumber());
//                System.out.println(fetchGeneral.getPassengerDestination());
//            }
//            if(pass instanceof SeniorCitizen){
//                SeniorCitizen fetchSenior= (SeniorCitizen) pass;
//                System.out.println(fetchSenior.getPassengerId());
//                System.out.println(fetchSenior.getPassengerName());
//                System.out.println(fetchSenior.getPassengerEmail());
//                System.out.println(fetchSenior.getPassengerMobile());
//                System.out.println(fetchSenior.getPassengerSeatNumber());
//                System.out.println(fetchSenior.getPassengerDestination());
//                System.out.println(fetchSenior.getSeniorCitizenId());
//                System.out.println(fetchSenior.getSeniorDiscount());
//            }

            if(pass instanceof PhysicallyHandicapped) {
                PhysicallyHandicapped fetchHandicapped = (PhysicallyHandicapped) pass;

                System.out.println(fetchHandicapped.getPassengerId());
                System.out.println(fetchHandicapped.getPassengerName());
                System.out.println(fetchHandicapped.getPassengerEmail());
                System.out.println(fetchHandicapped.getPassengerMobile());
                System.out.println(fetchHandicapped.getPassengerSeatNumber());
                System.out.println(fetchHandicapped.getPassengerDestination());
                System.out.println(fetchHandicapped.getProofOfDisability());
            }
            else{
                continue;
            }
        }

    }

    static class InvalidNumber extends Exception{
        InvalidNumber(String message){
            super(message);
        }

    }
}
