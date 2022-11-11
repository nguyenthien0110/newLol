package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBconnection;
import entity.Account;
import entity.newsPost;
import entity.typeNews;

public class dao {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public Account checkLogin(String user, String pass) {
		try {
			String query = "SELECT * FROM `accout` WHERE username = ? AND password = ?";
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));
				return a;
			}

		} catch (Exception e) {
			e.printStackTrace();//https://helpex.vn/question/viec-su-dung-phuong-thuc-printstacktrace-trong-java-la-gi-5ccacb8dae03f63cf0b2a291
		}
		return null;
	}

	public Account checkAccountExist(String user) {
		try {
			String query = "SELECT * FROM `accout` WHERE username = ?";
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));
				return a;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countVisitor(String user) {
		int cVisitor = 0;
		String query = "SELECT viѕitor FROM accout WHERE username = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				cVisitor = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cVisitor;
	}

	// Change visitor
	public void updateVisitor(String user, int visitor) {
		String query = "UPDATE `accout` SET `viѕitor`= ? WHERE username = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, visitor);
			ps.setString(2, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void signUp(String user, String pass) {
		try {
			String query = "INSERT INTO `accout`(`username`, `password`, `viѕitor`, `admin`) VALUES (?,?,0,0)";
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get all data len JSP
	public List<newsPost> getAllNewsPost() {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost GROUP BY id DESC";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2).substring(0, 10), rs.getString(3).substring(0, 10),
						rs.getString(4).substring(0, 10), rs.getString(5).substring(0, 50), rs.getString(6),
						rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<typeNews> getAllTypeNews() {
		List<typeNews> list = new ArrayList<>();
		String query = "SELECT * FROM typenews";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new typeNews(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// top 1 new post
	public newsPost getTop1News() {
		String query = "SELECT * FROM newspost ORDER BY id DESC LIMIT 1";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// top 2 news
	public newsPost getTop2News() {
		String query = "SELECT * FROM newspost ORDER BY id DESC LIMIT 1,1";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// top 3 news
	public newsPost getTop3News() {
		String query = "SELECT * FROM newspost ORDER BY id DESC LIMIT 2,1";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// top 4 news
	public newsPost getTop4News() {
		String query = "SELECT * FROM newspost ORDER BY id DESC LIMIT 3,1";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// top 5 news
	public newsPost getTop5News() {
		String query = "SELECT * FROM newspost ORDER BY id DESC LIMIT 4,1";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Trendding
	public List<newsPost> trenddinList() {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost WHERE trend = 1 GROUP BY id DESC LIMIT 4";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// return a news folow id
	public newsPost getOneNewsPost(int id) {
		String query = "SELECT * FROM newspost WHERE id = ? GROUP BY id DESC";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// get rangdom news post
	public List<newsPost> getRanNewsPost() {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM `newspost` ORDER BY RAND() LIMIT 4";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// get news post to category.jsp
	public List<newsPost> getListCategory(String index) {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost WHERE typeNews = ? GROUP BY id DESC";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// return count post type ?
	public int totalPageCategory(String index) {
		int total = 0;
		String query = "SELECT COUNT(*) FROM newspost WHERE typeNews = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				int totalA = rs.getInt(1);
				total = totalA / 5;
				if (total % 5 != 0) {
					total++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

//list news folow index
	public List<newsPost> pagingList(int index) {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost GROUP BY id DESC LIMIT 5 OFFSET ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, index * 5 - 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5).substring(0, 100), rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Seach
	public List<newsPost> getListSeach(String index) {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost WHERE titleName LIKE ? OR content LIKE ? OR  dayNews LIKE ? OR typeNews LIKE ? ";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, index);
			ps.setString(2, index);
			ps.setString(3, index);
			ps.setString(4, index);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<newsPost> pagingListCate(String type, int index) {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost WHERE typeNews = ? GROUP BY id DESC LIMIT 5 OFFSET ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, type);
			ps.setInt(2, index * 5 - 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5).substring(0, 100), rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// list Crud paging
	public List<newsPost> pagingListCRUD(int index) {
		List<newsPost> list = new ArrayList<>();
		String query = "SELECT * FROM newspost GROUP BY id DESC LIMIT 5 OFFSET ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, index * 5 - 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new newsPost(rs.getInt(1), rs.getString(2).substring(0, 10), rs.getString(3).substring(0, 10),
						rs.getString(4).substring(0, 10), rs.getString(5).substring(0, 100), rs.getString(6),
						rs.getBoolean(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//count Showing x out of x entries
	public int countBackList(int index) {
		int count = 0;
		String query = "SELECT * FROM newspost GROUP BY id DESC LIMIT 5 OFFSET ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, index * 5 - 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = count + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public newsPost getNewsPost(int index) {
		String query = "SELECT * FROM newspost WHERE id = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, index);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// inser nice !!!
	public void insertNews(String dayNews, String titleName, String imageLink, String content, String typeNews,
			String trend) {
		String query = "INSERT INTO newspost(`dayNews`, `titleName`, `imageLink`, `content`, `typeNews`, `trend`) VALUES (?,?,?,?,?,?)";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, dayNews);
			ps.setString(2, titleName);
			ps.setString(3, imageLink);
			ps.setString(4, content);
			ps.setString(5, typeNews);
			ps.setString(6, trend);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete nice !!!
	public void deleteNews(String id) {
		String query = "DELETE FROM newspost WHERE id = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public newsPost getOneNewsPost(String id) {
		String query = "SELECT * FROM newspost WHERE id = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new newsPost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateNews(String dayNews, String titleName, String imageLink, String content, String typeNews,
			String trend, String id) {
		String query = "UPDATE newspost SET dayNews=?, titleName=?, imageLink =?, content=?, typeNews=?, trend=? WHERE newspost.id = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, dayNews);
			ps.setString(2, titleName);
			ps.setString(3, imageLink);
			ps.setString(4, content);
			ps.setString(5, typeNews);
			ps.setString(6, trend);
			ps.setString(7, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// count news
	public int countList() {
		int count = 0;
		String query = "SELECT COUNT(*) FROM newspost";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				{
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// return count post type ?
	public int totalPage() {
		int total = 0;
		int totalA = countList();
		total = totalA / 5;
		if (totalA % 5 != 0) {
			++total;
		}
		return total;
	}

	public typeNews getOneTypeNews(String typeNews) {
		String query = "SELECT * FROM `typenews` WHERE typeNews=?";
		try {
			conn = new DBconnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, typeNews);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new typeNews(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> listAccounts() {
		List<Account> list = new ArrayList<>();
		String query = "SELECT * FROM accout";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Account> listAccSeach(String seach) {
		List<Account> list = new ArrayList<>();
		String query = "SELECT * FROM accout WHERE username = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, seach);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// insert user
	public void insertAcc(String username, String password, String checkAdmin) {
		String query = "INSERT INTO `accout`(`username`, `password`, `viѕitor`, `admin`) VALUES (?,?,0,?)";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, checkAdmin);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Set acc user
	public Account accUser(String user) {
		String query = "SELECT * FROM accout WHERE username = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// update user
	public void updateAcc(String user, String pass, String checkAdmin) {
		String query = "UPDATE accout SET username=?, password=?, admin=? WHERE username = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, checkAdmin);
			ps.setString(4, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAcc(String user) {
		String query = "DELETE FROM accout WHERE username=?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Account checkLoginAdmin(String user, String pass) {
		try {
			String query = "SELECT * FROM `accout` WHERE username = ? AND password = ? AND admin = 1";
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));
				return a;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// create a list typeNews
	public List<typeNews> listTypeNewTotal(int index) {
		List<typeNews> list = new ArrayList<>();
		String query = "SELECT * FROM `typenews` GROUP BY id DESC LIMIT 5 OFFSET ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index * 5) - 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new typeNews(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertType(String name, String img) {
		String query = "INSERT INTO `typenews`(`typeNews`, `imagesType`) VALUES (?,?)";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, img);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatType(String id, String name, String img) {
		String query = "UPDATE `typenews` SET `typeNews`=?,`imagesType`=? WHERE id =?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, img);
			ps.setString(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteType(String id) {
		String query = "DELETE FROM `typenews` WHERE id=?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// count type
	public int countRStype() {
		int count = 0;
		String query = "SELECT COUNT(*) FROM typenews";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int totalRStype() {
		int total = 0;
		int totalA = countRStype();
		total = totalA / 5;
		if (totalA % 5 != 0) {
			total++;
		}
		return total;
	}

	public int showingType(int index) {
		int count = 0;
		String query = "SELECT * FROM typenews GROUP BY id DESC LIMIT 5 OFFSET ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, index * 5 - 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = count + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public static void main(String[] args) {
		dao Dao = new dao();
		System.out.println(Dao.totalRStype());
//        Dao.updatType("5", "tinmoi1", "https://lienminh.garena.vn/news/articles/9353");
//        Dao.insertType("Tinmoi", "qweqweqw");
//        Dao.updateAcc("kp", "12345678", "0");
//        List<typeNews> list =  Dao.listTypeNew();
//      for (typeNews o : list) {
//        System.out.println(o);
//    }
//        Dao.updateVisitor("nthien", 4);
//        Dao.deleteAcc("sdfsdf");
//        Dao.updateAcc("nthien", "123412415");
//        System.out.println(Dao.accUser("Nthien"));
//        Dao.insertAcc("pokemon", "123");
//        System.out.println(Dao.getOneTypeNews("GAME UPDATE"));
//        Dao.updateNews("Lol Esports Staff5 days ago",
//        		"Top 10 Plays of the Group Stage", 
//        		"https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt481add8b70ff4bd9/634f52cbbb329010566dee4e/Top10-YT-Template-Faker.jpg",
//        		"Following another week full of bangers at Worlds 2022, it’s time to rewind and take a look back at the Top 10 Plays from the Group Stage. Let us know if we missed anything, and be sure to comment your favorite play below! \\r\\n\"\r\n"
//        		+ "        		+ \"\\r\\n\"\r\n"
//        		+ "        		+ \"WATCH WORLDS LIVE\\r\\n\"\r\n"
//        		+ "        		+ \"https://lolesports.com\\r\\n\"\r\n"
//        		+ "        		+ \"\\r\\n\"\r\n"
//        		+ "        		+ \"FULL SCHEDULE\\r\\n\"\r\n"
//        		+ "        		+ \"https://lolesports.com/schedule\\r\\n\"\r\n"
//        		+ "        		+ \"\\r\\n\"\r\n"
//        		+ "        		+ \"Quarterfinals: October 20-23\\r\\n\"\r\n"
//        		+ "        		+ \"Semifinals: October 29-30\\r\\n\"\r\n"
//        		+ "        		+ \"Finals: November 5\\r\\n\"\r\n"
//        		+ "        		+ \"\\r\\n\"\r\n"
//        		+ "        		+ \"SOCIAL\\r\\n\"\r\n"
//        		+ "        		+ \"Twitter: https://twitter.com/lolesports\\r\\n\"\r\n"
//        		+ "        		+ \"Facebook: https://www.facebook.com/lolesports\\r\\n\"\r\n"
//        		+ "        		+ \"Instagram: https://www.instagram.com/lolesports", 
//        		"DEV", 
//        		"0", 
//        		"34");
//        List<newsPost> list = Dao.pagingListCRUD(1);
//        System.out.println(nPost);
//        int a = Dao.totalPageCategory("MEDIA");
//        System.out.println(a);
//        List<newsPost> listTop2 = dao.getTop2NewsPost();
//        newsPost p = dao.getTop1New();
//        Dao.insertNews("Lol Esports Staff5 days ago",
//        		"Top 10 Plays of the Group Stage",
//        		"https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt481add8b70ff4bd9/634f52cbbb329010566dee4e/Top10-YT-Template-Faker.jpg", 
//        		"Following another week full of bangers at Worlds 2022, it’s time to rewind and take a look back at the Top 10 Plays from the Group Stage. Let us know if we missed anything, and be sure to comment your favorite play below! \r\n"
//        		+ "\r\n"
//        		+ "WATCH WORLDS LIVE\r\n"
//        		+ "https://lolesports.com\r\n"
//        		+ "\r\n"
//        		+ "FULL SCHEDULE\r\n"
//        		+ "https://lolesports.com/schedule\r\n"
//        		+ "\r\n"
//        		+ "Quarterfinals: October 20-23\r\n"
//        		+ "Semifinals: October 29-30\r\n"
//        		+ "Finals: November 5\r\n"
//        		+ "\r\n"
//        		+ "SOCIAL\r\n"
//        		+ "Twitter: https://twitter.com/lolesports\r\n"
//        		+ "Facebook: https://www.facebook.com/lolesports\r\n"
//        		+ "Instagram: https://www.instagram.com/lolesports", 
//        		"GAME UPDATE", 

//        		"0");
//        List<newsPost> list = Dao.pagingList(2);
//        List<Account> list = Dao.listAccounts();
//        for (Account o : list) {
//          System.out.println(o);
//      }
//        System.out.println(dao.totalPage());
//        List<newsPost> listFollowSomethingCategoryList = dao.getListCategory("game update");
//        for (newsPost o : listFollowSomethingCategoryList) {
//         System.out.println(o);
	}
}
