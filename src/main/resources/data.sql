# Thêm dữ liệu vào Catergory
INSERT INTO `tmdt`.`catergories` (`id`, `code`, `name`) VALUES ('1','phone', 'điện thoại');
INSERT INTO `tmdt`.`catergories` (`id`, `code`, `name`) VALUES ('2','laptop', 'máy tính xách tay');
INSERT INTO `tmdt`.`catergories` (`id`, `code`, `name`) VALUES ('3','clock', 'đồng hồ thông minh');
INSERT INTO `tmdt`.`catergories` (`id`, `code`, `name`) VALUES ('4','airpod', 'tai nghe không dây');


# Thêm dữ liệu vào bảng screens
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('1', '1 tỷ', '90', 'Gorilla Glass 5', '1080 x 2400', '6.55', '	AMOLED', 'FHD+');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('2', '16 triệu', '90', 'Kính cường lực', '828 x 1792', '	6.1', '	IPS LCD', '	Liquid Retina HD');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('3', '16 triệu', '120', 'Gorilla Glass 5', '1080 x 2400', '6.5', 'Super AMOLED', 'FHD+');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('4', '1 tỷ', '120', 'Gorilla Glass Victus', '1080 x 2400', '6.67', '	AMOLED', '	FHD+');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('5', '16 triệu', '60', 'Kính cường lực', '720 x 1600', '6.51','IPS LCD', 'HD+');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('6', '45% NTSC', '120', 'WVA', '1920 x 1080', '	15.6', 'WVA Anti-glare LED Backlit Narrow Border', 'LED');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('7', '45% NTSC', '60', 'WVA', '1920 x 1080', '15.6', 'WVA Anti-glare LED Backlit Narrow Border', 'LED');
INSERT INTO `tmdt`.`screens` (`id`, `color`, `frequent`, `material`, `resolution`, `size`, `tech`, `standard`)
VALUES ('8', '45% NTSC', '60', '	WVA', '	1920 x 1080', '	14.0', 'OLED 4K HDR (3840 x 1644)', 'LED');

# Thêm dữ liệu vào bảng CPU cho dòng laptop
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('1', 'Intel', '4','0', '6', '4.50', '2.70',b'0', '12', '11400H', 'Core i5');
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('2', 'Intel', '4', '0', '4', 'Turbo Boost 3.1 GHz', '1.10',b'0', '4', 'N5030', 'Intel Pentium');
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('3', 'Intel', '24','0', '14', 'Turbo Boost 4.7 GHz', '2.30', b'0','20', '12700H', 'Intel Core i7 Alder Lake');
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('4', 'Amd', '24','0', '14', 'Turbo Boost 4.7 GHz', '2.30', b'0','20', '12700H', 'Amd 19 Alder Lake');
# Thêm dữ liệu vào bảng CPU cho điện thoại
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('5', '', '0','0', '8', '', '2.20', b'0','0', 'Octa-Core', 'Helio P95');
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('6', '', '0','0', '6', '', '3.22', b'0','0', 'Octa-Core', 'Apple A15 Bionic');
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('7', '', '0','0', '8', '', '3.22', b'1','0', 'Octa-Core', 'Snapdragon 888');
INSERT INTO `tmdt`.`cpus` (`id`, `brand`, `buffer`,`bus`,`core`, `max_speed`, `speed`,`sp_64bits`, `thread`, `type`, `version`)
VALUES ('8', '', '0','0', '8', '', '3.22', b'0','0', 'Octa-Core', 'Snapdragon 8 Gen 1');
# Thêm Ram
INSERT INTO `tmdt`.`rams` (`id`, `code`, `frequent`, `storage`) VALUES ('1', 'DDR4', '3200', '8');
INSERT INTO `tmdt`.`rams` (`id`, `code`, `frequent`, `storage`) VALUES ('2', 'DDR4', '3200', '8');
INSERT INTO `tmdt`.`rams` (`id`, `code`, `frequent`, `storage`) VALUES ('3', 'DDR4', '3200', '8');
INSERT INTO `tmdt`.`rams` (`id`, `code`, `frequent`, `storage`) VALUES ('4', 'DDR4', '3200', '8');
# Thêm Storage
INSERT INTO `tmdt`.`storages` (`id`, `code`, `optane`, `remain`, `slot`, `storage`, `type`)
VALUES ('1', 'M.2 NVMe', b'0', '2', '2', '512GB', 'SSD');
# Thêm dữ liệu cho bảng product
# Thêm Laptop
INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('1', b'1', '4 Cell', 'Acer', '0', '', '1', 'Gaming AN515-57-5669', '18490000',
        '22000000', 'Lithium-ion', '1', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        '', '161.4 x 75.6 x 7.8 mm', '12', '2.2 kg','Trung Quốc','Card onboard (Intel Iris Xe Share)*Card rời (NVIDIA GeForce GTX 1650 4 GB GDDR6)',
        'Khung màn hình: Nhựa*Mặt bàn phím + kê tay: Nhựa*Mặt bên ngoài cùng: Nhựa*Mặt lưng máy: Nhựa','','','Windows 11 Home', '2', '2', '7');
INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('2', b'1', '4 Cell', 'Dell', '0', '', '1', 'Gaming G15 5511', '18490000',
        '22000000', 'Lithium-ion', '2', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        '', '25 x 357.2 x 272 mm', '12', '2.2 kg','Trung Quốc','Card onboard (Intel Iris Xe Share)*Card rời (NVIDIA GeForce GTX 1650 4 GB GDDR6)',
        'Khung màn hình: Nhựa*Mặt bàn phím + kê tay: Nhựa*Mặt bên ngoài cùng: Nhựa*Mặt lưng máy: Nhựa','','','Windows 11 Home', '2', '2', '7');

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('3', b'1', '4 Cell', 'Asus', '0', '', '1', 'Gaming G15 5511', '18490000',
        '22000000', 'Lithium-ion', '3', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        '', '25 x 357.2 x 272 mm', '12', '2.2 kg','Trung Quốc','Card onboard (Intel Iris Xe Share)*Card rời (NVIDIA GeForce GTX 1650 4 GB GDDR6)',
        'Khung màn hình: Nhựa*Mặt bàn phím + kê tay: Nhựa*Mặt bên ngoài cùng: Nhựa*Mặt lưng máy: Nhựa','','','Windows 11 Home', '2', '2', '7');

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('4', b'1', '4 Cell', 'Lenovo', '0', '', '1', 'Gaming G15 5511', '18490000',
        '22000000', 'Lithium-ion', '4', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        '', '25 x 357.2 x 272 mm', '12', '2.2 kg','Trung Quốc','Card onboard (Intel Iris Xe Share)*Card rời (NVIDIA GeForce GTX 1650 4 GB GDDR6)',
        'Khung màn hình: Nhựa*Mặt bàn phím + kê tay: Nhựa*Mặt bên ngoài cùng: Nhựa*Mặt lưng máy: Nhựa','','','Windows 11 Home', '2', '2', '7');


# Thêm điện thoại

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('5', b'0', '4250 mAh', 'Xiaomi', 'Standard (Resolution 64.0, MPAperture	ƒ/1.79, Pixel size	0.70 µm)*Ultra Wide (Resolution	8.0 MP, Aperture ƒ/2.2, Pixel size 1.12 µm)
*Macro lens (Resolution	5.0 MP, Aperture ƒ/2.4, Pixel size 1.12 µm)','Không chỉ là một chiếc điện thoại, Xiaomi 11 Lite 5G NE xứng đáng được gọi là biểu
tượng thời trang trong giới smartphone, nơi bạn được cảm nhận sự thanh tú và tinh tế đến từng đường nét, cùng với đó là sức mạnh không ngờ, kết nối 5G
siêu tốc độ, làm chủ tương lai.',
'1', '11 Lite 5G NE', '18000000', '22000000', 'Lithium polymer', '3', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
'Single selfie camera (Resolution 20.0 MP)', '160.53 x 75.73 x 6.81 mm', '12', '189g','Trung Quốc','Adreno 642L','Khung máy: Kim loại*Mặt lưng máy:
Kính Gorilla Glass 5','4K 4230P@30Fbs*FullHD 1080P@30Fps*FullHD 1080P@60Fbs*HD 720p@30fps','A.I Camera*Chạm lấy nét*Chụp góc rộng (Wide)*Chụp góc siêu rộng (Ultrawide)
*Flash LED HDR*Làm đẹp (Beautify)*Nhận diện khuôn mặt*Siêu cận (Macro)*Toàn cảnh (Panorama)*Trôi nhanh thời gian (Time Lapse)*Tự động lấy nét (AF)*Xóa phông',
'Android 11','1', '1', '1');
INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('6', b'0', '4250 mAh', 'Sony', 'Standard (Resolution 64.0, MPAperture	ƒ/1.79, Pixel size	0.70 µm)*Ultra Wide (Resolution	8.0 MP, Aperture ƒ/2.2, Pixel size 1.12 µm)
*Macro lens (Resolution	5.0 MP, Aperture ƒ/2.4, Pixel size 1.12 µm)','Không chỉ là một chiếc điện thoại, Xiaomi 11 Lite 5G NE xứng đáng được gọi là biểu
tượng thời trang trong giới smartphone, nơi bạn được cảm nhận sự thanh tú và tinh tế đến từng đường nét, cùng với đó là sức mạnh không ngờ, kết nối 5G
siêu tốc độ, làm chủ tương lai.',
        '1', '11 Lite 5G NE', '18000000', '22000000', 'Lithium polymer', '2', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        'Single selfie camera (Resolution 20.0 MP)', '160.53 x 75.73 x 6.81 mm', '12', '189g','Trung Quốc','Adreno 642L','Khung máy: Kim loại*Mặt lưng máy:
Kính Gorilla Glass 5','4K 4230P@30Fbs*FullHD 1080P@30Fps*FullHD 1080P@60Fbs*HD 720p@30fps','A.I Camera*Chạm lấy nét*Chụp góc rộng (Wide)*Chụp góc siêu rộng (Ultrawide)
*Flash LED HDR*Làm đẹp (Beautify)*Nhận diện khuôn mặt*Siêu cận (Macro)*Toàn cảnh (Panorama)*Trôi nhanh thời gian (Time Lapse)*Tự động lấy nét (AF)*Xóa phông',
        'Android 11','1', '1', '1');

INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('7', b'0', '4250 mAh', 'Mastel', 'Standard (Resolution 64.0, MPAperture	ƒ/1.79, Pixel size	0.70 µm)*Ultra Wide (Resolution	8.0 MP, Aperture ƒ/2.2, Pixel size 1.12 µm)
*Macro lens (Resolution	5.0 MP, Aperture ƒ/2.4, Pixel size 1.12 µm)','Không chỉ là một chiếc điện thoại, Xiaomi 11 Lite 5G NE xứng đáng được gọi là biểu
tượng thời trang trong giới smartphone, nơi bạn được cảm nhận sự thanh tú và tinh tế đến từng đường nét, cùng với đó là sức mạnh không ngờ, kết nối 5G
siêu tốc độ, làm chủ tương lai.',
        '1', '11 Lite 5G NE', '18000000', '22000000', 'Lithium polymer', '1', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        'Single selfie camera (Resolution 20.0 MP)', '160.53 x 75.73 x 6.81 mm', '12', '189g','Trung Quốc','Adreno 642L','Khung máy: Kim loại*Mặt lưng máy:
Kính Gorilla Glass 5','4K 4230P@30Fbs*FullHD 1080P@30Fps*FullHD 1080P@60Fbs*HD 720p@30fps','A.I Camera*Chạm lấy nét*Chụp góc rộng (Wide)*Chụp góc siêu rộng (Ultrawide)
*Flash LED HDR*Làm đẹp (Beautify)*Nhận diện khuôn mặt*Siêu cận (Macro)*Toàn cảnh (Panorama)*Trôi nhanh thời gian (Time Lapse)*Tự động lấy nét (AF)*Xóa phông',
        'Android 11','1', '1', '1');
INSERT INTO `tmdt`.`products` (`id`, `amortization`, `battery_capacity`, `brand`, `camera`, `description`, `storage_id`, `model`, `new_price`,
                               `original_price`, `pin`, `ram_id`, `rate`, `release_date`, `selfie`, `size`, `warranty`, `weight`,`origin`,`graphic`,
                               `material`,`video`,`feature`,`os`, `catergory_id`, `cpu_id`, `screen_id`)
VALUES ('8', b'0', '4250 mAh', 'Iphone', 'Standard (Resolution 64.0, MPAperture	ƒ/1.79, Pixel size	0.70 µm)*Ultra Wide (Resolution	8.0 MP, Aperture ƒ/2.2, Pixel size 1.12 µm)
*Macro lens (Resolution	5.0 MP, Aperture ƒ/2.4, Pixel size 1.12 µm)','Không chỉ là một chiếc điện thoại, Xiaomi 11 Lite 5G NE xứng đáng được gọi là biểu
tượng thời trang trong giới smartphone, nơi bạn được cảm nhận sự thanh tú và tinh tế đến từng đường nét, cùng với đó là sức mạnh không ngờ, kết nối 5G
siêu tốc độ, làm chủ tương lai.',
        '1', '11 Lite 5G NE', '18000000', '22000000', 'Lithium polymer', '3', '1.2', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),
        'Single selfie camera (Resolution 20.0 MP)', '160.53 x 75.73 x 6.81 mm', '12', '189g','Trung Quốc','Adreno 642L','Khung máy: Kim loại*Mặt lưng máy:
Kính Gorilla Glass 5','4K 4230P@30Fbs*FullHD 1080P@30Fps*FullHD 1080P@60Fbs*HD 720p@30fps','A.I Camera*Chạm lấy nét*Chụp góc rộng (Wide)*Chụp góc siêu rộng (Ultrawide)
*Flash LED HDR*Làm đẹp (Beautify)*Nhận diện khuôn mặt*Siêu cận (Macro)*Toàn cảnh (Panorama)*Trôi nhanh thời gian (Time Lapse)*Tự động lấy nét (AF)*Xóa phông',
        'Android 11','1', '1', '1');