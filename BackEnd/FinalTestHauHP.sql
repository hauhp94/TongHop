CREATE DATABASE FinalSQL
USE FinalSQL
CREATE TABLE Phong
(MaPhong CHAR(5) PRIMARY KEY ,
TenPhong VARCHAR(20) NOT NULL,
GiaThue MONEY,
GhiChu VARCHAR(50))

CREATE TABLE LoaiSuKien
(MaLoaiSK CHAR(4) PRIMARY KEY,
TenLoaiSK VARCHAR(50))

CREATE TABLE SuKien
(MaSK CHAR(5) PRIMARY KEY,
MaLoaiSK CHAR(4),
TenNPT VARCHAR(50),
DiaChi VARCHAR(100),
SoDienThoai VARCHAR(10),
NgayToChuc DATE,
FOREIGN KEY (MaLoaiSK) REFERENCES dbo.LoaiSuKien(MaLoaiSK))

CREATE TABLE DangKyThue
(MaDKT CHAR(6) PRIMARY KEY,
MaPhong CHAR(4),
MaSK CHAR(5),
GiaThucTe MONEY,
FOREIGN KEY (MaSK) REFERENCES dbo.SuKien(MaSK))

CREATE TABLE DichVu
(MaDV CHAR(5) PRIMARY KEY,
TenDV VARCHAR(20),
GiaDV MONEY)

CREATE TABLE CTDangKyThue
(MaCT CHAR(5) PRIMARY KEY,
MaDKT CHAR(6),
MaDV CHAR(5),
FOREIGN KEY (MaDKT) REFERENCES dbo.DangKyThue(MaDKT),
FOREIGN KEY (MaDV) REFERENCES dbo.DichVu(MaDV))

INSERT INTO dbo.DichVu
(
    MaDV,
    TenDV,
    GiaDV
)
VALUES
(   'DV001',  -- MaDV - char(5)
    'MC',  -- TenDV - varchar(20)
    1000000 -- GiaDV - money
    ),
(   'DV002',  -- MaDV - char(5)
    'Ca si',  -- TenDV - varchar(20)
    2000000 -- GiaDV - money
    ),
(   'DV003',  -- MaDV - char(5)
    'Vu Doan',  -- TenDV - varchar(20)
    2000000 -- GiaDV - money
    )
SELECT * FROM dbo.DichVu

INSERT INTO dbo.Phong
(
    MaPhong,
    TenPhong,
    GiaThue,
    GhiChu
)
VALUES
(   'P001',   -- MaPhong - char(5)
    'Green',   -- TenPhong - varchar(20)
    4000000, -- GiaThue - money
    'Co may chieu'    -- GhiChu - varchar(50)
    ),
(   'P002',   -- MaPhong - char(5)
    'Yellow',   -- TenPhong - varchar(20)
    6500000, -- GiaThue - money
    'Co may chieu'    -- GhiChu - varchar(50)
    ),
(   'P003',   -- MaPhong - char(5)
    'Blue',   -- TenPhong - varchar(20)
    3500000, -- GiaThue - money
    'Co am thanh, may chieu'    -- GhiChu - varchar(50)
    ),
(   'P004',   -- MaPhong - char(5)
    'Pink',   -- TenPhong - varchar(20)
    5500000, -- GiaThue - money
    'Khong co may chieu'    -- GhiChu - varchar(50)
    )
SELECT * FROM dbo.Phong

INSERT INTO dbo.LoaiSuKien
(
    MaLoaiSK,
    TenLoaiSK
)
VALUES
(   'L001', -- MaLoaiSK - char(4)
    'Thanking party'  -- TenLoaiSK - varchar(50)
    ),
(   'L002', -- MaLoaiSK - char(4)
    'Welcome party'  -- TenLoaiSK - varchar(50)
    ),
(   'L003', -- MaLoaiSK - char(4)
    'Birthday party'  -- TenLoaiSK - varchar(50)
    )

SELECT * FROM dbo.LoaiSuKien

