<%@page import="dao.CandidaturaDAO"%>
<%@page import="model.Candidatura"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controller.VagaController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Vagas"%>
<%@page import="model.Usuario"%>
<%@page import="controller.UsuarioController"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario user = SessionController.getCurrent_user();
    Usuario userAnonimo = null;
    if (SessionController.getCurrent_user() == null) {
        userAnonimo = new Usuario(0, "Anonimo", "Anonimo", "Anonimo", 0);
        user = userAnonimo;
        SessionController.setCurrent_user(userAnonimo);
    }
    VagaController ctrl = new VagaController();
    List<Vagas> vagas = new ArrayList<Vagas>();
    vagas = ctrl.consultarVagas();

    CandidaturaDAO candDAO = new CandidaturaDAO();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Listagem</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="libs/bootstrap/css/bootstrap.min.css" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="script.js"></script> 
    </head>
    <body>
        <%@include file="nav.jsp"%>        
        <div class="row ml-sm-3">
            <div class="col-sm-12">
                <div class="card align-self-center mt-3 mr-3">
                    <div class="card-body">
                        <h5 class="card-title">Vagas</h5>
                        <div class="row mt-3">
                            <div class="col-sm-12">
                                <table class="table table-hover" id="tabela">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>  
                                            <th scope="col">Cargo</th>
                                            <th scope="col">Função</th>
                                            <th scope="col">Empresa</th>
                                            <th scope="col">Data Início</th>
                                            <th scope="col">Data Fim</th>
                                        </tr>
                                        <tr>
                                            <th><input type="text" id="txtColuna1"/></th>
                                            <th><input type="text" id="txtColuna2"/></th>
                                            <th><input type="text" id="txtColuna3"/></th>
                                            <th><input type="text" id="txtColuna4"/></th>
                                            <th><input type="text" id="txtColuna5"/></th>    
                                            <th><input type="text" id="txtColuna6"/></th> 
                                        </tr>	
                                    </thead>
                                    <tbody>
                                        <%for (Vagas vaga : vagas) {%>
                                        <tr>
                                            <td><%out.print(vaga.getIdVaga());%></td>  
                                            <td><%out.print(vaga.getCargo());%></td>
                                            <td><%out.print(vaga.getFuncao());%></td>
                                            <td><%out.print(vaga.getNomeEmpresa());%></td>
                                            <td><%
                                                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                                                out.print(sdf1.format(vaga.getDataIni()));
                                                %></td>
                                            <td><%
                                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                                out.print(sdf.format(vaga.getDataFim()));
                                                %></td>
                                                <%if (user.getUsuario_perfil() == 1) {%>
                                            <td>                                
                                                <%out.println("<td><form name=\"editarForm\" action=\"vagaUpdate.jsp\" method=\"POST\">");
                                                    out.println("<input type=\"hidden\" name=\"idvaga\" id=\"idvaga\" value=\"" + vaga.getIdVaga() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"requisitos\" id=\"requisitos\" value=\"" + vaga.getRequisitos() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"requisitosdesejaveis\" id=\"requisitosdesejaveis\" value=\"" + vaga.getRequisitos_desejaveis() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"cargo\" id=\"cargo\" value=\"" + vaga.getCargo() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"obs\" id=\"obs\" value=\"" + vaga.getObservacao() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"nomeempresa\" id=\"nomeempresa\" value=\"" + vaga.getNomeEmpresa() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"funcao\" id=\"funcao\" value=\"" + vaga.getFuncao() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"dataini\" id=\"dataini\" value=\"" + vaga.getDataIni() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"datafim\" id=\"datafim\" value=\"" + vaga.getDataFim() + "\"/>");
                                                    out.println("<input type=\"hidden\" name=\"idempresa\" id=\"idempresa\" value=\"" + vaga.getIdEmpresa() + "\"/>");
                                                    out.println("<input type=\"submit\" class=\"btn btn-warning btn-xs\" value=\"Editar\" name=\"btvagaUpdate\" id=\"btvagaUpdate\" />");
                                                    out.println("</form></td>");%>
                                            </td>  
                                            <%}%>
                                            <%if (user.getUsuario_perfil() == 2) {%>
                                                <%if (candDAO.readCandidatura(vaga.getIdVaga(), user.getUsuario_id()) == null) {%>
                                                    <td>                                
                                                        <%out.println("<td><form name=\"candidatarForm\" action=\"VagaCandidatarServlet\" method=\"POST\">");
                                                            out.println("<input type=\"hidden\" name=\"idvaga\" id=\"idvaga\" value=\"" + vaga.getIdVaga() + "\"/>");
                                                            out.println("<input type=\"submit\" class=\"btn btn-warning btn-xs\" value=\"Candidatar-se\" name=\"btvagaCandidatar\" id=\"btvagaCandidatar\" />");
                                                            out.println("</form></td>");%>
                                                    </td>
                                                <%}%>
                                            <%}%>
                                        </tr>                   
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3 mb-3 mr-3">
                        <div class="col-sm-12 text-right">
                            <%if (user.getUsuario_perfil() > 0) {%>
                            <a id="btn_cadastro" href="homepage.jsp" class="btn btn-md btn-outline-secondary">Voltar</a>
                            <%}%>
                            <%if (user.getUsuario_perfil() == 1) {%>
                            <a id="btn_cadastro" href="vagaIncluir.jsp" class="btn btn-md btn-primary">Cadastrar</a>
                            <%}%>
                        </div> 
                    </div> 
                </div>
            </div>
        </div>
    </div>
</div>
</body>

