package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.CustomerUsing;
import modal.service.CustomerUsingService;

/**
 * Servlet implementation class CustomerUsingController
 */
@WebServlet(name="/CustomerUsingController", urlPatterns = {"/customerUsingService"})
public class CustomerUsingController extends HttpServlet {
	CustomerUsingService customerUsingService = new CustomerUsingService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUsingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			action = "create";
		}
		switch (action) {
		case "list":
			displayList(request, response);
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
	}

	private void displayList(HttpServletRequest request, HttpServletResponse response) {
		List<CustomerUsing> customerUsings = customerUsingService.getList();
		request.setAttribute("customerUsings", customerUsings);
		try {
			request.getRequestDispatcher("WEB-INF/views/register/09-khach-hang-dich-vu.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
