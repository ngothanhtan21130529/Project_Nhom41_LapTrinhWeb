CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(50),
  `password` varchar(30),
  `full_name` varchar(30),
  `email` varchar(30),
  `phone` varchar(10),
  `created_at` datetime,
  `updated_at` datetime,
  `status` varchar(30),
  `avatar` text,
  `roles_id` int,
  `birthday` datetime
);

CREATE TABLE `products` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `category_id` int,
  `product_name` varchar(100),
  `price` int,
  `status` varchar(30),
  `thumbnail` varchar(500)
);

CREATE TABLE `product_details` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `product_name` varchar(100),
  `price` int,
  `sale` int,
  `hot` boolean,
  `description` text,
  `created_at` datetime,
  `updated_at` datetime,
  `deleted_at` datetime,
  `color` text,
  `weight` text,
  `size` text,
  `opacity` text,
  `status` varchar(30),
  `product_id` int,
  `inventories_id` int
);

CREATE TABLE `order_details` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `product_id` int,
  `order_id` int,
  `quantity_total` int,
  `total_price` int,
  `created_at` datetime,
  `updated_at` datetime,
  `status` varchar(30)
);

CREATE TABLE `categories` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `category_name` varchar(50),
  `created_at` datetime,
  `updated_at` datetime,
  `deleted_at` datetime,
  `status` varchar(30)
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `created_at` datetime,
  `updated_at` datetime,
  `total_price` int
);

CREATE TABLE `roles` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `role_name` varchar(30)
);

CREATE TABLE `images` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `img_url` text,
  `product_details_id` int,
  `category_id` int
);

CREATE TABLE `inventories` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `quantity` int
);

CREATE TABLE `feedbacks` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `full_name` varchar(50),
  `email` varchar(50),
  `phone` varchar(15),
  `title` varchar(100),
  `feedback_content` varchar(500),
  `status` varchar(30),
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `comments` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `product_details_id` int,
  `comment_content` text,
  `img_url` text
);

ALTER TABLE `users` ADD FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`);

ALTER TABLE `products` ADD FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

ALTER TABLE `product_details` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `product_details` ADD FOREIGN KEY (`inventories_id`) REFERENCES `inventories` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `images` ADD FOREIGN KEY (`product_details_id`) REFERENCES `product_details` (`id`);

ALTER TABLE `images` ADD FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`product_details_id`) REFERENCES `product_details` (`id`);
