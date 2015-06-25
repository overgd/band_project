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
 * Servlet implementation class QnaReplyServlet
 */
public class QnaReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaReplyServlet() {
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
		
		Qna_info qnainfo = new Qna_info();
		Qna_content qnacontent = new Qna_content();
		Id_sequence id_sequence = new Id_sequence(); 
		
		String RESULT = "FALSE";
		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String writing_id = (String)request.getParameter("writing_id");
		
		String writer_id = (String)session.getAttribute("ID");
		String band_id = (String)session.getAttribute("BID");
		
		String table_name = band_id+".qna_info";
		
		id_sequence =  crud.selectIdSequence(table_name);
		int last_id = id_sequence.getLast_id();
		last_id++;
		id_sequence.setLast_id(last_id);
		crud.updateIdSequence(id_sequence);
		
		qnainfo.setTitle(title);
		qnainfo.setOrder_no(1);
		qnainfo.setParent_id(Integer.valueOf(writing_id));
		qnainfo.setBand_id(band_id);
		qnainfo.setWriting_id(id_sequence.getLast_id());
		qnainfo.setWriter_id(writer_id);
		qnainfo.setWriting_date(new Timestamp(System.currentTimeMillis()).toString());
		
		qnacontent.setBand_id(band_id);
		qnacontent.setContent(content);
		qnacontent.setWriting_id(id_sequence.getLast_id());
		
		if(crud.insertQnaInfo(qnainfo) > 0) {
			
			crud.insertQnaContent(qnacontent);
			RESULT = "TRUE";
			
		}
				
		response.sendRedirect("qna/qnareplyresult.jsp?RESULT="+RESULT);
		
		
	}

}
