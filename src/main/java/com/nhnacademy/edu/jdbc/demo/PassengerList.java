package com.nhnacademy.edu.jdbc.demo;

import com.nhnacademy.edu.jdbc.DBUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class PassengerList {
    List<Passenger> passengerList = new ArrayList<>();

    public List<Passenger> getData() {

        Connection myConnection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            DataSource dataSource = DBUtils.getDatasource();
            myConnection = dataSource.getConnection();
            String sqlQuery = "SELECT PassengerNo,PassengerName, Grade ,Age FROM Passenger";
            statement = myConnection.prepareStatement(sqlQuery);
            // statement.setInt(1,2);

            result = statement.executeQuery(sqlQuery);

            while(result.next()){
                this.passengerList.add(new Passenger(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4)));
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
        return passengerList;

    }
}

