<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.first.servlet.domain.Client" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Редагування клієнта</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

    <% Client client = (Client) request.getAttribute("client"); %>

    <div class="w3-container w3-blue">
        <a href="/" class="w3-button w3-margin w3-large w3-yellow">Всі клієнти</a>
        <h1>Редагування клієнта <%= client.getFirstName()%> <%= client.getLastName() %></h1>
    </div>

    <br/>

    <div class="w3-container w3-blue w3-padding">
        <form method="post" action="/client_edit">
            <input type="hidden" name="id" value="<%= client.getId()%>">

            <div class="w3-container w3-light-grey w3-margin w3-padding">
                <h3>Ім'я:</h3>
                <input class="w3-input" type="text" name="clientFirstName" value="<%= client.getFirstName()%>">
            </div>

            <div class="w3-container w3-light-grey w3-margin w3-padding">
                <h3>Прізвище:</h3>
                <input class="w3-input" type="text" name="clientLastName" value="<%= client.getLastName()%>">
            </div>

            <div class="w3-container">
                <a href="/client_delete?id=<%=client.getId()%>" class="w3-button w3-red">Видалити</a>

                <input type="submit" href="/client_edit" class="w3-button w3-green w3-right w3-large" value="Зберегти"/>
            </div>
        </form>
    </div>
</body>
</html>
