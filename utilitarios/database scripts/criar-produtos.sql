-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `full-stack-ecommerce`;

CREATE SCHEMA `full-stack-ecommerce`;
USE `full-stack-ecommerce` ;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`produto_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-ecommerce`.`produto_categoria` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `categoria_nome` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-ecommerce`.`produto` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `nome` VARCHAR(255) DEFAULT NULL,
  `descricao` VARCHAR(255) DEFAULT NULL,
  `unidade_preco` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `ativo` BIT DEFAULT 1,
  `unidades_em_estoque` INT(11) DEFAULT NULL,
   `data_criacao` DATETIME(6) DEFAULT NULL,
  `ultimo_updated` DATETIME(6) DEFAULT NULL,
  `categoria_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria` (`categoria_id`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `produto_categoria` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO produto_categoria(categoria_nome) VALUES ('BOOKS');

INSERT INTO produto (sku, nome, descricao, image_url, ativo, unidades_em_estoque,
unidade_preco, categoria_id, data_criacao)
VALUES ('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript',
'assets/images/produtos/placeholder.png'
,1,100,19.99,1, NOW());

INSERT INTO produto (sku, nome, descricao, image_url, ativo, unidades_em_estoque,
unidade_preco, categoria_id, data_criacao)
VALUES ('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring',
'assets/images/produtos/placeholder.png'
,1,100,29.99,1, NOW());

INSERT INTO produto (sku, nome, descricao, image_url, ativo, unidades_em_estoque,
unidade_preco, categoria_id, data_criacao)
VALUES ('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes',
'assets/images/produtos/placeholder.png'
,1,100,24.99,1, NOW());

INSERT INTO produto (sku, nome, descricao, image_url, ativo, unidades_em_estoque,
unidade_preco, categoria_id, data_criacao)
VALUES ('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT',
'assets/images/produtos/placeholder.png'
,1,100,29.99,1, NOW());

INSERT INTO produto (sku, nome, descricao, image_url, ativo, unidades_em_estoque,
unidade_preco, categoria_id, data_criacao)
VALUES ('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go',
'assets/images/produtos/placeholder.png'
,1,100,24.99,1, NOW());
