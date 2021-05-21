package jp.co.rich.item.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.rich.item.bean.Item;
import jp.co.rich.item.bean.ItemUser;
import jp.co.rich.item.dao.ItemDao;
import jp.co.rich.item.dao.ItemUserDao;

@WebServlet("/Index")
public class Index extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		/* 一致するユーザを検索 */
		List<ItemUser> UserList=ItemUserDao.findUser(id, pass);
		/* 整合する情報がなければログイン画面へ戻ってメッセージ表示 */
		if(UserList==null){
			request.setAttribute("ErrorMessage", "ユーザID、またはパスワードが間違っています。");
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		} else {
			/* 整合する情報があれば下記の処理を行う */
			/*①ユーザの名前をセッションスコープへ格納して商品一覧ページへ*/
			HttpSession session = request.getSession();
			session.setAttribute("UserList", UserList);
			/*②ログイン状態にする*/
			session.setAttribute("Login","ようこそ、"+UserList.get(0).getItemUserName()+"さん");
			/*③商品一覧を出力*/
			List<Item> Item = ItemDao.findAll();
//			request.setAttribute("Item", Item);
			session.setAttribute("Item", Item);
			/**/
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		}
	}

}
