<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Вхід в систему</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>

        <div class="w3-container w3-margin">

        <div class="w3-container">
            <div class="w3-container w3-red">
                <h5>Логін</h5>
            </div>

            <div class="w3-container w3-gray">
                <form method="post" action="/login">

                    <div class="w3-container w3-margin-top">
                        <input class="w3-input w3-block" name="login" placeholder="Введіть логін">
                    </div>

                    <div class="w3-container w3-margin-top">
                        <input class="w3-input w3-block" name="password" type="password" placeholder="Введіть пароль">
                    </div>

                    <div class="w3-container w3-margin-top">
                        <input type="submit" class="w3-button w3-green w3-right w3-margin-bottom" value="Ввійти"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
