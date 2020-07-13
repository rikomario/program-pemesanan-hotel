-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2020 at 05:30 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbhotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`Username`, `Password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_chekin`
--

CREATE TABLE `tb_chekin` (
  `no_chekin` varchar(50) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `id_kamar` varchar(15) DEFAULT NULL,
  `id_pelanggan` varchar(15) DEFAULT NULL,
  `lama_sewa` int(15) DEFAULT NULL,
  `total_harga` int(15) DEFAULT NULL,
  `jumlah_bayar` int(15) DEFAULT NULL,
  `kembalian` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_chekin`
--

INSERT INTO `tb_chekin` (`no_chekin`, `tanggal`, `id_kamar`, `id_pelanggan`, `lama_sewa`, `total_harga`, `jumlah_bayar`, `kembalian`) VALUES
('CK001', '2020-07-15', 'K3', 'P2', 1, 125000, 130000, 5000),
('CK002', '2020-07-30', 'K2', 'P5', 1, 500000, 1000000, 500000),
('CK003', '2020-07-08', 'K5', 'P7', 2, 2000000, 2000000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_kamar`
--

CREATE TABLE `tb_kamar` (
  `id_kamar` varchar(50) NOT NULL,
  `tipe` varchar(20) DEFAULT NULL,
  `biaya` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kamar`
--

INSERT INTO `tb_kamar` (`id_kamar`, `tipe`, `biaya`) VALUES
('K1', 'VIP', 200000),
('K2', 'V VIP', 500000),
('K3', 'Ekonomi', 125000),
('K4', 'Bisnis', 150000),
('KH5', 'S V VIP', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `id_pegawai` varchar(10) NOT NULL,
  `Nama` varchar(50) DEFAULT NULL,
  `Jenis_Kelamin` varchar(5) DEFAULT NULL,
  `Umur` int(4) DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  `Gaji` int(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id_pegawai`, `Nama`, `Jenis_Kelamin`, `Umur`, `Alamat`, `Gaji`) VALUES
('KH1', 'Riko', 'L', 20, 'Wonogiri', 120000),
('KH2', 'Mario', 'L', 22, 'Boyolali', 300000),
('KH3', 'Defani', 'P', 20, 'Wonogiri', 1200000),
('KH5', 'Reni', 'P', 23, 'Wonogiri', 220000),
('KH7', 'Sainan', 'P', 23, 'Wonogiri', 3000000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `id_pelanggan` varchar(12) NOT NULL,
  `nama_pelanggan` varchar(50) DEFAULT NULL,
  `umur_pelanggan` int(4) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`id_pelanggan`, `nama_pelanggan`, `umur_pelanggan`, `alamat`) VALUES
('P1', 'Mario', 22, 'Wonogiri'),
('P2', 'Bilal', 22, 'Boyolali'),
('P3', 'Atta', 20, 'Wonogiri'),
('P5', 'Bonzterhang', 35, 'Nedherland'),
('P6', 'Nemanja Vidic', 32, 'Liverpool, Inggris'),
('P7', 'Denin', 22, 'Boyolali');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_chekin`
--
ALTER TABLE `tb_chekin`
  ADD PRIMARY KEY (`no_chekin`),
  ADD KEY `id_kamar` (`id_kamar`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Indexes for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD PRIMARY KEY (`id_kamar`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
