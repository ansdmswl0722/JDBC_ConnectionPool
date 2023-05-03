package com.nhnacademy.edu.jdbc.demo;

import com.nhnacademy.edu.jdbc.DBUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FlightInfo {

    Flight flight;

    public Flight getData(int no) {
        Connection myConnection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            DataSource dataSource = DBUtils.getDatasource();
            myConnection = dataSource.getConnection();
            String sqlQuery = "select * from flight where flightNo = ?";
            statement = myConnection.prepareStatement(sqlQuery);
            statement.setInt(1,no);

            result = statement.executeQuery();

            while(result.next()){
                flight = new Flight(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
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
        return flight;

    }

}
