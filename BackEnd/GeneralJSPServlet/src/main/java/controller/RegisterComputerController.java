package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Computer;
import modal.bean.Customer;
import modal.bean.RegisterComputer;
import modal.service.ComputerService;
import modal.service.ComputerServiceImpl;
import modal.service.CustomerService;
import modal.service.CustomerServiceImpl;
import modal.service.RegisterComputerService;
import modal.service.RegisterComputerServiceImpl;

/**
 * Servlet implementation class RegisterComputerController
 */
@WebServlet(name = "/RegisterComputerController", urlPatterns = { "/registerComputer" })
public class RegisterComputerController extends HttpServlet {
	private RegisterComputerService service = new RegisterComputerServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	private ComputerService computerService = new ComputerServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterComputerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			action = "create";
		}
		switch (action) {
//		case "list":
//			displayList(request, response);
//			break;
		case "create":
			displayCreate(request, response);
			break;
		default:
			break;
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	

	private void displayCreate(HttpServletRequest request, HttpServletResponse response) {
		List<Computer> computers = computerService.getList();
		List<Customer> customers = customerService.getList();
		request.setAttribute("computers", computers);
		request.setAttribute("customers", customers);
		try {
			request.getRequestDispatcher("WEB-INF/views/register/07-su-dung-may.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		switch (action) {
		case "create":
			create(request, response);
			break;
//		case "update":
//			update(request, response);
//			break;
		default:
			response.sendRedirect("customer?action=list");
			break;
		}
	}
//	private void displayList(HttpServletRequest request, HttpServletResponse response) {
//		List<RegisterComputer> registerComputers = service.getList();
//		request.setAttribute("registerComputers", registerComputers);
//		try {
//			request.getRequestDispatcher("WEB-INF/views/register/07-su-dung-may.jsp").forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		RegisterComputer registerComputer = new RegisterComputer();
		registerComputer.setMaKH(request.getParameter("maKH"));
		registerComputer.setMaMay(request.getParameter("maMay"));
		registerComputer.setNgayBatDauSuDung(request.getParameter("ngayBatDauSuDung"));
		registerComputer.setGioBatDauSuDung(request.getParameter("gioBatDauSuDung"));
		registerComputer.setThoiGianSuDung(Integer.parseInt(request.getParameter("thoiGianSuDung")));
		service.save(registerComputer);
		try {
			response.sendRedirect("registerComputer?action=create");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
