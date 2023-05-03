package com.nhnacademy.edu.jdbc.demo;

import com.nhnacademy.edu.jdbc.DBUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservationList {
    List<Reservation> reservationList = new ArrayList<>();

    public List<Reservation> getData(int no) {
        Connection myConnection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            DataSource dataSource = DBUtils.getDatasource();
            myConnection = dataSource.getConnection();
            String sqlQuery = "select passengerNo, flightNo, reservedDate from reservation " +
                            "where passengerNo = ?";
            statement = myConnection.prepareStatement(sqlQuery);
             statement.setInt(1,no);

            result = statement.executeQuery();

            while(result.next()){
                this.reservationList.add(new Reservation(result.getInt(1),
                        result.getInt(2),
                        result.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally{
            try{
                result.close();
                statement.close();
                myConnection.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return reservationList;

    }
}
