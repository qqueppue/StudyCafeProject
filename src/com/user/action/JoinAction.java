package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.UserDAO;
import com.user.model.UserDAOImpl;
import com.user.model.UserDTO;
import com.user.util.SHA256;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/user/join")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		
		UserDTO user = new UserDTO();
		user.setName(request.getParameter("name"));
		user.setNickname(request.getParameter("nickname"));
		user.setAdmin(Integer.parseInt(request.getParameter("admin")));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
//		member.setUserNum(Integer.parseInt(request.getParameter("usernum")));
		
//		member.setPwd(request.getParameter("pwd"));
		String encPwd = SHA256.getEncrypt(request.getParameter("pwd"), phone);
		user.setPwd(encPwd);
		
		UserDAO dao = UserDAOImpl.getInstance();
		dao.memberJoin(user);
		
		response.sendRedirect("login");
	}

}
