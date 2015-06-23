package qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna_crud.CrudProcess;
import qna_model.Id_sequence;

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
		
		String writer_id = (String)session.getAttribute("ID");
		String band_id = (String)session.getAttribute("BID");
		String content = (String)session.getAttribute("content");
		
		//id_sequence를 검색해서 table_name과 last_id를 가지고 온다.
		Id_sequence idsequence = crud.selectIdSequence(band_id);
		//글이 없으면 insert로 table_name과 last_id를 초기화해준다.
		System.out.println("I'm HERE");
		if(idsequence.getTable_name().isEmpty()) {
			
			System.out.println(idsequence.getTable_name());
		}
		//글이 있으면 last_id를 가져와서 등록한다.
		
		
	
	}

}
