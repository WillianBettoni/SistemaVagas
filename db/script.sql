#DROP DATABASE IF EXISTS curriculo
CREATE DATABASE IF NOT EXISTS curriculo;
USE curriculo;

CREATE TABLE IF NOT EXISTS `curriculo`.`usuario` (
  `usuario_id` INT NOT NULL AUTO_INCREMENT,
  `usuario_login` VARCHAR(255) NULL,
  `usuario_senha` VARCHAR(255) NULL,
  `usuario_email` VARCHAR(255) NULL,
  PRIMARY KEY (`usuario_id`))
ENGINE = InnoDB;