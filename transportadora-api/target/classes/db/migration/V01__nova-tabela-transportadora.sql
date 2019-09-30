create table transportadora (
	id bigint auto_increment not null,
	email varchar(100) not null,
	nome varchar(100) not null,
	empresa varchar(100) not null,
	telefone varchar(10) not null,
	celular varchar(11),
	whatsapp varchar(11),
	modal varchar(100) not null,
	cep varchar(8),
	estado varchar(2) not null,
	cidade varchar(100) not null,
	bairro varchar(100) not null,
	rua varchar(100) not null,
	numero varchar(10) not null,
	
	primary key (id)
	
);
	
	
	
	
	 
	