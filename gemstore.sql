-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2024 at 08:47 AM
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
  `category_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `status` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `img_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `category_name`, `created_at`, `updated_at`, `deleted_at`, `status`, `img_id`) VALUES
(1, 'Jewelry', '2024-01-01 14:00:38', NULL, NULL, NULL, NULL),
(2, 'Ruby', '2024-01-01 14:07:31', NULL, NULL, NULL, 1),
(3, 'Sapphire', '2024-01-22 14:07:31', NULL, NULL, NULL, 2),
(4, 'Emerald', '2024-01-01 14:08:42', NULL, NULL, NULL, 4),
(5, 'Spinel', '2024-01-09 14:08:42', NULL, NULL, NULL, 5),
(6, 'Aquamarine', '2024-01-03 14:09:42', NULL, NULL, NULL, 6),
(7, 'Tourmaline', '2024-01-01 14:09:42', NULL, NULL, NULL, 7),
(8, 'Prediot', '2024-01-03 14:10:36', NULL, NULL, NULL, 8),
(9, 'Topaz', '2024-01-02 14:10:36', NULL, NULL, NULL, 9),
(10, 'Kim Cương', '2024-01-02 14:16:05', NULL, NULL, NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `comment_content` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `img_url` text COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL,
  `full_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `feedback_content` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `img_url` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `img_url`, `image_name`, `type`) VALUES
(1, 'https://iruby.vn/wp-content/uploads/2023/10/ruby-e1703317900141.jpg', 'Ruby', 'category'),
(2, 'https://iruby.vn/wp-content/uploads/2023/10/pink-sapphire.jpg', 'Sapphire', 'category'),
(3, 'https://m.media-amazon.com/images/W/MEDIAX_792452-T1/images/I/51JaTsA8prL._AC_SX679_.jpg', 'Diamond', 'category'),
(4, 'https://iruby.vn/wp-content/uploads/2023/10/ngoc-luc-bao.jpg', 'Emerald', 'category'),
(5, 'https://iruby.vn/wp-content/uploads/2023/10/spinel.jpg', 'Spinel', 'category'),
(6, 'https://iruby.vn/wp-content/uploads/2023/10/aquamarine.jpg', 'Aquamarine', 'category'),
(7, 'https://iruby.vn/wp-content/uploads/2023/10/GREEN-TOURMALINE.jpg', 'Tourmaline', 'category'),
(8, 'https://iruby.vn/wp-content/uploads/2023/10/Peridot.jpg', 'Prediot', 'category'),
(9, 'https://iruby.vn/wp-content/uploads/2023/10/topaz-1.jpg', 'Topaz', 'category'),
(10, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-anh-chao-dong-122ct-IRRF203-240112200000.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG ÁNH CHÁO ĐỒNG 1,22CT', 'product'),
(11, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-anh-chao-dong-122ct-IRRF203-240112200001.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG ÁNH CHÁO ĐỒNG 1,22CT', 'product'),
(12, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-anh-chao-dong-122ct-IRRF203-240112200002.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG ÁNH CHÁO ĐỒNG 1,22CT', 'product'),
(13, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-anh-chao-dong-122ct-IRRF203-240112200003.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG ÁNH CHÁO ĐỒNG 1,22CT', 'product'),
(14, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-anh-chao-dong-122ct-IRRF203-240112200004.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG ÁNH CHÁO ĐỒNG 1,22CT', 'product'),
(15, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-Luc-Yen-100ct-IRRF202-240110000000.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG LỤC YÊN 1,00CT', 'product'),
(16, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-Luc-Yen-100ct-IRRF202-240110000001.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG LỤC YÊN 1,00CT ', 'product'),
(17, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-Luc-Yen-100ct-IRRF202-240110000002.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG LỤC YÊN 1,00CT', 'product'),
(18, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-Luc-Yen-100ct-IRRF202-240110000003.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG LỤC YÊN 1,00CT ', 'product'),
(19, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Ruby-facet-do-hong-Luc-Yen-100ct-IRRF202-240110000004.jpg', 'VIÊN RUBY FACET ĐỎ HỒNG LỤC YÊN 1,00CT ', 'product'),
(20, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Sapphire-xanh-lam-tu-nhien-412ct-IRBS155-240141200000.jpg', 'VIÊN SAPPHIRE XANH LAM TỰ NHIÊN 4,12CT', 'product'),
(21, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Sapphire-xanh-lam-tu-nhien-412ct-IRBS155-240141200001.jpg', 'VIÊN SAPPHIRE XANH LAM TỰ NHIÊN 4,12CT', 'product'),
(22, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Sapphire-xanh-lam-tu-nhien-412ct-IRBS155-240141200002.jpg', 'VIÊN SAPPHIRE XANH LAM TỰ NHIÊN 4,12CT', 'product'),
(23, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Sapphire-xanh-lam-tu-nhien-412ct-IRBS155-240141200003.jpg', 'VIÊN SAPPHIRE XANH LAM TỰ NHIÊN 4,12CT', 'product'),
(24, 'https://iruby.vn/wp-content/uploads/2024/01/Vien-Sapphire-xanh-lam-tu-nhien-412ct-IRBS155-240141200004.jpg', 'VIÊN SAPPHIRE XANH LAM TỰ NHIÊN 4,12CT', 'product'),
(25, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-Blue-450ct-IRBS154-231245000000.jpg', 'VIÊN SAPPHIRE XANH BLUE 4,50CT', 'product'),
(26, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-Blue-450ct-IRBS154-231245000001.jpg', 'VIÊN SAPPHIRE XANH BLUE 4,50CT', 'product'),
(27, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-Blue-450ct-IRBS154-231245000002.jpg', 'VIÊN SAPPHIRE XANH BLUE 4,50CT', 'product'),
(28, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-Blue-450ct-IRBS154-231245000003.jpg', 'VIÊN SAPPHIRE XANH BLUE 4,50CT', 'product'),
(29, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-Blue-450ct-IRBS154-231245000004.jpg', 'VIÊN SAPPHIRE XANH BLUE 4,50CT', 'product'),
(30, 'https://iruby.vn/wp-content/uploads/2023/12/Vien-Sapphire-xanh-Blue-450ct-IRBS154-231245000005.jpg', 'VIÊN SAPPHIRE XANH BLUE 4,50CT', 'product'),
(31, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600000.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(32, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600001.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(33, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600002.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(34, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600003.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(35, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600004.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(36, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600005.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(37, 'https://iruby.vn/wp-content/uploads/2024/01/IRAQ5-231295600006.jpg', 'MẶT DÂY AQUAMARINE DÁNG GIỌT NƯỚC', 'product'),
(38, 'https://iruby.vn/wp-content/uploads/2024/01/Doi-bong-tai-Tourmaline-Spinel-IRTM-231240500000.jpg', 'ĐÔI BÔNG TAI TOURMALINE SPINEL', 'product'),
(39, 'https://iruby.vn/wp-content/uploads/2024/01/Doi-bong-tai-Tourmaline-Spinel-IRTM-231240500001.jpg', 'ĐÔI BÔNG TAI TOURMALINE SPINEL', 'product'),
(40, 'https://iruby.vn/wp-content/uploads/2024/01/Doi-bong-tai-Tourmaline-Spinel-IRTM-231240500002.jpg', 'ĐÔI BÔNG TAI TOURMALINE SPINEL', 'product'),
(41, 'https://iruby.vn/wp-content/uploads/2024/01/Doi-bong-tai-Tourmaline-Spinel-IRTM-231240500003.jpg', 'ĐÔI BÔNG TAI TOURMALINE SPINEL', 'product'),
(42, 'https://iruby.vn/wp-content/uploads/2024/01/Doi-bong-tai-Tourmaline-Spinel-IRTM-231240500004.jpg', 'ĐÔI BÔNG TAI TOURMALINE SPINEL', 'product');

-- --------------------------------------------------------

--
-- Table structure for table `inventories`
--

CREATE TABLE `inventories` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `inventories`
--

INSERT INTO `inventories` (`id`, `product_id`, `quantity`) VALUES
(1, 1, 1),
(2, 2, 0),
(3, 3, 3),
(4, 4, NULL),
(5, 5, 1),
(6, 6, 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
  `status` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `product_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `status` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `thumbnail_id` int(11) DEFAULT NULL,
  `sale` int(11) DEFAULT NULL,
  `hot` tinyint(1) DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `color` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `weight` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `opacity` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `size` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cutting_grinding_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `material` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `category_id`, `product_name`, `price`, `status`, `thumbnail_id`, `sale`, `hot`, `description`, `created_at`, `updated_at`, `deleted_at`, `color`, `weight`, `opacity`, `size`, `cutting_grinding_type`, `material`) VALUES
