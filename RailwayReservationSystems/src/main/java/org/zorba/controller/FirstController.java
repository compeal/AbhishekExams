package org.zorba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zorba.dto.PassengerDTO;
import org.zorba.dto.TrainDTO;
import org.zorba.service.PassengerService;
import org.zorba.service.TrainService;


@RestController
@RequestMapping("/sampleFirst")
public class FirstController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TrainService trainService;

    @PostMapping("/savePassengerInfo")
    public ModelAndView saveUserInfo(@ModelAttribute PassengerDTO passengerDto) {
        System.out.println("UserInfo Object : "+passengerDto);
        String msg = this.passengerService.savePassengerInfo(passengerDto);
        String viewName = "";
        if (msg.equalsIgnoreCase("success")) {
            viewName = "success"; // this is view / jsp file name
        } else {
            viewName = "passengerForm"; // this is also view / jsp file name
        }
        ModelAndView modelAndView = new ModelAndView(viewName);
        return modelAndView;
    }

    @PostMapping("/saveTrainInfo")
    public ModelAndView saveUserInfo(@ModelAttribute TrainDTO trainDTO) {
        System.out.println("UserInfo Object : "+trainDTO);
        String msg = this.trainService.saveTrainInfo(trainDTO);
        String viewName = "";
        if (msg.equalsIgnoreCase("success")) {
            viewName = "success"; // this is view / jsp file name
        } else {
            viewName = "trainForm"; // this is also view / jsp file name
        }
        ModelAndView modelAndView = new ModelAndView(viewName);
        return modelAndView;
    }
}
