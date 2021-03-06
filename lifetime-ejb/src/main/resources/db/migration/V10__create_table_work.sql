/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zuacaldeira
 * Created: May 30, 2016
 */
CREATE TABLE IF NOT EXISTS `lifetime`.`work` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `workcol` VARCHAR(45) NULL,
  `lifetime_event_id` INT NOT NULL,
  PRIMARY KEY (`id`, `lifetime_event_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_work_lifetime_event1_idx` (`lifetime_event_id` ASC),
  CONSTRAINT `fk_work_lifetime_event1`
    FOREIGN KEY (`lifetime_event_id`)
    REFERENCES `lifetime`.`lifetime_event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

