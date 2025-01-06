package org.zorba.service;

import org.springframework.stereotype.Service;
import org.zorba.dto.PassengerDTO;
import org.zorba.entity.Passenger;

@Service
public class PassengerService {
    public String checkStatus(){
        return "Passenger Form";
    }

    public String savePassengerInfo(PassengerDTO passengerDTO) {
        Passenger passenger= new Passenger();
        passenger.setPassName(passengerDTO.getPassName());
        passenger.setEmail(passengerDTO.getEmail());
        passenger.setMobile(passengerDTO.getMobile());
        passenger.setPassengerType(passengerDTO.getPassengerType());

        return "success";
    }
}
