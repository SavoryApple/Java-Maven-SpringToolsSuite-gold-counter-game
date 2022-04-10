    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Ninja Gold</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    </head>
    <body>
    
    <h1>Current Gold: <c:out value="${totalGold}"></c:out></h1>
    <div class="container d-flex flex-row justify-content-around w-100">
    
    <form action="/submitFarmCaveHouse" method="post" class="container col-2 border border-secondary p-3">
    <h2>Farm</h2>
    <h3>(earns 10-20 gold)</h3>
    <input value=1 name="farm" type="hidden"></input>
    <button class="btn btn-primary">Find Gold!</button>
    </form>
    <form action="/submitFarmCaveHouse" method="post" class="container col-2 border border-secondary p-3">
    <h2>Cave</h2>
    <h3>(earns 10-20 gold)</h3>
    <input value=2 name="cave" type="hidden"></input>
    <button class="btn btn-primary">Find Gold!</button>
    </form>
    <form action="/submitFarmCaveHouse" method="post" class="container col-2 border border-secondary p-3">
    <h2>House</h2>
    <h3>(earns 10-20 gold)</h3>
    <input value=3 name="house" type="hidden"></input>
    <button class="btn btn-primary">Find Gold!</button>
    </form>
    <form action="/submitQuest" method="post" class="container col-2 border border-secondary p-3">
    <h2>Quest</h2>
    <h3>(earns/takes 0-50 gold)</h3>
    <button class="btn btn-primary">Find Gold!</button>
    </form>
    
<p><c:out value="${error}"></c:out>
    </div>
    <form action="/reset" method="post" class="container col-2 p-3">
    <button class="btn btn-danger">Reset</button>
    </form>
    <div class="container border border-secondary">
    <h3>Activities:</h3>
    <c:forEach var="oneMessage" items="${displayMessages}">
    
        <p><c:out value="${oneMessage}"></c:out></p>
    
    </c:forEach>
    </div>
       
    </body>
    </html>