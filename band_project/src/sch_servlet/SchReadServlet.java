package sch_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sch_crud.CrudProcess;
import sch_model.Writing;

/**
 * Servlet implementation class ReadServlet
 */
public class SchReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writeId = request.getParameter("id");
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writeId));
		String content = crud.selectWritingContent(Integer.parseInt(writeId));
		writing.setContent(content);
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=sch/schread_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writeId = request.getParameter("id");
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(Integer.parseInt(writeId));
		String content = crud.selectWritingContent(Integer.parseInt(writeId));
		writing.setContent(content);
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=sch/schread_view.jsp");
		rd.forward(request, response);
	}

}













