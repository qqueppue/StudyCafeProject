package com.cafe.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserDAO;
import com.user.model.UserDAOImpl;
import com.user.model.UserDTO;

/**
 * Servlet implementation class SeatInsertAction
 */
@WebServlet("/cafe/seatInsert")
public class SeatInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("seat.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		HttpSession session = request.getSession();
		UserDTO sessionUser = (UserDTO)session.getAttribute("user");
		
		String phone = sessionUser.getPhone();
		UserDAO dao = UserDAOImpl.getInstance();
		UserDTO user = new UserDTO();
		user.setSeat(Integer.parseInt(request.getParameter("seat")));
		user.setPhone(phone);
		dao.seatInsert(user);
		
//		int usernum = sessionUser.getUserNum();
//		UserDAO dao = UserDAOImpl.getInstance();
//		seatDTO seat = new seatDTO();
//		seat.setSeat(Integer.parseInt(request.getParameter("seat")));
//		seat.setUsernum(usernum);
//		dao.seatInsert(seat);
		
		response.sendRedirect("main.jsp");
	}

}
