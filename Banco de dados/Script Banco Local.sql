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
loginMaquina VARCHAR(30)
);
insert into maquinas values(null, '2', 'HS1321B', 'AMD Ryzen 5', 'GTX 750ti', 8, '123321', 'Gustavo', 'Quaresma', 'admin');
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
-- select * from empresa;
-- SELECT DATABASE();
-- show tables;
-- describe empresa;
-- Transformando a fkMaquinas em uma Foreign Key
ALTER TABLE Processos ADD 
FOREIGN KEY (fkMaquinas) REFERENCES Maquinas (idMaquinas);
-- drop database gelis;