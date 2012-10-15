-- Table: restricoes


-- DROP TABLE restricoes;


CREATE TABLE restricoes
(
  
codigo_restricao character varying(10) NOT NULL,
  
descricao_restricao character varying(100),
  
tipo character varying(20),
  
fk_cpf character varying(15),
  
CONSTRAINT restricoes_pkey PRIMARY KEY (codigo_restricao),
  
CONSTRAINT fk_cpf FOREIGN KEY (fk_cpf)
      
REFERENCES pacientes (codigo_paciente) MATCH SIMPLE
     
 ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

ALTER TABLE restricoes
  OWNER TO postgres;
