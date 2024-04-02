/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import dao.SachDAO;
import dao.TacGiaDAO;
import dao.TheLoaiDAO;
import dao.UserDAO;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Sach;
import model.TacGia;
import model.TheLoai;
import model.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Extension {

//    Class<Object> class = 
	// Chỉnh kích thước ảnh vừa với widthxheight của Jlabel
	public static void scaleImage(String path, JLabel anh) {
		ImageIcon icon = new ImageIcon(Extension.class.getResource(path));
		// scale image
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(anh.getWidth(), anh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		anh.setIcon(scaledIcon);
	}

	public static void scaleImage(JLabel anh, String fileName) {
		ImageIcon icon = XImage.getImageIcon(fileName);
		// scale image
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(anh.getWidth(), anh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		anh.setIcon(scaledIcon);
	}

	public static int checkUser(String username, String pass) {

		UserDAO dao = new UserDAO();
		ArrayList<User> userList = dao.select();

		for (User user : userList) {
			if ((username.equals(user.getUserName()) || username.equals(user.getEmail()))) {
				if (pass.equals(user.getPassword())) {
//					System.out.println("login successfully");
					return 1;
				} else {
//					System.out.println("Sai Mật Khẩu! Vui lòng thử lại");
					return 0;
				}
			}
		}
//		System.out.println("Tài khoản không tồn tại! Vui lòng kiểm tra thông tin đăng nhập!");
		return -1;
	}

	// Tạo placeholder cho textField
	public static void setPlaceholder(JTextField textField, String placeholder) {
		textField.setText(placeholder);
		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(placeholder)) {
					textField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// nếu textField rỗng -> setplaceholder
				if (textField.getText().isEmpty()) {
					textField.setText(placeholder);
				}
			}
		});
	}

	// thêm sự kiện hiển thị Password cho passwordField
	public static void togglePassword(JPasswordField passwordField) {
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setEchoChar((char) 0);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar('*');
			}
		});
	}

	// return true nếu có 1 or n JtextField rỗng
	public static boolean areEmpty(JTextField... args) {
		for (JTextField txt : args) {
			if (txt.getText().length() == 0) {
				DialogHelper.alert(txt, "Vui lòng nhập đủ các trường");
				return true;
			}
		}
		return false;
	}

	public static boolean areValidString(String... args) {

		for (String txt : args) {
			if (txt.isBlank() || txt.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	// return true nếu textfield chứa nội dung là email
	public static boolean isEmail(JTextField txt) {
		String email = txt.getText();
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			DialogHelper.alert(txt, "Vui lòng nhập đúng syntax Email!");
		}

		return matcher.matches();
	}

	public static boolean isEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	// return một randomString với độ dài là length và có kiểu là randomString =
	// "init" + randomPart;
	public static String randomString(String init, int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder randomString = new StringBuilder(init);

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			randomString.append(characters.charAt(index));
		}

		return randomString.toString();
	}

	public static void setUnderline(JButton... args) {
		for (JButton btn : args) {
			btn.setBorder(null);
			String text = "<html><u style=\"color: blue;\">" + btn.getText() + "</u></html>";
			btn.setText(text);
		}
	}

	// show book cover thông qua url link ảnh
	public static void setBookCover(String imageUrl, JLabel lbl) {
		try {
			URL url = new URL(imageUrl);
			BufferedImage image = ImageIO.read(url);

			if (image != null) {
//                ImageIcon icon = new ImageIcon(image);
				Image scaledImage = image.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				lbl.setIcon(scaledIcon);
			} else {
				System.err.println("Không thể tải hình ảnh từ URL.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Lỗi khi tải hình ảnh từ URL.");
		}
	}

//    public static String randomOTP(int length) {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder randomString = new StringBuilder("user_");
//
//        Random random = new Random();
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(characters.length());
//            randomString.append(characters.charAt(index));
//        }
//
//        return randomString.toString();
//    }
	public static ArrayList<Sach> getListSachfromOpenLibrary(String keyword, int lim, boolean insertable,
			boolean truncated) {
		ArrayList<Sach> ds = new ArrayList<>();
		SachDAO sachDao = new SachDAO();
		TacGiaDAO tacGiaDao = new TacGiaDAO();
		TheLoaiDAO theLoaiDao = new TheLoaiDAO();
		try {
			OkHttpClient client = new OkHttpClient();

			Gson gson = new Gson();

			// Specify the search query to get readable books
			String query = "has_fulltext:true";

			// Build the URL for the OpenLibrary Search API
			String url = "http://openlibrary.org/search.json?q=" + query + "&title=" + keyword;

			Request request = new Request.Builder().url(url).build();

			// Perform the HTTP GET request
			Response response = client.newCall(request).execute();

			// Check if the request was successful (HTTP status code 200)
			if (response.isSuccessful()) {
				// Get the JSON data as a string
				String jsonData = response.body().string();

				JsonObject jsonResponse = gson.fromJson(jsonData, JsonObject.class);

				JsonArray docs = jsonResponse.getAsJsonArray("docs");

				if (!docs.isEmpty()) {
					System.out.println("a");

					// lặp qua jsonArray với mỗi phần từ trong array là jsonElement
					// JsonElement không thể auto parse quan JsonObject
					for (JsonElement book : docs) {
						System.out.println("b");
						JsonObject bookObj = book.getAsJsonObject();
						System.out.println("c");

						String idSach = bookObj.get("key").getAsString();
						System.out.println(idSach);
						if (sachDao.selectByID(idSach) != null && !truncated) {
							continue;
						}
						String tenSach = bookObj.get("title").getAsString();
						int namXB = bookObj.getAsJsonArray("publish_year").get(0).getAsInt();
						int namSangTac = bookObj.get("first_publish_year") == null ? 0
								: bookObj.get("first_publish_year").getAsInt();
						int soTrang = bookObj.get("number_of_pages_median") == null ? 0
								: bookObj.get("number_of_pages_median").getAsInt();
						String ebookAccess = bookObj.get("ebook_access").getAsString();
						boolean hasFulltext = bookObj.get("has_fulltext").getAsBoolean();
						boolean publicScanB = bookObj.get("public_scan_b").getAsBoolean();

						// urlLink chỉ để địa chỉ đọc eBook
						String urlLink = "https://archive.org/details/"
								+ bookObj.getAsJsonArray("ia").get(0).getAsString() + "/mode/2up?ref=ol&view=theater";
						// coverI là ảnh bìa quyển sách
						String coverI = "http://covers.openlibrary.org/b/id/" + bookObj.get("cover_i").getAsString()
								+ "-L.jpg";

						// nếu muốn tải ảnh khi pull data từ api
						URL_Dealer.downloadImage(coverI, false);

						// tìm trên json méo thấy mô tả nên lấy câu đầu tiên thay thế :>>
						JsonArray firstSentence = bookObj.get("first_sentence") == null ? null
								: bookObj.get("first_sentence").getAsJsonArray();
						String moTa = "", cauDau[];
						if (firstSentence != null) {
							cauDau = new String[firstSentence.size()];
							for (int i = 0; i < firstSentence.size(); i++) {
								cauDau[i] = firstSentence.get(i).getAsString();
							}
							moTa = String.join(".", cauDau);
						}

						// do một quyển sách có thể trình bày bằng nhiều ngôn ngữ
						JsonArray languages = bookObj.getAsJsonArray("language");
						String[] ngonNgu = {};
						if (languages != null) {
							ngonNgu = new String[languages.size()];
							for (int i = 0; i < languages.size(); i++) {
								ngonNgu[i] = languages.get(i).getAsString();
							}
						}

						// array tác giả
						JsonArray author_key = bookObj.getAsJsonArray("author_key");
						JsonArray author_name = bookObj.getAsJsonArray("author_name");

						// array thể loại
						JsonArray subject_key = bookObj.getAsJsonArray("subject_key");
						JsonArray subject = bookObj.getAsJsonArray("subject");

						String phienBan = bookObj.get("_version_").getAsString();

						Sach sach = new Sach(idSach, tenSach, namXB, namSangTac, soTrang, ebookAccess, hasFulltext,
								publicScanB, urlLink, coverI, moTa, ngonNgu, phienBan, 0, 0, null);
						System.out.println(sach.toString());
						ds.add(sach);

						if (ds.size() >= lim) {
							return ds;
						}

						if (insertable) {

							sachDao.insert(sach);
							if (author_key != null) {
								for (int i = 0; i < author_key.size(); i++) {
									String idTacGia = author_key.get(i).getAsString();
									String tenTacGia = author_name.get(i).getAsString();
									TacGia tacGia;

									if (tacGiaDao.selectByID(idTacGia) == null) {
										tacGia = new TacGia(idTacGia, tenTacGia);
										tacGiaDao.insert(tacGia);
									} else {
										tacGia = tacGiaDao.selectByID(idTacGia);
									}

									System.out.println(tacGia.toString());
									sachDao.insertSvTG(sach, tacGia);
								}
							}

							if (subject_key != null) {
								for (int i = 0; i < subject_key.size(); i++) {
									String idTheLoai = subject_key.get(i).getAsString();
									String tenTheLoai = subject.get(i).getAsString();

									TheLoai theLoai;

									if (theLoaiDao.selectByID(idTheLoai) == null) {
										theLoai = new TheLoai(idTheLoai, tenTheLoai);
										theLoaiDao.insert(theLoai);
									} else {
										theLoai = theLoaiDao.selectByID(idTheLoai);
									}

									System.out.println(theLoai.toString());
									sachDao.insertSvTL(sach, theLoai);
								}

							}
						}

					}
					return ds;
				}

			} else {
				System.out.println("Error: " + response.code() + " - " + response.message());
			}
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public static void getSachfromOpenLibrary(String keyword, List<Sach> ds, int lim, boolean insertable,
			boolean truncated) {
		ds = new ArrayList<>();
		SachDAO sachDao = new SachDAO();
		TacGiaDAO tacGiaDao = new TacGiaDAO();
		TheLoaiDAO theLoaiDao = new TheLoaiDAO();
		try {
			OkHttpClient client = new OkHttpClient();

			Gson gson = new Gson();

			// Specify the search query to get readable books
			String query = "has_fulltext:true";

			// Build the URL for the OpenLibrary Search API
			String url = "http://openlibrary.org/search.json?q=" + query + "&title=" + keyword;

			Request request = new Request.Builder().url(url).build();

			// Perform the HTTP GET request
			Response response = client.newCall(request).execute();

			// Check if the request was successful (HTTP status code 200)
			if (response.isSuccessful()) {
				// Get the JSON data as a string
				String jsonData = response.body().string();

				JsonObject jsonResponse = gson.fromJson(jsonData, JsonObject.class);

				JsonArray docs = jsonResponse.getAsJsonArray("docs");

				if (!docs.isEmpty()) {
					System.out.println("a");

					// lặp qua jsonArray với mỗi phần từ trong array là jsonElement
					// JsonElement không thể auto parse quan JsonObject
					for (JsonElement book : docs) {
						System.out.println("b");
						JsonObject bookObj = book.getAsJsonObject();
						System.out.println("c");

						String idSach = bookObj.get("key").getAsString();
						System.out.println(idSach);
						if (sachDao.selectByID(idSach) != null && !truncated) {
							continue;
						}
						String tenSach = bookObj.get("title").getAsString();
						int namXB = bookObj.getAsJsonArray("publish_year").get(0).getAsInt();
						int namSangTac = bookObj.get("first_publish_year") == null ? 0
								: bookObj.get("first_publish_year").getAsInt();
						int soTrang = bookObj.get("number_of_pages_median") == null ? 0
								: bookObj.get("number_of_pages_median").getAsInt();
						String ebookAccess = bookObj.get("ebook_access").getAsString();
						boolean hasFulltext = bookObj.get("has_fulltext").getAsBoolean();
						boolean publicScanB = bookObj.get("public_scan_b").getAsBoolean();

						// urlLink chỉ để địa chỉ đọc eBook
						String urlLink = "https://archive.org/details/"
								+ bookObj.getAsJsonArray("ia").get(0).getAsString() + "/mode/2up?ref=ol&view=theater";
						// coverI là ảnh bìa quyển sách
						String coverI = "http://covers.openlibrary.org/b/id/" + bookObj.get("cover_i").getAsString()
								+ "-L.jpg";

						// nếu muốn tải ảnh khi pull data từ api
						URL_Dealer.downloadImage(coverI, false);

						// tìm trên json méo thấy mô tả nên lấy câu đầu tiên thay thế :>>
						JsonArray firstSentence = bookObj.get("first_sentence") == null ? null
								: bookObj.get("first_sentence").getAsJsonArray();
						String moTa = "", cauDau[];
						if (firstSentence != null) {
							cauDau = new String[firstSentence.size()];
							for (int i = 0; i < firstSentence.size(); i++) {
								cauDau[i] = firstSentence.get(i).getAsString();
							}
							moTa = String.join(".", cauDau);
						}

						// do một quyển sách có thể trình bày bằng nhiều ngôn ngữ
						JsonArray languages = bookObj.getAsJsonArray("language");
						String[] ngonNgu = {};
						if (languages != null) {
							ngonNgu = new String[languages.size()];
							for (int i = 0; i < languages.size(); i++) {
								ngonNgu[i] = languages.get(i).getAsString();
							}
						}

						// array tác giả
						JsonArray author_key = bookObj.getAsJsonArray("author_key");
						JsonArray author_name = bookObj.getAsJsonArray("author_name");

						// array thể loại
						JsonArray subject_key = bookObj.getAsJsonArray("subject_key");
						JsonArray subject = bookObj.getAsJsonArray("subject");

						String phienBan = bookObj.get("_version_").getAsString();

						Sach sach = new Sach(idSach, tenSach, namXB, namSangTac, soTrang, ebookAccess, hasFulltext,
								publicScanB, urlLink, coverI, moTa, ngonNgu, phienBan, 0, 0, null);
						System.out.println(sach.toString());
						ds.add(sach);
						if (ds.size() >= 5) {
							return;
						}

						if (insertable) {

							sachDao.insert(sach);
							if (author_key != null) {
								for (int i = 0; i < author_key.size(); i++) {
									String idTacGia = author_key.get(i).getAsString();
									String tenTacGia = author_name.get(i).getAsString();
									TacGia tacGia;

									if (tacGiaDao.selectByID(idTacGia) == null) {
										tacGia = new TacGia(idTacGia, tenTacGia);
										tacGiaDao.insert(tacGia);
									} else {
										tacGia = tacGiaDao.selectByID(idTacGia);
									}

									System.out.println(tacGia.toString());
									sachDao.insertSvTG(sach, tacGia);
								}
							}

							if (subject_key != null) {
								for (int i = 0; i < subject_key.size(); i++) {
									String idTheLoai = subject_key.get(i).getAsString();
									String tenTheLoai = subject.get(i).getAsString();

									TheLoai theLoai;

									if (theLoaiDao.selectByID(idTheLoai) == null) {
										theLoai = new TheLoai(idTheLoai, tenTheLoai);
										theLoaiDao.insert(theLoai);
									} else {
										theLoai = theLoaiDao.selectByID(idTheLoai);
									}

									System.out.println(theLoai.toString());
									sachDao.insertSvTL(sach, theLoai);
								}

							}
						}

					}
				}

			} else {
				System.out.println("Error: " + response.code() + " - " + response.message());
			}
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
}
