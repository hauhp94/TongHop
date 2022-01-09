package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Service;
import modal.service.ServiceService;
import modal.service.ServiceServiceImpl;

/**
 * Servlet implementation class ComputerController
 */
@WebServlet(name = "ServiceController", urlPatterns = { "/service" })
public class ServiceController extends HttpServlet {
	private ServiceService service = new ServiceServiceImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceController() {
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
//		case "detail":
//			detailStudent(request, response);
//			break;
		case "update":
			updateService(request, response);
			break;
		case "delete":
			deleteService(request, response);
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
	}

	private void updateService(HttpServletRequest request, HttpServletResponse response) {
		Service service1 = service.getServiceByCode(request.getParameter("maDV"));
		request.setAttribute("service", service1);
		try {
			request.getRequestDispatcher("WEB-INF/views/service/sua-dich-vu.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteService(HttpServletRequest request, HttpServletResponse response) {
		service.delete(request.getParameter("maDV"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("service?action=list");
		request.setAttribute("message", "da xoa thanh cong");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void displayList(HttpServletRequest request, HttpServletResponse response) {
		List<Service> services = service.getList();
		request.setAttribute("services", services);
		try {
			request.getRequestDispatcher("WEB-INF/views/service/06-danh-sach-dich-vu.jsp").forward(request, response);
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
			request.getRequestDispatcher("WEB-INF/views/service/03-tao-moi-dich-vu.jsp").forward(request, response);
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
			response.sendRedirect("service?action=list");
			break;
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String maDV = request.getParameter("maDV");
		String tenDV = request.getParameter("tenDichVu");
		String donViTinh = request.getParameter("donViTinh");
		double donGia = Double.parseDouble(request.getParameter("donGia"));
		Service service1 = new Service(maDV, tenDV, donViTinh, donGia);
		service.update(service1);
		request.setAttribute("message", "da update thanh cong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("service?action=list");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		Service service1 = new Service();
		service1.setMaDV(request.getParameter("maDichVu"));
		service1.setTenDV(request.getParameter("tenDichVu"));
		service1.setDonViTinh(request.getParameter("donViTinh"));
		service1.setDonGia(Double.parseDouble(request.getParameter("donGia")));
		service.save(service1);
		try {
			response.sendRedirect("service?action=list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
