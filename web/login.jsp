<%@page import="controller.SessionController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
  SessionController.setCurrent_user(null);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="libs/bootstrap/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container m-3 text-center">
            <c:if test="${param.status == 401}">
                <div class="row mt-3 ml-3">
                    <div class="col-sm-6 offset-sm-4">
                        <div class="alert alert-danger text-center" role="alert">
                            Usuário não autorizado!
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${param.status == 1}">
                <div class="row mt-3 ml-3">
                    <div class="col-sm-6 offset-sm-4">
                        <div class="alert alert-danger text-center" role="alert">
                            Senha ou login inválidos!
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${param.status == 3}">
                <div class="row mt-3 ml-3">
                    <div class="col-sm-6 offset-sm-4">
                        <div class="alert alert-success text-center" role="alert">
                            Usuário cadastrado com sucesso!
                        </div>
                    </div>
                </div>
            </c:if>
            <div id="alerta" class="row mt-3 ml-3" type="hidden">
                <div class="col-sm-6 offset-sm-4">
                    <div id="alerta_text"class="alert alert-danger text-center" role="alert">
                        Preencha todos os Campos!
                    </div>
                </div>
            </div>
            <div class="row ml-sm-3">
                <div class="col-sm-6 offset-sm-4">
                    <div class="card align-self-center">
                        <div class="card-body">
                            <h5 class="card-title">Vagas</h5>
                            <form name="login" method="POST" action="LoginServlet">
                                <div class="row mt-3">
                                    <div class="col-sm-12">
                                        <input id="login" type="text" class="form-control" name="usuario_login" placeholder="Login">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-sm-12">
                                        <input id="senha" type="password" name="usuario_senha" class="form-control" placeholder="Password">
                                    </div>
                                </div>
                            </form>
                            <div class="row mt-3">
                                <div class="col-sm-12">
                                    <button onclick="validar()" class="btn btn-block btn-primary">Entrar</button>
                                </div> 
                            </div>
                            <div class="row mt-3">
                                <div class="col-sm-12">
                                    <a id="listagem" href="listagem.jsp" class="btn btn-block btn-outline-secondary">Buscar Vagas</a>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-sm-12">
                                    <a id="cadastro" href="usuarioIncluir.jsp" class="btn btn-block btn-link">Cadastrar-se</a>
                                </div>
                            </div>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

<script>
    
    listagem = function () {
        window.location = "http://localhost:8084/vagas/listagem.jsp";
    }
    
    cadastro = function () {
        window.location = "http://localhost:8084/vagas/usuarioIncluir.jsp";
    }

    document.getElementById("alerta").style.display = "none";
    validar = function () {
        let login = document.getElementById("login");
        let senha = document.getElementById("senha");

        if ((!!login.value) && (!!senha.value)) {
            document.login.submit();
        } else {
            document.getElementById("alerta").style.display = "none";
            document.getElementById("alerta_text").innerHTML = "Por Favor, preencha todos os campos!";
            document.getElementById("alerta").style.display = "block";
        }
    }
</script>