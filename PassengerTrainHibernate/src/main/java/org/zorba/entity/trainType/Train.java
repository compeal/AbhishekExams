package org.zorba.entity.trainType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.zorba.entity.Passenger;

import java.util.Set;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Train {
    @Column(name="train_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer trainId;

    private String train_name;

    private String[] trainWeeklyDaysSchedule;

    private String startStation;

    private String endStation;

    private String trainType;

    private Double averageSpeed;

    private Double fareCharges;

    @OneToMany(mappedBy = "passenger_id", cascade = CascadeType.ALL)

    private Set<Train> trains;
}
