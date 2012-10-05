CREATE DATABASE prontuario_digital;
CREATE TABLE hospitais{
	Codigo_Hospital SERIAL PRIMARY KEY,
	Nome_Hospital VARCHAR(25)
)
CREATE TABLE pessoas(
	Codigo_Pessoa SERIAL PRIMARY KEY,
	Nome_Pessoa VARCHAR(100),
	Cpf_Pessoa CHAR(11) UNIQUE,
	Email_Pessoa VARCHAR(200),
	Id_Pessoa VARCHAR(10),
	Data_Nascimento_Pessoa TIMESTAMP,
	Senha_Pessoa VARCHAR(255)
)