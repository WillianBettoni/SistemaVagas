<%@page import="dao.VagaDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EmpresaDAO"%>
<%@page import="model.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EmpresaDAO empDAO = new EmpresaDAO();
    List<Empresa> empresas = new ArrayList<Empresa>();
    empresas = empDAO.readEmpresas();
    VagaDAO vagaDAO = new VagaDAO();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Vagas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="libs/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="libs/templateIni/css/creative.min.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />        
        <link href="libs/templateIni/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
        <link href="libs/templateIni/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
        <link href="libs/templateIni/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">        
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <!-- Portfolio Section -->
        <section id="portfolio">
            <div class="container-fluid p-0">
                <div class="row no-gutters">
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="portfolio/fullsize/1.jpg">
                            <img class="img-fluid" src="portfolio/thumbnails/1.jpg" alt="">
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">
                                    Categoria
                                </div>
                                <div class="project-name">
                                    Gestão Educacional
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="portfolio/fullsize/2.jpg">
                            <img class="img-fluid" src="portfolio/thumbnails/2.jpg" alt="">
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">
                                    Categoria
                                </div>
                                <div class="project-name">
                                    Finanças
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="portfolio/fullsize/3.jpg">
                            <img class="img-fluid" src="portfolio/thumbnails/3.jpg" alt="">
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">
                                    Categoria
                                </div>
                                <div class="project-name">
                                    Marketing e Publicidade
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="portfolio/fullsize/4.jpg">
                            <img class="img-fluid" src="portfolio/thumbnails/4.jpg" alt="">
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">
                                    Categoria
                                </div>
                                <div class="project-name">
                                    Alimentos e Bebidas
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="portfolio/fullsize/5.jpg">
                            <img class="img-fluid" src="portfolio/thumbnails/5.jpg" alt="">
                            <div class="portfolio-box-caption">
                                <div class="project-category text-white-50">
                                    Categoria
                                </div>
                                <div class="project-name">
                                    Engenharia
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <a class="portfolio-box" href="portfolio/fullsize/6.jpg">
                            <img class="img-fluid" src="portfolio/thumbnails/6.jpg" alt="">
                            <div class="portfolio-box-caption p-3">
                                <div class="project-category text-white-50">
                                    Categoria
                                </div>
                                <div class="project-name">
                                    Outros
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <section class="page-section bg-dark text-white">
            <div class="container text-center">
                <h2 class="mb-4">Busque sua vaga!</h2>        
                <a class="btn btn-light btn-xl" href="listagem.jsp">Vagas</a>
            </div>
        </section>

        <section class="page-section" id="contact">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8 text-center">
                        <h2 class="mt-0">Busque Sua Vaga!</h2>
                        <hr class="divider my-4">
                        <p class="text-muted mb-5">Está em busca de um emprego? Temos a solução!</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 ml-auto text-center mb-5 mb-lg-0">
                        <i class="fas fa-phone fa-3x mb-3 text-muted"></i>
                        <div>(49)99822-9272</div>
                        <div>(49)98889-1297</div>
                    </div>
                    <div class="col-lg-4 mr-auto text-center">
                        <i class="fas fa-envelope fa-3x mb-3 text-muted"></i>
                        <a class="d-block" href="https://www.facebook.com/willian.bettoni">Willian Bettoni</a>
                        <a class="d-block" href="https://www.facebook.com/flamia.rodrigo">Rodrigo Flamia</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer class="bg-light py-5">
            <div class="container">
                <div class="small text-center text-muted">Copyright &copy; 2019 - Cadastro de Vagas</div>
            </div>
        </footer>

    </body>
</html>
