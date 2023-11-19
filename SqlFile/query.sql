use Nerdyers
go

-- Inserting records into the SACH table
INSERT INTO SACH (IDSACH, TENSACH, GIANIEMYET, THUMBNAIL, AVATAR, MOTA, DANHGIATB, MINAGE, PDFAVAI, AUDIOAVAI, SOTRANG, NGONNGU, SOURCEPDF, sourceSound, FREE, LIKECOUNT, viewcount)
VALUES 
('S001', 'Book One', 20, '/thumbnails/book1_thumbnail.jpg', '/avatars/book1_avatar.jpg', 'Description for Book One', 4.5, 10, 1, 0, 150, 'en', '/pdfs/book1.pdf', '/sounds/book1.mp3', 1, 50, 100),
('S002', 'Book Two', 25, '/thumbnails/book2_thumbnail.jpg', '/avatars/book2_avatar.jpg', 'Description for Book Two', 4.2, 12, 1, 1, 200, 'en', '/pdfs/book2.pdf', '/sounds/book2.mp3', 0, 30, 80),
('S003', 'Book Three', 18, '/thumbnails/book3_thumbnail.jpg', '/avatars/book3_avatar.jpg', 'Description for Book Three', 4.8, 8, 0, 0, 180, 'en', '/pdfs/book3.pdf', '/sounds/book3.mp3', 1, 70, 120);

update SACH
set TENSACH = '?', GIANIEMYET = '?', THUMBNAIL = '?' ,...
where IDSACH = '?'

insert into SACH (IDSACH, TENSACH, THUMBNAIL, SOTRANG)
values
('s001', 'abc', null, 256);

select * from SACH