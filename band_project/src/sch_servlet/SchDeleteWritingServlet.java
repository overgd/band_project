package sch_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sch_crud.CrudProcess;
import sch_model.Writing;

/**
 * Servlet implementation class DeleteWritingServlet
 */
public class SchDeleteWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchDeleteWritingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		String writeId = request.getParameter("id");

		CrudProcess crud = new CrudProcess();
		Writing orgWriting = 
				crud.selectOneWritingInfo(Integer.parseInt(writeId));
		if(orgWriting.getWriterid().equals(id)){//암호 일치
			crud.deleteWritingInfo(Integer.parseInt(writeId));
			crud.deleteWritingContent(Integer.parseInt(writeId));
		}else {
			request.setAttribute("id", writeId);
		}
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=sch/schdelete_result.jsp");
		rd.forward(request, response);
	}

}



///////미완성 아이디 세션으로 받아오는 부분 만들어야 함










