package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.user.model.UserDAO;
import com.user.model.UserDAOImpl;
import com.user.model.UserDTO;

/**
 * Servlet implementation class UserDeleteAction
 */
@WebServlet("/user/userDelete")
public class UserDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int usernum = Integer.parseInt(request.getParameter("usernum"));
		
		UserDAO dao = UserDAOImpl.getInstance();
		dao.memberDelete(usernum);
		
		ArrayList<UserDTO> arr = dao.getMember();
		int count = dao.memberCount();
		JSONArray jarr = new JSONArray();
		for(UserDTO member:arr) {
			JSONObject obj = new JSONObject();
			obj.put("admin", member.getAdmin());
			obj.put("name", member.getName());
			obj.put("nickname", member.getNickname());
			obj.put("phone", member.getPhone());
			obj.put("email", member.getEmail());
			jarr.add(obj);
		}
		
		JSONObject countObj = new JSONObject();
		countObj.put("countObj", count);
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("jarr", jarr);
		mainObj.put("countObj", countObj);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(mainObj.toString());
		
//		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
