package guest_servlet;

import guest_crud.CrudProcess;
import guest_model.SequenceManager;
import guest_model.Writing;
import guest_util.MultipartUploading;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





/**
 * Servlet implementation class WriteServlet
 */
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		
		HttpSession session = request.getSession();
		
//		request.setCharacterEncoding("euc-kr");
//		HttpSession session = request.getSession();
//		CrudProcess crud = new CrudProcess();
//		
//		Qna_info qnainfo = new Qna_info();
//		Qna_content qnacontent = new Qna_content();
//		Id_sequence id_sequence = new Id_sequence();
		
		String band_id = (String)session.getAttribute("BID");
		String id = (String)session.getAttribute("ID");
//		Id_sequence id_sequence = new Id_sequence(); 
		
		
//		String table_name = band_id+".qna_info";
		
		Writing writing = new Writing();
		
		writing.setBandid(band_id);

//		String table_name = band_id+".qna_info";
//id_sequence를 검색해서 table_name과 last_id를 가지고 온다.
//		id_sequence =  crud.selectIdSequence(table_name);
//글이 없으면 insert로 table_name과 last_id를 초기화해준다.
		
		MultipartUploading multiPart = null;
		try{
			multiPart = new MultipartUploading(request);
		}catch(Exception e){ }
		String parentId = multiPart.getParameter("parentid");
		String groupId = multiPart.getParameter("groupid");
		String orderNo = multiPart.getParameter("orderno");
		CrudProcess crud = new CrudProcess();
		if(parentId == null || parentId.equals("")){//부모글이 없는경우
			writing.setParentid(0);
			writing.setOrderno(0);
			int maxGroup = crud.selectMaxGroupId();
			maxGroup++;
			writing.setGroupid(maxGroup);
		}else{//답글인 경우
			writing.setParentid(Integer.parseInt(parentId));
			writing.setGroupid(Integer.parseInt(groupId));
			writing.setOrderno(Integer.parseInt(orderNo));
			int ordering = crud.selectMaxGroupIdReply(writing);
			if(ordering > 0){
				if(ordering > 1){
					ordering = ordering + 1;
					writing.setOrderno(ordering);
					crud.updateOrderNoReply(writing);
				}else{
					int order_no = crud.selectMaxOrderNo(writing);
					order_no = order_no + 1;
					writing.setOrderno(order_no);
					crud.updateOrderNoReply(writing);
				}
			}else{
				crud.updateOrderNoReply(writing);
			}
		}
		System.out.println("글번호:["+writing.getWritingid()+"]");
		writing.setWritingdate(
				new Timestamp(System.currentTimeMillis()).toString());
		writing.setWriterid((String)session.getAttribute("ID"));
		writing.setTitle(multiPart.getParameter("title"));
		writing.setContent(multiPart.getParameter("content"));
		try{
			writing.setWritingid(SequenceManager.nextId("guestbook_info"));
		}catch(Exception e){}
		//writing_info에 삽입.writing_content에 삽입
		crud.insertguestbookinfo(writing);
		crud.insertguestbookcontent(writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=guest/template.jsp?CONTENTPAGE=write_result.jsp");
		rd.forward(request, response);
	}
}
