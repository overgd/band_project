package free_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import free_crud.CrudProcess;
import free_model.Condition;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static int PAGE_SIZE = 5;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		CrudProcess crud = new CrudProcess();
		
		String pageNum = request.getParameter("page");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = crud.selectCount();
		int totalPageCount=0;//전체 페이지 수
		int startRow =0, endRow = 0;//시작 행과 마지막 행 번호
		if(count >0){//게시글이 존재하는 경우
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage -1) * PAGE_SIZE +1;
			endRow = currentPage * PAGE_SIZE;
			if(endRow > count) endRow = count;
		}
		Condition condition = new Condition();
		condition.setStartRow(startRow); condition.setEndRow(endRow);
		List list = crud.selectWritingInfoWithRange(condition);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("PAGE_SIZE", PAGE_SIZE);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startRow", startRow);
		request.setAttribute("count", count);
		request.setAttribute("list", list);	
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=free/list_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
CrudProcess crud = new CrudProcess();
		
		String pageNum = request.getParameter("page");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = crud.selectCount();
		int totalPageCount=0;//전체 페이지 수
		int startRow =0, endRow = 0;//시작 행과 마지막 행 번호
		if(count >0){//게시글이 존재하는 경우
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage -1) * PAGE_SIZE +1;
			endRow = currentPage * PAGE_SIZE;
			if(endRow > count) endRow = count;
		}
		Condition condition = new Condition();
		condition.setStartRow(startRow); condition.setEndRow(endRow);
		List list = crud.selectWritingInfoWithRange(condition);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("PAGE_SIZE", PAGE_SIZE);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startRow", startRow);
		request.setAttribute("count", count);
		request.setAttribute("list", list);	
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=free/list_view.jsp");
		rd.forward(request, response);
	}

}
