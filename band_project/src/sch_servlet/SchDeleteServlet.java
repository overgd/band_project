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
 * Servlet implementation class DeleteServlet
 */
public class SchDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchDeleteServlet() {
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
		String writeId = request.getParameter("id");
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(
							Integer.parseInt(writeId));
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=sch/schdeleteForm_view.jsp");
		rd.forward(request, response);
	}

}










