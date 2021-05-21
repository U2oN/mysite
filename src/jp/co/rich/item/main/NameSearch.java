package jp.co.rich.item.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.rich.item.bean.Item;
import jp.co.rich.item.dao.ItemDao;

@WebServlet("/NameSearch")
public class NameSearch extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ItemName = (String) request.getParameter("ItemName");
		List<Item> Item = ItemDao.findByNameContains(ItemName);
		// System.out.println(Item);
		if (Item.isEmpty() == true) {
			request.setAttribute("Item", Item);
			request.setAttribute("ErrorMessage", "該当する商品は存在しません。");
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		} else {
			request.setAttribute("Item", Item);
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> Item = ItemDao.findAll();
		request.setAttribute("Item", Item);
		/**/
		request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
	}
}

// String ItemName = (String)request.getParameter("ItemName");
// List<Item> Item = ItemDao.findByNameContains(ItemName);
// request.setAttribute("Item", Item);
// request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);