INSERT INTO dbo.SuKien
(
    MaSK,
    MaLoaiSK,
    TenNPT,
    DiaChi,
    SoDienThoai,
    NgayToChuc
)
VALUES
(   'SK001',       -- MaSK - char(5)
    'L001',       -- MaLoaiSK - char(4)
    'Nguyen Van Hung',       -- TenNPT - varchar(50)
    '76 CMT8',       -- DiaChi - varchar(100)
    '0976657654',       -- SoDienThoai - varchar(10)
    '2020-10-5' -- NgayToChuc - date
    ),
(   'SK002',       -- MaSK - char(5)
    'L002',       -- MaLoaiSK - char(4)
    'Nguyen Van Son',       -- TenNPT - varchar(50)
    '25 Ha Huy Tap',       -- DiaChi - varchar(100)
    '0988765432',       -- SoDienThoai - varchar(10)
    '2021-03-09' -- NgayToChuc - date
    ),
(   'SK003',       -- MaSK - char(5)
    'L003',       -- MaLoaiSK - char(4)
    'Tran Thi Phuong',       -- TenNPT - varchar(50)
    '17 Hai Phong',       -- DiaChi - varchar(100)
    '0915976546',       -- SoDienThoai - varchar(10)
    '2021-05-07' -- NgayToChuc - date
    ),
(   'SK004',       -- MaSK - char(5)
    'L001',       -- MaLoaiSK - char(4)
    'Le Phan Thi',       -- TenNPT - varchar(50)
    '5 Nam Ky Khoi Nghia',       -- DiaChi - varchar(100)
    '0987643342',       -- SoDienThoai - varchar(10)
    '2021-04-20' -- NgayToChuc - date
    ),
(   'SK005',       -- MaSK - char(5)
    'L002',       -- MaLoaiSK - char(4)
    'Bui Viet Linh',       -- TenNPT - varchar(50)
    '257 Nguyen Tri Phuong',       -- DiaChi - varchar(100)
    '0963456543',       -- SoDienThoai - varchar(10)
    '2021-06-30' -- NgayToChuc - date
    )

	SELECT * FROM dbo.SuKien

INSERT INTO dbo.DangKyThue
(
    MaDKT,
    MaPhong,
    MaSK,
    GiaThucTe
)
VALUES
(   'DKT001',  -- MaDKT - char(5)
    'P001',  -- MaPhong - char(4)
    'SK001',  -- MaSK - char(5)
    3000000 -- GiaThucTe - money
    ),
(   'DKT002',  -- MaDKT - char(5)
    'P002',  -- MaPhong - char(4)
    'SK002',  -- MaSK - char(5)
    5000000 -- GiaThucTe - money
    ),
(   'DKT003',  -- MaDKT - char(5)
    'P003',  -- MaPhong - char(4)
    'SK003',  -- MaSK - char(5)
    2000000 -- GiaThucTe - money
    ),
(   'DKT004',  -- MaDKT - char(5)
    'P004',  -- MaPhong - char(4)
    'SK004',  -- MaSK - char(5)
    4500000 -- GiaThucTe - money
    ),
(   'DKT005',  -- MaDKT - char(5)
    'P004',  -- MaPhong - char(4)
    'SK005',  -- MaSK - char(5)
    2500000 -- GiaThucTe - money
    )
SELECT * FROM dbo.DangKyThue

INSERT INTO dbo.CTDangKyThue
(
    MaCT,
    MaDKT,
    MaDV
)
VALUES
(   'LS001', -- MaCT - char(5)
    'DKT001', -- MaDKT - char(6)
    'DV001'  -- MaDV - char(5)
    ),
(   'LS002', -- MaCT - char(5)
    'DKT002', -- MaDKT - char(6)
    'DV002'  -- MaDV - char(5)
    ),
(   'LS003', -- MaCT - char(5)
    'DKT003', -- MaDKT - char(6)
    'DV003'  -- MaDV - char(5)
    ),
