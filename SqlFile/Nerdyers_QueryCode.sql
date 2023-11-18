use Nerdyers
go

--Procedure Thống kê----

--THống kê doanh thu theo thời gian

create or alter procedure doanhThu @time nvarchar(10)
as
begin
	select * from DONHANG
end
go


------

--trigger

GO
create or alter TRIGGER insert_Reader
ON Reader
AFTER INSERT
AS
BEGIN
    DECLARE @idReader NVARCHAR(100); 
    SELECT @idReader = idReader FROM inserted;
    
    INSERT INTO Wishlist (idWishlist, totalCount) VALUES (@idReader, 0); 
    INSERT INTO READLIST (IDREADLIST, alternativeName, totalPDFCount, totalAudioCount) VALUES (@idReader, '', 0, 0); 
    INSERT INTO GIOHANG (IDGIOHANG, SELECTALL, TONGTIEN, ITEMSCOUNT) VALUES (@idReader, 0, 0, 0); 
END;
GO
/*
-- Insert rows into table 'Users' in schema '[dbo]'
INSERT INTO [dbo].[Users]
VALUES
(N'HUY2311', N'HUY000', N'123', N'NHOX', N'HUY', CAST(0xEF150B00 AS Date))
GO

SELECT * FROM [dbo].[USERS]
GO

INSERT INTO [dbo].[Reader]
VALUES
(N'WTF', N'HUY2311', 1, 1000)
GO
*/






create or alter TRIGGER tinh_subtotal
ON DHCT
AFTER INSERT
AS
BEGIN
    DECLARE @iddonhang NVARCHAR(100);
    DECLARE @subtotal INT;

    -- Lấy ID đơn hàng từ dòng vừa được thêm vào bảng DHCT
    SELECT @iddonhang = INSERTED.IDDONHANG FROM INSERTED;

    -- Tính toán subtotal dựa trên số lượng sách và cập nhật vào bảng DHCT
    UPDATE DHCT
    SET SUBTOTAL = INSERTED.SOLUONGSACH * (SELECT GIANIEMYET FROM SACH WHERE IDSACH = INSERTED.IDSACH)
    FROM DHCT
    INNER JOIN INSERTED 
	ON DHCT.IDSACH = INSERTED.IDSACH

	-- Tính toán tổng tiền dựa trên subtotal và cập nhật vào bảng đơn hàng
    SELECT @subtotal = SUM(SUBTOTAL) FROM DHCT WHERE IDDONHANG = @iddonhang;
    UPDATE DONHANG
    SET TONGTIEN = @subtotal
    WHERE IDDONHANG = @iddonhang;
END;
GO
/*
-- Insert rows into table 'SACH' in schema '[dbo]'
INSERT INTO [dbo].[SACH]
VALUES
(N'1', N'HUYDZ', 120, 100, N'2TF', N'2TF', N'2TF', N'2TF',2 , 1, 1, 1, N'2TF' ,1 ,N'2TF', N'2TF',N'2TF',1,1),
(N'2', N'HUYDZ', 50, 100, N'2TF', N'2TF', N'2TF', N'2TF',2 , 1, 1, 1, N'2TF' ,1 ,N'2TF', N'2TF',N'2TF',1,1),
(N'3', N'HUYDZ', 60, 100, N'2TF', N'2TF', N'2TF', N'2TF',2 , 1, 1, 1, N'2TF' ,1 ,N'2TF', N'2TF',N'2TF',1,1)
GO


INSERT INTO [dbo].[KHUYENMAI]
VALUES
(N'HUYCAIWTF', CAST(0xEF150B00 AS Date), CAST(0xEF150B00 AS Date), 1, 1, 1, 1)
GO

INSERT INTO [dbo].[DONHANG]
VALUES
(N'DHHUY', N'WTF', N'HUYCAIWTF', 0, CAST(0x48230B00 AS Date))
GO

INSERT INTO [dbo].[DHCT]
VALUES
(N'DHHUY', N'1', 2, 0),
(N'DHHUY', N'2', 3, 0),
(N'DHHUY', N'3', 2, 0)
GO

-- Delete rows from table '[DHCT]' in schema '[dbo]'
DELETE FROM [dbo].[DHCT]
WHERE IDDONHANG = N'DHHUY'
GO
*/




create or alter TRIGGER tr_comment_update
ON COMMENT
INSTEAD OF UPDATE
AS
BEGIN
DECLARE @iddanhgia NVARCHAR(100), @idreader nvarchar(100), @idsach nvarchar(100);

SELECT @iddanhgia = IDDANHGIA, @idreader = idreader, @idsach = idsach
FROM deleted;

-- Ẩn bản ghi cũ
UPDATE COMMENT
SET [enable] = 0, editable = 0
WHERE IDDANHGIA = @iddanhgia;

-- Thêm bản ghi mới với ENABLES = 1 và không thể chỉnh sửa (EDITTABLE = 0)
INSERT INTO COMMENT (IDDANHGIA, IDREADER, IDSACH, SAO, CONTENT, IMAGES, VIDEOS, editable, [enable])
SELECT @iddanhgia + '.v2', @IDREADER, @IDSACH, SAO, CONTENT, IMAGES, VIDEOS, 0, 1
FROM INSERTED;

END;
GO

/* Insert rows into table 'COMMENT' in schema '[dbo]'
INSERT INTO [dbo].[COMMENT]
VALUES
(N'1', N'WTF', N'2', 1, N'CAIWTFGITHE', N'HUH', N'HUH', 1, 1),
(N'2', N'WTF', N'2', 1, N'CAIWTFGITHE', N'HUH', N'HUH', 1, 1)
GO

-- Update rows in table '[COMMENT]' in schema '[dbo]'
UPDATE [dbo].[COMMENT]
SET
CONTENT = N'OMG'
WHERE IDDANHGIA = N'1'
GO
*/