package jp.co.rich.item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.rich.item.bean.ItemUser;

public class ItemUserDao {

	/* id,passの検索 */

	public static List<ItemUser> findUser(String id, String pass) {
		Connection con = null;
		PreparedStatement ps = null;
		List<ItemUser> UserList = new ArrayList<ItemUser>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM item_user where item_user_id=? and password=?");
			int userid = Integer.parseInt(id);
			ps.setInt(1, userid);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			/* id、パスワードが一致していればその情報を送る */
			if (rs.next()) {
				ItemUser itemUser = new ItemUser();
				itemUser.setItemUserId(rs.getInt("item_user_id"));
				itemUser.setItemUserName(rs.getString("item_user_name"));
				itemUser.setPassword(rs.getString("password"));
				UserList.add(itemUser);
			} else {/* しなければnullを送る */
				return null;

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (NumberFormatException n) {
			System.out.println("数値以外");
			return null;
		}

		finally {
			DBManager.close(ps, con);
		}
		return UserList;
	}
}