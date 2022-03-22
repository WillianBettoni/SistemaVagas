<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar usuário</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="libs/bootstrap/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container-fluid">
            <c:if test="${param.status == 1}">
                <div class="row mt-3">
                    <div class="col-sm-8 offset-sm-2">
                        <div class="alert alert-danger text-center" role="alert">
                            Já existe um usuario com este login!
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${param.status == 2}">
                <div class="row mt-3">
                    <div class="col-sm-8 offset-sm-2">
                        <div class="alert alert-danger text-center" role="alert">
                            Erro ao incluir usuario!
                        </div>
                    </div>
                </div>
            </c:if>
            <div id="alerta" class="row mt-3" type="hidden">
                <div class="col-sm-8 offset-sm-2">
                    <div id="alerta_text"class="alert alert-danger text-center" role="alert">
                        Preencha todos os Campos!
                    </div>
                </div>
            </div>
            <div class="row ml-sm-3">
                <div class="col-sm-12">
                    <div class="card align-self-center mt-3 mr-3">
                        <div class="card-body">
                            <h5 class="card-title">Cadastre seu usuario</h5>
                            <form onsubmit="validar()" id="form" name="cadastro" method="POST" action="CreateUsuarioServlet">
                                <div class="row mt-3">
                                    <div class="col-sm-12 col-md-6">
                                        <input type="text" class="form-control" id="login" name="usuario_login" placeholder="Login">
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <input type="email" class="form-control" id="email" name="usuario_email" placeholder="E-mail"/>
                                    </div>  
                                </div>
                                <div class="row mt-3">
                                    <div class="col-sm-12">
                                        <input type="password" name="usuario_senha" id="senha" class="form-control" placeholder="Senha">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-sm-12">
                                        <input type="password" name="usuario_senha_check" id="check" class="form-control" placeholder="Digite novamente sua senha">
                                    </div>
                                </div>
                            </form>
                            <div class="row mt-3">
                                <div class="col-sm-12 text-right">
                                    <a id="btn_cadastro" href="login.jsp" class="btn btn-md btn-outline-secondary">Voltar</a>
                                    <button id="btn_cadastro" onclick="validar()" class="btn btn-md btn-primary">Cadastrar</button>
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
    document.getElementById("alerta").style.display = "none";
    validar = function () {
        let login = document.getElementById("login");
        let senha = document.getElementById("senha");
        let check = document.getElementById("check");
        let email = document.getElementById("email");

        if ((!!login.value) && (!!senha.value) && (!!check.value) && (!!email.value)) {
            if (senha.value === check.value) {
                if (senha.value.match(/^[0-9]+$/) != null || senha.value.match(/^[a-zA-z]+$/) != null) {
                    document.getElementById("alerta").style.display = "none";
                    document.getElementById("alerta_text").innerHTML = "A sua senha deve conter letras e números! ";
                    document.getElementById("alerta").style.display = "block";
                } else {
                    document.cadastro.submit();
                }
            } else {
                document.getElementById("alerta").style.display = "none";
                document.getElementById("alerta_text").innerHTML = "As senhas não se equivalem!";
                document.getElementById("alerta").style.display = "block";
            }
        } else {
            document.getElementById("alerta").style.display = "none";
            document.getElementById("alerta_text").innerHTML = "Por Favor, preencha todos os campos!";
            document.getElementById("alerta").style.display = "block";
        }
    }
</script>