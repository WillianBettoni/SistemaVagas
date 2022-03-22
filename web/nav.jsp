<%@page import="controller.SessionController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (SessionController.getCurrent_user() == null && !response.isCommitted()) {
        response.sendRedirect("login.jsp?status=401");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="libs/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <script src="libs/jquery/jquery-3.3.1.min.js"></script>
        <script src="libs/bootstrap/js/bootstrap.min.js"></script>
        <nav class="navbar navbar-collapse navbar-dark bg-dark">
            <a class="navbar-brand"><h3 class="text-white">Vagas</h3></a>
            <li class="nav-item text-right">
                <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item text-right">
                <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item text-right">
                <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item text-right">
                <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item text-right">
                <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item text-right">
                <% if (SessionController.getCurrent_user() != null) { %>
                    <% if (SessionController.getCurrent_user().getUsuario_perfil() == 1) { %>
                        <a class="nav-link text-white" href="vagaIncluir.jsp">Nova Vaga</a>
                    <%} else {%>
                         <a class="nav-link" href="#"></a>
                    <%}%>
                <%} else {%>
                    <a class="nav-link" href="#"></a>
                <%}%>
            </li>
            <li class="nav-item">
                <% if (SessionController.getCurrent_user().getUsuario_perfil() > 0) { %>
                    <a class="nav-link text-white" href="listagem.jsp">Listagem</a>
                <%}%>
            </li>
            <li class="nav-item dropdown mr-5" >
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <% if (SessionController.getCurrent_user() != null) {
                        out.print(SessionController.getCurrent_user().getUsuario_login());
                    }%>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <% if (SessionController.getCurrent_user().getUsuario_perfil() == 2) { %>
                            <button onclick="perfil()" class="dropdown-item" type="button">Perfil</button>
                        <%}%>
                        <button onclick="logout()" class="dropdown-item" type="button">Sair</button>
                    </div>
                </div>
            </li>
        </nav>
    </body>
</html>

<script>
    perfil = function () {
        window.location = 'http://localhost:8080/vagas/usuarioDetalhes.jsp';
    }
    
    logout = function () {
        window.location = 'http://localhost:8080/vagas/login.jsp';
    }

</script>

