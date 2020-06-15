create database eightshop;
use eightshop;

create table cliente(
	cpf varchar(15),
	nome varchar(30) not null,
	telefone VARCHAR(11) not null,
	endereco varchar(45) not null,
	num VARCHAR(10) not null,
	complemento varchar(20),
	cep VARCHAR(9) not null,
	email varchar(45) not null unique,
	senha varchar(30) not null,

	PRIMARY KEY(cpf)
);

create table loja(
	cnpj varchar(18),
	nome varchar(30) not null,
	telefone VARCHAR(11) not null,
	endereco varchar(45) not null,
	num VARCHAR(10) not null,
	complemento varchar(20),
	cep varchar(9) not null,
	email varchar(45) not null unique,
	senha varchar(30) not null,
	
	PRIMARY KEY(cnpj)
);

create table mercadoria(
	codmercadoria int(16) auto_increment,
	produto boolean not null,
	nome varchar(55) not null,
	preco float not null,
	cnpj VARCHAR(18) NOT NULL,
	categoria VARCHAR(30) NOT NULL,
	
	PRIMARY KEY(codmercadoria),
	FOREIGN KEY(cnpj) REFERENCES loja(cnpj)
);

create table pedido(
	codpedido int(16) auto_increment,
	cpf VARCHAR(15) NOT NULL,
	cnpj VARCHAR(15) NOT NULL,
	pagamento VARCHAR(20) NOT NULL,
	pago BOOLEAN NOT NULL,
	totalpreco FLOAT NOT NULL,
	
	PRIMARY KEY(codpedido),
	FOREIGN KEY(cnpj) REFERENCES loja(cnpj),
	FOREIGN KEY(cpf) REFERENCES cliente(cpf)
);

CREATE TABLE contem(
	codPedido INT,
	codMerc INT,
	qtd INT NOT NULL,
	
	PRIMARY KEY(codPedido, codMerc),
    FOREIGN KEY(codPedido) REFERENCES pedido(codpedido),
    FOREIGN KEY(codMerc) REFERENCES mercadoria(codmercadoria)
);

create table agendamento (
	codpedido int(16),
	horario VARCHAR(16) NOT NULL,
	status INT NOT NULL,
	
	PRIMARY KEY(codpedido),
	FOREIGN KEY(codpedido) REFERENCES pedido(codpedido)
);

CREATE USER api@localhost IDENTIFIED BY 'api@eightstore';
GRANT ALL ON eightshop.* TO api@localhost;

INSERT INTO loja(
	cnpj,
	nome,
	telefone,
	endereco,
	num,
	cep,
	email,
	senha
) VALUES(
	"01.234.567_0001-16",
	"Tio Zé",
	"2123456789",
	"Rua da Amargura",
	"240",
	"20123-456",
	"tioze42@gmail.com",
	"z3_do_ti0"
);

INSERT INTO mercadoria(
	produto,
	nome,
	preco,
	cnpj,
	categoria
) VALUES(
	TRUE,
	"Arroz 1KG",
	3.50,
	"01.234.567_0001-16",
	"alimentos"
);

INSERT INTO mercadoria(
	produto,
	nome,
	preco,
	cnpj,
	categoria
) VALUES(
	TRUE,
	"Feijão 1.5KG",
	5.10,
	"01.234.567_0001-16",
	"alimentos"
);

INSERT INTO cliente(
	cpf,
	nome,
	telefone,
	endereco,
	num,
	complemento,
	cep,
	email,
	senha
) VALUES(
	"258.147.369-00",
	"Arnaldo Aguilar",
	"21989054321",
	"Rua Villa Lobos",
	"35",
	"Apt. 320",
	"20587-147",
	"aaguilar1000@hotmail.com",
	"m@3$tr0"
);
