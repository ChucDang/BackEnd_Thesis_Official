-- Active: 1661928110488@@127.0.0.1@3306@tmdt
INSERT INTO categories (id, code, name)
VALUES (1, 'phone', 'điện thoại'),
       (2, 'laptop', 'máy tính xách tay'),
       (3, 'clock', 'đồng hồ thông minh');

INSERT INTO stores (id, address, name)
VALUES (1, '111 Tân Định, Tân Trào, Thái Lý, Bạc Liêu', 'Hi-Tech số 1'),
       (2, '286A/3 xã Định Hòa, huyện Lai Vung, Đồng Tháp', 'Hi-Tech số 2'),
       (3, '108/17 Trần Quang Diệu, An Thới, Bình Thủy, Cần Thơ', 'Hi-Tech số 3');

INSERT INTO screens (id, color, frequent, material, resolution, size, standard, tech)
VALUES (1, '1 tỷ', 90, 'Gorilla Glass 5', '1080 x 2400', '6.55', 'FHD+', 'AMOLED'),
       (2, '16 triệu', 90, 'Kính cường lực', '828 x 1792', '6.1', '	Liquid Retina HD', 'IPS LCD'),
       (3, '16 triệu', 120, 'Gorilla Glass 5', '1080 x 2400', '6.5', 'FHD+', 'Super AMOLED'),
       (4, '1 tỷ', 120, 'Gorilla Glass Victus', '1080 x 2400', '6.67', '	FHD+', 'AMOLED'),
       (5, '16 triệu', 60, 'Kính cường lực', '720 x 1600', '6.51', 'HD+', 'IPS LCD'),
       (6, '45% NTSC', 120, 'WVA', '1920 x 1080', '	15.6', 'LED', 'WVA Anti-glare LED Backlit Narrow Border'),
       (7, '45% NTSC', 60, 'WVA', '1920 x 1080', '15.6', 'LED', 'WVA Anti-glare LED Backlit Narrow Border'),
       (8, '45% NTSC', 60, '	WVA', '	1920 x 1080', '	14.0', 'LED', 'OLED 4K HDR (3840 x 1644)');

INSERT INTO `brands` (name, category_id)
VALUES ('Samsung', 1),
       ('Sony', 1),
       ('Oppo', 1),
       ('Iphone', 1),
       ('Xiaomi', 1),
       ('Dell', 2),
       ('Asus', 2),
       ('Acer', 2),
       ('Lenovo', 2),
       ('Mastel', 1),
       ('Skeleton', 3),
       ('Chronograph', 3),
       ('Big Date', 3);
# Thêm RAM
insert into rams (id, speed, storage, support_max_speed, type)
VALUES (1, 3, 8, 16, 'DDR4'),
       (2, 1, 7, 16, 'KDB3'),
       (3, 4, 16, 16, 'HRE6'),
       (4, 2, 32, 16, 'TBK5');


INSERT INTO cpus (brand, buffer, bus, core, max_speed, sp_64bits, speed, thread, version)
VALUES ('Intel', 4, 0, 6, '4.50', 0, 2.7, 12, 'Core i5'),
       ('Intel', 4, 0, 4, 'Turbo Boost 3.1 GHz', 0, 1.1, 4, 'Pentium'),
       ('Intel', 24, 0, 14, 'Turbo Boost 4.7 GHz', 0, 2.3, 20, 'Core i7 Alder Lake'),
       ('Amd', 24, 0, 14, 'Turbo Boost 4.7 GHz', 0, 2.3, 20, 'Amd 19 Alder Lake');
      
# Thêm Storage
INSERT INTO tmdt.storages (id, code, storage, support_optane, type)
VALUES ('1', 'DDR4', '8GB', b'1', 'SSD'),
       ('2', 'DDR4', '8GB', b'0', 'HDD'),
       ('3', 'M.2 NVMe', '8GB', b'1', 'SSD');

-- Thêm vào bảng Gift

INSERT INTO `tmdt`.`gift` (code, end, list_gifts, start) 
VALUES ('welcome', '2022-09-29', 'Tai nghe Bluetooth G63*Tấm lót chuột Sky Mine', '2022-09-23');



