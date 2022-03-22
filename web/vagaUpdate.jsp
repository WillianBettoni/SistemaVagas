<%@page import="java.sql.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="model.Vagas"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="model.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String[] temp = request.getParameter("dataini").split("-");
    Calendar cal = Calendar.getInstance();
    cal.set(Integer.parseInt(temp[0]),
            Integer.parseInt(temp[1]) - 1,
            Integer.parseInt(temp[2]));
    String[] temp2 = request.getParameter("datafim").split("-");
    Calendar cal2 = Calendar.getInstance();
    cal2.set(Integer.parseInt(temp2[0]),
            Integer.parseInt(temp2[1]) - 1,
            Integer.parseInt(temp2[2]));
    Vagas vagas = new Vagas(
            Integer.parseInt(request.getParameter("idvaga")),
            request.getParameter("cargo"),
            request.getParameter("funcao"),
            request.getParameter("requisitos"),
            request.getParameter("requisitosdesejaveis"),
            request.getParameter("obs"),
            new Date(cal.getTimeInMillis()),
            new Date(cal2.getTimeInMillis()),
            Integer.parseInt(request.getParameter("idempresa")),
            request.getParameter("idempresa")
    );
    EmpresaDAO empDAO = new EmpresaDAO();
    List<Empresa> empresas = new ArrayList<Empresa>();
    empresas = empDAO.readEmpresas();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Atualizar Vagas</title>
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
                            <h3 class="card-title">Vagas</h3>
                        </div>
                        <form id="cadastro" name="cadastro" method="POST" action="UpdateVagaServlet">
                            <div class="row mt-3 ml-3 mr-3">
                                <input type= "hidden" name="idvaga" id="idvaga" value="<% out.print(vagas.getIdVaga()); %>"/>  
                                <div class="col-sm-12 col-md-6">
                                    <label for="cargo">Cargo *</label>
                                    <input type="text" class="form-control" value="<% out.print(vagas.getCargo()); %>" id="cargo" name="cargo" placeholder="Cargo" required/>
                                </div>
                                <div class="col-sm-12 col-md-6">
                                    <label for="funcao">Função *</label>
                                    <input type="text" class="form-control" value="<% out.print(vagas.getFuncao()); %>" id="funcao" name="funcao" placeholder="Função" required/>
                                </div>    
                            </div>
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="dataini">Data Início *</label>
                                    <input type="date" class="form-control" value="<% out.print(vagas.getDataIni()); %>" id="datani" name="dataini" placeholder="Data Início" required/>
                                </div>  
                                <div class="col-sm-12 col-md-6">
                                    <label for="datafim">Data Fim *</label>
                                    <input type="date" class="form-control" value="<% out.print(vagas.getDataFim()); %>" id="datafim" name="datafim" placeholder="Data Fim" required/>
                                </div>     
                            </div>    
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="idempresa">Empresa</label>
                                    <select class="form-control" name="idempresa" required/>
                                    <%
                                        for (Empresa empresa : empresas) {                                     
                                            if ((empresa.getIdEmpresa()) == (vagas.getIdEmpresa())) {
                                                out.print("<option value=\"" + empresa.getIdEmpresa() + "\" selected>" + empresa.toString() + "</option>");
                                            } else {
                                                out.print("<option value=\"" + empresa.getIdEmpresa() + "\">" + empresa.toString() + "</option>");
                                            }
                                        }
                                    %>
                                    </select>
                                </div>     
                                <div class="col-sm-12 col-md-6">
                                    <label for="requisitos">Requisitos *</label>
                                    <input type="text" class="form-control" value="<% out.print(vagas.getRequisitos()); %>" id="requisitos" name="requisitos" placeholder="Requisitos" required/>
                                </div>
                            </div>
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="requisitosdesejaveis">Requisitos Desejáveis *</label>
                                    <input type="text" class="form-control" value="<% out.print(vagas.getRequisitos_desejaveis()); %>" id="requisitosdesejaveis" name="requisitosdesejaveis" placeholder="Requisitos Desejáveis" required/>
                                </div>
                                <div class="col-sm-12 col-md-6">
                                    <label for="observacao">Observação *</label>
                                    <input type="text" class="form-control" value="<% out.print(vagas.getObservacao());%>" id="observacao" name="observacao" placeholder="Observação"required/>
                                </div>
                            </div>    

                            <div class="row mt-3 mb-3 mr-3">
                                <div class="col-sm-12 text-right">
                                    <a id="btn_cadastro" href="listagem.jsp" class="btn btn-md btn-outline-secondary">Voltar</a>
                                    <button id="btn_cadastro" onclick="cadastrar()" class="btn btn-md btn-primary">Alterar</button>
                                </div> 
                            </div>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>