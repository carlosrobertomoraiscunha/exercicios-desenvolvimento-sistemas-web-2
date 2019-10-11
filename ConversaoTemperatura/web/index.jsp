<%-- 
    Document   : index
    Created on : Oct 5, 2019, 6:39:17 PM
    Author     : Carlos
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="basics.TipoTemperatura"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="basics.Temperatura" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversão Temperatura</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body {
                background-image: url(<c:url value='/images/background.jpg' />);
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                background-attachment: fixed;
            }

            .table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
                background-color: rgba(255, 255, 255, 0.8);
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <c:set var="tempList" value="${tempList}" scope="request" />
            <jsp:scriptlet>
                double tempInp = Double.NaN;

                // Verifica se o valor do input existe no request
                if (request.getParameter("tempInp") != null) {
                    try {
                        // Define o valor da variavel igual ao do atributo
                        tempInp = Double.valueOf(request.getParameter("tempInp"));
                    } catch (Exception e) {
                        tempInp = Double.NaN;
                    }
                }

                // Verifica se a variavel e um numero valido
                if (!Double.isNaN(tempInp)) {
                    // Cria um objeto Temperatura para o valor passado no request
                    Temperatura temp = new Temperatura(tempInp, TipoTemperatura.CELSIUS);
                    request.setAttribute("temp", temp);
                }
            </jsp:scriptlet>

            <c:if test="${tempList == null}">
                <jsp:forward page="TabelaConversao" />
            </c:if>

            <div class="container d-flex justify-content-center">
                <p class="h1 text-white">Conversão Temperatura</p>
            </div>

            <div class="container d-flex flex-column text-white">

                <div class="d-inline-flex justify-content-center">
                    <form method="POST" action="index.jsp" class="form-inline m-3">
                        <div class="form-row align-items-center">
                            <div class="col-auto">
                                <label for="tempInp">Valor de Temperatura (°C): </label>
                            </div>
                            <div class="col-auto">
                                <input class="form-control" autofocus="true" type="number" id="tempInp" name="tempInp" required="true" step="0.1" placeholder="Temperatura em Celsius" />
                            </div>
                            <div class="col-auto">
                                <button type="submit" class="btn btn-primary">Converter para Fahrenheit</button>
                            </div>
                        </div>
                    </form>
                </div>

                <c:if test="${temp != null}">
                    <blockquote class="blockquote text-center">
                        <fmt:formatNumber value="${temp.tempCels}" var="cels" minFractionDigits="1" maxFractionDigits="1" />
                        <fmt:formatNumber value="${temp.tempFahr}" var="fahr" minFractionDigits="1" maxFractionDigits="1" />
                        <h1>A temperatura ${cels} °C equivale a ${fahr} °F.</h1>
                    </blockquote>
                </c:if>

                <div class="table-responsive col-6 mx-auto text-center">
                    <table class="table table-hover table-bordered text-white">
                        <tr class="bg-info">
                            <th scope="col">Celsius</th>
                            <th scope="col">Fahrenheit</th>
                        </tr>

                        <c:forEach items="${tempList}" var="temp">
                            <tr>
                                <td><c:out value="${temp.tempCels}" /></td>
                                <td><c:out value="${temp.tempFahr}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
