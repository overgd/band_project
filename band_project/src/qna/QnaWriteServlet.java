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
		
		//id_sequence�� �˻��ؼ� table_name�� last_id�� ������ �´�.
		Id_sequence idsequence = crud.selectIdSequence(band_id);
		//���� ������ insert�� table_name�� last_id�� �ʱ�ȭ���ش�.
		System.out.println("I'm HERE");
		if(idsequence.getTable_name().isEmpty()) {
			
			System.out.println(idsequence.getTable_name());
		}
		//���� ������ last_id�� �����ͼ� ����Ѵ�.
		
		
	
	}

}
