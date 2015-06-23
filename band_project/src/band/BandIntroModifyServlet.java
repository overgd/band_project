package band;

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

		HttpSession session = request.getSession();
		CrudProcess crud = new CrudProcess();
		Band band = new Band();
		MultipartUploading mutipart = null;
		try {
			mutipart = new MultipartUploading(request);
		} catch(Exception e) { }
		
		band.setId("b."+(String)session.getAttribute("ID"));
		band.setName(mutipart.getParameter("name"));
		band.setGenre(mutipart.getParameter("genre"));
		band.setContent(mutipart.getParameter("content"));
		
		String image_name = mutipart.getFileName("image_name");
		
		String filename = band.getId()+mutipart.getFileName("image_name");
		
		String uploadpath = getServletContext().getRealPath("band_upload_files");
			
		if(image_name != "") {
			
			try {
				mutipart.saveFile("image_name", uploadpath+"/"+filename);
			}catch(Exception e) {}
			
			String thupath = uploadpath+"/thumb."+filename;
			String orgpath = uploadpath+"/"+filename;
			
			File thufile = new File(thupath);
			File orgfile = new File(orgpath);
			
			ImageUtility.resize(orgfile, thufile, 50, ImageUtility.RATIO);
			
			band.setImage_name(filename);
		}else if(image_name == "") {
			
			band.setImage_name(mutipart.getParameter("org_image_name"));
		}
		
		int result = crud.updateBandIntro(band);
		
		if(result > 0) {
			session.setAttribute("NAME", band.getName());
			session.setAttribute("BNAME", band.getName());
			
			request.setAttribute("BAND", band);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=band/bandIntro.jsp?BOTTOM=bottom/bottomMenu.jsp");
			rd.forward(request, response);
		}
	}

}
