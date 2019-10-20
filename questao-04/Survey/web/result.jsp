<%-- 
    Document   : result
    Created on : 19/10/2019, 22:20:21
    Author     : Carlos
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da Votação</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="container text-white d-flex justify-content-center">
                <p class="h1">Resultado da Votação</p>
            </div>

            <div class="container d-flex justify-content-center">
                <table class="table text-white">
                    <tr>
                        <th class="text-primary">Disciplina</th>
                        <th class="text-primary">Quantidade de Votos</th>
                        <th class="text-primary">Gráfico</th>
                    </tr>
                    <c:forEach items="${votes}" var="vote">
                        <c:set var="percent" value="${vote.value / totalVotes}" />
                        <tr>
                            <td>${vote.key}</td>
                            <td>${vote.value}</td>
                            <td><meter value="${percent}" min="0" max="1"></meter> <fmt:formatNumber maxFractionDigits="2" type="percent" value="${percent}"/></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th class="text-primary">Quantidade Total de Votos</th>
                        <td colspan="2">${totalVotes}</td>
                    </tr>
                </table>
            </div>

            <div class="container d-flex justify-content-center">
                <a class="btn btn-primary btn-lg" href="index.jsp">Voltar</a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
