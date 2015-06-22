package band;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_model.Band;
import band_crud.CrudProcess;

/**
 * Servlet implementation class SearchBandServlet
 */
public class SearchBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("bandname");
		CrudProcess crud = new CrudProcess();
		
		List bandlist = crud.selectBandInfoToName(name);
		
		if(bandlist != null) {

			Band[] band = new Band[bandlist.size()];
			
			for(int cnt = 0; cnt < bandlist.size(); cnt++) {
				band[cnt] = (Band)bandlist.get(cnt);
			}
			
			request.setAttribute("LISTSIZE", band.length);
			request.setAttribute("LISTRESULT", band);
		
		}else {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=band/searchResult.jsp");
		rd.forward(request, response);
	}

}
