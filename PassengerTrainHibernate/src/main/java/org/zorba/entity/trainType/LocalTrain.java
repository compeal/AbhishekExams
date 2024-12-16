package org.zorba.entity.trainType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class LocalTrain extends Train {
    private Integer trainFrequency;


}
