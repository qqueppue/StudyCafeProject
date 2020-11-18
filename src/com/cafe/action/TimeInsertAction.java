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
 * Servlet implementation class TimeInsertAction
 */
@WebServlet("/time/timeInsert")
public class TimeInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("time.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UserDTO sessionUser = (UserDTO)session.getAttribute("user");
		
		String phone = sessionUser.getPhone();
		UserDAO dao = UserDAOImpl.getInstance();
		UserDTO user = new UserDTO();
		user.setTime(request.getParameter("time"));
		user.setPhone(phone);
		dao.od_timeInsert(user);
		
		response.sendRedirect("usermain.jsp");
	}

}
