package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudProcess;
import login_model.Band;

/**
 * Servlet implementation class JoinBandServlet
 */
public class JoinBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinBandServlet() {
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
		
		Band band = new Band();
		
		String id = (String)request.getAttribute("id");
		String password = (String)request.getAttribute("password");
		String name = (String)request.getAttribute("name");
		String email = (String)request.getAttribute("email");
		String genre = (String)request.getAttribute("genre");
		
		band.setId(id);
		band.setPassword(password);
		band.setName(name);
		band.setEmail(email);
		band.setGenre(genre);
		band.setContent("");
		band.setImage_name("");
		
		CrudProcess crud = new CrudProcess();
		
		crud.insertBandUser(band);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=joinresult.jsp");
		rd.forward(request, response);
		
	}

}
