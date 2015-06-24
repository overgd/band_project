package guest_servlet;


import guest_crud.CrudProcess;
import guest_model.Writing;
import guest_util.MultipartUploading;

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
		try{
			multiPart = new MultipartUploading(request);
		}catch(Exception e){}
		Writing writing = new Writing();
		String writeId = multiPart.getParameter("id");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		CrudProcess crud = new CrudProcess();
		Writing oldWriting = crud.selectOneWritingInfo(
				Integer.parseInt(writeId));
		writing.setWritingid(Integer.parseInt(writeId));
		if(oldWriting.getWriterid().equals(id)){
			writing.setTitle(multiPart.getParameter("title"));
			writing.setWriterid(multiPart.getParameter("name"));
			writing.setContent(multiPart.getParameter("content"));
			crud.updateWritingInfo(writing);
			crud.updateWritingContent(writing);
		}else{
			request.setAttribute("RESULT", "FAIL");
		}
		request.setAttribute("id", writeId);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/update_result.jsp");
		rd.forward(request, response);
	}

}
