package jp.co.rich.item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.rich.item.bean.Genre;
import jp.co.rich.item.bean.Item;

public class ItemDao {

	/*商品一覧を出力*/
	public static List<Item> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Item> Item= new ArrayList<Item>();
		try{
		con = DBManager.getConnection();
		ps = con.prepareStatement("SELECT * FROM item i inner join genre g on i.genre_id=g.genre_id");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Item item = new Item();
		item.setItemId(rs.getInt("item_id"));
		item.setItemName(rs.getString("item_name"));
		item.setDetails(rs.getString("details"));
		item.setRegisterDate(rs.getDate("register_date"));
		item.setStock(rs.getInt("stock"));
		Genre genre=new Genre();
		genre.setGenreId(rs.getInt("genre_id"));
		genre.setGenreName(rs.getString("genre_name"));
		item.setGenre(genre);
		Item.add(item);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		DBManager.close(ps, con);
		}
		return Item;
		}

	/*商品名検索*/
	public static List<Item> findByNameContains(String ItemName) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Item> Item = new ArrayList<Item>();
		try {
		con = DBManager.getConnection();
		ps = con.prepareStatement("SELECT * FROM item f inner join genre t on f.genre_id=t.genre_id WHERE Item_name LIKE ?");
		ps.setString(1, "%" + ItemName + "%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		Item item = new Item();
		item.setItemId(rs.getInt("item_id"));
		item.setItemName(rs.getString("item_name"));
		item.setDetails(rs.getString("details"));
		item.setRegisterDate(rs.getDate("register_date"));
		item.setStock(rs.getInt("stock"));
		Genre genre=new Genre();
		genre.setGenreId(rs.getInt("genre_id"));
		genre.setGenreName(rs.getString("genre_name"));
		item.setGenre(genre);
		Item.add(item);
		}
		} catch(SQLException e) {
		e.printStackTrace();
		} finally {
		DBManager.close(ps, con);
		}
		return Item;
		}

	/*ジャンル検索*/
	public static List<Item> findByGenre(String GenreName) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Item> Item = new ArrayList<Item>();
		try {
		con = DBManager.getConnection();
		ps = con.prepareStatement("SELECT * FROM item f inner join genre t on f.genre_id=t.genre_id WHERE genre_name=?");
		ps.setString(1,GenreName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		Item item = new Item();
		item.setItemId(rs.getInt("item_id"));
		item.setItemName(rs.getString("item_name"));
		item.setDetails(rs.getString("details"));
		item.setRegisterDate(rs.getDate("register_date"));
		item.setStock(rs.getInt("stock"));
		Genre genre=new Genre();
		genre.setGenreId(rs.getInt("genre_id"));
		genre.setGenreName(rs.getString("genre_name"));
		item.setGenre(genre);
		Item.add(item);
		}
		} catch(SQLException e) {
		e.printStackTrace();
		} finally {
		DBManager.close(ps, con);
		}
		return Item;
		}


/*更新（在庫）*/

	public static void update(Item item) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
		con = DBManager.getConnection();
		ps = con.prepareStatement
				("UPDATE item SET stock = ? WHERE item_id = ?");
		ps.setInt(1,item.getStock());
		ps.setInt(2,item.getItemId());
		System.out.println("dao"+item.getStock());
		ps.executeUpdate();
		} catch(SQLException e) {
		e.printStackTrace();
		} finally {
		DBManager.close(ps, con);
		}
		}
}