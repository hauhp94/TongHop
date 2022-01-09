package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Computer;
import modal.service.ComputerService;
import modal.service.ComputerServiceImpl;

/**
 * Servlet implementation class ComputerController
 */
@WebServlet( name = "ComputerController", urlPatterns = { "/computer" })
public class ComputerController extends HttpServlet {
	private ComputerService service = new ComputerServiceImpl();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputerController() {
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
		case "create":
			displayCreate(request, response);
			break;
//		case "detail":
//			detailStudent(request, response);
//			break;
		case "update":
			updateComputer(request, response);
			break;
		case "delete":
			deleteComputer(request, response);
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
	}

	private void deleteComputer(HttpServletRequest request, HttpServletResponse response) {
		service.delete(request.getParameter("maMay"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("computer?action=list");
		request.setAttribute("message", "da xoa thanh cong");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updateComputer(HttpServletRequest request, HttpServletResponse response) {
		Computer conputer = service.getComputerByCode(request.getParameter("maMay"));
		request.setAttribute("computer", conputer);
		try {
			request.getRequestDispatcher("WEB-INF/views/computer/sua-may.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void displayList(HttpServletRequest request, HttpServletResponse response) {
		List<Computer> computers = service.getList();
		request.setAttribute("computers", computers);
		try {
			request.getRequestDispatcher("WEB-INF/views/computer/04-danh-sach-may.jsp").forward(request, response);
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
			request.getRequestDispatcher("WEB-INF/views/computer/01-tao-moi-may.jsp").forward(request, response);
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
			response.sendRedirect("computer?action=list");
			break;
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String maMay = request.getParameter("maMay");
		String viTri = request.getParameter("viTri");
		String trangThai = request.getParameter("trangThai");
		Computer computer = new Computer(maMay, viTri, trangThai);
		service.update(computer);
		request.setAttribute("message", "da update thanh cong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("computer?action=list");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		Computer computer = new Computer();
		computer.setMaMay(request.getParameter("maMay"));
		computer.setViTri(request.getParameter("viTri"));
		computer.setTrangThai(request.getParameter("trangThai"));
		service.save(computer);
		try {
			response.sendRedirect("computer?action=list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
