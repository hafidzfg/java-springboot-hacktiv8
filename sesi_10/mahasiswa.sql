-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `db_mahasiswa`;
CREATE DATABASE `db_mahasiswa` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_mahasiswa`;

DROP TABLE IF EXISTS `tb_dosen`;
CREATE TABLE `tb_dosen` (
  `id_dosen` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(64) NOT NULL,
  `umur` int(4) NOT NULL,
  PRIMARY KEY (`id_dosen`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_dosen`;
INSERT INTO `tb_dosen` (`id_dosen`, `nama`, `umur`) VALUES
(1,	'sarl cagan',	62),
(2,	'j. nash',	86);

DROP TABLE IF EXISTS `tb_mahasiswa`;
CREATE TABLE `tb_mahasiswa` (
  `nim` int(16) NOT NULL AUTO_INCREMENT,
  `nama` varchar(64) NOT NULL,
  `alamat` varchar(8) NOT NULL,
  `id_ortu` int(11) NOT NULL,
  PRIMARY KEY (`nim`),
  KEY `id_ortu` (`id_ortu`),
  CONSTRAINT `tb_mahasiswa_ibfk_1` FOREIGN KEY (`id_ortu`) REFERENCES `tb_ortu` (`id_ortu`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_mahasiswa`;
INSERT INTO `tb_mahasiswa` (`nim`, `nama`, `alamat`, `id_ortu`) VALUES
(1,	'ezio auditore',	'firenze',	3),
(2,	'haytham kenway',	'USA',	2),
(3,	'barbarossa jr.',	'kanaan',	1);

DROP TABLE IF EXISTS `tb_matkul`;
CREATE TABLE `tb_matkul` (
  `id_matkul` int(8) NOT NULL AUTO_INCREMENT,
  `nama_matkul` varchar(32) NOT NULL,
  `sks` int(8) NOT NULL,
  `harga` int(16) NOT NULL,
  PRIMARY KEY (`id_matkul`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_matkul`;
INSERT INTO `tb_matkul` (`id_matkul`, `nama_matkul`, `sks`, `harga`) VALUES
(1,	'embedded system programming',	4,	50000),
(2,	'optimization',	3,	35000),
(3,	'artificial neural network',	4,	5000);

DROP TABLE IF EXISTS `tb_ortu`;
CREATE TABLE `tb_ortu` (
  `id_ortu` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(64) NOT NULL,
  `tgl_lahir` date NOT NULL,
  PRIMARY KEY (`id_ortu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_ortu`;
INSERT INTO `tb_ortu` (`id_ortu`, `nama`, `tgl_lahir`) VALUES
(1,	'barbarossa',	'1545-08-06'),
(2,	'edward kenway',	'1693-03-10'),
(3,	'giovanni auditore',	'1436-05-03');

-- 2022-06-20 11:41:08