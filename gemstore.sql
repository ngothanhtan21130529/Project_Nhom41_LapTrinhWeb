-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2023 at 08:12 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gemstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `img_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `category_name`, `created_at`, `updated_at`, `deleted_at`, `status`, `img_id`) VALUES
(1, 'Ruby', '2023-12-19 13:33:42', '2023-12-16 13:33:42', '2023-12-04 13:33:42', NULL, 1),
(2, 'Sapphire', '2023-12-23 13:33:42', '2023-12-01 13:33:42', '2023-12-13 13:33:42', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `comment_content` text DEFAULT NULL,
  `img_url` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `feedback_content` varchar(500) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `img_url` text DEFAULT NULL,
  `image_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `img_url`, `image_name`) VALUES
(1, 'https://iruby.vn/wp-content/uploads/2023/10/ruby.jpg', 'ruby'),
(2, 'https://iruby.vn/wp-content/uploads/2023/10/pink-sapphire.jpg', 'sapphire'),
(3, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Ruby-sao-net-cang-tu-nhien-100-109ct-IRSR185-231210900000.jpg', 'VIÊN RUBY SAO NÉT CĂNG TỰ NHIÊN 100% 1,09CT – IRSR185 2312109'),
(4, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Ruby-cabochon-do-huyet-Luc-Yen-781ct-IRRC183-231278100000.jpg', 'VIÊN RUBY SAO TỰ NHIÊN 100% 0,98CT – IRSR184 2312098'),
(5, 'https://iruby.vn/wp-content/uploads/2023/12/Nhan-nu-Ruby-cabochon-do-huyet-Vintage-IRRC-231213500000.jpg', 'TRANG SỨC: NHẪN NỮ RUBY CABOCHON ĐỎ HUYẾT VINTAGE – IRRC 2312135'),
(6, 'https://iruby.vn/wp-content/uploads/2023/12/Doi-bong-Spinel-Blue-IRSI-231221700000.jpg', 'TRANG SỨC: ĐÔI BÔNG TAI SPINEL BLUE – IRSI 2312217\r\n'),
(7, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-lam-hoang-gia-167ct-IRBS153-231216700000.jpg', 'VIÊN SAPPHIRE XANH LAM HOÀNG GIA 1,67CT – IRBS153 2312167'),
(8, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-vang-tu-nhien-100-chua-qua-nhiet-162ct-IRYS152-231216200000.jpg', 'VIÊN SAPPHIRE VÀNG TỰ NHIÊN 100% CHƯA QUA NHIỆT 2,62CT – IRYS152 2312262');

-- --------------------------------------------------------

--
-- Table structure for table `inventories`
--

CREATE TABLE `inventories` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventories`
--

INSERT INTO `inventories` (`id`, `product_id`, `quantity`) VALUES
(1, 1, NULL),
(2, 2, 1),
(3, 3, 1),
(4, 3, 0),
(5, 5, 2),
(6, 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `quantity_total` int(11) DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `thumbnail_id` int(11) DEFAULT NULL,
  `sale` int(11) DEFAULT NULL,
  `hot` tinyint(1) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `weight` varchar(50) DEFAULT NULL,
  `opacity` varchar(50) DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  `material` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `category_id`, `product_name`, `price`, `status`, `thumbnail_id`, `sale`, `hot`, `description`, `created_at`, `updated_at`, `deleted_at`, `color`, `weight`, `opacity`, `size`, `material`) VALUES
(1, 2, 'VIÊN SAPPHIRE XANH LAM HOÀNG GIA 1,67CT – IRBS153 2312167', 2000000, 'Còn hàng', 7, NULL, NULL, 'ewrawefasdfasdf', '2023-12-25 13:34:47', '2023-12-29 13:34:47', '2023-12-30 13:34:47', 'Xanh lam', '1,67ct', 'Chiếu bung toàn viên, đầy đủ đáy, bề mặt sáng bóng', '7,4mm - 4mm', NULL),
(2, 2, 'Viên Sapphire vàng tự nhiên 100% chưa qua nhiệt 2,62ct – IRYS152 2312262', 15000400, 'Available', 8, NULL, NULL, 'đfsdgsdrgsdgs ok ok ok ok ok ok ok', '2023-12-24 13:34:47', '2023-12-25 13:34:47', NULL, 'Vàng', '2,62ct', 'Chiếu đẹp toàn viền, đủ đáy, bề mặt sáng bóng giác', '7,2mm - 5,5mm', NULL),
(3, 1, 'Viên Ruby sao nét căng tự nhiên 100% 1,09ct – IRSR185 2312109', 62600000, 'Còn hàng', 3, NULL, NULL, 'nasdweqrer fa fa', '2023-12-13 13:43:09', NULL, NULL, 'Đỏ', '1,09ct', 'Chất ngọc lành sạch', '6,4 x 4,9 - 3,5mm', NULL),
(4, 1, 'Viên Ruby sao tự nhiên 100% 0,98ct – IRSR184 2312098', 6203000, 'Available', 4, NULL, NULL, 'gggggggggggggg', '2023-12-12 13:43:09', NULL, NULL, 'Đỏ', '0,98ct', 'Chất kính trong bền vững', '6,6 x 5 - 3,1mm', NULL),
(5, NULL, 'TRANG SỨC: Nhẫn nữ Ruby cabochon đỏ huyết Vintage – IRRC 2312135', 15116000, 'Còn hàng', 5, NULL, NULL, 'xxxxxxxxxxxx', NULL, NULL, NULL, 'Đỏ', '1,35ct', NULL, 'Tất cả các size', NULL),
(6, NULL, 'TRANG SỨC: Đôi bông tai Spinel Blue – IRSI 2312217', 50000000, NULL, 6, NULL, NULL, 'ghhhhhhhhhhhhh', NULL, NULL, NULL, 'Xanh lam', '2,17ct', NULL, 'Tất cả các size', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role_name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `full_name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `avatar` text DEFAULT NULL,
  `roles_id` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `img_id` (`img_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventories`
--
ALTER TABLE `inventories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `thumbnail_id` (`thumbnail_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `roles_id` (`roles_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `inventories`
--
ALTER TABLE `inventories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`img_id`) REFERENCES `images` (`id`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `inventories`
--
ALTER TABLE `inventories`
  ADD CONSTRAINT `inventories_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`thumbnail_id`) REFERENCES `images` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
