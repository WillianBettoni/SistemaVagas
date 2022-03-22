create database trabalhoWeb;
use trabalhoWeb;

create table usuario(
    usuario_id INT NOT NULL AUTO_INCREMENT,
    usuario_login VARCHAR(45) NOT NULL,
    usuario_senha VARCHAR(45) NOT NULL,
    usuario_email VARCHAR(150) NOT NULL,
    usuario_perfil INT NOT NULL,
PRIMARY KEY (usuario_id));

create table empresa(
    idEmpresa int not null auto_increment,
    nome varchar(250),
    razao varchar(280),
    cnpj numeric(14),
    email varchar(150),
    cidade varchar(250),
    uf varchar(2),
    primary key(idEmpresa),
    UNIQUE KEY(razao,cnpj) 
);

create table vaga(
    idVaga int not null auto_increment,
    cargo varchar(150),
    funcao varchar(400),
    requisitos varchar(450),
    requisitos_desejaveis varchar(450),
    observacao varchar(400),
    idEmpresa int not null,
    dataIni date,
    dataFim date,
    primary key (idVaga),
    foreign key (idEmpresa) references empresa (idEmpresa)
);

create table usuarioDetalhes(
    idUsuarioDetalhes int not null auto_increment,
    idUsuario int,
    nome varchar(250),
    email varchar(250),
    sexo varchar(15),
    dataNascimento date,
    curriculoResumido varchar(2000),
    foto LONGBLOB,
    formatoFoto VARCHAR(5),
    primary key(idUsuarioDetalhes),
    foreign key(idUsuario) references usuario(usuario_id)
);

create table candidatura (
    idCandidatura int not null auto_increment,
    idVaga int,
    idUsuario int,
    dataCandidatura date,
    primary key(idCandidatura),
    foreign key(idVaga) references vaga(idVaga)
);

insert into empresa (nome, razao, cnpj, email, cidade, uf)
values ('Google', 'Google LTDA', '21445386000115', 'google@gmail.com', 'Capinzal', 'SC');

insert into empresa (nome, razao, cnpj, email, cidade, uf)
values ('Facebook', 'Facebook LTDA', '02251113000195', 'facebook@gmail.com', 'Zortea', 'SC');

insert into empresa (nome, razao, cnpj, email, cidade, uf)
values ('Orkut', 'Orkut LTDA', '12873341000150', 'orkut@gmail.com', 'Lacerdopolis', 'SC');

insert into empresa (nome, razao, cnpj, email, cidade, uf)
values ('Instagram', 'Instagram LTDA', '29439074000100', 'instagram@gmail.com', 'Erval Velho', 'SC');

insert into usuario (usuario_login, usuario_senha, usuario_email, usuario_perfil)
values('admin', 'admin', 'admin@gmail.com', 1);


