package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Customer;
import modal.service.CustomerService;
import modal.service.CustomerServiceImpl;

/**
 * Servlet implementation class ComputerController
 */
@WebServlet(name = "CustomerController", urlPatterns = { "/customer" })
public class CustomerController extends HttpServlet {
	private CustomerService service = new CustomerServiceImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
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
		case "list":
			displayList(request, response);
			break;
		case "create":
			displayCreate(request, response);
			break;
		case "search":
			searchByName(request, response);
			break;
		case "update":
			updateCustomer(request, response);
			break;
		case "delete":
			deleteCustomer(request, response);
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
	}

	private void searchByName(HttpServletRequest request, HttpServletResponse response) {
		String tenKH = request.getParameter("tenKH");
		List<Customer> customers = service.findByName(tenKH);
		request.setAttribute("customers", customers);
//		if (customers.isEmpty()) {
//			try {
//				response.sendRedirect("customer?action=list");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return;
//		}
		try {
			request.getRequestDispatcher("WEB-INF/views/customer/05-danh-sach-khach-hang.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
		Customer customer = service.getCustomerByCode(request.getParameter("maKH"));
		request.setAttribute("customer", customer);
		System.out.println("custoer code " + customer.getMaKH());
		try {
			request.getRequestDispatcher("WEB-INF/views/customer/sua-khach-hang.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		service.delete(request.getParameter("maKH"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer?action=list");
		request.setAttribute("message", "da xoa thanh cong");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void displayList(HttpServletRequest request, HttpServletResponse response) {
		List<Customer> customers = service.getList();
		request.setAttribute("customers", customers);
		try {
			request.getRequestDispatcher("WEB-INF/views/customer/05-danh-sach-khach-hang.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void displayCreate(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("WEB-INF/views/customer/02-tao-moi-khach-hang.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		switch (action) {
		case "create":
			create(request, response);
			break;
		case "update":
			update(request, response);
			break;
		default:
			response.sendRedirect("customer?action=list");
			break;
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String maKH = request.getParameter("maKH");
		String tenKH = request.getParameter("tenKhachHang");
		String diaChi = request.getParameter("diaChi");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		Customer customer = new Customer(maKH, tenKH, diaChi, soDienThoai, email);
		service.update(customer);
		request.setAttribute("message", "da update thanh cong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer?action=list");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Customer customer = new Customer();
		customer.setMaKH(request.getParameter("maKhachHang"));
		customer.setTenKH(request.getParameter("tenKhachHang"));
		customer.setDiaChi(request.getParameter("diaChi"));
		customer.setSoDienThoai(request.getParameter("soDienThoai"));
		customer.setEmail(request.getParameter("email"));
//		service.save(customer);
//		try {
//			response.sendRedirect("customer?action=list");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Map<String, String> mapMessage = service.save(customer);
		if (mapMessage.isEmpty()) {
			request.getRequestDispatcher("WEB-INF/views/customer/02-tao-moi-khach-hang.jsp").forward(request, response);
		} else {
			request.setAttribute("messageMaKH", mapMessage.get("maKH"));
			request.setAttribute("messageEmail", mapMessage.get("email"));
			request.setAttribute("messageSoDienThoai", mapMessage.get("soDienThoai"));
			request.setAttribute("messageExist", mapMessage.get("maKHTonTai"));
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/views/customer/02-tao-moi-khach-hang.jsp").forward(request, response);

		}

	}



}
