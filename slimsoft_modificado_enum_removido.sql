-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.17 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para slimsoft
DROP DATABASE IF EXISTS `slimsoft`;
CREATE DATABASE IF NOT EXISTS `slimsoft` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `slimsoft`;


-- Copiando estrutura para tabela slimsoft.alimento
DROP TABLE IF EXISTS `alimento`;
CREATE TABLE IF NOT EXISTS `alimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `valor_energetico` float(10,2) NOT NULL,
  `id_porcao` int(11) NOT NULL,
  `valor_porcao` float(10,2) NOT NULL,
  `proteinas` float(10,2) NOT NULL,
  `fibras` float(10,2) NOT NULL,
  `carboidratos` float(10,2) NOT NULL,
  `sodio` float(10,2) NOT NULL,
  `gorduras_totais` float(10,2) NOT NULL,
  `gorduras_saturadas` float(10,2) NOT NULL,
  `gorduras_trans` float(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_porcao` (`id_porcao`),
  CONSTRAINT `porcao_id` FOREIGN KEY (`id_porcao`) REFERENCES `porcao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.alimento: ~4 rows (aproximadamente)
DELETE FROM `alimento`;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` (`id`, `nome`, `valor_energetico`, `id_porcao`, `valor_porcao`, `proteinas`, `fibras`, `carboidratos`, `sodio`, `gorduras_totais`, `gorduras_saturadas`, `gorduras_trans`) VALUES
	(4, 'Arroz', 50.00, 3, 50.00, 50.00, 50.00, 50.00, 50.00, 50.00, 50.00, 50.00),
	(5, 'Feijão', 50.00, 3, 50.00, 50.00, 50.00, 50.00, 50.00, 50.00, 50.00, 50.00);
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.atividade_fisica
DROP TABLE IF EXISTS `atividade_fisica`;
CREATE TABLE IF NOT EXISTS `atividade_fisica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `gasto_calorico` float(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.atividade_fisica: ~0 rows (aproximadamente)
DELETE FROM `atividade_fisica`;
/*!40000 ALTER TABLE `atividade_fisica` DISABLE KEYS */;
/*!40000 ALTER TABLE `atividade_fisica` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.historico
DROP TABLE IF EXISTS `historico`;
CREATE TABLE IF NOT EXISTS `historico` (
  `id_usuario` int(11) NOT NULL,
  `data_historico` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `imc` float(10,2) NOT NULL,
  `tbm_normal` float(10,2) NOT NULL,
  `tbm_recomendada` float(10,2) NOT NULL,
  `peso` float(10,2) NOT NULL,
  `consumo_calorico` float(10,2) NOT NULL,
  `gasto_calorico` float(10,2) NOT NULL,
  PRIMARY KEY (`id_usuario`,`data_historico`),
  CONSTRAINT `historico_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.historico: ~0 rows (aproximadamente)
DELETE FROM `historico`;
/*!40000 ALTER TABLE `historico` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.intensidade
DROP TABLE IF EXISTS `intensidade`;
CREATE TABLE IF NOT EXISTS `intensidade` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.intensidade: ~4 rows (aproximadamente)
DELETE FROM `intensidade`;
/*!40000 ALTER TABLE `intensidade` DISABLE KEYS */;
INSERT INTO `intensidade` (`id`, `nome`) VALUES
	(1, 'LEVE'),
	(2, 'MODERADA'),
	(3, 'INTENSA'),
	(4, 'MUITO_INTENSA');
/*!40000 ALTER TABLE `intensidade` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.item_refeicao
DROP TABLE IF EXISTS `item_refeicao`;
CREATE TABLE IF NOT EXISTS `item_refeicao` (
  `id_refeicao` int(11) NOT NULL,
  `id_alimento` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id_refeicao`,`id_alimento`),
  KEY `id_alimento` (`id_alimento`),
  CONSTRAINT `item_refeicao_ibfk_1` FOREIGN KEY (`id_refeicao`) REFERENCES `refeicao` (`id`),
  CONSTRAINT `item_refeicao_ibfk_2` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.item_refeicao: ~0 rows (aproximadamente)
DELETE FROM `item_refeicao`;
/*!40000 ALTER TABLE `item_refeicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_refeicao` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.meta
DROP TABLE IF EXISTS `meta`;
CREATE TABLE IF NOT EXISTS `meta` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.meta: ~3 rows (aproximadamente)
DELETE FROM `meta`;
/*!40000 ALTER TABLE `meta` DISABLE KEYS */;
INSERT INTO `meta` (`id`, `nome`) VALUES
	(1, 'PERDER PESO'),
	(2, 'MANTER PESO'),
	(3, 'GANHAR PESO');
