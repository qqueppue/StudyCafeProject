package com.user.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserDAO;
import com.user.model.UserDAOImpl;
import com.user.model.UserDTO;
import com.user.util.SHA256;

/**
 * Servlet implementation class UpdateAction
 */
@WebServlet("/user/update")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UserDTO sessionUser = (UserDTO)session.getAttribute("user");
		UserDAO dao = UserDAOImpl.getInstance();
		
		String phone = sessionUser.getPhone();
		UserDTO user = new UserDTO();
//		member.setUserid(userid);
//		member.setPwd(request.getParameter("pwd"));
		user.setAdmin(Integer.parseInt(request.getParameter("admin")));
		user.setName(request.getParameter("name"));
		user.setNickname(request.getParameter("nickname"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		
//		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String encPwd = SHA256.getEncrypt(pwd, phone);
		
		user.setPhone(phone);
		user.setPwd(encPwd);
		
		dao.memberUpdate(user);
		response.sendRedirect("login");
		session.invalidate();
		
//		int flag = dao.memberUpdate(member);
//		if(flag==1) {
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			rd.forward(request, response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
