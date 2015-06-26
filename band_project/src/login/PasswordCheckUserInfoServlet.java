package login;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_crud.CrudProcess;

/**
 * Servlet implementation class PasswordCheckUserInfoServlet
 */
public class PasswordCheckUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordCheckUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("ID");
		String div = (String)session.getAttribute("DIV");
		
		CrudProcess crud = new CrudProcess();
		
		String password = null;
		
		if(div.equals("f")) {
			password = crud.selectIDPasswordFanUser("f."+id);
			
			if(password != null) {
				request.setAttribute("PWD", password);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/modifyfanuser.jsp");
				rd.forward(request, response);
			}
			
		}else if(div.equals("b")) {
			password = crud.selectIDPasswordBandUser("b."+id);
			
			if(password != null) {
				request.setAttribute("PWD", password);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/modifybanduser.jsp");
				rd.forward(request, response);
			}
						
		}else {
			System.out.println("fail");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
