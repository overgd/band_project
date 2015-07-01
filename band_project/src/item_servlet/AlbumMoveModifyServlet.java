package item_servlet;

import item_model.Album;
import item_model.Albumbbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlbumMoveModifyServlet
 */
public class AlbumMoveModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumMoveModifyServlet() {
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
		
		Album album = new Album();
		Albumbbs albumbbs = new Albumbbs();
		
		album.setAlbum_id(Integer.valueOf(request.getParameter("album_id")));
		album.setContent(request.getParameter("content"));
		album.setFile_name(request.getParameter("file_name"));
		album.setImage_name(request.getParameter("image_name"));
		album.setPrice(Integer.valueOf(request.getParameter("price")));
		album.setRegister_date(request.getParameter("register_date"));
		album.setTitle(request.getParameter("title"));
		
		request.setAttribute("album", album);
		request.setAttribute("writer", request.getParameter("writer_id"));
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=item/albumModifyForm.jsp");
		rd.forward(request, response);
	
	}

}
