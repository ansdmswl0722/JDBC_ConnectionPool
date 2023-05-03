<%--
  Created by IntelliJ IDEA.
  User: muneunji
  Date: 2023/05/02
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>예약정보</title>
</head>
<body>
    <h1>예약 정보</h1>
    <table>
        <thead>
        <tr>
            <th>승객No.</th>
            <th>항공편No.</th>
            <th>예약날짜</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${reservationList}">
            <tr>
                <td>${item.passengerNo}</td>
                <td><a href="/flight.do?no=${item.no}">${item.no}</a></td>
                <td>${item.reservedDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
