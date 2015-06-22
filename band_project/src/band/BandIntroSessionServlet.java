package band;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_model.Band;
import band_crud.CrudProcess;

/**
 * Servlet implementation class BandIntroSessionServlet
 */
public class BandIntroSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandIntroSessionServlet() {
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
		
		Band band = crud.selectBandIntroToId("b."+id);
		
		request.setAttribute("BAND", band);
		request.setAttribute("ID", id);
		session.setAttribute("BID", id);
		session.setAttribute("BNAME", band.getName());
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=band/bandIntro.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
