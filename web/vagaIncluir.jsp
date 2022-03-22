<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="model.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EmpresaDAO empDAO = new EmpresaDAO();
    List<Empresa> empresas = new ArrayList<Empresa>();
    empresas = empDAO.readEmpresas();
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
                            <h3 class="card-title">Vagas</h3>
                        </div>
                        <form id="cadastro" name="cadastro" method="POST" action="CreateVagaServlet">
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="cargo">Cargo *</label>
                                    <input type="text" class="form-control" id="cargo" name="cargo" placeholder="Cargo" required/>
                                </div>
                                <div class="col-sm-12 col-md-6">
                                    <label for="funcao">Função *</label>
                                    <input type="text" class="form-control" id="funcao" name="funcao" placeholder="Função" required/>
                                </div>    
                            </div>
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="dataini">Data Início *</label>
                                    <input type="date" class="form-control" id="datani" name="dataini" placeholder="Data Início" required/>
                                </div>  
                                <div class="col-sm-12 col-md-6">
                                    <label for="datafim">Data Fim *</label>
                                    <input type="date" class="form-control" id="datafim" name="datafim" placeholder="Data Fim" required/>
                                </div>     
                            </div>    
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="idempresa">Empresa</label>
                                    <select class="form-control" name="idempresa" required/>
                                    <%
                                        for (Empresa empresa : empresas) {
                                            out.print("<option value=\"" + empresa.getIdEmpresa() + "\">" + empresa.toString() + "</option>");
                                        }
                                    %>
                                    </select>
                                </div>  
                                <div class="col-sm-12 col-md-6">
                                    <label for="requisitos">Requisitos *</label>
                                    <input type="text" class="form-control" id="requisitos" name="requisitos" placeholder="Requisitos" required/>
                                </div>
                            </div>
                            <div class="row mt-3 ml-3 mr-3">
                                <div class="col-sm-12 col-md-6">
                                    <label for="requisitosdesejaveis">Requisitos Desejáveis *</label>
                                    <input type="text" class="form-control" id="requisitosdesejaveis" name="requisitosdesejaveis" placeholder="Requisitos Desejáveis" required/>
                                </div>  
                                <div class="col-sm-12 col-md-6">
                                    <label for="observacao">Observação *</label>
                                    <input type="text" class="form-control" id="observacao" name="observacao" placeholder="Observação" required/>
                                </div>                      
                            </div>    

                            <div class="row mt-3 mb-3 mr-3">
                                <div class="col-sm-12 text-right">
                                    <a id="btn_cadastro" href="homepage.jsp" class="btn btn-md btn-outline-secondary">Voltar</a>
                                    <button id="btn_cadastro" onclick="cadastrar()" class="btn btn-md btn-primary">Cadastrar</button>
                                </div> 
                            </div>   
                        </form>  
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>