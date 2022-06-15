# Thêm dữ liệu vào Catergory
INSERT INTO `tmdt`.`catergory` (`id`, `code`, `name`) VALUES ('1','phone', 'điện thoại');
INSERT INTO `tmdt`.`catergory` (`id`, `code`, `name`) VALUES ('2','laptop', 'máy tính xách tay');
INSERT INTO `tmdt`.`catergory` (`id`, `code`, `name`) VALUES ('3','clock', 'đồng hồ thông minh');

# Thêm dữ liệu vào CPU
INSERT INTO `tmdt`.`cpus` (`id`, `code`, `catergory_id`) VALUES ('1', 'Intel Celeron', '2');
INSERT INTO `tmdt`.`cpus` (`id`, `code`, `catergory_id`) VALUES ('2', 'Intel Pentium', '2');
INSERT INTO `tmdt`.`cpus` (`id`, `code`, `catergory_id`) VALUES ('3', 'Intel Core I3', '1');
INSERT INTO `tmdt`.`cpus` (`id`, `code`, `catergory_id`) VALUES ('4', 'Amd ryzen 9', '3');
INSERT INTO `tmdt`.`cpus` (`id`, `code`, `catergory_id`) VALUES ('5', 'Amd ryzen 7', '1');
# Thêm dữ liệu vào bảng Products

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `brand`, `description`, `memory`, `model`, `monitor`, `new_price`, `original_price`, `ram`, `rate`, `catergory_id`, `cpu_id`)
VALUES ('1', 1, 'laptop 1', 'Sạc nhanh, chống thấm nước', '8G', 'XA12', '16 inch', '89.98', '100.98', '16G', '1', '2', '2');


INSERT INTO `tmdt`.`products` (`id`, `amortization`, `brand`, `description`, `memory`, `model`, `monitor`, `new_price`, `original_price`, `ram`, `rate`, `catergory_id`, `cpu_id`)
VALUES ('2', 1, 'laptop 2', 'Sạc nhanh, chống thấm nước', '8G', 'XA12', '16 inch', '89.98', '100.98', '16G', '1', '2', '2');

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `brand`, `description`, `memory`, `model`, `monitor`, `new_price`, `original_price`, `ram`, `rate`, `catergory_id`, `cpu_id`)
VALUES ('3', 1, 'laptop 3', 'Sạc nhanh, chống thấm nước', '8G', 'XA12', '16 inch', '89.98', '100.98', '16G', '1', '2', '2');

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `brand`, `description`, `memory`, `model`, `monitor`, `new_price`, `original_price`, `ram`, `rate`, `catergory_id`, `cpu_id`)
VALUES ('4', 1, 'điện thoại 1', 'Sạc nhanh, chống thấm nước', '8G', 'XA12', '16 inch', '89.98', '100.98', '16G', '1', '1', '3');

