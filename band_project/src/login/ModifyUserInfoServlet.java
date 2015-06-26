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
 * Servlet implementation class ModifyUserInfoServlet
 */
public class ModifyUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserInfoServlet() {
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
		
		HttpSession session = request.getSession();
		String div = (String)session.getAttribute("DIV");
		
		if(div.equals("f")) {
			
			Fan fan = new Fan();
			CrudProcess crud = new CrudProcess();
			
			fan.setId("f."+(String)session.getAttribute("ID"));
			fan.setPassword((String)request.getParameter("password"));
			fan.setName((String)request.getParameter("name"));
			fan.setEmail((String)request.getParameter("email"));
			fan.setBirth((String)request.getParameter("birth"));
			fan.setGender((String)request.getParameter("gender"));
			fan.setPhone((String)request.getParameter("phone"));
			
			int result = crud.updateFanUserInfo(fan);
			
			if(result > 0) {
				session.setAttribute("NAME", fan.getName());
				session.setAttribute("GENDER", fan.getGender());
				session.setAttribute("PHONE", fan.getPhone());
				session.setAttribute("BIRTH", fan.getBirth());
				session.setAttribute("EMAIL", fan.getEmail());
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/modifyresult.jsp");
				rd.forward(request, response);
			}
			
		}else if(div.equals("b")) {
			
			Band band = new Band();
			CrudProcess crud = new CrudProcess();
			
			band.setId("b."+(String)session.getAttribute("ID"));
			band.setPassword((String)request.getParameter("password"));
			band.setName((String)request.getParameter("name"));
			band.setEmail((String)request.getParameter("email"));
			band.setGenre((String)request.getParameter("genre"));
			
			int result = crud.updateBandUserInfo(band);
			
			if(result > 0) {
				session.setAttribute("NAME", band.getName());
				session.setAttribute("BNAME", band.getName());
				session.setAttribute("EMAIL", band.getEmail());
				session.setAttribute("GENRE", band.getGenre());
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=login/modifyresult.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