# Thêm dữ liệu cho bảng product

INSERT INTO `products` 
VALUES 
(1,NULL,NULL,'admin','2022-09-05 12:38:09',_binary '',10,
'Wide Resolution 64.0 MP Aperture ƒ/1.8*Ultra Wide Resolution 12.0 MP Aperture ƒ/2.2*Macro lens Resolution 5.0
 MP*Portrait Resolution	5.0 MP Aperture ƒ/2.4','Tận hưởng hiệu năng mạnh mẽ Exynos 1280, màn hình siêu mượt 
 120Hz và hệ thống camera 64MP chống rung OIS cải tiến. Tất cả được hội tụ bên trong gọn nhẹ, tươi trẻ và đầy 
 màu sắc cá tính. Phiên bản bộ nhớ 256GB độc quyền tại FPT Shop còn giúp bạn lưu 
 trữ nhiều hơn.',_binary '','Chống rung quang học (OIS)*Cảm biến tiệm cận*Con quay hồi chuyển*Cảm biến vân 
 tay','Card on Board Intel UHD*Card rời NVIDIA GeForce GTX 1650','Vỏ máy: Nhựa','Galaxy Note 3',17800000,
 'Trung Quốc',24000000,'Android 8.1 Oreo','Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',
 2,'Macro lens Resolution	5.0 MP*Single selfie camera Resolution 32.0 MP Aperture ƒ/2.2',12,'2.3kg',
 'Samsung',NULL, NULL,'welcome',NULL,1,NULL,1,1),
 (2,NULL,NULL,'admin','2022-09-05 12:38:09',_binary '\0',10,'Triple rear camera*Wide Resolution 50.0 MP 
 Aperture ƒ/1.8*Macro lens Resolution	2.0 MP Aperture ƒ/2.4','đẹp tỏa sáng trên tay bạn với 
 kiểu dáng thanh lịch và màu sắc thời trang. Thiết kế cong 3D thời thượng, độ mỏng 8,40mm, phun sơn 3 
 lớp tạo nên một chiếc điện thoại không chỉ đẹp mà còn rất dễ cầm nắm, thao tác. Phiên bản màu Xanh cầu 
 vồng bóng bẩy, hiệu ứng thay đổi màu sắc thú vị dành cho những ai thích sự nổi bật. Trong khi đó màu Đen 
 trời sao sử dụng lớp vỏ nhám hiện đại, chống bám vân tay, giúp điện thoại mềm mại khi chạm vào và luôn 
 đẹp như mới.',_binary '','A.I Camera*Ban đêm (Night Mode)*Chuyên nghiệp (Pro)*Chụp chân dung*Chụp góc 
 rộng (Wide)*Flash LED*Gắn thẻ ảnh địa lý HDR*Làm đẹp (Beautify)*Lấy nét laser*Lấy nét theo pha (PDAF)*Nhận 
 diện khuôn mặt*Quay chậm (Slow Motion)*Toàn cảnh (Panorama)','Card on Board Intel UHD*Card rời	NVIDIA GeForce
  GTX 1650','Khung máy: Nhựa*Mặt lưng máy: Nhựa','A53',12000000,'Trung Quốc',17900000,'Android 11',
  'Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',2,'FullHD 1080p@30fps*HD 720p@30fps',12,
  '2.3kg','Oppo',NULL, NULL,'welcome',NULL,3,NULL,8,3),
  (3, NULL,NULL,'admin','2022-09-05 12:38:09',_binary '',10,'Wide Resolution 64.0 MP Aperture ƒ/1.8*Ultra Wide Resolution 12.0 MP Aperture ƒ/2.2*Macro lens Resolution 5.0
 MP*Portrait Resolution	5.0 MP Aperture ƒ/2.4','Tận hưởng hiệu năng mạnh mẽ Exynos 1280, màn hình siêu mượt 
 120Hz và hệ thống camera 64MP chống rung OIS cải tiến. Tất cả được hội tụ bên trong  gọn nhẹ, tươi trẻ và đầy màu sắc cá tính. Phiên bản bộ nhớ 256GB độc quyền tại FPT Shop còn giúp bạn lưu 
 trữ nhiều hơn.',_binary '','Chống rung quang học (OIS)*Cảm biến tiệm cận*Con quay hồi chuyển*Cảm biến vân 
 tay','Card on Board Intel UHD*Card rời NVIDIA GeForce GTX 1650','Vỏ máy: Nhựa','13',17800000,
 'Trung Quốc',24000000,'Android 8.1 Oreo','Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',
 2,'Macro lens Resolution	5.0 MP*Single selfie camera Resolution 32.0 MP Aperture ƒ/2.2',12,'2.3kg',
 'Iphone',NULL, NULL,'welcome',NULL,1,NULL,4,2),
 (4,NULL,NULL,'admin','2022-09-05 12:38:09',_binary '\0',10,'Triple rear camera*Wide Resolution 50.0 MP 
 Aperture ƒ/1.8*Macro lens Resolution	2.0 MP Aperture ƒ/2.4','đẹp tỏa sáng trên tay bạn với 
 kiểu dáng thanh lịch và màu sắc thời trang. Thiết kế cong 3D thời thượng, độ mỏng 8,40mm, phun sơn 3 
 lớp tạo nên một chiếc điện thoại không chỉ đẹp mà còn rất dễ cầm nắm, thao tác. Phiên bản màu Xanh cầu 
 vồng bóng bẩy, hiệu ứng thay đổi màu sắc thú vị dành cho những ai thích sự nổi bật. Trong khi đó màu Đen 
 trời sao sử dụng lớp vỏ nhám hiện đại, chống bám vân tay, giúp điện thoại mềm mại khi chạm vào và luôn 
 đẹp như mới.',_binary '','A.I Camera*Ban đêm (Night Mode)*Chuyên nghiệp (Pro)*Chụp chân dung*Chụp góc 
 rộng (Wide)*Flash LED*Gắn thẻ ảnh địa lý HDR*Làm đẹp (Beautify)*Lấy nét laser*Lấy nét theo pha (PDAF)*Nhận 
 diện khuôn mặt*Quay chậm (Slow Motion)*Toàn cảnh (Panorama)','Card on Board Intel UHD*Card rời	NVIDIA GeForce
  GTX 1650','Khung máy: Nhựa*Mặt lưng máy: Nhựa','Xperia XA1',1100000,'Trung Quốc',12000000,'Android 11',
  'Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',2,'FullHD 1080p@30fps*HD 720p@30fps',12,
  '2.3kg','Sony',NULL, NULL,'welcome',NULL,3,NULL,2,3),
 (5,NULL,NULL,'admin','2022-09-05 12:38:09',_binary '\0',10,'Triple rear camera*Wide Resolution 50.0 MP 
 Aperture ƒ/1.8*Macro lens Resolution	2.0 MP Aperture ƒ/2.4','đẹp tỏa sáng trên tay bạn với 
 kiểu dáng thanh lịch và màu sắc thời trang. Thiết kế cong 3D thời thượng, độ mỏng 8,40mm, phun sơn 3 
 lớp tạo nên một chiếc điện thoại không chỉ đẹp mà còn rất dễ cầm nắm, thao tác. Phiên bản màu Xanh cầu 
 vồng bóng bẩy, hiệu ứng thay đổi màu sắc thú vị dành cho những ai thích sự nổi bật. Trong khi đó màu Đen 
 trời sao sử dụng lớp vỏ nhám hiện đại, chống bám vân tay, giúp điện thoại mềm mại khi chạm vào và luôn 
 đẹp như mới.',_binary '','A.I Camera*Ban đêm (Night Mode)*Chuyên nghiệp (Pro)*Chụp chân dung*Chụp góc 
 rộng (Wide)*Flash LED*Gắn thẻ ảnh địa lý HDR*Làm đẹp (Beautify)*Lấy nét laser*Lấy nét theo pha (PDAF)*Nhận 
 diện khuôn mặt*Quay chậm (Slow Motion)*Toàn cảnh (Panorama)','Card on Board Intel UHD*Card rời	NVIDIA GeForce
  GTX 1650','Khung máy: Nhựa*Mặt lưng máy: Nhựa','Dim 01',1100000,'Trung Quốc',12000000,'Android 11',
  'Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',2,'FullHD 1080p@30fps*HD 720p@30fps',12,
  '2.3kg','Mastel',NULL, NULL,'welcome',NULL,3,NULL,2,3), 
  (6,NULL,NULL,'admin','2022-09-05 12:38:09',_binary '\0',10,'Triple rear camera*Wide Resolution 50.0 MP 
 Aperture ƒ/1.8*Macro lens Resolution	2.0 MP Aperture ƒ/2.4','đẹp tỏa sáng trên tay bạn với 
 kiểu dáng thanh lịch và màu sắc thời trang. Thiết kế cong 3D thời thượng, độ mỏng 8,40mm, phun sơn 3 
 lớp tạo nên một chiếc điện thoại không chỉ đẹp mà còn rất dễ cầm nắm, thao tác. Phiên bản màu Xanh cầu 
 vồng bóng bẩy, hiệu ứng thay đổi màu sắc thú vị dành cho những ai thích sự nổi bật. Trong khi đó màu Đen 
 trời sao sử dụng lớp vỏ nhám hiện đại, chống bám vân tay, giúp điện thoại mềm mại khi chạm vào và luôn 
 đẹp như mới.',_binary '','A.I Camera*Ban đêm (Night Mode)*Chuyên nghiệp (Pro)*Chụp chân dung*Chụp góc 
 rộng (Wide)*Flash LED*Gắn thẻ ảnh địa lý HDR*Làm đẹp (Beautify)*Lấy nét laser*Lấy nét theo pha (PDAF)*Nhận 
 diện khuôn mặt*Quay chậm (Slow Motion)*Toàn cảnh (Panorama)','Card on Board Intel UHD*Card rời	NVIDIA GeForce
  GTX 1650','Khung máy: Nhựa*Mặt lưng máy: Nhựa','RT91',1100000,'Trung Quốc',12000000,'Android 11',
  'Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',2,'FullHD 1080p@30fps*HD 720p@30fps',12,
  '2.3kg','Xiaomi',NULL, NULL,'welcome',NULL,3,NULL,2,3), 
  (7,NULL,NULL,'admin','2022-09-05 12:38:09',_binary '\0',10,'Triple rear camera*Wide Resolution 50.0 MP 
 Aperture ƒ/1.8*Macro lens Resolution	2.0 MP Aperture ƒ/2.4','đẹp tỏa sáng trên tay bạn với 
 kiểu dáng thanh lịch và màu sắc thời trang. Thiết kế cong 3D thời thượng, độ mỏng 8,40mm, phun sơn 3 
 lớp tạo nên một chiếc điện thoại không chỉ đẹp mà còn rất dễ cầm nắm, thao tác. Phiên bản màu Xanh cầu 
 vồng bóng bẩy, hiệu ứng thay đổi màu sắc thú vị dành cho những ai thích sự nổi bật. Trong khi đó màu Đen 
 trời sao sử dụng lớp vỏ nhám hiện đại, chống bám vân tay, giúp điện thoại mềm mại khi chạm vào và luôn 
 đẹp như mới.',_binary '','A.I Camera*Ban đêm (Night Mode)*Chuyên nghiệp (Pro)*Chụp chân dung*Chụp góc 
 rộng (Wide)*Flash LED*Gắn thẻ ảnh địa lý HDR*Làm đẹp (Beautify)*Lấy nét laser*Lấy nét theo pha (PDAF)*Nhận 
 diện khuôn mặt*Quay chậm (Slow Motion)*Toàn cảnh (Panorama)','Card on Board Intel UHD*Card rời	NVIDIA GeForce
  GTX 1650','Khung máy: Nhựa*Mặt lưng máy: Nhựa','Gaming XT13',1100000,'Trung Quốc',12000000,'Android 11',
  'Lithium-ion 3 Cell',2.3,'2005-05-24',1,'','359 * 256 * 24.9 mm',2,'FullHD 1080p@30fps*HD 720p@30fps',12,
  '2.3kg','Dell',NULL, NULL,'welcome',NULL,3,NULL,2,3);

-- Product áp dụng Gift

