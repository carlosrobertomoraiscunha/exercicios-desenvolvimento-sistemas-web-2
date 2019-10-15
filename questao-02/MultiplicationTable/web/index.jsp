<%-- 
    Document   : index
    Created on : 13/10/2019, 15:38:49
    Author     : Carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mine" uri="MyTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabuada</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/style.css" />
    </head>
    <body>
        <div class="container-fluid">
            <c:if test="${integerNumbers != null}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert" id="integerNumbers">
                    O valor inicial e final devem ser números inteiros.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <div class="alert alert-warning alert-dismissible fade show" role="alert" id="startGreaterThanEnd">
                O número inicial da tabauda não pode ser maior que o final.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="container">
                <div class="container-fluid text-center">
                    <p class="h1 text-white">Tabuada</p>
                </div>
            </div>

            <div class="container">
                <form method="POST" action="GenerateTable" id="formMultiplication">
                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <label class="text-white" for="start">Início da Tabuada</label>
                            <input type="number" class="form-control" name="start" id="start" placeholder="Insira o início da tabuada" required="true">
                        </div>
                        <div class="form-group col-md-5">
                            <label class="text-white" for="end">Final da Tabuada</label>
                            <input type="number" class="form-control" name="end" id="end" placeholder="Insira o final da tabuada" required="true">
                        </div>
                        <div class="form-group col-md-2 align-self-end">
                            <button type="submit" class="btn btn-primary">Gerar Tabuada</button>
                        </div>
                    </div>
                </form>
            </div>

            <c:if test="${multiplicationTable != null}">
                <div class="container">
                    <table class="table table-responsive text-white">
                        <tr>
                            <th class="text-primary">#</th>
                                <mine:simpleFor start="${start}" end="${end}" var="item">
                                <th class="text-primary"><c:out value="${item}" /></th>
                                </mine:simpleFor>
                            <th class="text-primary">#</th>
                        </tr>
                        <c:set var="count" value="${start}" />
                        <c:forEach items="${multiplicationTable}" var="items">
                            <tr>
                                <th class="text-primary" scope="row"><c:out value="${count}" /></th>

                                <c:forEach items="${items}" var="item">
                                    <td><c:out value="${item}" /></td>
                                </c:forEach>
                                <th class="text-primary" scope="row"><c:out value="${count}" /></th>
                                    <c:set var="count" value="${count+1}" />
                            </tr>
                        </c:forEach>
                        <tr>
                            <th class="text-primary">#</th>
                                <mine:simpleFor start="${start}" end="${end}" var="item">
                                <th class="text-primary"><c:out value="${item}" /></th>
                                </mine:simpleFor>
                            <th class="text-primary">#</th>
                        </tr>
                    </table>
                </div>
            </c:if>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="scripts/script.js"></script>
    </body>
</html>
