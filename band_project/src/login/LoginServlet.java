package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_crud.CrudProcess;
import login_model.Band;
import login_model.Fan;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String result = null;
		
		CrudProcess crud = new CrudProcess();
		
		String usercheck = crud.selectLoginUserCheck(id);
		
		if(usercheck != null) {
			
			char bnfcheck = usercheck.charAt(0);
			String div = null;
			String[] info = null;
			
			HttpSession session = request.getSession();
			
			if(bnfcheck == 'f') {
				
				Fan selectinfo = crud.selectFanUserInfo(id);
				
				session.setAttribute("NAME", selectinfo.getName());
				session.setAttribute("GENDER", selectinfo.getGender());
				session.setAttribute("PHONE", selectinfo.getPhone());
				session.setAttribute("BIRTH", selectinfo.getBirth());
				div = "f";
				session.setAttribute("DIV", div);
				
			}else if(bnfcheck == 'b') {
				
				Band selectinfo = crud.selectBandUserInfo(id);
				
				session.setAttribute("NAME", selectinfo.getName());
				session.setAttribute("GENRE", selectinfo.getGenre());
				div = "b";
				session.setAttribute("DIV", div);
				
			}
			session.setAttribute("ID", id);
			
			
			result = "OK";
			
		}else {
			result = "NOK";
		}
		
		if(result == "OK") {

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?LOGIN=login/loginConfirm.jsp");
			rd.forward(request, response);
			
		}
		if(result == "NOK") {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/loginFail.jsp");
			rd.forward(request, response);
		}
		
	}


}
