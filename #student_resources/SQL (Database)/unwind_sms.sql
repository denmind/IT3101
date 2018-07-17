-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2018 at 07:55 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `unwind_sms`
--

-- --------------------------------------------------------

--
-- Table structure for table `modifications`
--

CREATE TABLE `modifications` (
  `mod_id` int(11) NOT NULL,
  `salary_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `salary` double NOT NULL COMMENT 'Value of salary by the time the modification is performed',
  `description` varchar(256) NOT NULL,
  `type` enum('DEDUCTION','ADDITION') NOT NULL,
  `datetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `modifications`
--

INSERT INTO `modifications` (`mod_id`, `salary_id`, `amount`, `salary`, `description`, `type`, `datetime`) VALUES
(1, 1, -200, 2800, 'Total Late Fine', 'DEDUCTION', '2018-07-27 12:29:26'),
(2, 11, 300, 1606, 'why not', 'ADDITION', '2018-07-16 12:30:43'),
(3, 11, 5000, 7400, 'why not', 'ADDITION', '2018-07-16 12:55:34'),
(4, 10, 600, 1500, 'Helping a grandmother out', 'ADDITION', '2018-07-16 12:56:10'),
(5, 11, 10000, 17400, 'Bonus', 'ADDITION', '2018-07-16 14:24:00'),
(6, 1, 100000, 135000, 'Bonus', 'ADDITION', '2018-07-16 22:07:26'),
(7, 2, 2000, 33000, 'Fine', 'DEDUCTION', '2018-07-16 22:07:57'),
(8, 1, 200, 135200, 'Bonus', 'ADDITION', '2018-07-16 22:08:05'),
(9, 10, 10000, 45000, 'Bonus', 'ADDITION', '2018-07-16 22:08:11'),
(10, 1, 100, 45100, 'why not', 'ADDITION', '2018-07-17 13:41:33');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `sal_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`sal_id`, `employee_id`, `amount`) VALUES
(1, 1, 45100),
(2, 2, 25000),
(3, 3, 35000),
(10, 10, 25000),
(11, 11, 45000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `modifications`
--
ALTER TABLE `modifications`
  ADD PRIMARY KEY (`mod_id`),
  ADD KEY `mod_sal` (`salary_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`sal_id`),
  ADD KEY `salary_employee` (`employee_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `modifications`
--
ALTER TABLE `modifications`
  MODIFY `mod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `sal_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `modifications`
--
ALTER TABLE `modifications`
  ADD CONSTRAINT `mod_sal` FOREIGN KEY (`salary_id`) REFERENCES `salary` (`sal_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
