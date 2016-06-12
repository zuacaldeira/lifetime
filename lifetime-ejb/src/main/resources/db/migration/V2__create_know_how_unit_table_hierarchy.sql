-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lifetime
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lifetime
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lifetime` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema semantic
-- -----------------------------------------------------
USE `lifetime` ;

-- -----------------------------------------------------
-- Table `lifetime`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `locality` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(15) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`photo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` LONGBLOB NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`lifetime_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`lifetime_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  `photo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_lifetime_user_address1_idx` (`address_id` ASC),
  INDEX `fk_lifetime_user_account1_idx` (`account_id` ASC),
  INDEX `fk_lifetime_user_photo1_idx` (`photo_id` ASC),
  CONSTRAINT `fk_lifetime_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `lifetime`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_user_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `lifetime`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_user_photo1`
    FOREIGN KEY (`photo_id`)
    REFERENCES `lifetime`.`photo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`lifetime_org`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`lifetime_org` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `photo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_lifetime_org_account1_idx` (`account_id` ASC),
  INDEX `fk_lifetime_org_address1_idx` (`address_id` ASC),
  INDEX `fk_lifetime_org_photo1_idx` (`photo_id` ASC),
  CONSTRAINT `fk_lifetime_org_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `lifetime`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_org_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `lifetime`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lifetime_org_photo1`
    FOREIGN KEY (`photo_id`)
    REFERENCES `lifetime`.`photo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`lifetime_event`
-- -----------------------------------------------------
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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`study`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`study` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lifetime_event_id` INT NOT NULL,
  PRIMARY KEY (`id`, `lifetime_event_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_study_lifetime_event1_idx` (`lifetime_event_id` ASC),
  CONSTRAINT `fk_study_lifetime_event1`
    FOREIGN KEY (`lifetime_event_id`)
    REFERENCES `lifetime`.`lifetime_event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `study_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_course_study1_idx` (`study_id` ASC),
  CONSTRAINT `fk_course_study1`
    FOREIGN KEY (`study_id`)
    REFERENCES `lifetime`.`study` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`lecture` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_lecture_course1_idx` (`course_id` ASC),
  CONSTRAINT `fk_lecture_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `lifetime`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`work`
-- -----------------------------------------------------
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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(255) NULL,
  `work_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_project_work1_idx` (`work_id` ASC),
  CONSTRAINT `fk_project_work1`
    FOREIGN KEY (`work_id`)
    REFERENCES `lifetime`.`work` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(255) NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_task_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_task_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `lifetime`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`sport`
-- -----------------------------------------------------
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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`training` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `sport_id` INT NOT NULL,
  `sport_lifetime_event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_training_sport1_idx` (`sport_id` ASC, `sport_lifetime_event_id` ASC),
  CONSTRAINT `fk_training_sport1`
    FOREIGN KEY (`sport_id` , `sport_lifetime_event_id`)
    REFERENCES `lifetime`.`sport` (`id` , `lifetime_event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`competition`
-- -----------------------------------------------------
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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`know_how_unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`know_how_unit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `summary` VARCHAR(255) NULL,
  `content` VARCHAR(1024) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`knowledge_unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`knowledge_unit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `know_how_unit_id` INT NOT NULL,
  `lecture_id` INT NOT NULL,
  PRIMARY KEY (`id`, `know_how_unit_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_knowledge_unit_know_how_unit1_idx` (`know_how_unit_id` ASC),
  INDEX `fk_knowledge_unit_lecture1_idx` (`lecture_id` ASC),
  CONSTRAINT `fk_knowledge_unit_know_how_unit1`
    FOREIGN KEY (`know_how_unit_id`)
    REFERENCES `lifetime`.`know_how_unit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_knowledge_unit_lecture1`
    FOREIGN KEY (`lecture_id`)
    REFERENCES `lifetime`.`lecture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lifetime`.`work_unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lifetime`.`work_unit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `know_how_unit_id` INT NOT NULL,
  `task_id` INT NOT NULL,
  PRIMARY KEY (`id`, `know_how_unit_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_work_unit_know_how_unit1_idx` (`know_how_unit_id` ASC),
  INDEX `fk_work_unit_task1_idx` (`task_id` ASC),
  CONSTRAINT `fk_work_unit_know_how_unit1`
    FOREIGN KEY (`know_how_unit_id`)
    REFERENCES `lifetime`.`know_how_unit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_work_unit_task1`
    FOREIGN KEY (`task_id`)
    REFERENCES `lifetime`.`task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
