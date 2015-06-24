package qna;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class QnaWriteServlet
 */
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		
		String writer_id = (String)session.getAttribute("ID");
		String band_id = (String)session.getAttribute("BID");
		
		System.out.print(band_id);
		
		String table_name = band_id+".qna_info";
		
		//id_sequence를 검색해서 table_name과 last_id를 가지고 온다.
		
		id_sequence =  crud.selectIdSequence(table_name);
		//글이 없으면 insert로 table_name과 last_id를 초기화해준다.
		if(id_sequence == null) {
			id_sequence = new Id_sequence();
			id_sequence.setLast_id(1);
			id_sequence.setTable_name(table_name);
			crud.insertIdSequence(id_sequence);
		}else {
			int last_id = id_sequence.getLast_id();
			last_id++;
			id_sequence.setLast_id(last_id);
			crud.insertIdSequence(id_sequence);
		}
		
		qnainfo.setTitle(title);
		qnainfo.setOrder_no(0);
		qnainfo.setParent_id(id_sequence.getLast_id());
		qnainfo.setBand_id(band_id);
		qnainfo.setWriting_id(id_sequence.getLast_id());
		qnainfo.setWriter_id(writer_id);
		qnainfo.setWriting_date(new Timestamp(System.currentTimeMillis()).toString());
		
		qnacontent.setBand_id(band_id);
		qnacontent.setContent(content);
		qnacontent.setWriting_id(id_sequence.getLast_id());
		
		crud.insertQnaInfo(qnainfo);
		crud.insertQnaContent(qnacontent);
		
		//글이 있으면 last_id를 가져와서 등록한다.
		
		request.setAttribute("INFO", qnainfo);
		request.setAttribute("CONTENT", qnacontent);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=qna/qnalist.jsp");
		rd.forward(request, response);
		
	}

}
