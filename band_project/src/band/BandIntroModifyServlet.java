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
 * Servlet implementation class BandIntroModifyServlet
 */
public class BandIntroModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandIntroModifyServlet() {
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
		
		CrudProcess crud = new CrudProcess();
		
		Band band = new Band();
		
		band.setId("b."+(String)session.getAttribute("ID"));
		band.setName(request.getParameter("name"));
		band.setGenre(request.getParameter("genre"));
		band.setImage_name(request.getParameter("image_name"));
		band.setContent(request.getParameter("content"));
		
		int result = crud.updateBandIntro(band);
		
		if(result > 0) {
			request.setAttribute("BAND", band);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=band/bandIntro.jsp");
			rd.forward(request, response);
		}
	}

}
