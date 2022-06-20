-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `employee`;
CREATE DATABASE `employee` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `employee`;

DROP VIEW IF EXISTS `data_gaji`;
CREATE TABLE `data_gaji` (`id_pegawai` int(11), `nama_pegawai` varchar(64), `jabatan` varchar(16), `gaji` float);


DROP VIEW IF EXISTS `data_transaksi`;
CREATE TABLE `data_transaksi` (`id_transaksi` int(11), `nama_pembeli` varchar(64), `nama_menu` varchar(32), `nama_pegawai` varchar(64), `tgl_transaksi` date);


DROP TABLE IF EXISTS `tb_gaji`;
CREATE TABLE `tb_gaji` (
  `id_asli` int(11) NOT NULL AUTO_INCREMENT,
  `id_pegawai` int(11) NOT NULL,
  `gaji` float NOT NULL,
  `tgl_gaji` date NOT NULL,
  PRIMARY KEY (`id_asli`),
  KEY `id_pegawai` (`id_pegawai`),
  CONSTRAINT `tb_gaji_ibfk_2` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2011 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_gaji`;
INSERT INTO `tb_gaji` (`id_asli`, `id_pegawai`, `gaji`, `tgl_gaji`) VALUES
(2001,	1,	2000000,	'2012-12-01'),
(2002,	2,	1800000,	'2012-12-01'),
(2003,	3,	1500000,	'2012-12-01'),
(2004,	4,	3500000,	'2012-12-01'),
(2005,	5,	4000000,	'2012-12-01'),
(2006,	6,	2500000,	'2012-12-01'),
(2007,	7,	1500000,	'2012-12-01'),
(2008,	8,	1000000,	'2012-12-01'),
(2009,	9,	3500000,	'2012-12-01'),
(2010,	10,	3500000,	'2012-12-01');

DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nama_menu` varchar(32) NOT NULL,
  `jenis` enum('indonesian food','western food','beverage') NOT NULL,
  `harga` int(11) NOT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_menu`;
INSERT INTO `tb_menu` (`id_menu`, `nama_menu`, `jenis`, `harga`) VALUES
(111,	'es cendol',	'beverage',	3000),
(112,	'es buah',	'beverage',	15000),
(113,	'fish ball soup',	'western food',	50000),
(114,	'indomie',	'western food',	50000),
(115,	'sirloin steak',	'western food',	50000),
(116,	'sushi',	'western food',	50000),
(117,	'nasi goreng',	'western food',	50000),
(118,	'ketoprak',	'western food',	50000),
(119,	'gado gado',	'western food',	50000),
(120,	'mie ayam',	'western food',	50000);

DROP TABLE IF EXISTS `tb_pegawai`;
CREATE TABLE `tb_pegawai` (
  `id_pegawai` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pegawai` varchar(64) NOT NULL,
  `alamat` text NOT NULL,
  `jenis_kelamin` enum('male','female') NOT NULL,
  `tgl_lahir` date NOT NULL,
  `status` enum('belum menikah','menikah') NOT NULL,
  `no_tlp` varchar(13) NOT NULL,
  `jabatan` varchar(16) NOT NULL,
  PRIMARY KEY (`id_pegawai`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_pegawai`;
INSERT INTO `tb_pegawai` (`id_pegawai`, `nama_pegawai`, `alamat`, `jenis_kelamin`, `tgl_lahir`, `status`, `no_tlp`, `jabatan`) VALUES
(1,	'sanji',	'east blue',	'male',	'1992-10-14',	'menikah',	'32234',	'chef'),
(2,	'zoro',	'baratie',	'male',	'1992-04-13',	'belum menikah',	'23749',	'cleaning service'),
(3,	'chopper',	'drum island',	'male',	'1989-05-09',	'belum menikah',	'89764',	'doctor'),
(4,	'luffy',	'east blue',	'male',	'1990-03-05',	'belum menikah',	'29537',	'ceo'),
(5,	'nami',	'east blue',	'female',	'1989-01-02',	'belum menikah',	'12341',	'branch manager'),
(6,	'usopp',	'east blue',	'male',	'1989-01-09',	'belum menikah',	'64528',	'assistant manage'),
(7,	'brook',	'west blue',	'male',	'1820-12-05',	'belum menikah',	'72348',	'sales manager'),
(8,	'franky',	'water 7',	'male',	'1999-09-13',	'belum menikah',	'12343',	'technical archit'),
(9,	'jinbe',	'fishman island',	'male',	'1899-09-09',	'belum menikah',	'88773',	'marketing manage'),
(10,	'robin',	'ohara',	'female',	'2001-10-07',	'belum menikah',	'2342',	'hrd manager');

DROP TABLE IF EXISTS `tb_pembeli`;
CREATE TABLE `tb_pembeli` (
  `id_pembeli` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pembeli` varchar(64) NOT NULL,
  `alamat` varchar(64) NOT NULL,
  `jenis_kelamin` enum('male','female') NOT NULL,
  `tgl_lahir` date NOT NULL,
  `status` varchar(64) NOT NULL,
  `no_tlp` int(13) NOT NULL,
  `pekerjaan` varchar(32) NOT NULL,
  PRIMARY KEY (`id_pembeli`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_pembeli`;
INSERT INTO `tb_pembeli` (`id_pembeli`, `nama_pembeli`, `alamat`, `jenis_kelamin`, `tgl_lahir`, `status`, `no_tlp`, `pekerjaan`) VALUES
(211,	'wiwit',	'bengkulu',	'female',	'1983-03-01',	'lajang',	567890,	'apoteker'),
(212,	'ayu',	'malang',	'female',	'1982-06-10',	'menikah',	123424,	'dosen'),
(213,	'nengsih',	'solo',	'female',	'1981-05-01',	'menikah',	46784,	'asisten'),
(214,	'mamat',	'austria',	'female',	'1980-03-12',	'lajang',	47892,	'analis'),
(215,	'cecep',	'bengkulu',	'male',	'1979-01-01',	'lajang',	134245,	'kontraktor'),
(216,	'adam',	'lombok',	'male',	'1978-02-02',	'lajang',	769053,	'analis'),
(217,	'vivi',	'bali',	'female',	'1999-02-09',	'lajang',	56225,	'programmer'),
(218,	'violet',	'palembang',	'female',	'1998-07-03',	'menikah',	57823,	'perawat'),
(219,	'rebecca',	'papua',	'female',	'2001-08-10',	'menikah',	13456,	'dokter'),
(220,	'kureha',	'bengkulu',	'male',	'1800-08-11',	'lajang',	83456,	'dokter');

DROP TABLE IF EXISTS `tb_transaksi`;
CREATE TABLE `tb_transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_pembeli` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_pembeli` (`id_pembeli`),
  KEY `id_menu` (`id_menu`),
  KEY `id_pegawai` (`id_pegawai`),
  CONSTRAINT `tb_transaksi_ibfk_1` FOREIGN KEY (`id_pembeli`) REFERENCES `tb_pembeli` (`id_pembeli`) ON DELETE NO ACTION,
  CONSTRAINT `tb_transaksi_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `tb_menu` (`id_menu`) ON DELETE NO ACTION,
  CONSTRAINT `tb_transaksi_ibfk_3` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_transaksi`;
INSERT INTO `tb_transaksi` (`id_transaksi`, `id_pembeli`, `id_menu`, `id_pegawai`, `tgl_transaksi`) VALUES
(1001,	211,	111,	9,	'2012-09-09'),
(1002,	211,	112,	9,	'2012-11-08'),
(1003,	212,	113,	10,	'2012-11-10'),
(1004,	213,	114,	10,	'2012-11-28'),
(1005,	213,	115,	9,	'2012-11-28'),
(1006,	214,	116,	9,	'2012-11-29'),
(1007,	215,	117,	10,	'2012-12-08'),
(1008,	216,	118,	9,	'2012-12-08'),
(1009,	217,	119,	9,	'2012-12-18'),
(1010,	218,	119,	9,	'2012-12-18'),
(1011,	219,	120,	10,	'2012-12-28'),
(1012,	220,	120,	10,	'2012-12-29');

DROP TABLE IF EXISTS `data_gaji`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `data_gaji` AS select `tp`.`id_pegawai` AS `id_pegawai`,`tp`.`nama_pegawai` AS `nama_pegawai`,`tp`.`jabatan` AS `jabatan`,`tg`.`gaji` AS `gaji` from (`tb_pegawai` `tp` join `tb_gaji` `tg` on(`tg`.`id_pegawai` = `tp`.`id_pegawai`));

DROP TABLE IF EXISTS `data_transaksi`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `data_transaksi` AS select `tr`.`id_transaksi` AS `id_transaksi`,`tpl`.`nama_pembeli` AS `nama_pembeli`,`tm`.`nama_menu` AS `nama_menu`,`tp`.`nama_pegawai` AS `nama_pegawai`,`tr`.`tgl_transaksi` AS `tgl_transaksi` from (((`tb_transaksi` `tr` join `tb_pembeli` `tpl` on(`tr`.`id_pembeli` = `tpl`.`id_pembeli`)) join `tb_menu` `tm` on(`tr`.`id_menu` = `tm`.`id_menu`)) join `tb_pegawai` `tp` on(`tr`.`id_pegawai` = `tp`.`id_pegawai`));

-- 2022-06-20 07:58:20