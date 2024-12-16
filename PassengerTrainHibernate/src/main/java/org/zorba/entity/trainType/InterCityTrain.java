package org.zorba.entity.trainType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InterCityTrain extends Train{

    private Integer numberOfCities;
}
