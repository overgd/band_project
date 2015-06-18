package item_servlet;

import item_crud.CrudProcess;
import item_model.AInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlbumPostServlet
 */
public class AlbumPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumPostServlet() {
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
		
		String albumid = request.getParameter("albumid");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String content = request.getParameter("content");
		
		AInfo ai = new AInfo();
		ai.setAlbumid(Integer.parseInt(albumid));
		ai.setTitle(title);
		ai.setPrice(Integer.parseInt(price));
		ai.setContent(content);
		
		CrudProcess crud = new CrudProcess();
		crud.insertAlbumInfo(ai);
		
		request.setAttribute("ai",ai);
		RequestDispatcher rd = request.getRequestDispatcher("albumReadView.jsp");
		rd.forward(request, response);
		
		
	}

}
