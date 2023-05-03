<%--
  Created by IntelliJ IDEA.
  User: muneunji
  Date: 2023/05/03
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>편명정보</title>
</head>
<body>
    <h1>항공편명 정보</h1>
    <table>
        <tr>
            <th>항공편No.</th>
            <td>${flight.flightNo}</td>
        </tr>
        <tr>
            <th>비행기No.</th>
            <td>${flight.aircraftNo}</td>
        </tr>
        <tr>
            <th>출발</th>
            <td>${flight.departures}</td>
        </tr>
        <tr>
            <th>도착</th>
            <td>${flight.arrival}</td>
        </tr>
        <tr>
            <th>가격</th>
            <td>${flight.price}</td>
        </tr>
        <tr>
            <th>출발시각</th>
            <td>${flight.flightDate}</td>
        </tr>

    </table>
</body>
</html>
