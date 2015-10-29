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

-- Copiando estrutura do banco de dados para controle_calorias
DROP DATABASE IF EXISTS `controle_calorias`;
CREATE DATABASE IF NOT EXISTS `controle_calorias` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `controle_calorias`;


-- Copiando estrutura para tabela controle_calorias.alimento
DROP TABLE IF EXISTS `alimento`;
CREATE TABLE IF NOT EXISTS `alimento` (
  `alimento_id` int(11) NOT NULL AUTO_INCREMENT,
  `alimento_sysdata` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `alimento_valor_energetico` double(10,2) NOT NULL,
  `porcao_id` int(11) NOT NULL DEFAULT '1',
  `alimento_valor_porcao` int(11) NOT NULL,
  `alimento_proteinas` double(10,2) NOT NULL,
  `alimento_fibras` double(10,2) NOT NULL,
  `alimento_carboidratos` double(10,2) NOT NULL,
  `alimento_sodio` double(10,2) NOT NULL,
  `alimento_gorduras_totais` double(10,2) NOT NULL,
  `alimento_gorduras_saturadas` double(10,2) NOT NULL,
  `alimento_gorduras_trans` double(10,2) NOT NULL,
  `alimento_ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`alimento_id`),
  KEY `porcao_id` (`porcao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela controle_calorias.alimento: ~0 rows (aproximadamente)
DELETE FROM `alimento`;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;


-- Copiando estrutura para tabela controle_calorias.item_refeicao
DROP TABLE IF EXISTS `item_refeicao`;
CREATE TABLE IF NOT EXISTS `item_refeicao` (
  `refeicao_id` int(11) NOT NULL,
  `alimento_id` int(11) NOT NULL,
  `item_refeicao_quantidade` int(11) NOT NULL,
  PRIMARY KEY (`refeicao_id`,`alimento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela controle_calorias.item_refeicao: ~0 rows (aproximadamente)
DELETE FROM `item_refeicao`;
/*!40000 ALTER TABLE `item_refeicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_refeicao` ENABLE KEYS */;


-- Copiando estrutura para tabela controle_calorias.porcao
DROP TABLE IF EXISTS `porcao`;
CREATE TABLE IF NOT EXISTS `porcao` (
  `porcao_id` int(11) NOT NULL AUTO_INCREMENT,
  `porcao_descricao` varchar(30) NOT NULL,
  `porcao_ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`porcao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela controle_calorias.porcao: ~0 rows (aproximadamente)
DELETE FROM `porcao`;
/*!40000 ALTER TABLE `porcao` DISABLE KEYS */;
INSERT INTO `porcao` (`porcao_id`, `porcao_descricao`, `porcao_ativo`) VALUES
	(1, 'ML', 1),
	(2, 'GR', 1),
	(3, 'UNIDADE', 1);
/*!40000 ALTER TABLE `porcao` ENABLE KEYS */;


-- Copiando estrutura para tabela controle_calorias.refeicao
DROP TABLE IF EXISTS `refeicao`;
CREATE TABLE IF NOT EXISTS `refeicao` (
  `refeicao_id` int(11) NOT NULL AUTO_INCREMENT,
  `refeicao_data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo_refeicao_id` int(11) NOT NULL DEFAULT '1',
  `refeicao_ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`refeicao_id`),
  KEY `tipo_refeicao_id` (`tipo_refeicao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela controle_calorias.refeicao: ~0 rows (aproximadamente)
DELETE FROM `refeicao`;
/*!40000 ALTER TABLE `refeicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `refeicao` ENABLE KEYS */;


-- Copiando estrutura para tabela controle_calorias.tipo_refeicao
DROP TABLE IF EXISTS `tipo_refeicao`;
CREATE TABLE IF NOT EXISTS `tipo_refeicao` (
  `tipo_refeicao_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_refeicao_descricao` varchar(100) NOT NULL,
  `tipo_refeicao_ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tipo_refeicao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela controle_calorias.tipo_refeicao: ~0 rows (aproximadamente)
DELETE FROM `tipo_refeicao`;
/*!40000 ALTER TABLE `tipo_refeicao` DISABLE KEYS */;
INSERT INTO `tipo_refeicao` (`tipo_refeicao_id`, `tipo_refeicao_descricao`, `tipo_refeicao_ativo`) VALUES
	(1, 'Café da Manhã', 1),
	(2, 'Lanche da Manhã', 1),
	(3, 'Almoço', 1),
	(4, 'Lanche da Tarde', 1),
	(5, 'Jantar', 1),
	(6, 'Ceia', 1);
/*!40000 ALTER TABLE `tipo_refeicao` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
