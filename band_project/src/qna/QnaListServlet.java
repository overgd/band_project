package qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		request.setCharacterEncoding("euc-kr");
		
		CrudProcess crud = new CrudProcess();
		HttpSession session = request.getSession();
		String band_id = request.getParameter("BID");
//		String band_id = (String)session.getAttribute("BID");
		
		List<Qna_info> qnainfo = crud.selectQnaInfo(band_id);
		List<Qna_content> qnacontent = crud.selectQnaContent(band_id);
		Integer qnacount = crud.selectCountQnaInfo(band_id);
		
		request.setAttribute("COUNT", qnacount);
		request.setAttribute("INFO", qnainfo);
		request.setAttribute("CONTENT", qnacontent);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=qna/qnalist.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CrudProcess crud = new CrudProcess();
		
		String band_id = request.getParameter("BID");
		
		List<Qna_info> qnainfo = crud.selectQnaInfo(band_id);
		List<Qna_content> qnacontent = crud.selectQnaContent(band_id);
		
		request.setAttribute("INFO", qnainfo);
		request.setAttribute("CONTENT", qnacontent);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?MAIN=qna/qnalist.jsp");
		rd.forward(request, response);
		
	}

}
