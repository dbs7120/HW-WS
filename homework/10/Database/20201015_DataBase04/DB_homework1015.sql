-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema product_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema product_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `product_db` DEFAULT CHARACTER SET utf8 ;
USE `product_db` ;

-- -----------------------------------------------------
-- Table `product_db`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_db`.`Product` ;

CREATE TABLE IF NOT EXISTS `product_db`.`Product` (
  `productid` INT NOT NULL,
  `pname` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `amount` INT NULL,
  PRIMARY KEY (`productid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_db`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_db`.`Customer` ;

CREATE TABLE IF NOT EXISTS `product_db`.`Customer` (
  `userid` INT NOT NULL,
  `username` VARCHAR(10) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `contact1` VARCHAR(20) NOT NULL,
  `contact2` VARCHAR(20) NULL,
  `Customercol` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_db`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_db`.`Order` ;

CREATE TABLE IF NOT EXISTS `product_db`.`Order` (
  `orderid` INT NOT NULL,
  `userid` INT NOT NULL,
  `productid` INT NOT NULL,
  `orderprice` VARCHAR(45) NULL,
  `ordered` TINYINT NULL,
  `delivered` TINYINT NULL,
  PRIMARY KEY (`orderid`, `userid`, `productid`),
  INDEX `product_productid_pk_idx` (`productid` ASC) VISIBLE,
  CONSTRAINT `product_productid_fk`
    FOREIGN KEY (`productid`)
    REFERENCES `product_db`.`Product` (`productid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_userid_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `product_db`.`Customer` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
