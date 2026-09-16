-- HSO Inventory database schema
-- Fresh install script for MySQL / MariaDB

CREATE DATABASE IF NOT EXISTS hso_database
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE hso_database;

DROP TABLE IF EXISTS removed_equipment;
DROP TABLE IF EXISTS removed_medicine;
DROP TABLE IF EXISTS equipment_borrowers;
DROP TABLE IF EXISTS medicine_takers;
DROP TABLE IF EXISTS equipment_inventory;
DROP TABLE IF EXISTS medicine_inventory;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  user_id INT NOT NULL AUTO_INCREMENT,
  fname VARCHAR(100) NOT NULL,
  lname VARCHAR(100) NOT NULL,
  username VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id),
  UNIQUE KEY uk_user_username (username),
  UNIQUE KEY uk_user_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE medicine_inventory (
  md_id INT NOT NULL AUTO_INCREMENT,
  added_by VARCHAR(100) NOT NULL,
  md_date DATE NOT NULL,
  md_item VARCHAR(255) NOT NULL,
  md_quantity INT NOT NULL DEFAULT 0,
  md_disposed INT NOT NULL DEFAULT 0,
  md_expiry DATE NOT NULL,
  md_remarks TEXT,
  md_totalquantity INT NOT NULL DEFAULT 0,
  PRIMARY KEY (md_id),
  KEY idx_medicine_inventory_date (md_date),
  KEY idx_medicine_inventory_expiry (md_expiry),
  KEY idx_medicine_inventory_added_by (added_by)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE equipment_inventory (
  eq_id INT NOT NULL AUTO_INCREMENT,
  added_by VARCHAR(100) NOT NULL,
  eq_date DATE NOT NULL,
  eq_item VARCHAR(255) NOT NULL,
  eq_quantity INT NOT NULL DEFAULT 0,
  eq_disposed INT NOT NULL DEFAULT 0,
  eq_expiry DATE NOT NULL,
  eq_remarks TEXT,
  eq_totalquantity INT NOT NULL DEFAULT 0,
  PRIMARY KEY (eq_id),
  KEY idx_equipment_inventory_date (eq_date),
  KEY idx_equipment_inventory_expiry (eq_expiry),
  KEY idx_equipment_inventory_added_by (added_by)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE medicine_takers (
  md_id INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(100) NOT NULL,
  md_patient_id VARCHAR(50) NOT NULL,
  md_date DATE NOT NULL,
  md_fname VARCHAR(255) NOT NULL,
  md_sex VARCHAR(20) NOT NULL,
  md_department VARCHAR(100) NOT NULL,
  md_time VARCHAR(20) NOT NULL,
  md_medication VARCHAR(255) NOT NULL,
  PRIMARY KEY (md_id),
  KEY idx_medicine_takers_date (md_date),
  KEY idx_medicine_takers_patient (md_patient_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE equipment_borrowers (
  eq_id INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(100) NOT NULL,
  eq_patient_id VARCHAR(50) NOT NULL,
  eq_fname VARCHAR(255) NOT NULL,
  eq_gender VARCHAR(20) NOT NULL,
  eq_department VARCHAR(100) NOT NULL,
  eq_date DATE NOT NULL,
  eq_timeBorrowed VARCHAR(20) NOT NULL,
  eq_equip_id INT NOT NULL,
  eq_equipment VARCHAR(255) NOT NULL,
  PRIMARY KEY (eq_id),
  KEY idx_equipment_borrowers_date (eq_date),
  KEY idx_equipment_borrowers_equipment (eq_equip_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE removed_medicine (
  md_id INT NOT NULL,
  added_by VARCHAR(100) DEFAULT NULL,
  md_date DATE NOT NULL,
  md_item VARCHAR(255) NOT NULL,
  md_quantity INT NOT NULL DEFAULT 0,
  md_dispensed INT NOT NULL DEFAULT 0,
  md_expiry DATE NOT NULL,
  md_remarks TEXT,
  md_totalquantity INT NOT NULL DEFAULT 0,
  PRIMARY KEY (md_id),
  KEY idx_removed_medicine_date (md_date),
  KEY idx_removed_medicine_expiry (md_expiry),
  KEY idx_removed_medicine_added_by (added_by)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE removed_equipment (
  eq_id INT NOT NULL,
  added_by VARCHAR(100) DEFAULT NULL,
  eq_date DATE NOT NULL,
  eq_item VARCHAR(255) NOT NULL,
  eq_quantity INT NOT NULL DEFAULT 0,
  eq_dispensed INT NOT NULL DEFAULT 0,
  eq_expiry DATE NOT NULL,
  eq_remarks TEXT,
  eq_totalquantity INT NOT NULL DEFAULT 0,
  PRIMARY KEY (eq_id),
  KEY idx_removed_equipment_date (eq_date),
  KEY idx_removed_equipment_expiry (eq_expiry),
  KEY idx_removed_equipment_added_by (added_by)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
