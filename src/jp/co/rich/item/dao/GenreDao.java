package jp.co.rich.item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.rich.item.bean.Genre;

public class GenreDao {
	public static Genre findById(String genreId) {
		Connection con = null;
		PreparedStatement ps = null;
		Genre genre = null;
		try {
		con = DBManager.getConnection();
		ps = con.prepareStatement("SELECT * FROM genre WHERE genre_id = ?");
		ps.setString(1, genreId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		genre = new Genre();
		genre.setGenreId(rs.getInt("genre_id"));
		genre.setGenreName(rs.getString("type_name"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		DBManager.close(ps, con);
		}
		return genre;
		}

}
