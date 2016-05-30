/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  zuacaldeira
 * Created: May 30, 2016
 */

CREATE TABLE IF NOT EXISTS `lifetime`.`competition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `performance` INT UNSIGNED NULL,
  `sport_id` INT NOT NULL,
  `sport_lifetime_event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_competition_sport1_idx` (`sport_id` ASC, `sport_lifetime_event_id` ASC),
  CONSTRAINT `fk_competition_sport1`
    FOREIGN KEY (`sport_id` , `sport_lifetime_event_id`)
    REFERENCES `lifetime`.`sport` (`id` , `lifetime_event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
