<%@page import="dao.UsuarioDetalhesDAO"%>
<%@page import="model.UsuarioDetalhes"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="model.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario user = SessionController.getCurrent_user();
    UsuarioDetalhes userDetalhes = new UsuarioDetalhes();
    UsuarioDetalhesDAO userDetalhesDAO = new UsuarioDetalhesDAO();
    userDetalhes = userDetalhesDAO.readUsuarioDetalhes(user.getUsuario_id());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Vagas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="libs/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <div class="container-fluid">
            <div class="row ml-sm-3 mt-2">
                <div class="col-sm-12">
                    <div class="card align-self-center mt-3 mr-3">
                        <div class="card-body mb-3 ml-3 mr-3">
                            <h3 class="card-title">Perfil</h3>
                        </div>
                        <div class="col-sm-6">
                            <div class="text-center">
                                <div class="container">
                                    <h1 class="h3 mb-3 font-weight-normal">Imagem do perfil</h1>
                                    <hr>

                                    <%
                                        if (userDetalhes == null) {
                                    %>
                                    <label>Complete seus dados pessoais para inserir a imagem do perfil.</label>
                                    <%
                                    } else if (userDetalhes != null) {
                                        if (userDetalhes.getFoto() == null) {
                                    %>
                                    <label style="font-size: small">*Selecione uma imagem com tamanho máximo de 1536kB</label>
                                    <%
                                    } else {
                                    %>
                                    <img src="CarregarImagem" style="border-radius: 50%; width: 40%; height: auto" /><br>
                                    <a href="RemoverImagem" class="buttonDelete">Remover</a>
                                    <%
                                        }
                                    %>
                                    <div class="container">
                                        <form action="UploadImagem" enctype="multipart/form-data" method = "post">
                                            <input type="file" name="imagem" accept=".png, .jpg, .jpeg"/>
                                            <button type="submit" class="btn btn-primary" style="width: auto" >Upload</button>
                                            <p style="font-size: smaller">${retorno}</p>
                                        </form>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>

                        <form id="cadastro" name="cadastro" method="POST" action="CreateUsuarioDetalhesServlet">
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="nome">Nome *</label>
                                    <input type="text" class="form-control" id="nome" value="<% if (userDetalhes != null) {
                                            out.print(userDetalhes.getNome());
                                        } %>" name="nome" placeholder="Nome" required/>
                                </div>
                                <div class="col-sm-12 col-md-6">
                                    <label for="email">E-mail *</label>
                                    <input type="email" class="form-control" id="email" value="<% if (userDetalhes != null) {
                                            out.print(userDetalhes.getEmail());
                                        } %>" name="email" placeholder="E-mail" required/>
                                </div>    
                            </div>
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="sexo">Sexo</label>
                                    <select class="form-control" name="sexo" required/>
                                    <%if (userDetalhes != null) {%>
                                    <%if (userDetalhes.getSexo().equals("Masculino")) {%>
                                    <option value="Masculino" selected>Masculino</option>
                                    <%} else {%>
                                    <option value="Masculino" >Masculino</option>
                                    <%}%>
                                    <%if (userDetalhes.getSexo().equals("Feminino")) {%>
                                    <option value="Feminino" selected>Feminino</option>
                                    <%} else {%>
                                    <option value="Feminino" >Feminino</option>
                                    <%}%>
                                    <%if (userDetalhes.getSexo().equals("Nao Esp.")) {%>
                                    <option value="Nao Esp." selected>Não Específicado</option>
                                    <%} else {%>
                                    <option value="Nao Esp." >Não Específicado</option>
                                    <%}%>
                                    <%} else { %>
                                    <option value="Masculino" >Masculino</option>
                                    <option value="Feminino" >Feminino</option>
                                    <option value="Nao Esp." >Não Específicado</option>
                                    <%}%>
                                    </select>
                                </div>  
                                <div class="col-sm-12 col-md-6">
                                    <label for="dataNascimento">Data Nascimento *</label>
                                    <input type="date" class="form-control" id="datanascimento" value="<% if (userDetalhes != null) {
                                            out.print(userDetalhes.getDataNascimento());
                                        } %>" name="datanascimento" placeholder="Data Nascimento" required/>
                                </div>     
                            </div>    
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-12">
                                    <label for="curriculo">Curriculo Resumido *</label>
                                    <input type="text" class="form-control" id="curriculo" value="<% if (userDetalhes != null) {
                                            out.print(userDetalhes.getCurriculoResumido());
                                        } %>" name="curriculo" placeholder="Currículo" required/>
                                </div>
                            </div>
                            <div class="row mt-3 mb-3 mr-3">
                                <div class="col-sm-12 text-right">
                                    <a id="btn_cadastro" href="homepage.jsp" class="btn btn-md btn-outline-secondary">Voltar</a>
                                    <%if (userDetalhes != null) {%>
                                    <button id="btn_cadastro" onclick="cadastrar()" class="btn btn-md btn-primary">Alterar</button>
                                    <%} else {%>
                                    <button id="btn_cadastro" onclick="cadastrar()" class="btn btn-md btn-primary">Cadastrar</button>
                                    <%}%>
                                </div> 
                            </div>   
                        </form>  
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>