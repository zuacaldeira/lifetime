/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zuacaldeira
 * Created: May 29, 2016
 */

-- V3__create_table_address
CREATE TABLE IF NOT EXISTS `lifetime`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `locality` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(15) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
) ENGINE = InnoDB

