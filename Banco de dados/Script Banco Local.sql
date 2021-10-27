CREATE DATABASE Gelis;
USE Gelis;

-- Criação da tabela Empresa
CREATE TABLE Empresa (
idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
nomeEmpresa VARCHAR(100),
CNPJ CHAR(18),
CEP CHAR(8),
estado CHAR(2),
cidade VARCHAR(50),
logradouro VARCHAR(100),
email VARCHAR(100),
senha VARCHAR(45),
whatsApp CHAR(11)
);
-- insert into Empresa values(null, 'SDSDSDA', 123456789012345678, 12345678, 'SP', 'São Paulo', 'Rua', 'gustavo@gelis.com', '123321',12345678910);
select * from empresa;
-- Criação da tabela Máquinas
CREATE TABLE Maquinas (
idMaquinas INT PRIMARY KEY AUTO_INCREMENT,
fkEmpresa INT,
hostname VARCHAR(30),
modCPU VARCHAR(50),
modGPU VARCHAR(50),
qntRAM Double,
senhaMaquina VARCHAR(45),
nomeResp VARCHAR(100),
sobrenomeResp VARCHAR(100),
emailFunc varchar(100),
loginMaquina VARCHAR(30)
);

insert into maquinas values(null, '1', 'HS1323A', null, null, null, '123321', 'ADADSD', 'DASDADA','BBBBBBB@gelis.com', 'admin1');
select * from Maquinas;
-- Transformando a fkEmpresa em uma Foreign Key
ALTER TABLE Maquinas ADD 
FOREIGN KEY (fkEmpresa) REFERENCES Empresa (idEmpresa);

--  Criação da tabela DadosMáquinas
CREATE TABLE dadosMaquinas (
idDadosMaquinas INT PRIMARY KEY AUTO_INCREMENT,
fkMaquinas INT,
tempCPU FLOAT,
tempGPU FLOAT,
usoRAM FLOAT,
dataHora DATETIME
);
select * from dadosMaquinas;
-- Transformando a fkMaquinas em uma Foreign Key
ALTER TABLE dadosMaquinas ADD 
FOREIGN KEY (fkMaquinas) REFERENCES Maquinas (idMaquinas);

--  Criação da tabela Processos
CREATE TABLE Processos (
idProcessos INT PRIMARY KEY AUTO_INCREMENT,
fkMaquinas INT,
nomeProcesso VARCHAR(50),
usoCPU INT,
memRAM INT,
PID INT
);
SELECT hostname as Hostname, nomeResp as Nome,sobrenomeResp as Sobrenome, emailFunc as email FROM maquinas JOIN empresa WHERE fkEmpresa = idEmpresa and idEmpresa = 1;

-- select * from empresa;
-- SELECT DATABASE();
-- show tables;
-- describe empresa;
-- Transformando a fkMaquinas em uma Foreign Key
ALTER TABLE Processos ADD 
FOREIGN KEY (fkMaquinas) REFERENCES Maquinas (idMaquinas);
-- drop database gelis;