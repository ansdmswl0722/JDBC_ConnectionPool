<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>승객리스트</title>
</head>
<body>
    <h1>승객 리스트</h1>
    <table>
        <thead>
        <tr>
            <th>이름</th>
            <th>등급</th>
            <th>나이</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${passengerList}">
            <tr>
                <td><a href="/view.do?no=${item.passengerNo}">${item.name}</a></td>
                <td>${item.grade}</td>
                <td>${item.age}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<br/>
</body>
</html>