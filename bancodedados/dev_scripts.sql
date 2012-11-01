-- CADASTRO DE PESSOA
INSERT INTO Pessoas (Nome_Pessoa, Id_Pessoa, cpf_pessoa, data_nascimento_pessoa, senha_pessoa)
VALUES (' Welerson Silva' , ' mg123', '12312312332', '1970-01-09', MD5('S3creta') );

-- ATUALIZAR UM MÉDICO
UPDATE Medico 
   SET Crm_Medico = '1231123'
 WHERE Codigo_Medico = 12


-- EXCLUSÃO DE EXAME
DELETE 
  FROM Exames
 WHERE Codigo_Exame = 12

 -- RECUPERAR UM MÉDICO
 SELECT M.Codigo_Medico,
        P.Codigo_Pessoa,
        P.Nome_Pessoa AS Nome_Medico,
        P.Cpf_Pessoa AS Cpf_Medico,
        M.Crm_Medico
   FROM Medicos AS M,
        Pessoas AS P
  WHERE M.Codigo_Pessoa = P.Codigo_Pessoa
    AND M.Codigo_Medico = 12

-- PROCURAR POR PACIENTE PELO NOME
 SELECT Pa.Codigo_Paciente,
        P.Codigo_Pessoa,
        P.Nome_Pessoa AS Nome_Paciente,
        P.Cpf_Pessoa AS Cpf_Paciente
   FROM Pacientes AS Pa,
        Pessoas AS P
  WHERE Pa.Codigo_Pessoa = P.Codigo_Pessoa
    AND P.Nome_Pessoa LIKE '%Wel%'