/*!40000 ALTER TABLE `meta` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.nivel_atividade_fisica
DROP TABLE IF EXISTS `nivel_atividade_fisica`;
CREATE TABLE IF NOT EXISTS `nivel_atividade_fisica` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.nivel_atividade_fisica: ~5 rows (aproximadamente)
DELETE FROM `nivel_atividade_fisica`;
/*!40000 ALTER TABLE `nivel_atividade_fisica` DISABLE KEYS */;
INSERT INTO `nivel_atividade_fisica` (`id`, `nome`) VALUES
	(1, 'SEDENTARIA'),
	(2, 'LIGEIRA'),
	(3, 'MODERADA'),
	(4, 'INTENSA'),
	(5, 'MUITO_INTENSA');
/*!40000 ALTER TABLE `nivel_atividade_fisica` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.porcao
DROP TABLE IF EXISTS `porcao`;
CREATE TABLE IF NOT EXISTS `porcao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.porcao: ~3 rows (aproximadamente)
DELETE FROM `porcao`;
/*!40000 ALTER TABLE `porcao` DISABLE KEYS */;
INSERT INTO `porcao` (`id`, `desc`) VALUES
	(1, 'ml'),
	(2, 'g'),
	(3, 'unidade');
/*!40000 ALTER TABLE `porcao` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.refeicao
DROP TABLE IF EXISTS `refeicao`;
CREATE TABLE IF NOT EXISTS `refeicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `data_refeicao` datetime NOT NULL,
  `id_tipo_refeicao` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_tipo_refeicao` (`id_tipo_refeicao`),
  CONSTRAINT `refeicao_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `refeicao_ibfk_2` FOREIGN KEY (`id_tipo_refeicao`) REFERENCES `tipo_refeicao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.refeicao: ~1 rows (aproximadamente)
DELETE FROM `refeicao`;
/*!40000 ALTER TABLE `refeicao` DISABLE KEYS */;
INSERT INTO `refeicao` (`id`, `id_usuario`, `data_refeicao`, `id_tipo_refeicao`) VALUES
	(1, 9, '2015-11-24 13:10:27', 3);
/*!40000 ALTER TABLE `refeicao` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.registro_atividade
DROP TABLE IF EXISTS `registro_atividade`;
CREATE TABLE IF NOT EXISTS `registro_atividade` (
  `id_usuario` int(11) NOT NULL,
  `id_atividade` int(11) NOT NULL,
  `data_atividade` datetime NOT NULL,
  `duracao` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_atividade`,`data_atividade`),
  KEY `id_atividade` (`id_atividade`),
  CONSTRAINT `registro_atividade_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `registro_atividade_ibfk_2` FOREIGN KEY (`id_atividade`) REFERENCES `atividade_fisica` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.registro_atividade: ~0 rows (aproximadamente)
DELETE FROM `registro_atividade`;
/*!40000 ALTER TABLE `registro_atividade` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_atividade` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.tipo_refeicao
DROP TABLE IF EXISTS `tipo_refeicao`;
CREATE TABLE IF NOT EXISTS `tipo_refeicao` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.tipo_refeicao: ~6 rows (aproximadamente)
DELETE FROM `tipo_refeicao`;
/*!40000 ALTER TABLE `tipo_refeicao` DISABLE KEYS */;
INSERT INTO `tipo_refeicao` (`id`, `nome`) VALUES
	(1, 'Café da Manhã'),
	(2, 'Lanche da Manhã'),
	(3, 'Almoço'),
	(4, 'Lanche da Tarde'),
	(5, 'Jantar'),
	(6, 'Ceia');
/*!40000 ALTER TABLE `tipo_refeicao` ENABLE KEYS */;


-- Copiando estrutura para tabela slimsoft.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `altura` float(10,2) NOT NULL,
  `peso` float(10,2) NOT NULL,
  `peso_desejado` float(10,2) NOT NULL,
  `id_meta` tinyint(4) NOT NULL,
  `id_intensidade` tinyint(4) NOT NULL,
  `id_nivel_atividade_fisica` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_meta` (`id_meta`),
  KEY `id_intensidade` (`id_intensidade`),
  KEY `id_nivel_atividade_fisica` (`id_nivel_atividade_fisica`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_meta`) REFERENCES `meta` (`id`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_intensidade`) REFERENCES `intensidade` (`id`),
  CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`id_nivel_atividade_fisica`) REFERENCES `nivel_atividade_fisica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela slimsoft.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nome`, `data_nascimento`, `altura`, `peso`, `peso_desejado`, `id_meta`, `id_intensidade`, `id_nivel_atividade_fisica`) VALUES
	(8, 'Rafael', '1994-04-29', 179.00, 62.30, 67.00, 3, 1, 1),
	(9, 'João', '1984-04-29', 179.00, 62.30, 67.00, 3, 1, 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
