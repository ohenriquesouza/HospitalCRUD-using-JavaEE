create database bdhospital;
show databases;
use bdhospital;

describe usuario;
create table especialidades(idespecs int primary key auto_increment, 
nome_espec varchar(45) not null, profissional varchar(45) not null);
create table plano_saude(idplan int primary key auto_increment, nome_plan varchar(45) not null);
create table usuario(idpaciente int primary key auto_increment, nome_paciente varchar(45) not null,
 nm_carteira int not null, idplan int not null, idespecs int not null);
insert into especialidades(nome_espec, profissional) values('Ortopedia', 'Dr. Gabriel Toledo');
insert into especialidades(nome_espec, profissional) values('Pediatria', 'Dr. Fernando Alvarenga');
insert into especialidades(nome_espec, profissional) values('Clínica geral', 'Dr. Lincoln Lau');
insert into especialidades(nome_espec, profissional) values('Cardiologia', 'Dr. Givanildo dos Santos');
insert into especialidades(nome_espec, profissional) values('Oftalmologia', 'Dr. João Eduardo');

insert into plano_saude(nome_plan) values('Unimed');
insert into plano_saude(nome_plan) values('Amil');
insert into plano_saude(nome_plan) values('GNDI');
insert into plano_saude(nome_plan) values('IPSEMG');


/* READ*/
select u.nome_paciente, u.nm_carteira, e.nome_espec, p.nome_plan from usuario u inner join especialidades e on u.idespecs = e.idespecs inner join plano_saude p on u.idplan = p.idplan;
select * from usuario order by nome_paciente;
select * from usuario where nome_paciente=? and nm_carteira=?;
select * from especialidades;
select * from plano_saude where idplan=?;
select * from usuario where nome_paciente=?;


/*UPDATE*/
update usuario set nome_paciente=?, nm_carteira=?,idplan=?,idespecs=? where idpaciente =?;

/*REMOVE*/
delete from usuario where idpaciente=?;

