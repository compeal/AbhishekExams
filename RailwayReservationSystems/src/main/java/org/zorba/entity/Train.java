package org.zorba.entity;

import lombok.Data;

@Data
public class Train {
    private String trainName;

    private Integer noOfCoaches;

    private String startStation;

    private String endStation;

    private String trainType;

    private Double averageSpeed;
}
