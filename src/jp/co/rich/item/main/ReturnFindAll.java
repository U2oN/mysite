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


@WebServlet("/ReturnFindAll")
public class ReturnFindAll extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Item> Item = ItemDao.findAll();
			request.setAttribute("Item", Item);
			/**/
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		}
	}
