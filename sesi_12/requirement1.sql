-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `db_melodiindah`;
CREATE DATABASE `db_melodiindah` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_melodiindah`;

DROP VIEW IF EXISTS `instrumen_musisi`;
CREATE TABLE `instrumen_musisi` (`nama` varchar(64), `alamat` varchar(64), `nama_instrumen` varchar(32), `kunci_musik` varchar(8));


DROP VIEW IF EXISTS `pengarang_album`;
CREATE TABLE `pengarang_album` (`judul` varchar(64), `pengarang` varchar(64), `nama_album` varchar(32), `tgl_copyright` date, `format` enum('cd','mc'), `id_album` int(11));


DROP TABLE IF EXISTS `tb_album`;
CREATE TABLE `tb_album` (
  `id_album` int(11) NOT NULL AUTO_INCREMENT,
  `nama_album` varchar(32) NOT NULL,
  `tgl_copyright` date NOT NULL,
  `format` enum('cd','mc') NOT NULL,
  `ssn` int(11) NOT NULL,
  PRIMARY KEY (`id_album`),
  KEY `ssn` (`ssn`),
  CONSTRAINT `tb_album_ibfk_1` FOREIGN KEY (`ssn`) REFERENCES `tb_musisi` (`ssn`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_album`;
INSERT INTO `tb_album` (`id_album`, `nama_album`, `tgl_copyright`, `format`, `ssn`) VALUES
(1,	'Humbug',	'2020-05-01',	'mc',	2),
(2,	'TBHC',	'2000-03-05',	'cd',	2),
(3,	'Gravity',	'2007-08-29',	'cd',	4),
(4,	'ebook',	'2005-02-15',	'cd',	1),
(5,	'sample a',	'2012-11-11',	'mc',	2);

DROP TABLE IF EXISTS `tb_combine_musik`;
CREATE TABLE `tb_combine_musik` (
  `id_combine` int(11) NOT NULL AUTO_INCREMENT,
  `ssn` int(11) NOT NULL,
  `id_instrumen` int(11) NOT NULL,
  PRIMARY KEY (`id_combine`),
  KEY `ssn` (`ssn`),
  KEY `id_instrumen` (`id_instrumen`),
  CONSTRAINT `tb_combine_musik_ibfk_1` FOREIGN KEY (`ssn`) REFERENCES `tb_musisi` (`ssn`) ON DELETE NO ACTION,
  CONSTRAINT `tb_combine_musik_ibfk_2` FOREIGN KEY (`id_instrumen`) REFERENCES `tb_instrumen` (`id_instrumen`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_combine_musik`;
INSERT INTO `tb_combine_musik` (`id_combine`, `ssn`, `id_instrumen`) VALUES
(1,	1,	1),
(2,	1,	2),
(3,	1,	3),
(4,	2,	1),
(5,	2,	4),
(6,	2,	7),
(7,	3,	8),
(8,	4,	1),
(9,	4,	2),
(10,	4,	3),
(11,	4,	5);

DROP TABLE IF EXISTS `tb_instrumen`;
CREATE TABLE `tb_instrumen` (
  `id_instrumen` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(32) NOT NULL,
  `kunci_musik` varchar(8) NOT NULL,
  PRIMARY KEY (`id_instrumen`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_instrumen`;
INSERT INTO `tb_instrumen` (`id_instrumen`, `nama`, `kunci_musik`) VALUES
(1,	'gitar',	'c#'),
(2,	'gitar',	'f'),
(3,	'gitar',	'c'),
(4,	'gitar',	'g'),
(5,	'gitar',	'e'),
(6,	'keyboard',	'a'),
(7,	'keyboard',	'am'),
(8,	'keyboard',	'g'),
(9,	'keyboard',	'gm'),
(10,	'keyboard',	'ab');

DROP TABLE IF EXISTS `tb_lagu`;
CREATE TABLE `tb_lagu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(64) NOT NULL,
  `pengarang` varchar(64) NOT NULL,
  `id_album` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_album` (`id_album`),
  CONSTRAINT `tb_lagu_ibfk_1` FOREIGN KEY (`id_album`) REFERENCES `tb_album` (`id_album`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_lagu`;
INSERT INTO `tb_lagu` (`id`, `judul`, `pengarang`, `id_album`) VALUES
(1,	'ultracheese',	'alex turner',	2),
(2,	'gravity',	'john mayer',	3),
(3,	'thinking fast and slow',	'd. kahneman',	4),
(4,	'cornerstone',	'alex turner',	1),
(5,	'secret door',	'alex turner',	1);

DROP TABLE IF EXISTS `tb_musisi`;
CREATE TABLE `tb_musisi` (
  `ssn` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(64) NOT NULL,
  `alamat` varchar(64) NOT NULL,
  `nomor_telepon` varchar(64) NOT NULL,
  PRIMARY KEY (`ssn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_musisi`;
INSERT INTO `tb_musisi` (`ssn`, `nama`, `alamat`, `nomor_telepon`) VALUES
(1,	'd. kahneman',	'USA',	'165728495051'),
(2,	'alex turner',	'USA',	'168290683231'),
(3,	'w. r. supratman',	'ID',	'6285294018827'),
(4,	'john mayer',	'USA',	'167286018266');

DROP TABLE IF EXISTS `instrumen_musisi`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `instrumen_musisi` AS select `tm`.`nama` AS `nama`,`tm`.`alamat` AS `alamat`,`ti`.`nama` AS `nama_instrumen`,`ti`.`kunci_musik` AS `kunci_musik` from ((`tb_combine_musik` `tcm` join `tb_instrumen` `ti` on(`ti`.`id_instrumen` = `tcm`.`id_instrumen`)) join `tb_musisi` `tm` on(`tm`.`ssn` = `tcm`.`ssn`));

DROP TABLE IF EXISTS `pengarang_album`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `pengarang_album` AS select `tl`.`judul` AS `judul`,`tl`.`pengarang` AS `pengarang`,`ta`.`nama_album` AS `nama_album`,`ta`.`tgl_copyright` AS `tgl_copyright`,`ta`.`format` AS `format`,`ta`.`id_album` AS `id_album` from (`tb_lagu` `tl` join `tb_album` `ta` on(`ta`.`id_album` = `tl`.`id_album`));

-- 2022-06-21 05:52:37