-- V1__init.sql - cria tabelas e seeds
CREATE TABLE usuarios (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  area_atuacao VARCHAR(100),
  nivel_carreira VARCHAR(50),
  data_cadastro DATE NOT NULL
);

CREATE TABLE trilhas (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(150) NOT NULL,
  descricao TEXT,
  nivel VARCHAR(50) NOT NULL,
  carga_horaria INT NOT NULL,
  foco_principal VARCHAR(100)
);

CREATE TABLE competencias (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  categoria VARCHAR(100),
  descricao TEXT
);

CREATE TABLE trilha_competencia (
  trilha_id BIGINT NOT NULL,
  competencia_id BIGINT NOT NULL,
  PRIMARY KEY (trilha_id, competencia_id),
  CONSTRAINT fk_trilha_competencia_trilha FOREIGN KEY (trilha_id) REFERENCES trilhas (id),
  CONSTRAINT fk_trilha_competencia_competencia FOREIGN KEY (competencia_id) REFERENCES competencias (id)
);

CREATE TABLE matriculas (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  usuario_id BIGINT NOT NULL,
  trilha_id BIGINT NOT NULL,
  data_inscricao DATE NOT NULL,
  status VARCHAR(50) NOT NULL,
  CONSTRAINT fk_matricula_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
  CONSTRAINT fk_matricula_trilha FOREIGN KEY (trilha_id) REFERENCES trilhas (id)
);

-- Seeds: competencias
INSERT INTO competencias (nome, categoria, descricao) VALUES
('Inteligência Artificial', 'Tecnologia', 'Fundamentos de IA e aplicações.'),
('Análise de Dados', 'Tecnologia', 'Análise e interpretação de dados.'),
('Empatia', 'Humana', 'Desenvolvimento de habilidades socioemocionais.'),
('Colaboração', 'Humana', 'Trabalho em equipe e metodologias ágeis.');

-- Seeds: trilhas
INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) VALUES
('Introdução à IA', 'Conceitos básicos de IA e ML', 'INICIANTE', 40, 'IA'),
('Data Basics', 'Fundamentos de análise de dados', 'INICIANTE', 35, 'Dados'),
('Soft Skills para Transição', 'Comunicação, empatia e colaboração', 'INICIANTE', 20, 'Soft Skills');

-- relaciona trilha -> competencia (trilha_competencia)
INSERT INTO trilha_competencia (trilha_id, competencia_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(3, 4);

-- seeds: usuarios
INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro) VALUES
('Ana Silva', 'ana.silva@example.com', 'Administração', 'Em transição', CURRENT_DATE()),
('João Souza', 'joao.souza@example.com', 'TI', 'Pleno', CURRENT_DATE());

-- seeds: matriculas
INSERT INTO matriculas (usuario_id, trilha_id, data_inscricao, status) VALUES
(1, 3, CURRENT_DATE(), 'ATIVA');
