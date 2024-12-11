package org.zorba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PhysicallyHandicapped extends Passenger{
    @Column(name="proof_of_disability")
    private String proofOfDisability;

    @Override
    public String toString() {
        return "PhysicallyHandicapped{" +
                "proofOfDisability='" + proofOfDisability + '\'' +
                '}';
    }
}
