package guest_servlet;

import guest_crud.CrudProcess;
import guest_model.Writing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String bandId = (String)session.getAttribute("BID");
		String writeId = request.getParameter("id");
		
		Writing inwriting = new Writing();
		
		inwriting.setBandid(bandId);
		inwriting.setWritingid(Integer.parseInt(writeId));
		
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(
				inwriting);
		String content = crud.selectWritingContent(
				inwriting);
		writing.setContent(content);
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/template.jsp?CONTENTPAGE=updateForm_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String bandId = (String)session.getAttribute("BID");
		String writeId = request.getParameter("id");
		
		Writing inwriting = new Writing();
		
		inwriting.setBandid(bandId);
		inwriting.setWritingid(Integer.parseInt(writeId));
		
		CrudProcess crud = new CrudProcess();
		Writing writing = crud.selectOneWritingInfo(
				inwriting);
		String content = crud.selectWritingContent(
				inwriting);
		writing.setContent(content);
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/template.jsp?CONTENTPAGE=updateForm_view.jsp");
		rd.forward(request, response);
	}

}
