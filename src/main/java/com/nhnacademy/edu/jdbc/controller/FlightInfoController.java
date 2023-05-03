package com.nhnacademy.edu.jdbc.controller;

import com.nhnacademy.edu.jdbc.Command;
import com.nhnacademy.edu.jdbc.annotation.RequestMapping;
import com.nhnacademy.edu.jdbc.demo.Flight;
import com.nhnacademy.edu.jdbc.demo.FlightInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value="/flight.do" ,method = RequestMapping.Method.GET)
public class FlightInfoController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        int no = Integer.parseInt(req.getParameter("no"));
        FlightInfo info = new FlightInfo();
        Flight flight = info.getData(no);
        req.setAttribute("flight",flight);
        return "/flight.jsp";
    }
}
