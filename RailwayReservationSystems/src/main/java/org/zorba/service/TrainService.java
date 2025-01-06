package org.zorba.service;

import org.springframework.stereotype.Service;
import org.zorba.dto.TrainDTO;
import org.zorba.entity.Train;

@Service
public class TrainService {
    public String checkStatus(){ return "Train";}

    public String saveTrainInfo(TrainDTO trainDTO){
        Train train = new Train();
        train.setTrainName(trainDTO.getTrainName());
        train.setNoOfCoaches(trainDTO.getNoOfCoaches());
        train.setStartStation(trainDTO.getStartStation());
        train.setEndStation(trainDTO.getEndStation());
        train.setAverageSpeed(trainDTO.getAverageSpeed());
        train.setTrainType(trainDTO.getTrainType());

        return "success";
    }
}
