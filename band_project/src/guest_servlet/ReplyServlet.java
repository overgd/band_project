package guest_servlet;

import guest_crud.CrudProcess;
import guest_model.Writing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
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
		
		HttpSession session = request.getSession();
		
		String bandId = (String)session.getAttribute("BID");
		String writeId = request.getParameter("id");
		
		Writing inwriting = new Writing();
		
		inwriting.setBandid(bandId);
		inwriting.setWritingid(Integer.parseInt(writeId));
		
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		String title = "";
		Writing writing = null;
		if(parentId != null){//답글인 경우
			try{
				CrudProcess crud = new CrudProcess();
				writing = crud.selectOneWritingInfo(
						inwriting);//부모글정보 검색
			}catch(Exception e){}
			if(writing != null){//검색된 경우
				title = "RE] " + writing.getTitle();//원글의 제목을 불러옴
			}
			writing.setParentid(Integer.parseInt(parentId));
			writing.setGroupid(Integer.parseInt(groupId));
		}
			request.setAttribute("writing", writing);
			request.setAttribute("title", title);
			RequestDispatcher rd = request.getRequestDispatcher(
					"index.jsp?MAIN=guest/template.jsp?CONTENTPAGE=writeForm_view.jsp");
			rd.forward(request, response);
		}
	}

