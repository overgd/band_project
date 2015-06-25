package qna;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna_crud.CrudProcess;
import qna_model.Id_sequence;
import qna_model.Qna_content;
import qna_model.Qna_info;

/**
 * Servlet implementation class QnaModifyServlet
 */
public class QnaModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaModifyServlet() {
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
		CrudProcess crud = new CrudProcess();
		
		String sid = (String)session.getAttribute("ID");
		String writer_id = request.getParameter("writer_id");
		
		String RESULT = "FALSE";
		
		if(sid.equals(writer_id)) {
		
			String band_id = (String)session.getAttribute("BID");
			String writing_id = request.getParameter("writing_id");
			String title = (String)request.getParameter("title");
			String content = (String)request.getParameter("content");
			
			Qna_info qnainfo = new Qna_info();
			Qna_content qnacontent = new Qna_content();
			
			qnainfo.setBand_id(band_id);
			qnainfo.setTitle(title);
			qnainfo.setWriting_id(Integer.valueOf(writing_id));
			
			qnacontent.setBand_id(band_id);
			qnacontent.setContent(content);
			qnacontent.setWriting_id(Integer.valueOf(writing_id));
			
			crud.updateQnaContent(qnacontent);
			crud.updateQnaInfo(qnainfo);
			
			RESULT = "TRUE";
			
		}
		
		response.sendRedirect("qna/qnaresult.jsp?RESULT="+RESULT);
		
	}

}
