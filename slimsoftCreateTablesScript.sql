CREATE DATABASE slimsoft;

USE slimsoft;

CREATE TABLE meta (
	id TINYINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

CREATE TABLE intensidade (
	id TINYINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

CREATE TABLE nivel_Atividade_Fisica (
	id TINYINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	data_nascimento DATETIME NOT NULL,
	altura FLOAT(10,2) NOT NULL,
	peso FLOAT(10,2) NOT NULL,
	peso_desejado FLOAT(10,2) NOT NULL,
	id_meta TINYINT NOT NULL,
	id_intensidade TINYINT NOT NULL,
	id_nivel_atividade_fisica TINYINT NOT NULL,
	FOREIGN KEY (id_meta) REFERENCES meta (id),
	FOREIGN KEY (id_intensidade) REFERENCES intensidade (id),
	FOREIGN KEY (id_nivel_atividade_fisica) REFERENCES nivel_atividade_fisica (id)
);

CREATE TABLE historico (
	id_usuario INT NOT NULL,
	data_historico DATETIME DEFAULT NOW() NOT NULL,
	imc FLOAT(10,2) NOT NULL,
	tbm_normal FLOAT(10,2) NOT NULL,
	tbm_recomendada FLOAT(10,2) NOT NULL,
	peso FLOAT(10,2) NOT NULL,
	consumo_calorico FLOAT(10,2) NOT NULL,
	gasto_calorico FLOAT(10,2) NOT NULL,
	CONSTRAINT pk_historico PRIMARY KEY (id_usuario, data_historico),
	FOREIGN KEY (id_usuario) REFERENCES usuario (id)
);

CREATE TABLE atividade_fisica (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	gasto_calorico FLOAT(10,2) NOT NULL
);

CREATE TABLE registro_atividade (
	id_usuario INT NOT NULL,
	id_atividade INT NOT NULL,
	data_atividade DATETIME NOT NULL,
	duracao INT NOT NULL,
	CONSTRAINT pk_registro_atividade PRIMARY KEY (id_usuario, id_atividade, data_atividade),
	FOREIGN KEY (id_usuario) REFERENCES usuario (id),
	FOREIGN KEY (id_atividade) REFERENCES atividade_fisica (id)
);

CREATE TABLE alimento (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	valor_energetico FLOAT(10,2) NOT NULL,
	porcao ENUM ('ml', 'g', 'unidade') NOT NULL,
	valor_porcao FLOAT(10,2) NOT NULL,
	proteinas FLOAT(10,2) NOT NULL,
	fibras FLOAT(10,2) NOT NULL,
	carboidratos FLOAT(10,2) NOT NULL,
	sodio FLOAT(10,2) NOT NULL,
	gorduras_totais FLOAT(10,2) NOT NULL,
	gorduras_saturadas FLOAT(10,2) NOT NULL,
	gorduras_trans FLOAT(10,2) NOT NULL
);

CREATE TABLE tipo_refeicao (
	id TINYINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

CREATE TABLE refeicao (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_usuario INT NOT NULL,
	data_refeicao DATETIME NOT NULL,
	id_tipo_refeicao TINYINT NOT NULL,
	FOREIGN KEY (id_usuario) REFERENCES usuario (id),
	FOREIGN KEY (id_tipo_refeicao) REFERENCES tipo_refeicao (id)
);

CREATE TABLE item_refeicao (
	id_refeicao INT NOT NULL,
	id_alimento INT NOT NULL,
	quantidade INT NOT NULL,
	CONSTRAINT pk_item_alimento PRIMARY KEY (id_refeicao, id_alimento),
	FOREIGN KEY (id_refeicao) REFERENCES refeicao (id),
	FOREIGN KEY (id_alimento) REFERENCES alimento (id)
);