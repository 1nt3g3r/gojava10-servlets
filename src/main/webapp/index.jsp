<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.first.servlet.domain.Client" %>

<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Клієнти банку</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
<body>
    <div class="w3-container w3-blue w3-margin-bottom">
        <h1>Клієнти</h1>
    </div>

    <div class="w3-container w3-padding">
        <ol class="w3-ul">
            <%
                List<Client> clients = (List<Client>) request.getAttribute("clients");
                for(Client client: clients) {
                    out.print("<li class=\"w3-yellow\">" + client.getFirstName() + " " + client.getLastName() +
                                " <a class=\"w3-button w3-green\" href=\"/client_edit?id=" + client.getId() + "\">Редагувати</a>");
                    out.print(" <a class=\"w3-button w3-blue\" href=\"/client/accounts?clientId=" + client.getId() + "\">Рахунки клієнта</a>");
                    out.println("</li>");
                }
            %>
        </ol>

        <a href="/client_add" class="w3-margin-top w3-button w3-green w3-right">Додати нового клієнта</a>
    </div>
</body>
</html>
