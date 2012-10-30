-- DROP TABLE Pacientes
-- DROP TABLE Medicos
-- DROP TABLE Pessoas
CREATE TABLE Pessoas
(
	Codigo_Pessoa	SERIAL PRIMARY KEY,
	Nome_Pessoa	VARCHAR(40) NOT NULL,
	ID_Pessoa	VARCHAR(10),
	CPF_Pessoa	CHAR(11) UNIQUE,
	Data_Nascimento_Pessoa	DATE,
	Email_Pessoa	VARCHAR(80) NOT NULL UNIQUE,
	Senha_Pessoa	VARCHAR(100) NOT NULL,
	Data_Cadastro_Pessoa DATE DEFAULT CURRENT_TIMESTAMP
);
				
CREATE TABLE Pacientes(
	Codigo_Paciente	SERIAL PRIMARY KEY,
	Codigo_Pessoa	INT REFERENCES Pessoas(Codigo_Pessoa)
);

CREATE TABLE Medicos(
	Codigo_Medico	SERIAL PRIMARY KEY,
	Codigo_Pessoa	INT REFERENCES Pessoas(Codigo_Pessoa),
	CRM_Medico 	VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Cirurgias
	(
	Codigo_Cirurgia			SERIAL NOT NULL,
	NOME_Cirurgia			VARCHAR(40) NOT NULL,
	Codigo_Pessoa			INT NOT NULL,
	Codigo_Medico			INT NOT NULL,
	Descricao				VARCHAR(800),
	Data					DATE,
	
	PRIMARY KEY(Codigo_Cirurgia),
	FOREIGN KEY(Codigo_Pessoa) REFERENCES Pessoas(Codigo_Pessoa),
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico)
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
	Codigo_Pessoa			INT NOT NULL,
	PRIMARY KEY(Codigo_Restricao),
	FOREIGN KEY(Codigo_Pessoa) REFERENCES Pessoas(Codigo_Pessoa)
	);
				
CREATE TABLE Especialidade
	(
	Codigo_Especialidade	SERIAL NOT NULL,
	Descricao_Especialidade	VARCHAR(40)			,
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
	PRIMARY KEY(Codigo_Paciente,Codigo_Receita),
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),
	FOREIGN KEY(Codigo_Receita) REFERENCES Receitas(Codigo_Receita)
	);			
				
CREATE TABLE MedicoXHospital
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Hospital			INT NOT NULL,
	PRIMARY KEY(Codigo_Medico,Codigo_Hospital),
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);
				
CREATE TABLE CirurgiasXHospitais
	(
	Codigo_Cirurgia			INT NOT NULL,
	Codigo_Hospital			INT NOT NULL,
	PRIMARY KEY(Codigo_Cirurgia,Codigo_Hospital),
	FOREIGN KEY(Codigo_Cirurgia) REFERENCES Cirurgias(Codigo_Cirurgia),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);
				
CREATE TABLE MedicoXEspecialidade
	(
	Codigo_Medico		INT NOT NULL,
	Codigo_Hospital		INT NOT NULL,
	Codigo_Especialidade	INT NOT NULL,
	PRIMARY KEY(Codigo_Medico,Codigo_Hospital),
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);

CREATE TABLE PacienteXExames
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Exame			INT NOT NULL,
	PRIMARY KEY(Codigo_Paciente,Codigo_Exame),
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),	
	FOREIGN KEY(Codigo_Exame) REFERENCES Exames(Codigo_Exame)
	);
				
CREATE TABLE PacienteXHospital
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Hospital			INT NOT NULL,
	PRIMARY KEY(Codigo_Paciente,Codigo_Hospital),
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),	
	FOREIGN KEY(Codigo_Hospital) REFERENCES Hospitais(Codigo_Hospital)
	);
				
CREATE TABLE MedicoXExames
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Exame			INT NOT NULL,
	PRIMARY KEY(Codigo_Medico,Codigo_Exame),
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Exame) REFERENCES Exames(Codigo_Exame)
	);
				
				
CREATE TABLE MedicoXCirurgia
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Cirurgia			INT NOT NULL,
	PRIMARY KEY(Codigo_Medico,Codigo_Cirurgia),
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Cirurgia) REFERENCES Cirurgias(Codigo_Cirurgia)
	);
					
CREATE TABLE ReceitasXMedicamentos
	(
	Codigo_Receita			INT NOT NULL,
	Codigo_Medicamento		INT NOT NULL,
	PRIMARY KEY(Codigo_Receita,Codigo_Medicamento),
	FOREIGN KEY(Codigo_Receita) REFERENCES Receitas(Codigo_Receita),	
	FOREIGN KEY(Codigo_Medicamento) REFERENCES Medicamentos(Codigo_Medicamento)
	);
				
CREATE TABLE PacienteXCirurgia
	(
	Codigo_Paciente			INT NOT NULL,
	Codigo_Cirurgia			INT NOT NULL,
	PRIMARY KEY(Codigo_Paciente,Codigo_Cirurgia),
	FOREIGN KEY(Codigo_Paciente) REFERENCES Pacientes(Codigo_Paciente),	
	FOREIGN KEY(Codigo_Cirurgia) REFERENCES Cirurgias(Codigo_Cirurgia)
	);
				
CREATE TABLE MedicoXReceita
	(
	Codigo_Medico			INT NOT NULL,
	Codigo_Receita			INT NOT NULL,
	PRIMARY KEY(Codigo_Medico,Codigo_Receita),
	FOREIGN KEY(Codigo_Medico) REFERENCES Medicos(Codigo_Medico),	
	FOREIGN KEY(Codigo_Receita) REFERENCES Receitas(Codigo_Receita)
	);
				




