package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_crud.CrudProcess;

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
		System.out.println(usercheck.charAt(0));
		
		if(usercheck != null) {
			
			char bnfcheck = usercheck.charAt(0);
			String div = null;
			String[] info = null;
			
			HttpSession session = request.getSession();
			
			if(bnfcheck == 'f') {
				List selectinfo = crud.selectFanUserInfo(id);
				info = (String[])selectinfo.toArray(new String[selectinfo.size()]);
				System.out.println(info.length);
				session.setAttribute("GENDER", info[4]);
				session.setAttribute("PHONE", info[5]);
				session.setAttribute("BIRTH", info[6]);
				div = "f";
				
			}else if(bnfcheck == 'b') {
				List selectinfo = crud.selectBandUserInfo(id);
				info = (String[])selectinfo.toArray(new String[selectinfo.size()]);
				System.out.println(info.length);
				session.setAttribute("GENRE", info[4]);
				div = "b";
			}
			
			session.setAttribute("ID", id);
			session.setAttribute("NAME", info[3]);
			session.setAttribute("DIV", div);
			
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
