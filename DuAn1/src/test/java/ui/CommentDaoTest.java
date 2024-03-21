package ui;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CommentDAOTest {
	private CommentDAO commentDAO;

	@BeforeEach
	void setUp() {
		commentDAO = new CommentDAO();
	}

	@Test
	void testInsertComment_Success() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertTrue(result, "Insert comment success");
		assertEquals(1, commentDAO.getNumberOfComments(), "Number of comments should be 1 after successful insert");
	}

	@Test
	void testInsertComment_Failure_NullFields() {
		Comment comment = new Comment(null, null, null, 0, null, null, null, false, false);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_EmptyFields() {
		Comment comment = new Comment("", "", "", 0, "", "", "", false, false);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidRating() {
		Comment comment = new Comment("1", "1", "1", 6, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_LongContent() {
		String longContent = new String(new char[1001]).replace("\0", "a");
		Comment comment = new Comment("1", "1", "1", 5, longContent, "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}
	@Test
	void testInsertComment_InvalidImageFormat() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.txt", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidVideoFormat() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.txt", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_NegativeRating() {
		Comment comment = new Comment("1", "1", "1", -1, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}
	@Test
	void testInsertComment_NullImage() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", null, "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_NullVideo() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", null, true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_DisabledComment() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, false);
		boolean result = commentDAO.insert(comment);
		assertTrue(result, "Insert comment success");
		assertEquals(1, commentDAO.getNumberOfComments(), "Number of comments should be 1 after successful insert");
	}
	@Test
	void testInsertComment_InvalidId() {
		Comment comment = new Comment("", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidReaderId() {
		Comment comment = new Comment("1", "", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidBookId() {
		Comment comment = new Comment("1", "1", "", 5, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}
	@Test
	void testInsertComment_InvalidEditable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", null, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidEnable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, null);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidSao() {
		Comment comment = new Comment("1", "1", "1", null, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}
	@Test
	void testInsertComment_InvalidEditable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", null, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidEnable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, null);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}

	@Test
	void testInsertComment_InvalidSao() {
		Comment comment = new Comment("1", "1", "1", null, "Good book", "image.jpg", "video.mp4", true, true);
		boolean result = commentDAO.insert(comment);
		assertFalse(result, "Error insert comment");
		assertEquals(0, commentDAO.getNumberOfComments(), "Number of comments should be 0 after failed insert");
	}
	//Test update comment
	@Test
	void testUpdateComment_NullFields() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdDanhGia(null);
		comment.setIdReader(null);
		comment.setIdSach(null);
		comment.setSao(null);
		comment.setContent(null);
		comment.setImages(null);
		comment.setVideos(null);
		comment.setEditable(null);
		comment.setEnable(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null fields");
	}

	@Test
	void testUpdateComment_EmptyFields() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdDanhGia("");
		comment.setIdReader("");
		comment.setIdSach("");
		comment.setSao(0);
		comment.setContent("");
		comment.setImages("");
		comment.setVideos("");
		comment.setEditable(false);
		comment.setEnable(false);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty fields");
	}

	@Test
	void testDeleteComment_NullId() {
		assertThrows(Exception.class, () -> commentDAO.delete(null), "Delete should throw an exception for null id");
	}

	@Test
	void testDeleteComment_EmptyId() {
		assertThrows(Exception.class, () -> commentDAO.delete(""), "Delete should throw an exception for empty id");
	}
	@Test
	void testSelectAll_EmptyDatabase() {
		ArrayList<Comment> comments = commentDAO.selectall();
		assertTrue(comments.isEmpty(), "Select all should return an empty list when the database is empty");
	}

	@Test
	void testSelectAll_NonEmptyDatabase() {
		Comment comment1 = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		Comment comment2 = new Comment("2", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment1);
		commentDAO.insert(comment2);
		ArrayList<Comment> comments = commentDAO.selectall();
		assertEquals(2, comments.size(), "Select all should return all comments in the database");
		assertTrue(comments.contains(comment1), "Select all should return the first inserted comment");
		assertTrue(comments.contains(comment2), "Select all should return the second inserted comment");
	}

	@Test
	void testSelectAllByIdSach_NonExistingId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach("non-existing-id");
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id does not exist");
	}

	@Test
	void testSelectAllByIdSach_ExistingId() {
		Comment comment1 = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		Comment comment2 = new Comment("2", "1", "2", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment1);
		commentDAO.insert(comment2);
		ArrayList<Comment> comments = commentDAO.selectallByidSach("1");
		assertEquals(1, comments.size(), "Select all by book id should return all comments for the given book id");
		assertTrue(comments.contains(comment1), "Select all by book id should return the comment for the given book id");
	}

	@Test
	void testSelectAllByIdComment_NonExistingId() {
		Comment comment = commentDAO.selectallByIdcomment("non-existing-id");
		assertNull(comment, "Select all by comment id should return null when the id does not exist");
	}

	@Test
	void testSelectAllByIdComment_ExistingId() {
		Comment comment1 = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment1);
		Comment comment = commentDAO.selectallByIdcomment("1");
		assertEquals(comment1, comment, "Select all by comment id should return the comment for the given comment id");
	}
	@Test
	void testSelectAllByIdReader_NonExistingId() {
		ArrayList<Comment> comments = commentDAO.selectallByidReader("non-existing-id");
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id does not exist");
	}

	@Test
	void testSelectAllByIdReader_ExistingId() {
		Comment comment1 = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		Comment comment2 = new Comment("2", "2", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment1);
		commentDAO.insert(comment2);
		ArrayList<Comment> comments = commentDAO.selectallByidReader("1");
		assertEquals(1, comments.size(), "Select all by reader id should return all comments for the given reader id");
		assertTrue(comments.contains(comment1), "Select all by reader id should return the comment for the given reader id");
	}

	@Test
	void testUpdateComment_InvalidContent() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setContent(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null content");
	}

	@Test
	void testUpdateComment_EmptyContent() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setContent("");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty content");
	}
	@Test
	void testUpdateComment_InvalidRating() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setSao(6);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for invalid rating");
	}

	@Test
	void testUpdateComment_NegativeRating() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setSao(-1);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for negative rating");
	}

	@Test
	void testUpdateComment_InvalidImageFormat() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setImages("image.txt");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for invalid image format");
	}

	@Test
	void testUpdateComment_InvalidVideoFormat() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setVideos("video.txt");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for invalid video format");
	}

	@Test
	void testUpdateComment_NullImage() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setImages(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null image");
	}

	@Test
	void testUpdateComment_NullVideo() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setVideos(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null video");
	}

	@Test
	void testUpdateComment_DisabledComment() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setEnable(false);
		boolean result = commentDAO.update(comment);
		assertTrue(result, "Update comment success");
		Comment updatedComment = commentDAO.selectallByIdcomment("1");
		assertFalse(updatedComment.getEnable(), "Comment should be disabled after update");
	}
	@Test
	void testUpdateComment_InvalidId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdDanhGia("non-existing-id");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for non-existing id");
	}

	@Test
	void testUpdateComment_NullId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdDanhGia(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null id");
	}

	@Test
	void testUpdateComment_EmptyId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdDanhGia("");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty id");
	}

	@Test
	void testDeleteComment_InvalidId() {
		assertThrows(Exception.class, () -> commentDAO.delete("non-existing-id"), "Delete should throw an exception for non-existing id");
	}

	@Test
	void testSelectAllByIdReader_EmptyId() {
		ArrayList<Comment> comments = commentDAO.selectallByidReader("");
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id is empty");
	}

	@Test
	void testSelectAllByIdReader_NullId() {
		ArrayList<Comment> comments = commentDAO.selectallByidReader(null);
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id is null");
	}
	@Test
	void testUpdateComment_InvalidReaderId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdReader("non-existing-id");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for non-existing reader id");
	}

	@Test
	void testUpdateComment_NullReaderId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdReader(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null reader id");
	}

	@Test
	void testUpdateComment_EmptyReaderId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdReader("");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty reader id");
	}

	@Test
	void testUpdateComment_InvalidBookId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdSach("non-existing-id");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for non-existing book id");
	}

	@Test
	void testUpdateComment_NullBookId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdSach(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null book id");
	}

	@Test
	void testUpdateComment_EmptyBookId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setIdSach("");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty book id");
	}
	@Test
	void testUpdateComment_InvalidEditable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setEditable(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null editable");
	}

	@Test
	void testUpdateComment_InvalidEnable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setEnable(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null enable");
	}

	@Test
	void testDeleteComment_Success() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		boolean result = commentDAO.delete("1");
		assertTrue(result, "Delete comment success");
		Comment deletedComment = commentDAO.selectallByIdcomment("1");
		assertNull(deletedComment, "Comment should be null after delete");
	}

	@Test
	void testSelectAllByIdSach_EmptyId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach("");
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is empty");
	}

	@Test
	void testSelectAllByIdSach_NullId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach(null);
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is null");
	}
	@Test
	void testUpdateComment_LongContent() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longContent = new String(new char[1001]).replace("\0", "a");
		comment.setContent(longContent);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long content");
	}

	@Test
	void testUpdateComment_InvalidEditable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setEditable(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null editable");
	}

	@Test
	void testUpdateComment_InvalidEnable() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setEnable(null);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for null enable");
	}

	@Test
	void testDeleteComment_Success() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		boolean result = commentDAO.delete("1");
		assertTrue(result, "Delete comment success");
		Comment deletedComment = commentDAO.selectallByIdcomment("1");
		assertNull(deletedComment, "Comment should be null after delete");
	}

	@Test
	void testSelectAllByIdSach_EmptyId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach("");
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is empty");
	}

	@Test
	void testSelectAllByIdSach_NullId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach(null);
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is null");
	}
	@Test
	void testUpdateComment_LongId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longId = new String(new char[1001]).replace("\0", "a");
		comment.setIdDanhGia(longId);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long id");
	}

	@Test
	void testUpdateComment_LongReaderId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longReaderId = new String(new char[1001]).replace("\0", "a");
		comment.setIdReader(longReaderId);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long reader id");
	}

	@Test
	void testUpdateComment_LongBookId() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longBookId = new String(new char[1001]).replace("\0", "a");
		comment.setIdSach(longBookId);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long book id");
	}

	@Test
	void testDeleteComment_Success() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		boolean result = commentDAO.delete("1");
		assertTrue(result, "Delete comment success");
		Comment deletedComment = commentDAO.selectallByIdcomment("1");
		assertNull(deletedComment, "Comment should be null after delete");
	}

	@Test
	void testSelectAllByIdSach_EmptyId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach("");
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is empty");
	}

	@Test
	void testSelectAllByIdSach_NullId() {
		ArrayList<Comment> comments = commentDAO.selectallByidSach(null);
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is null");
	}
	@Test
	void testUpdateComment_LongImageName() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longImageName = new String(new char[256]).replace("\0", "a");
		comment.setImages(longImageName + ".jpg");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long image name");
	}

	@Test
	void testUpdateComment_LongVideoName() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longVideoName = new String(new char[256]).replace("\0", "a");
		comment.setVideos(longVideoName + ".mp4");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long video name");
	}

	@Test
	void testSelectAllByIdReader_LongId() {
		String longId = new String(new char[1001]).replace("\0", "a");
		ArrayList<Comment> comments = commentDAO.selectallByidReader(longId);
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id is too long");
	}

	@Test
	void testSelectAllByIdSach_LongId() {
		String longId = new String(new char[1001]).replace("\0", "a");
		ArrayList<Comment> comments = commentDAO.selectallByidSach(longId);
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is too long");
	}

	@Test
	void testSelectAllByIdcomment_LongId() {
		String longId = new String(new char[1001]).replace("\0", "a");
		Comment comment = commentDAO.selectallByIdcomment(longId);
		assertNull(comment, "Select all by comment id should return null when the id is too long");
	}
	@Test
	void testUpdateComment_LongContentWithSpaces() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longContent = new String(new char[1001]).replace("\0", " ");
		comment.setContent(longContent);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long content with spaces");
	}

	@Test
	void testUpdateComment_EmptyImageName() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setImages("");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty image name");
	}

	@Test
	void testUpdateComment_EmptyVideoName() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setVideos("");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty video name");
	}

	@Test
	void testSelectAllByIdReader_EmptyId() {
		ArrayList<Comment> comments = commentDAO.selectallByidReader("");
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id is empty");
	}

	@Test
	void testSelectAllByIdReader_NullId() {
		ArrayList<Comment> comments = commentDAO.selectallByidReader(null);
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id is null");
	}

	@Test
	void testSelectAllByIdcomment_EmptyId() {
		Comment comment = commentDAO.selectallByIdcomment("");
		assertNull(comment, "Select all by comment id should return null when the id is empty");
	}

	@Test
	void testSelectAllByIdcomment_NullId() {
		Comment comment = commentDAO.selectallByIdcomment(null);
		assertNull(comment, "Select all by comment id should return null when the id is null");
	}
	@Test
	void testUpdateComment_LongContentWithSpecialCharacters() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		String longContent = new String(new char[1001]).replace("\0", "@");
		comment.setContent(longContent);
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for long content with special characters");
	}

	@Test
	void testUpdateComment_EmptyContentWithSpaces() {
		Comment comment = new Comment("1", "1", "1", 5, "Good book", "image.jpg", "video.mp4", true, true);
		commentDAO.insert(comment);
		comment.setContent("   ");
		assertThrows(Exception.class, () -> commentDAO.update(comment), "Update should throw an exception for empty content with spaces");
	}

	@Test
	void testSelectAllByIdReader_LongIdWithSpecialCharacters() {
		String longId = new String(new char[1001]).replace("\0", "@");
		ArrayList<Comment> comments = commentDAO.selectallByidReader(longId);
		assertTrue(comments.isEmpty(), "Select all by reader id should return an empty list when the id is too long with special characters");
	}

	@Test
	void testSelectAllByIdSach_LongIdWithSpecialCharacters() {
		String longId = new String(new char[1001]).replace("\0", "@");
		ArrayList<Comment> comments = commentDAO.selectallByidSach(longId);
		assertTrue(comments.isEmpty(), "Select all by book id should return an empty list when the id is too long with special characters");
	}

	@Test
	void testSelectAllByIdcomment_LongIdWithSpecialCharacters() {
		String longId = new String(new char[1001]).replace("\0", "@");
		Comment comment = commentDAO.selectallByIdcomment(longId);
		assertNull(comment, "Select all by comment id should return null when the id is too long with special characters");
	}

}