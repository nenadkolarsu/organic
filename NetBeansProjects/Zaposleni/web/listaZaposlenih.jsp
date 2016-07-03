
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prikaz zaposlenih</title>
 <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <table border=1 class="imagetable">
        <thead>
            <tr>
                <th>Id</th>
                <th>Ime</th>
                <th>Starost</th>
                <th>Adresa</th>
                <th>Zarada</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${zaposleni}" var="zaposlen">
                <tr>
                    <td><c:out value="${zaposlen.id}" /></td>
                    <td><c:out value="${zaposlen.ime}" /></td>
                    <td><c:out value="${zaposlen.starost}" /></td>
                    <td><c:out value="${zaposlen.adresa}" /></td>
                    <td><c:out value="${zaposlen.zarada}" /></td>

                    <td><a href="ZaposleniController?action=edit&Id=<c:out value="${zaposlen.id}"/>">Update</a></td>
                    <td><a href="ZaposleniController?action=delete&Id=<c:out value="${zaposlen.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ZaposleniController?action=insert">Add User</a></p>
</body>
</html>

