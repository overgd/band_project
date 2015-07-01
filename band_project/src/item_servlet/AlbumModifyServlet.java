package item_servlet;

import item_crud.CrudProcess;
import item_model.Album;
import item_model.Albumbbs;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ImageUtility;
import util.MultipartUploading;

/**
 * Servlet implementation class AlbumModifyServlet
 */
public class AlbumModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumModifyServlet() {
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
		
		String RESULT = "FALSE";
		Album album = new Album();
		
		CrudProcess crud = new CrudProcess();
		
		HttpSession session = request.getSession();
		String band_id = (String)session.getAttribute("BID");
		
		MultipartUploading mutipart = null;
		try {
			mutipart = new MultipartUploading(request);
		} catch(Exception e) { }
		
		String album_id = mutipart.getParameter("album_id");
		
		String image_name = mutipart.getParameter("image_name");
		String title = mutipart.getParameter("title");
		String price = mutipart.getParameter("price");
		String content = mutipart.getParameter("content");
		String file_name = mutipart.getFileName("file_name");
		
		album = crud.selectOneAlbumInfo(album_id);
		
		if(album.getBand_id().equals(band_id)) {
			
			album.setTitle(title);
			album.setPrice(Integer.parseInt(price));
			album.setContent(content);
			album.setFile_name(file_name);
			
			String filename = album.getAlbum_id()+mutipart.getFileName("image_name");
			String uploadpath = getServletContext().getRealPath("album_upload_files");
			if(image_name != "") {
				
				try {
					mutipart.saveFile("image_name", uploadpath+"/"+filename);
				}catch(Exception e) {}
				
				String thupath = uploadpath+"/thumb."+filename;
				String orgpath = uploadpath+"/"+filename;
				
				File thufile = new File(thupath);
				File orgfile = new File(orgpath);
				
				ImageUtility.resize(orgfile, thufile, 100, ImageUtility.RATIO);
				
				album.setImage_name(filename);
			}else if(image_name == "") {
				album.setImage_name("");
			}
			
			int result = crud.updateAlbumInfo(album);
			
			if(result > 0) {
				RESULT = "TRUE";
			}
		}
		
		Albumbbs albumbbs = crud.selectOneAlbumBBSInfo(album_id);
		
		request.setAttribute("bbs", albumbbs);
		request.setAttribute("album", album);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=item/albumReadView.jsp");
		rd.forward(request, response);
	}

}
