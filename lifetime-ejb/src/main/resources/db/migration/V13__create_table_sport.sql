/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zuacaldeira
 * Created: May 30, 2016
 */

CREATE TABLE IF NOT EXISTS `lifetime`.`sport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modality` VARCHAR(45) NOT NULL,
  `lifetime_event_id` INT NOT NULL,
  PRIMARY KEY (`id`, `lifetime_event_id`),
  INDEX `fk_sport_lifetime_event1_idx` (`lifetime_event_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_sport_lifetime_event1`
    FOREIGN KEY (`lifetime_event_id`)
    REFERENCES `lifetime`.`lifetime_event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
