package org.zorba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeniorCitizen extends Passenger{
    @Column(name="senior_discount")
    private Integer seniorDiscount;

    @Column(name="senior_citizen_id")
    private Integer seniorCitizenId;

    @Override
    public String toString() {
        return "SeniorCitizen{" +
                "seniorDiscount=" + seniorDiscount +
                ", seniorCitizenId='" + seniorCitizenId + '\'' +
                '}';
    }
}