(1, 2, 'Viên Ruby facet đỏ hồng ánh cháo đồng 1,22ct', 24400000, NULL, 10, NULL, NULL, 'Đá Ruby hồng là một trong những loại đá quý hoàn hảo và đẹp nhất, chúng thể hiện quyền lực, sự tự do, may mắn và vui vẻ.', '2024-01-01 15:19:37', NULL, NULL, 'Đỏ', '1,22ct', 'Chiếu bung toàn viên, đầy đủ đáy, bề mặt sáng bóng', '6,5 x 5,5 - 4,1mm', 'Cushion - facet', NULL),
(2, 2, 'Viên Ruby facet đỏ hồng Lục Yên 1,00ct', 24000000, NULL, 15, NULL, NULL, 'Đá Ruby được xem là biểu tượng của tình yêu, biểu trưng cho sự nồng nàn và lãng mạn. Chính vì vậy, nhẫn đá Ruby thường được chọn làm món quà truyền thống dành cho các cặp vợ chồng nhân kỷ niệm ngày cưới của mình.', '2024-01-14 15:19:37', NULL, NULL, 'Đỏ', '1,00ct', 'Chiếu bung toàn viên, đầy đủ đáy, bề mặt sáng bóng', '5,7 x 4,8 - 4mm', 'Hình khối oval - facet', NULL),
(3, 1, 'Mặt dây Aquamarine dáng giọt nước', 43218000, NULL, 31, NULL, NULL, 'Đá Aquamarine mang đến cho chủ sở hữu nhiều may mắn, tài lộc. Đây là loại đá được lựa chọn làm trang sức tượng trưng cho tình yêu, cũng như sự chung thủy.', '2024-01-01 15:26:04', NULL, NULL, 'Xanh dương', NULL, NULL, NULL, 'Aquamarine', 'Vàng trắng 14k'),
(4, 1, 'Đôi bông tai Tourmaline Spinel', 25726000, NULL, 38, NULL, NULL, 'Đeo đá Tourmaline & Spinel tăng sự quý phái, sang trọng cho người sử dụng. Nguồn năng lượng lớn có trong đá sẽ giúp chủ nhân luôn có tràn đầy sức sống, suy nghĩ tích cực, vượt qua mọi khó khăn, thách thức trong cuộc sống.', '2024-01-09 15:26:04', NULL, NULL, 'Xanh lá mạ, Đỏ', NULL, NULL, 'Tất cả các size', 'Tourmaline, SPINEL ĐỎ', 'Vàng trắng 14k'),
(5, 3, 'Viên Sapphire xanh lam tự nhiên 4,12ct', 115360000, NULL, 20, NULL, NULL, 'Đá Sapphire xanh là màu quý giá nhất trong tất cả các màu của Sapphire. Mang lại sự giàu sang, phú quý. Chủ sở hữu trang sức từ đá Sapphire xanh có thể cải thiện và phát triển tốt các kỹ năng như thuyết trình, giao tiếp trước đám đông.', '2024-01-14 15:31:02', NULL, NULL, 'Xanh lam', '4,12ct', 'Chiếu bung toàn viên, đầy đủ đáy, bề mặt sáng bóng', '10,7 x 8,3 - 5,3mm', 'Hình khối oval - facet', NULL),
(6, 3, 'Viên Sapphire xanh Blue 4,50ct', 139000000, NULL, 35, NULL, NULL, 'Sapphire xanh lam nhạt tự nhiên 100% khá hiếm với trọng lượng carat lớn, thể hiện sự lịch thiệp và lịch lãm khi được lên mẫu nhẫn. Ngoài ra, loại đá này cũng giúp chủ sở hữu thu hút ánh nhìn của những người xung quanh.', '2024-01-01 15:31:02', NULL, NULL, 'Xanh lam', '4,50ct', 'Chiếu đẹp toàn viên, mọi giác cắt sáng rực', '9,7 x 8,8 - 6,3mm', 'Hình khối oval - facet', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `full_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `roles_id` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

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
