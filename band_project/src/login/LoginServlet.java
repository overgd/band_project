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
		String usercheck = null;
		
		CrudProcess crud = new CrudProcess();
		
		usercheck = crud.selectLoginUserCheck(id, pwd);
		
		if(usercheck == "FOK" || usercheck == "BOK") {
			
			char bnfcheck = usercheck.charAt(0);
			String div = null;
			
			HttpSession session = request.getSession();
			
			if(bnfcheck == 'F') {
				
				Fan selectinfo = crud.selectFanUserInfo(id);
				
				session.setAttribute("NAME", selectinfo.getName());
				session.setAttribute("GENDER", selectinfo.getGender());
				session.setAttribute("PHONE", selectinfo.getPhone());
				session.setAttribute("BIRTH", selectinfo.getBirth());
				session.setAttribute("EMAIL", selectinfo.getEmail());
				div = "f";
				session.setAttribute("DIV", div);
				session.setAttribute("ID", id);
				
				result = "OK";
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?LOGIN=login/loginConfirm.jsp");
				rd.forward(request, response);
				
				
			}else if(bnfcheck == 'B') {
				
				Band selectinfo = crud.selectBandUserInfo(id);
				
				session.setAttribute("NAME", selectinfo.getName());
				session.setAttribute("GENRE", selectinfo.getGenre());
				session.setAttribute("EMAIL", selectinfo.getEmail());
				div = "b";
				session.setAttribute("DIV", div);
				session.setAttribute("ID", id);
				session.setAttribute("BID", "b."+id);
				session.setAttribute("BNAME", selectinfo.getName());
				request.setAttribute("BAND", selectinfo);
				
				result = "OK";
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=band/bandIntro.jsp&BOTTOM=bottom/bottomMenu.jsp?LOGIN=login/loginConfirm.jsp");
				rd.forward(request, response);
				
			}
			
		}else {
			result = "NOK";
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/loginFail.jsp");
			rd.forward(request, response);
		}
		
		
	}


}
