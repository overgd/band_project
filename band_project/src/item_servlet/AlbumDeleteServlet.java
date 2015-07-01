package item_servlet;

import item_crud.CrudProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AlbumDeleteServlet
 */
public class AlbumDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumDeleteServlet() {
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

		HttpSession session = request.getSession();
		CrudProcess crud = new CrudProcess();
		
		String RESULT = "FALSE";
		String sid = (String)session.getAttribute("ID");
		String album_id = request.getParameter("album_id");
		String band_id = request.getParameter("band_id");
		
		if(sid.equals(band_id)) {
			
			crud.deleteAlbumBBSInfo(album_id);
			crud.deleteAlbumInfo(album_id);

			RESULT = "TRUE";
		}
		
		request.setAttribute("RESULT", RESULT);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=item/albumDeleteResult.jsp");
		rd.forward(request, response);
		
	}

}
