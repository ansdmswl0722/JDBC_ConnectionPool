package com.nhnacademy.edu.jdbc.controller;

import com.nhnacademy.edu.jdbc.Command;
import com.nhnacademy.edu.jdbc.annotation.RequestMapping;
import com.nhnacademy.edu.jdbc.demo.Passenger;
import com.nhnacademy.edu.jdbc.demo.PassengerList;
import com.nhnacademy.edu.jdbc.demo.Reservation;
import com.nhnacademy.edu.jdbc.demo.ReservationList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/view.do",method = RequestMapping.Method.GET)
public class ReservationViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ReservationList reservationList = new ReservationList();
        int no = Integer.parseInt(req.getParameter("no"));
        List<Reservation> reservations = reservationList.getData(no);
        if(reservations.size()==0){
            req.setAttribute("reservationList",reservations);
            return "/notfound.jsp";
        }
        req.setAttribute("reservationList",reservations);
        return "/view.jsp";
    }
}
