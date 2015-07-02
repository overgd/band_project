package item_servlet;

import item_crud.CrudProcess;
import item_model.Album;
import item_model.Albumbbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AlbumListServlet
 */
public class AlbumListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		CrudProcess crud = new CrudProcess();
		
		String band_id = request.getParameter("BID");
		
		List<Albumbbs> albumbbslist = crud.selectAlbumBBSInfoToBandId(band_id);
		List<Album> albumlist = crud.selectAlbumInfoToBandId(band_id);
		
		int count = albumbbslist.size();
			
		request.setAttribute("COUNT", count);
		request.setAttribute("album", albumlist);	
		request.setAttribute("bbs", albumbbslist);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=item/albumListView.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
