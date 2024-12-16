package org.zorba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.zorba.entity.trainType.Train;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Passenger {
    @Column(name="passenger_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passengerId;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name ="passenger_email")
    private String passengerEmail;

    @Column(name = "passenger_mobile")
    private Long passengerMobile;

    @Column(name="passenger_destination")
    private String passengerDestination;

    @Column(name="passenger_seat_number")
    private Integer passengerSeatNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="train_id")
    private Train train;

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", passengerName='" + passengerName + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                ", passengerMobile=" + passengerMobile +
                ", passengerDestination='" + passengerDestination + '\'' +
                ", passengerSeatNumber=" + passengerSeatNumber +
                '}';
    }
}