(   'LS004', -- MaCT - char(5)
    'DKT004', -- MaDKT - char(6)
    'DV001'  -- MaDV - char(5)
    )
SELECT * FROM dbo.CTDangKyThue
-- CAU 3
SELECT * FROM dbo.Phong

SELECT dbo.Phong.MaPhong, TenPhong, DangKyThue.MaSK,
TenLoaiSK, TenNPT, SoDienThoai, DiaChi FROM dbo.Phong
LEFT JOIN dbo.DangKyThue ON DangKyThue.MaPhong = Phong.MaPhong
LEFT JOIN dbo.SuKien ON SuKien.MaSK = DangKyThue.MaSK
LEFT JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK
ORDER BY DangKyThue.MaPhong, DangKyThue.MaSK DESC

-- CAU 4
INSERT INTO dbo.SuKien
(
    MaSK,
    MaLoaiSK,
    TenNPT,
    DiaChi,
    SoDienThoai,
    NgayToChuc
)
VALUES
(   'SK006',       -- MaSK - char(5)
    'L001',       -- MaLoaiSK - char(4)
    'Huynh Phuoc Hau',       -- TenNPT - varchar(50)
    '999 Nguyen Van Linh',       -- DiaChi - varchar(100)
    '0909119119',       -- SoDienThoai - varchar(10)
    '2021-12-12' -- NgayToChuc - date
    )
INSERT INTO dbo.SuKien
(
    MaSK,
    MaLoaiSK,
    TenNPT,
    DiaChi,
    SoDienThoai,
    NgayToChuc
)
VALUES
(   'SK007',       -- MaSK - char(5)
    'L002',       -- MaLoaiSK - char(4)
    'Huynh Van Toan',       -- TenNPT - varchar(50)
    '12 Nguyen Van Linh',       -- DiaChi - varchar(100)
    '0909000119',       -- SoDienThoai - varchar(10)
    '2021-12-12' -- NgayToChuc - date
    )
INSERT INTO dbo.LoaiSuKien
(
    MaLoaiSK,
    TenLoaiSK
)
VALUES
(   'L004', -- MaLoaiSK - char(4)
    'Tet Holiday'  -- TenLoaiSK - varchar(50)
    ),
(   'L005', -- MaLoaiSK - char(4)
    'Ram Holiday'  -- TenLoaiSK - varchar(50)
    )
INSERT INTO dbo.SuKien
(
    MaSK,
    MaLoaiSK,
    TenNPT,
    DiaChi,
    SoDienThoai,
    NgayToChuc
)
VALUES
(   'SK008',       -- MaSK - char(5)
    'L004',       -- MaLoaiSK - char(4)
    'Huynh Van Linh',       -- TenNPT - varchar(50)
    '60 Nguyen Van Linh',       -- DiaChi - varchar(100)
    '0909000000',       -- SoDienThoai - varchar(10)
    '2021-10-12' -- NgayToChuc - date
    ),
(   'SK009',       -- MaSK - char(5)
    'L005',       -- MaLoaiSK - char(4)
    'Huynh Van Vinh',       -- TenNPT - varchar(50)
    '88 Nguyen Van Linh',       -- DiaChi - varchar(100)
    '0909000900',       -- SoDienThoai - varchar(10)
    '2021-10-01' -- NgayToChuc - date
    )
SELECT DISTINCT dbo.LoaiSuKien.MaLoaiSK, TenLoaiSK FROM dbo.SuKien
RIGHT JOIN dbo.DangKyThue ON DangKyThue.MaSK = SuKien.MaSK
RIGHT JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK
WHERE DangKyThue.MaSK IS NULL

SELECT  SuKien.MaLoaiSK, TenLoaiSK FROM dbo.SuKien
LEFT JOIN dbo.DangKyThue ON DangKyThue.MaSK = SuKien.MaSK
LEFT JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK
WHERE SuKien.MaLoaiSK NOT IN 
(SELECT MaLoaiSK FROM dbo.SuKien 
JOIN dbo.DangKyThue ON DangKyThue.MaSK = SuKien.MaSK)

