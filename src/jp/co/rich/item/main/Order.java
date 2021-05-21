package jp.co.rich.item.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.rich.item.bean.Item;
import jp.co.rich.item.dao.ItemDao;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemId=request.getParameter("itemId");
		String stock=request.getParameter("stock");
		String order=request.getParameter("order");
		int id=Integer.parseInt(itemId);
		int sto=((Integer.parseInt(stock)+Integer.parseInt(order)));
		System.out.println("ID:"+itemId);
		System.out.println("+:"+sto);
		Item item=new Item();
		item.setStock(sto);
		item.setItemId(id);
		ItemDao.update(item);
		request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
	}

}
