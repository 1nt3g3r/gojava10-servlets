<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Цитатник</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>

        <div class="w3-container w3-margin">
            <div class="w3-container w3-padding w3-margin-bottom w3-yellow">
                <form method="get" action="/quote">
                    <div class="w3-container" style="display: inline-block; width: 80%;">
                        <select style="display: inline-block !important;" class="w3-select w3-block" name="lang">
                            <%
                                String currentLanguage = (String) request.getAttribute("language");
                                List<String> languages = (List<String>) request.getAttribute("languages");
                                for(String language: languages) {
                                    if (currentLanguage.equals(language)) {
                                        out.print("<option selected=\"\">");
                                    } else {
                                        out.print("<option>");
                                    }
                                    out.print(language);
                                    out.println("</option>");
                                }
                            %>
                        </select>
                    </div>

                    <input style="display: inline-block !important;" class="w3-button w3-blue" type="submit" value="Вибрати мову">
                </form>
            </div>

            <div class="w3-container w3-blue">
                <h4>Цитата (ви вже подивились: <%= session.getAttribute("viewCount")%> )</h4>
            </div>

            <div class="w3-panel w3-leftbar w3-light-grey">
                <p class="w3-xlarge w3-serif">
                    <i><%= request.getAttribute("quote")%></i></p>
                <p>Someone</p>
            </div>
        </div>

        <div class="w3-container">
            <div class="w3-container w3-red">
                <h5>Додавання нової цитати</h5>
            </div>

            <div class="w3-container w3-gray">
                <form method="post" action="/addQuote">

                    <div class="w3-container w3-margin-top">
                        <select style="display: inline-block !important;" class="w3-select w3-block" name="lang">
                            <%
                                for(String language: languages) {
                                    if (currentLanguage.equals(language)) {
                                        out.print("<option selected=\"\">");
                                    } else {
                                        out.print("<option>");
                                    }
                                    out.print(language);
                                    out.println("</option>");
                                }
                            %>

                        </select>

                        <br/>

                        <input name="customLanguage" placeholder="Введіть іншу мову" class="w3-input"/>
                    </div>

                    <div class="w3-container">
                        <textarea class="w3-input w3-margin-top" name="quoteText" rows="3"></textarea>
                    </div>

                    <div class="w3-container w3-margin-top">
                        <input type="submit" class="w3-button w3-green w3-right w3-margin-bottom" value="Добавить цитату"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
