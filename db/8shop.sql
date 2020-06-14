create database newsystem;
use newsystem;

create table tbcliente(

cpf varchar(15) primary key not null unique,

nome varchar(30) not null,

telefone int(10) not null,

endereco varchar(45) not null,

num int(10) not null,

complemento varchar(20),

cep int(8) not null,

email varchar(45) not null,

senha varchar(30) not null

);

create table tbloja(

cnpj varchar(18) primary key not null unique,

nome varchar(30) not null,

telefone int(10) not null,

endereco varchar(45) not null,

num int(10) not null,

complemento varchar(20),

cep int(8) not null,

email varchar(45) not null,

senha varchar(30) not null

);

create table mercadoria(

codmercadoria int(16) primary key auto_increment not null,

produto boolean not null,

nome varchar(55) not null,

preco float not null





);

alter table mercadoria add foreign key(cnpj)
references tbloja(cnpj);

create table pedido(

codpedido int(16) primary key auto_increment not null



);

alter table pedido add constraint fk_cpf foreign key (cpf) references tbcliente(cpf);

alter table pedido add constraint fk_cnpj foreign key(cnpj) references tbloja(cnpj);

create table `newsystems`.`agendamento` (
  
`codpedido` int(16) not null auto_increment,

`cpf` varchar(15) not null,
  
primary key (`codpedido`, `cpf`),
  unique index `cpf_UNIQUE` (`cpf` ASC),
  
constraint `codpedido`
    
  foreign key (`codpedido`)
    
  references `newsystems`.`pedido` (`codpedido`)
    
  ON DELETE NO ACTION
    
  ON UPDATE NO ACTION,
  
constraint `cpf`
    
  foreign key (`cpf`)
    
  references `newsystems`.`tbcliente` (`cpf`)
    
  ON DELETE NO ACTION
    
  ON UPDATE NO ACTION)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table agendamento add column horario datetime not null;

