package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.user.util.SHA256;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/user/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		UserDAO dao = UserDAOImpl.getInstance();
		
		String encPwd = SHA256.getEncrypt(pwd, phone);
		UserDTO member = dao.memberLoginCheck(phone, encPwd);
		
//		int flag = dao.memberLoginCheck(userid, pwd);
		int flag = -1;
		flag = member.getAdmin();
		if(flag==1||flag==0) {
			HttpSession session =  request.getSession();
			//session.setAttribute("userid", userid);
			session.setAttribute("user", member);
		}else {
			member.setAdmin(2);
		}
//		if(member==null) flag=-1;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(flag);
	}

}
