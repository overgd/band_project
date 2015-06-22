package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_crud.CrudProcess;

/**
 * Servlet implementation class DeleteUserInfoServlet
 */
public class DeleteUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		CrudProcess crud = new CrudProcess();
		
		if(session.getAttribute("DIV").equals("f")) {
			
			crud.deleteFanUserInfo(id);
			session.removeAttribute("ID");
			
		}else if(session.getAttribute("DIV").equals("b")) {
			
			crud.deleteBandUserInfo(id);
			session.removeAttribute("ID");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/deleteuserconfirm.html");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
