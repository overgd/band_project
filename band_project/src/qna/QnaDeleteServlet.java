package qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna_crud.CrudProcess;
import qna_model.Qna_info;

/**
 * Servlet implementation class QnaDeleteServlet
 */
public class QnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String writing_id = request.getParameter("WID");
		String session_id = (String)session.getAttribute("ID");
		String writer_id = request.getParameter("ID");
		String band_id = request.getParameter("BID");
		
		String result = null;
		
		if(session_id == writer_id) {
			
			Qna_info qnainfo = new Qna_info();
			
			qnainfo.setBand_id(band_id);
			qnainfo.setWriting_id(Integer.valueOf(writing_id));
			
			CrudProcess crud = new CrudProcess();
			
			crud.deleteQnaContent(qnainfo);
			crud.deleteQnaInfo(qnainfo);
			
			result = "TRUE";
			
			

		}else {
			
			result = "FALSE";
			
		}
		
		response.sendRedirect("index.jsp?MAIN=qnalist.do?BID="+session.getAttribute("BID")+"&RESULT"+result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