-- cau 5

SELECT TOP(1) Phong.MaPhong, TenPhong,MaDKT,NgayToChuc FROM dbo.Phong
JOIN dbo.DangKyThue ON DangKyThue.MaPhong = Phong.MaPhong
JOIN dbo.SuKien ON SuKien.MaSK = DangKyThue.MaSK
JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK
WHERE TenLoaiSK = 'Thanking party' AND MONTH(NgayToChuc) IN (1,2,3) AND YEAR(NgayToChuc) =2021
ORDER BY GiaThucTe DESC
SELECT * FROM dbo.LoaiSuKien
SELECT * FROM dbo.SuKien
INSERT INTO dbo.SuKien
(
    MaSK,
    MaLoaiSK,
    TenNPT,
    DiaChi,
    SoDienThoai,
    NgayToChuc
)
VALUES
(   'SK010',       -- MaSK - char(5)
    'L001',       -- MaLoaiSK - char(4)
    'Huynh Van Ba',       -- TenNPT - varchar(50)
    '112 Nguyen Cong Tru',       -- DiaChi - varchar(100)
    '0653999888',       -- SoDienThoai - varchar(10)
    '2021-02-02' -- NgayToChuc - date
    )
	SELECT * FROM dbo.DangKyThue
INSERT INTO dbo.DangKyThue
(
    MaDKT,
    MaPhong,
    MaSK,
    GiaThucTe
)
VALUES
(   'DKT006',  -- MaDKT - char(6)
    'P002',  -- MaPhong - char(4)
    'SK002',  -- MaSK - char(5)
    4500000 -- GiaThucTe - money
    )
-- CAU 6
SELECT Phong.MaPhong, TenPhong, COUNT(dbo.DangKyThue.MaPhong)AS SoLanThue   FROM dbo.Phong
JOIN dbo.DangKyThue ON DangKyThue.MaPhong = Phong.MaPhong
JOIN dbo.SuKien ON SuKien.MaSK = DangKyThue.MaSK
WHERE YEAR(NgayToChuc) ='2020'
GROUP BY Phong.MaPhong, TenPhong

-- cau 7
SELECT TOP(2) TenDV, COUNT(dbo.CTDangKyThue.maDV) AS SoLanToChuc FROM dbo.LoaiSuKien
JOIN dbo.SuKien ON SuKien.MaLoaiSK = LoaiSuKien.MaLoaiSK
JOIN dbo.DangKyThue ON DangKyThue.MaSK = SuKien.MaSK
JOIN dbo.CTDangKyThue ON CTDangKyThue.MaDKT = DangKyThue.MaDKT
JOIN dbo.DichVu ON DichVu.MaDV = CTDangKyThue.MaDV
WHERE TenLoaiSK = 'Birthday party'
GROUP BY DichVu.TenDV
ORDER BY COUNT(dbo.CTDangKyThue.maDV) DESC

-- cau 8
SELECT * FROM dbo.DangKyThue
INSERT INTO dbo.DangKyThue
(
    MaDKT,
    MaPhong,
    MaSK,
    GiaThucTe
)
VALUES
(   'DKT007',  -- MaDKT - char(6)
    'P001',  -- MaPhong - char(4)
    'SK001',  -- MaSK - char(5)
    52000000 -- GiaThucTe - money
    )
SELECT Phong.MaPhong, TenPhong, COUNT(DangKyThue.MaPhong) SoLanThue FROM dbo.Phong
JOIN dbo.DangKyThue ON DangKyThue.MaPhong = Phong.MaPhong
WHERE GiaThucTe >50000000
GROUP BY Phong.MaPhong, TenPhong

