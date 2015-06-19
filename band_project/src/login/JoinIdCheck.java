package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_crud.CrudProcess;

/**
 * Servlet implementation class JoinBandIdCheck
 */
public class JoinIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinIdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudProcess crud = new CrudProcess();
		
		String id = (String)request.getParameter("id");
		String bandid = "b."+id;
		String fanid = "f."+id;
		String selectbandid = crud.selectBandUserID(bandid);
		String selectfanid = crud.selectFanUserID(fanid);
		
		String result = "true";
	
		if(bandid.equals(selectbandid)) {
			result = "false";
		}
		if(fanid.equals(selectfanid)) {
			result = "false";
		}

		RequestDispatcher rd = request.getRequestDispatcher("login/idcheck.jsp?result="+result);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
