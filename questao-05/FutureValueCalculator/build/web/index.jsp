<%-- 
    Document   : index
    Created on : 31/10/2019, 21:11:45
    Author     : Carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valor Futuro</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/style.css">
    </head>
    <body>
        <div class="container-fluid">
            <c:if test="${error != null}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    ${error}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <div class="container text-center">
                <p class="h1 text-white">Cálculo do Valor Futuro</p>
            </div>

            <div class="container">
                <form method="POST" action="GenerateTableFutureValue">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="text-white" for="investmentAmount">Montante Inicial (R$)</label>
                            <input type="number" min="0" step="0.01" class="form-control" name="investmentAmount" id="investmentAmount" placeholder="Insira o montante incial (R$)" required="true">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="text-white" for="interestRate">Taxa de Juros Mensal</label>
                            <input type="number" step="0.001" min="0" max="1" class="form-control" name="interestRate" id="interestRate" placeholder="Insira a taxa de juros mensal" required="true">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="text-white" for="numberMonths">Tempo do Investimento (Meses)</label>
                            <input type="number" min="0" class="form-control" name="numberMonths" id="numberMonths" placeholder="Insira o tempo do investimento (meses)" required="true">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="text-white" for="contributions">Valor do Aporte (R$)</label>
                            <input type="number" step="0.01" min="0" class="form-control" name="contributions" id="contributions" placeholder="Insira o valor do aporte (R$)" required="true">
                        </div>
                    </div>
                    <div class="form-row justify-content-center">
                        <button type="submit" class="btn btn-primary">Calcular Valor Futuro</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
