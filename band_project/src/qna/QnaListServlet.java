package qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna_crud.CrudProcess;
import qna_model.Qna_content;
import qna_model.Qna_info;

/**
 * Servlet implementation class QnaListServlet
 */
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CrudProcess crud = new CrudProcess();
		
		String band_id = request.getParameter("BID");
		
		Qna_info qnainfo = crud.selectQnaInfo(band_id);
		Qna_content qnacontent = crud.selectQnaContent(band_id);
		
		request.setAttribute("INFO", qnainfo);
		request.setAttribute("CONTENT", qnacontent);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=qna/qnalist.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
