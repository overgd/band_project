package guest_servlet;

import guest_crud.CrudProcess;
import guest_model.Writing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DeleteWritingServlet
 */
public class DeleteWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWritingServlet() {
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
		
		String bandId = (String)session.getAttribute("BID");
		String writeId = request.getParameter("id");
		
		Writing inwriting = new Writing();
		
		inwriting.setBandid(bandId);
		inwriting.setWritingid(Integer.parseInt(writeId));
		
		String id = (String)session.getAttribute("ID");
		CrudProcess crud = new CrudProcess();
		Writing orgWriting =
				crud.selectOneWritingInfo(inwriting);
		if(orgWriting.getWriterid().equals(id)){//암호 일치
			
			crud.deleteWritingInfo(Integer.parseInt(writeId));
			crud.deleteWritingContent(Integer.parseInt(writeId));
		}else{//암호 불일치
			request.setAttribute("id", writeId);
		}
		RequestDispatcher rd= request.getRequestDispatcher(
				"index.jsp?MAIN=guest/delete_result.jsp");
		rd.forward(request, response);
	}

}