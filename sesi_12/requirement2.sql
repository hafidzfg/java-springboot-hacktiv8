-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `db_company`;
CREATE DATABASE `db_company` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_company`;

DROP TABLE IF EXISTS `dept_location`;
CREATE TABLE `dept_location` (
  `id_dept_location` int(11) NOT NULL AUTO_INCREMENT,
  `dept_no` int(11) NOT NULL,
  `department_location` varchar(32) NOT NULL,
  PRIMARY KEY (`id_dept_location`),
  KEY `dept_no` (`dept_no`),
  CONSTRAINT `dept_location_ibfk_1` FOREIGN KEY (`dept_no`) REFERENCES `tb_department` (`id_dept`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

TRUNCATE `dept_location`;
INSERT INTO `dept_location` (`id_dept_location`, `dept_no`, `department_location`) VALUES
(1,	1,	'1st floor'),
(2,	2,	'2nd floor'),
(3,	3,	'2nd floor'),
(4,	4,	'2nd floor'),
(5,	5,	'11th floor');

DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id_dept` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(11) NOT NULL,
  `department_name` varchar(64) NOT NULL,
  `manager_start_date` date NOT NULL,
  PRIMARY KEY (`id_dept`),
  KEY `id_ssn` (`id_ssn`),
  CONSTRAINT `tb_department_ibfk_2` FOREIGN KEY (`id_ssn`) REFERENCES `tb_employee` (`id_ssn`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_department`;
INSERT INTO `tb_department` (`id_dept`, `id_ssn`, `department_name`, `manager_start_date`) VALUES
(1,	5,	'ceo office',	'2014-09-16'),
(2,	2,	'board of commissioner',	'1956-08-11'),
(3,	4,	'treasury',	'1513-09-17'),
(4,	3,	'legal',	'2021-05-24'),
(5,	1,	'engineering',	'1996-07-24');

DROP TABLE IF EXISTS `tb_dependent`;
CREATE TABLE `tb_dependent` (
  `id_dependent` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(11) NOT NULL,
  `dependent_name` varchar(64) NOT NULL,
  `sex` enum('male','female') NOT NULL,
  `bdate` date NOT NULL,
  `relationship` enum('staff','lead','head') NOT NULL,
  PRIMARY KEY (`id_dependent`),
  KEY `id_ssn` (`id_ssn`),
  CONSTRAINT `tb_dependent_ibfk_1` FOREIGN KEY (`id_ssn`) REFERENCES `tb_employee` (`id_ssn`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_dependent`;
INSERT INTO `tb_dependent` (`id_dependent`, `id_ssn`, `dependent_name`, `sex`, `bdate`, `relationship`) VALUES
(1,	2,	'gatotkaca',	'male',	'1509-11-11',	'staff'),
(2,	2,	'gundala',	'male',	'1989-08-09',	'staff'),
(3,	1,	'guava',	'male',	'1980-02-09',	'lead'),
(4,	3,	'big boss',	'male',	'1903-07-01',	'lead'),
(5,	4,	'beluga whale',	'female',	'1967-12-01',	'head'),
(6,	1,	'rockstar',	'male',	'1943-02-02',	'staff'),
(7,	2,	'rei',	'female',	'1999-09-09',	'lead');

DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id_ssn` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(64) NOT NULL,
  `mname` varchar(64) DEFAULT NULL,
  `lname` varchar(64) NOT NULL,
  `bdate` date NOT NULL,
  `address` varchar(32) NOT NULL,
  `sex` enum('male','female') NOT NULL,
  `salary` float NOT NULL,
  `id_dept` int(11) NOT NULL,
  PRIMARY KEY (`id_ssn`),
  KEY `id_dept` (`id_dept`),
  CONSTRAINT `tb_employee_ibfk_1` FOREIGN KEY (`id_dept`) REFERENCES `tb_department` (`id_dept`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_employee`;
INSERT INTO `tb_employee` (`id_ssn`, `fname`, `mname`, `lname`, `bdate`, `address`, `sex`, `salary`, `id_dept`) VALUES
(1,	'hafidz',	'firmansyah',	'ghufara',	'1997-11-29',	'solo',	'male',	10000000,	5),
(2,	'nadiem',	'a.',	'makarim',	'1984-07-04',	'jakarta',	'male',	12000000,	2),
(3,	'mahatma',	'',	'gandhi',	'1869-10-02',	'mumbai',	'male',	1000,	4),
(4,	'edward',	'',	'kenway',	'1693-03-10',	'swansea',	'male',	20000000,	3),
(5,	'cirilla',	'fionna',	'riannon',	'1251-12-25',	'nilfgaard',	'female',	25000000,	1),
(6,	'liquid',	'c.',	'snake',	'1967-05-11',	'europe',	'male',	7000000,	5),
(7,	'solid',	'c.',	'snake',	'1911-04-12',	'eur',	'male',	32000000,	1),
(8,	'solidus',	'',	'snake',	'1976-05-22',	'unknown',	'male',	12000000,	4);

DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project` (
  `id_project` int(11) NOT NULL AUTO_INCREMENT,
  `id_dept` int(11) NOT NULL,
  `project_name` varchar(64) NOT NULL,
  `project_location` varchar(32) NOT NULL,
  PRIMARY KEY (`id_project`),
  KEY `id_dept` (`id_dept`),
  CONSTRAINT `tb_project_ibfk_1` FOREIGN KEY (`id_dept`) REFERENCES `tb_department` (`id_dept`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_project`;
INSERT INTO `tb_project` (`id_project`, `id_dept`, `project_name`, `project_location`) VALUES
(1,	1,	'series-b funding',	'jakarta'),
(2,	2,	'digital transformation',	'jakarta'),
(3,	4,	'internal audit',	'solo'),
(4,	5,	'create login form',	'tangerang'),
(5,	5,	'create auth',	'jakarta'),
(6,	2,	'transparency',	'jakarta');

DROP TABLE IF EXISTS `tb_works_on`;
CREATE TABLE `tb_works_on` (
  `id_works` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `hours` int(16) NOT NULL,
  PRIMARY KEY (`id_works`),
  KEY `id_ssn` (`id_ssn`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `tb_works_on_ibfk_1` FOREIGN KEY (`id_ssn`) REFERENCES `tb_employee` (`id_ssn`),
  CONSTRAINT `tb_works_on_ibfk_2` FOREIGN KEY (`id_project`) REFERENCES `tb_project` (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_works_on`;
INSERT INTO `tb_works_on` (`id_works`, `id_ssn`, `id_project`, `hours`) VALUES
(1,	1,	4,	40),
(2,	2,	2,	30),
(3,	3,	3,	15),
(4,	4,	3,	50),
(5,	5,	1,	100),
(6,	6,	5,	50),
(7,	6,	4,	100),
(8,	7,	3,	10),
(9,	7,	4,	170),
(10,	8,	1,	100),
(11,	1,	2,	35),
(12,	1,	3,	35),
(13,	1,	4,	50),
(14,	1,	5,	60);

-- 2022-06-21 10:32:21