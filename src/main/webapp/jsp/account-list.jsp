<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.first.servlet.domain.Client" %>
<%@ page import="com.first.servlet.domain.BankAccount" %>
<%@ page import="java.util.Set" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Рахунки клієнта</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

    <% Client client = (Client) request.getAttribute("client"); %>
    <% Set<BankAccount> accounts = (Set<BankAccount>) request.getAttribute("accounts"); %>


    <div class="w3-container w3-blue">
        <a href="/" class="w3-button w3-margin w3-large w3-yellow">Всі клієнти</a>
        <h1>Рахунки клієнта <%= client.getFirstName()%> <%= client.getLastName()%></h1>
    </div>

    <br/>

    <div class="w3-container">
        <h2>Кількість рахунків: <%= accounts.size() %></h2>
    </div>

    <div class="w3-container w3-blue w3-padding">
        <ul class="w3-ul">
            <%
                for(BankAccount account: accounts) {
                    String listItem = "<li>";
                    listItem += account.getNumber();
                    listItem += ", гроші: " + account.getMoney() + " коп.";
                    listItem += "</li>";

                    out.println(listItem);
                }
            %>
        </ul>
    </div>

    <div class="w3-container w3-margin-top">
        <a href="/client/account_add?clientId=<%=client.getId()%>" class="w3-button w3-green w3-right w3-marin-top">Додати рахунок</a>
    </div>
</body>
</html>
