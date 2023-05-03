package com.nhnacademy.edu.jdbc.controller;


import com.nhnacademy.edu.jdbc.Command;
import com.nhnacademy.edu.jdbc.annotation.RequestMapping;
import com.nhnacademy.edu.jdbc.demo.Passenger;
import com.nhnacademy.edu.jdbc.demo.PassengerList;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RequestMapping(value = "/index.do",method = RequestMapping.Method.GET)
public class PassengertListController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        PassengerList passengerList = new PassengerList();
        List<Passenger> passengers = passengerList.getData();
//        for(Passenger passenger : passengers) {
//            log.info("passenger:{},{},{}",passenger.getName(),passenger.getAge(),passenger.getGrade());
//        }
        req.setAttribute("passengerList",passengers);
        return "/index.jsp";
    }
}
