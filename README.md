# Socket-Interface

## Pre-requisites

`mysql version 5+` Veja o download no site [Mysql site.](https://dev.mysql.com/downloads/repo/apt/)


## Configuração

1 - realizar o download do projeto em sua maquina.

2 - Após o download, realizar a query no banco:

`create database aluno;`

`create table aluno(
	id integer auto_increment primary key,
    nome varchar(255),
    idade integer(3),
    nota integer(2)
);`

3 - Instalar o Driver JDBC do mysql.

## Construção

Após realizado todas as configurações, basta executar separadamente a classe do servidor e cliente.
