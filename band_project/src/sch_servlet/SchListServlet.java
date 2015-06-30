package sch_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sch_crud.CrudProcess;
import sch_model.Condition;
import sch_model.Writing;



/**
 * Servlet implementation class ListServlet
 */
public class SchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static int PAGE_SIZE = 5;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudProcess crud = new CrudProcess();
//		List list = crud.selectWritingInfo();//占쏙옙占� 占쌉시깍옙 占싯삼옙
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = crud.selectCount();
		int totalPageCount = 0;//占쏙옙체 占쏙옙占쏙옙占쏙옙 占쏙옙
		int startRow = 0, endRow = 0;//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙호
		if(count > 0){//占쌉시깍옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占�
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage - 1) * PAGE_SIZE + 1;
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
			"index.jsp?MAIN=sch/schlist_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudProcess crud = new CrudProcess();
//		List list = crud.selectWritingInfo();
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = crud.selectCount();
		int totalPageCount = 0;//占쏙옙체 占쏙옙占쏙옙占쏙옙 占쏙옙
		int startRow = 0, endRow = 0;//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙호
		if(count > 0){//占쌉시깍옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占�
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage - 1) * PAGE_SIZE + 1;
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
			"index.jsp?MAIN=sch/schlist_view.jsp");
		rd.forward(request, response);
	}

}