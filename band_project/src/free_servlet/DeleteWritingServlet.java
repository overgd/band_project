package free_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free_model.Writing;
import free_crud.CrudProcess;

/**
 * Servlet implementation class DeleteWritingServlet
 */
public class DeleteWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWritingServlet() {
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
		Writing orgWriting =
				crud.selectOneWritingInfo(Integer.parseInt(writeId));
		if(equals("loginConfirm.jsp?ID")){//암호 일치
			crud.deleteWritingInfo(Integer.parseInt(writeId));
			crud.deleteWritingContent(Integer.parseInt(writeId));
		}else{//암호 불일치
			request.setAttribute("id", writeId);
		}
		RequestDispatcher rd= request.getRequestDispatcher(
				"index.jsp?MAIN=free/delete_result.jsp");
		rd.forward(request, response);
	}

}























