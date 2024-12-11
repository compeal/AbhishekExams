package org.zorba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GeneralPassenger extends Passenger{
    @Column(name="coach_type")
    private Integer coachType;

    @Override
    public String toString() {
        return "GeneralPassenger{" +
                "coachType=" + coachType +
                '}';
    }
}
