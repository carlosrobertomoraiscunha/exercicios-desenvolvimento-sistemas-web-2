<%-- 
    Document   : index
    Created on : 19/10/2019, 21:41:49
    Author     : Carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enquete</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="container text-white d-flex justify-content-center">
                <p class="h1">Enquete</p>
            </div>

            <div class="container text-white d-flex justify-content-center">
                <form method="POST" class="w-100" action="VoteCounting">
                    <div class="form-row justify-content-center">
                        <div class="form-group col-md-6">
                            <label for="disciplineInput">Escolha um disciplina</label>
                            <select class="custom-select" id="disciplineInput" name="votedDiscipline">
                                <option hidden disabled selected value> -- Selecione uma Disciplina -- </option>
                                <c:forEach items="${initParam.disciplines}" var="discipline">
                                    <option value="${discipline}"><c:out value="${discipline}" /></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group align-self-end">
                            <button type="submit" class="btn btn-primary">Votar</button>
                            <a class="btn btn-primary" href="result.jsp">Ver Resultado Parcial</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
