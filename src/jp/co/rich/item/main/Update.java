package jp.co.rich.item.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.rich.item.bean.Item;


@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemId=request.getParameter("itemId");
		String stock=request.getParameter("stock");
		int id=Integer.parseInt(itemId);
		int sto=Integer.parseInt(stock);
		Item item=new Item();
		item.setItemId(id);
		item.setStock(sto);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/jsp/order.jsp")
		.forward(request, response);
















	}}

		//		String itemId=request.getParameter("itemId");
//		String stock=request.getParameter("stock");
//		String add=request.getParameter("add");
//		int id=Integer.parseInt(itemId);
//		int addStock=(Integer.parseInt(stock)+Integer.parseInt(add));
//
//		Item item=new Item();
//		item.setStock(addStock);
//		item.setItemId(id);
//
//		System.out.println("Up"+item.getStock());
//		ItemDao.update(item);
//		request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
//	}
//
//}
//String itemName=request.getParameter("itemName");
//String details=request.getParameter("details");
//String registerDate=request.getParameter("registerDate");
//String genreId=request.getParameter("genreId");
//Genre genre=GenreDao.findById(genreId);
//Date re=Date.valueOf(registerDate);
//item.setItemName(itemName);;
//item.setDetails(details);
//item.setRegisterDate(re);
//item.setGenre(genre);