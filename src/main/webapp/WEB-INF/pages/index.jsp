<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>springdemo</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">spring demo</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">All Provinces</a></li>
                    <li><a href="newProvince">New Province</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <c:choose>
                <c:when test="${mode == 'PROVINCE_VIEW'}">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Siglas</th>
                            <th>Nome</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="province" items="${provinces}">
                            <tr>
                                <td>${province.id}</td>
                                <td>${province.initials}</td>
                                <td>${province.name}</td>
                                <td>
                                    <a href="updateProvince?id=${province.id}">Edit</a>
                                    <a href="deleteProvince?id=${province.id}">Delete</a>
                                </td>
                                <td></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:when test="${mode == 'PROVINCE_EDIT' || mode == 'PROVINCE_NEW'}">
                    <form action="save" method="post">
                        <div class="form-group">
                            <label for="initials">Siglas</label>
                            <input type="text" class="form-control" value="${province.initials}" name="initials" id="initials">
                        </div>
                        <div class="form-group">
                            <label for="name">Nome</label>
                            <input type="text" class="form-control" value="${province.name}" name="name" id="name">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>