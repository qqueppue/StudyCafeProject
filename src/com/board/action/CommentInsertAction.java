package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.user.model.UserDTO;

/**
 * Servlet implementation class CommentInsertAction
 */
@WebServlet("/board/cInsert")
public class CommentInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertAction() {
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
		String phone = sessionUser.getPhone();
		
		CommentDTO comment = new CommentDTO();
		comment.setUserid(phone);
		comment.setBnum(Integer.parseInt(request.getParameter("bnum")));
		comment.setCnum(Integer.parseInt(request.getParameter("cnum")));
		comment.setMsg(request.getParameter("msg"));
		comment.setRegdate(request.getParameter("regdate"));
		
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		dao.commentInsert(comment);
		
		if(phone==null) {
			
		}else {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
