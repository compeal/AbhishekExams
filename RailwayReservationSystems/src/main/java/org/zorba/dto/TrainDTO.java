package org.zorba.dto;

import lombok.Data;

@Data
public class TrainDTO {
    private String trainName;

    private Integer noOfCoaches;

    private String startStation;

    private String endStation;

    private String trainType;

    private Double averageSpeed;
}
