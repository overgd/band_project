package guest_servlet;


import free_util.ImageUtility;
import guest_crud.CrudProcess;
import guest_model.Writing;
import guest_util.MultipartUploading;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class UpdateWritingServlet
 */
public class UpdateWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWritingServlet() {
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
		MultipartUploading multiPart =null;
		
		HttpSession session = request.getSession();
		
		String bandId = (String)session.getAttribute("BID");
		
		Writing inwriting = new Writing();
		
		inwriting.setBandid(bandId);
		
		try{
			multiPart = new MultipartUploading(request);
		}catch(Exception e){}
		Writing writing = new Writing();
		String writeId = multiPart.getParameter("id");
		inwriting.setWritingid(Integer.parseInt(writeId));
		String id = (String)session.getAttribute("ID");
		CrudProcess crud = new CrudProcess();
		Writing oldWriting = crud.selectOneWritingInfo(
				inwriting);
		writing.setWritingid(Integer.parseInt(writeId));
		if(oldWriting.getWriterid().equals(id)){
			writing.setTitle(multiPart.getParameter("title"));
			writing.setWriterid(multiPart.getParameter("name"));
			writing.setContent(multiPart.getParameter("content"));
			writing.setBandid((String)session.getAttribute("BID"));
			crud.updateWritingInfo(writing);
			crud.updateWritingContent(writing);
		}else{
			request.setAttribute("RESULT", "FAIL");
		}
		request.setAttribute("id", writeId);
		request.setAttribute("BID", (String)session.getAttribute("BID"));
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/update_result.jsp");
		rd.forward(request, response);
	}

}

