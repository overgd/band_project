
package guest_servlet;

import guest_crud.CrudProcess;
import guest_model.Condition;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    private static int PAGE_SIZE = 5;//������ ���� ���� ���� �ٲ��ָ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String band_id = request.getParameter("ID");
		
		CrudProcess crud = new CrudProcess();
//		List list= crud.selectWritingInfo();//��� �Խñ� �˻�
		//��ü �� ����, ������ ����, ���۱۹�ȣ, �������۹�ȣ
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = crud.selectCount();
		int totalPageCount = 0;//��ü ������ ��
		int startRow = 0, endRow = 0;//���� ��� ������ �� ��ȣ
		if(count > 0){//�Խñ��� �����ϴ� ���
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage - 1) * PAGE_SIZE + 1;
			endRow = currentPage * PAGE_SIZE;
			if(endRow > count) endRow = count;
		}
		Condition condition = new Condition();
		condition.setBand_id(band_id);
		condition.setStartRow(startRow);
		condition.setEndRow(endRow);
		List list = crud.selectWritingInfoWithRange(condition);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("PAGE_SIZE", PAGE_SIZE);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startRow", startRow);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/template.jsp?CONTENTPAGE=list_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudProcess crud = new CrudProcess();
//		List list= crud.selectWritingInfo();//��� �Խñ� �˻�
		//��ü �� ����, ������ ����, ���۱۹�ȣ, �������۹�ȣ
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = crud.selectCount();
		int totalPageCount = 0;//��ü ������ ��
		int startRow = 0, endRow = 0;//���� ��� ������ �� ��ȣ
		if(count > 0){//�Խñ��� �����ϴ� ���
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage - 1) * PAGE_SIZE + 1;
			endRow = currentPage * PAGE_SIZE;
			if(endRow > count) endRow = count;
		}
		Condition condition = new Condition();
		condition.setStartRow(startRow);
		condition.setEndRow(endRow);
		List list = crud.selectWritingInfoWithRange(condition);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("PAGE_SIZE", PAGE_SIZE);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startRow", startRow);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/template.jsp?CONTENTPAGE=guest/list_view.jsp");
		rd.forward(request, response);
	}

}
