﻿-- DROP TABLE Pacientes

-- DROP TABLE Medicos
-- SELECT MD5('julia1') -- "8ec70a26c1ffbba5e35a269286e8cea4"
-- DROP TABLE Pessoas
--create database sanus;

CREATE TABLE Pessoas
(
	Codigo_Pessoa	SERIAL PRIMARY KEY,
	Nome_Pessoa	VARCHAR(40) NOT NULL,
	ID_Pessoa	VARCHAR(10),
	CPF_Pessoa	CHAR(11) UNIQUE,
	Data_Nascimento_Pessoa	DATE,
	Email_Pessoa	VARCHAR(80) NOT NULL UNIQUE,
	Senha_Pessoa	VARCHAR(100) NOT NULL,
	Data_Cadastro_Pessoa DATE DEFAULT CURRENT_TIMESTAMP,
	Status_pessoa int default 1 --1 Pendente 2 Ativo 3 Inativo
);
				
CREATE TABLE Pacientes(
	Codigo_Paciente	SERIAL PRIMARY KEY,
	Codigo_Pessoa	INT REFERENCES Pessoas(Codigo_Pessoa) UNIQUE
);

CREATE TABLE Medicos(
	Codigo_Medico	SERIAL PRIMARY KEY,
	Codigo_Pessoa	INT REFERENCES Pessoas(Codigo_Pessoa) UNIQUE,
	CRM_Medico 	VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Cirurgias
	(
	Codigo_Cirurgia			SERIAL NOT NULL,
	Nome_Cirurgia			VARCHAR(40) NOT NULL,
	Descricao				VARCHAR(800),
	Data					DATE,
	
	PRIMARY KEY(Codigo_Cirurgia)
	);
	
CREATE TABLE Receitas
	(
	Codigo_Receita			SERIAL NOT NULL,
	PRIMARY KEY(Codigo_Receita)
	);
				
CREATE TABLE Hospitais
	(
	Codigo_Hospital			SERIAL NOT NULL,
	Nome_Hospital			VARCHAR(40) NOT NULL,	
	PRIMARY KEY(Codigo_Hospital)
	);
				
				
CREATE TABLE Restricoes
	(
	Codigo_Restricao		SERIAL NOT NULL,
	Descricao_Restricao		VARCHAR(100),
	Tipo_Restricao          VARCHAR(15),
	
	PRIMARY KEY(Codigo_Restricao)
	);
				
CREATE TABLE Especialidade
	(
	Codigo_Especialidade	SERIAL NOT NULL,
	Nome_Especialidade	VARCHAR(40),
	Descricao_Especialidade	VARCHAR(90),
	PRIMARY KEY(Codigo_Especialidade)
	
	);
	
CREATE TABLE Exames
	(
	Codigo_Exame			SERIAL NOT NULL,
	Nome_Exame				VARCHAR(40) NOT NULL,
	Descricao_Exame			VARCHAR(100)		,
	PRIMARY KEY(Codigo_Exame)
	);
				
				
CREATE TABLE Medicamentos
	(
	Codigo_Medicamento	SERIAL NOT NULL,
	Bula_Medicamento	VARCHAR(100)		,
	PRIMARY KEY(Codigo_Medicamento)
	);
				
				
CREATE TABLE PacienteXReceita
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Receita			INT NOT NULL,
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),
	FOREIGN KEY(Codigo_Receita) REFERENCES Receitas(Codigo_Receita)
	);			
				
CREATE TABLE MedicoXHospital
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Hospital			INT NOT NULL,
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);
				
CREATE TABLE CirurgiasXHospitais
	(
	Codigo_Cirurgia			INT NOT NULL,
	Codigo_Hospital			INT NOT NULL,
	FOREIGN KEY(Codigo_Cirurgia) REFERENCES Cirurgias(Codigo_Cirurgia),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);
				
CREATE TABLE MedicoXEspecialidade
	(
	Codigo_Medico		INT NOT NULL,
	Codigo_Especialidade	INT NOT NULL,
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),
	FOREIGN KEY(Codigo_especialidade) REFERENCES Especialidade(Codigo_especialidade)
	);

CREATE TABLE PacienteXExames
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Exame			INT NOT NULL,
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),	
	FOREIGN KEY(Codigo_Exame) REFERENCES Exames(Codigo_Exame)
	);
				
CREATE TABLE PacienteXHospital
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Hospital			INT NOT NULL,
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);
				
CREATE TABLE MedicoXExames
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Exame			INT NOT NULL,
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Exame) REFERENCES Exames(Codigo_Exame)
	);
				
				
CREATE TABLE MedicoXCirurgia
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Cirurgia			INT NOT NULL,
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico) ON UPDATE CASCADE ON DELETE CASCADE,	
	FOREIGN KEY(Codigo_Cirurgia) REFERENCES Cirurgias(Codigo_Cirurgia) ON UPDATE CASCADE ON DELETE CASCADE
	);
					
CREATE TABLE ReceitasXMedicamentos
	(
	Codigo_Receita			INT NOT NULL,
	Codigo_Medicamento		INT NOT NULL,
	FOREIGN KEY(Codigo_Receita) REFERENCES Receitas(Codigo_Receita),	
	FOREIGN KEY(Codigo_Medicamento) REFERENCES Medicamentos(Codigo_Medicamento)
	);
				
CREATE TABLE PacienteXCirurgia
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Cirurgia			INT NOT NULL,
	
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente) ON UPDATE CASCADE ON DELETE CASCADE,	
	FOREIGN KEY(Codigo_Cirurgia) REFERENCES Cirurgias(Codigo_Cirurgia) ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE PacienteXRestricao
(
	Codigo_Paciente 		INT NOT NULL,
	Codigo_Restricao		INT NOT NULL,
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(Codigo_Restricao) REFERENCES Restricoes(Codigo_Restricao) ON UPDATE CASCADE ON DELETE CASCADE

);
	
CREATE TABLE MedicoXReceita
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Receita			INT NOT NULL,
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Receita) REFERENCES Receitas(Codigo_Receita)
	);
				




