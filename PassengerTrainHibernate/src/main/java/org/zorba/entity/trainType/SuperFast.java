package org.zorba.entity.trainType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SuperFast extends Train{
    private double specialCharges;
}
