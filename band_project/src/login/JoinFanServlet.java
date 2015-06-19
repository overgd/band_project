package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_crud.CrudProcess;
import login_model.Fan;

/**
 * Servlet implementation class JoinFanServlet
 */
public class JoinFanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinFanServlet() {
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

		request.setCharacterEncoding("euc-kr");
		
		CrudProcess crud = new CrudProcess();
		Fan fan = new Fan();
		
		String id = (String)request.getParameter("id");
		id = "f."+id;
		String password = (String)request.getParameter("password");
		String name = (String)request.getParameter("name");
		String email = (String)request.getParameter("email");
		String gender = (String)request.getParameter("gender");
		String birth = (String)request.getParameter("birth");
		String phone = (String)request.getParameter("phone");

		fan.setId(id);
		fan.setPassword(password);
		fan.setName(name);
		fan.setEmail(email);
		fan.setGender(gender);
		fan.setBirth(birth);
		fan.setEmail(email);
		fan.setPhone(phone);
		
		crud.insertFanUser(fan);
		
		request.setAttribute("name", name);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/joinresult.jsp");
		rd.forward(request, response);
	}

}
