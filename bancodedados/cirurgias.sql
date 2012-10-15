-- Table: cirurgias


-- DROP TABLE cirurgias;


CREATE TABLE cirurgias
(
  
codigo_cirurgia character varying(10) NOT NULL,
  
nome_cirurgia character varying(40) NOT NULL,
  
fk_codigo_paciente character varying(10) NOT NULL,
  
fk_codigo_medico character varying(10) NOT NULL,
  
descricao character varying(800),
  
data character varying(10),
  
CONSTRAINT cirurgias_pkey PRIMARY KEY (codigo_cirurgia),
  
CONSTRAINT cirurgias_fk_codigo_medico_fkey FOREIGN KEY (fk_codigo_medico)
     
REFERENCES medicos (codigo_medico) MATCH SIMPLE
     
 ON UPDATE NO ACTION ON DELETE NO ACTION,
  
CONSTRAINT cirurgias_fk_codigo_paciente_fkey FOREIGN KEY (fk_codigo_paciente)
      REFERENCES pacientes (codigo_paciente) MATCH SIMPLE
     
 ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

ALTER TABLE cirurgias
  OWNER TO postgres;