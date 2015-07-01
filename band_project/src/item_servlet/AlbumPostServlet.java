package item_servlet;

import item_crud.CrudProcess;
import item_model.Album;
import item_model.Albumbbs;
import item_model.Id_sequence;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ImageUtility;
import util.MultipartUploading;

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
		
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		
		MultipartUploading mutipart = null;
		try {
			mutipart = new MultipartUploading(request);
		} catch(Exception e) { }
		
		Album album = new Album();
		Albumbbs albumbbs = new Albumbbs();
		Id_sequence idsequence = new Id_sequence();
		
		CrudProcess crud = new CrudProcess();
		
		String band_id = (String)session.getAttribute("BID");
		String writer_id = (String)session.getAttribute("NAME");
		
		String title = mutipart.getParameter("title");
		String price = mutipart.getParameter("price");
		String content = mutipart.getParameter("content");
		String register_date = new Timestamp(System.currentTimeMillis()).toString();
		String image_name = mutipart.getFileName("image_name");
		String file_name = mutipart.getFileName("file_name");
		
		String table_name = band_id+".albumbbs_info";
		
		int last_album_id = crud.selectLastAlbumId();
		idsequence = crud.selectIdSequence(table_name);
		
		if(last_album_id == 0) {
			last_album_id = 1;
		}else {
			last_album_id++;
		}
		
		if(idsequence == null) {
			idsequence = new Id_sequence();
			idsequence.setLast_id(1);
			idsequence.setTable_name(table_name);
			crud.insertIdSequence(idsequence);
		}else {
			idsequence.setLast_id(idsequence.getLast_id()+1);
			crud.updateIdSequence(idsequence);
		}
		
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
			
			album.setImage_name(mutipart.getParameter("org_image_name"));
		}

		album.setTitle(title);
		album.setPrice(Integer.parseInt(price));
		album.setContent(content);
		album.setAlbum_id(last_album_id);
		album.setBand_id(band_id);
		album.setRegister_date(register_date);
		album.setFile_name(file_name);
		
		albumbbs.setAlbum_id(last_album_id);
		albumbbs.setBand_id(band_id);
		albumbbs.setWriter_id(writer_id);
		albumbbs.setWriting_id(idsequence.getLast_id());
		
		crud.insertAlbumInfo(album);
		crud.insertAlbumBBSInfo(albumbbs);
		
		request.setAttribute("album",album);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=item/albumReadView.jsp");
		rd.forward(request, response);
		
	}

}
