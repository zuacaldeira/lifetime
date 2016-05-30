/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zuacaldeira
 * Created: May 30, 2016
 */

CREATE TABLE IF NOT EXISTS `lifetime`.`lifetime_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `event_start` DATE NULL,
  `event_end` DATE NULL,
  `status` ENUM('CREATED', 'RUNNING', 'PAUSED', 'STOPPED', 'FINISHED') NULL DEFAULT 'CREATED',
  `lifetime_user_id` INT NOT NULL,
  `lifetime_org_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_lifetime_event_lifetime_user1_idx` (`lifetime_user_id` ASC),
  INDEX `fk_lifetime_event_lifetime_org1_idx` (`lifetime_org_id` ASC),
  INDEX `fk_lifetime_event_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_lifetime_event_lifetime_user1`
    FOREIGN KEY (`lifetime_user_id`)
    REFERENCES `lifetime`.`lifetime_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_event_lifetime_org1`
    FOREIGN KEY (`lifetime_org_id`)
    REFERENCES `lifetime`.`lifetime_org` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_event_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `lifetime`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
