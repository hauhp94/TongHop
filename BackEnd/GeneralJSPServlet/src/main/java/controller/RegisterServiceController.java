package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Customer;
import modal.bean.RegisterService;
import modal.bean.Service;
import modal.service.CustomerService;
import modal.service.CustomerServiceImpl;
import modal.service.RegisterServiceService;
import modal.service.RegisterServiceServiceImpl;
import modal.service.ServiceService;
import modal.service.ServiceServiceImpl;

/**
 * Servlet implementation class RegisterServiceController
 */
@WebServlet(name ="/RegisterServiceController", urlPatterns = {"/registerService"})
public class RegisterServiceController extends HttpServlet {
	private ServiceService serviceService = new ServiceServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	private RegisterServiceService registerServiceService = new RegisterServiceServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServiceController() {
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
		List<Service> services = serviceService.getList();
		List<Customer> customers = customerService.getList();
		request.setAttribute("services", services);
		request.setAttribute("customers", customers);
		try {
			request.getRequestDispatcher("WEB-INF/views/register/08-su-dung-dich-vu.jsp").forward(request, response);
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
		RegisterService registerService = new RegisterService();
		registerService.setMaKH(request.getParameter("maKH"));
		registerService.setMaDV(request.getParameter("maDV"));
		registerService.setNgaySuDung(request.getParameter("ngaySuDung"));
		registerService.setGioSuDung(request.getParameter("gioSuDung"));
		registerService.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));
		registerServiceService.save(registerService);
		try {
			response.sendRedirect("registerService?action=create");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
