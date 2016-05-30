/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zuacaldeira
 * Created: May 30, 2016
 */
CREATE TABLE IF NOT EXISTS `lifetime`.`lifetime_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_lifetime_user_address1_idx` (`address_id` ASC),
  INDEX `fk_lifetime_user_account1_idx` (`account_id` ASC),
  CONSTRAINT `fk_lifetime_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `lifetime`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_user_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `lifetime`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