-- CAU 9
SELECT SuKien.MaSK,COUNT(dbo.CTDangKyThue.MaDV) AS SoLanThue FROM dbo.SuKien
JOIN dbo.DangKyThue ON DangKyThue.MaSK = SuKien.MaSK
JOIN dbo.CTDangKyThue ON CTDangKyThue.MaDKT = DangKyThue.MaDKT
JOIN dbo.DichVu ON DichVu.MaDV = CTDangKyThue.MaDV
WHERE TenDV = 'MC' 
AND GiaDV >=2000000
AND SuKien.MaSK NOT IN
(SELECT MaSK FROM dbo.DangKyThue
JOIN dbo.CTDangKyThue ON CTDangKyThue.MaDKT = DangKyThue.MaDKT
JOIN dbo.DichVu ON DichVu.MaDV = CTDangKyThue.MaDV
WHERE TenDV = 'MC' 
GROUP BY MaSK
HAVING COUNT( MaSK)>1)
GROUP BY SuKien.MaSK
HAVING COUNT(dbo.CTDangKyThue.MaDV) IN (2,3)


-- CAU 10
UPDATE dbo.DangKyThue
SET GiaThucTe  = GiaThucTe *0.9
WHERE MaDKT IN
(SELECT MaDKT FROM dbo.DangKyThue
JOIN dbo.SuKien ON SuKien.MaSK = DangKyThue.MaSK
JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK
WHERE TenLoaiSK = 'Thanking party' AND 
(NgayToChuc BETWEEN '2020-10-01' AND '2020-10-10') )

-- cau 11
SELECT DISTINCT Phong.MaPhong, TenPhong, GiaThue, GhiChu  FROM dbo.Phong
JOIN dbo.DangKyThue ON DangKyThue.MaPhong = Phong.MaPhong
JOIN dbo.SuKien ON SuKien.MaSK = DangKyThue.MaSK
JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK 
WHERE TenLoaiSK = 'Welcome party'
AND GiaThucTe >=50000000
AND Phong.MaPhong NOT IN 
(SELECT MaPhong FROM dbo.DangKyThue
JOIN dbo.SuKien ON SuKien.MaSK = DangKyThue.MaSK
JOIN dbo.LoaiSuKien ON LoaiSuKien.MaLoaiSK = SuKien.MaLoaiSK
WHERE TenLoaiSK != 'Welcom party')

SELECT * FROM dbo.Phong
INSERT INTO dbo.Phong
(
    MaPhong,
    TenPhong,
    GiaThue,
    GhiChu
)
VALUES
(   'P006',   -- MaPhong - char(5)
    'Gray',   -- TenPhong - varchar(20)
    18000000, -- GiaThue - money
    'Phong vip '    -- GhiChu - varchar(50)
    )
	SELECT * FROM dbo.LoaiSuKien
	SELECT * FROM dbo.SuKien
	INSERT INTO dbo.SuKien
	(
	    MaSK,
	    MaLoaiSK,
	    TenNPT,
	    DiaChi,
	    SoDienThoai,
	    NgayToChuc
	)
	VALUES
	(   'SK012',       -- MaSK - char(5)
	    'L002',       -- MaLoaiSK - char(4)
	    'Nguyen Pohng',       -- TenNPT - varchar(50)
	    '99 Phan Dang Tri',       -- DiaChi - varchar(100)
	    '0945123123',       -- SoDienThoai - varchar(10)
	    '2021-11-11' -- NgayToChuc - date
	    )
		SELECT * FROM dbo.DangKyThue
INSERT INTO dbo.DangKyThue
(
    MaDKT,
    MaPhong,
    MaSK,
    GiaThucTe
)
VALUES
(   'DKT008',  -- MaDKT - char(6)
    'P006',  -- MaPhong - char(4)
    'SK012',  -- MaSK - char(5)
    19000000 -- GiaThucTe - money
    )

-- cau 12 Đề: Xóa những Phòng mà chưa từng được đăng ký thuê bất cứ 1 lần nào
DELETE FROM dbo.Phong
WHERE MaPhong NOT IN
(SELECT MaPhong FROM dbo.DangKyThue
)