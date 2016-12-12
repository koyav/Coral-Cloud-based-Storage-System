-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 15, 2015 at 01:35 PM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `coral`
--

-- --------------------------------------------------------

--
-- Table structure for table `storageinfo`
--

CREATE TABLE IF NOT EXISTS `storageinfo` (
  `uname` varchar(50) NOT NULL,
  `email` varchar(5000) NOT NULL,
  `filename` varchar(5000) NOT NULL,
  `filesize` varchar(50) NOT NULL,
  `totalstorage` varchar(5) NOT NULL,
  `descrip` varchar(10000) NOT NULL,
  `keywrds` varchar(5000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storageinfo`
--

INSERT INTO `storageinfo` (`uname`, `email`, `filename`, `filesize`, `totalstorage`, `descrip`, `keywrds`) VALUES
('patlu', 'patlu@gmail.com', 'ffmpeg.exe', '3.5', '5', 'multimedia codec software', 'codec,frame conversion'),
('patlu', 'patlu@gmail.com', '1004.4438.pdf', '0.5580000281333923', '5', 'sasa', 'srfdfd'),
('jackspro', 'jackspro@gmail.com', '04547426.pdf', '2.936363216576865E-6', '5', 'coral : cloud storage', 'cloud storage,optimization');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(5000) NOT NULL,
  `storage` int(5) NOT NULL,
  `deb_card_num` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `uname`, `pass`, `dob`, `email`, `storage`, `deb_card_num`) VALUES
(1, 'motu', '123456', '1988-08-03', 'p.motu@gmail.com', 5, '453321069871256'),
(2, 'patlu', '123456', '1991-02-26', 'patlu@gmail.com', 5, '411111111111111111111'),
(3, 'jackspro', '123456', '1991-02-26', 'jackspro@gmail.com', 5, '41235698752130'),
(4, 'jackspro', '123456', '1991-02-26', 'jackspro@gmail.com', 5, '41235698752130');
