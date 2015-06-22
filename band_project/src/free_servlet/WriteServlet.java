package free_servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;

import free_crud.CrudProcess;
import free_model.SequenceManager;
import free_model.Writing;
import free_util.ImageUtility;
import free_util.MultipartUploading;

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
		Writing writing = new Writing();
		MultipartUploading multiPart = null;
		try{
			multiPart = new MultipartUploading(request);
		}catch(Exception e){}
		String fileName = multiPart.getFileName("imagename");
		String parentId = multiPart.getParameter("parentid");
		String groupId = multiPart.getParameter("groupid");
		String orderNo = multiPart.getParameter("orderno");
		CrudProcess crud = new CrudProcess();
		if(parentId ==null || parentId.equals("")){
			writing.setParentid(0);
			writing.setOrderno(0);
			int maxGroup = crud.selectMaxGroupId();
			maxGroup++;
			writing.setGroupid(maxGroup);
		}else {//답글인 경우
			writing.setParentid(Integer.parseInt(parentId));
			writing.setGroupid(Integer.parseInt(groupId));
			writing.setOrderno(Integer.parseInt(orderNo));
			int ordering = crud.selectMaxGroupIdReply(writing);
			if(ordering > 0){
				if(ordering > 1){
					ordering= ordering + 1;
					writing.setOrderno(ordering);
					crud.updateOrderNoReply(writing);
				}else{
					int order_no = crud.selectMaxOrderNo(writing);
					order_no= order_no + 1;
					writing.setOrderno(order_no);
					crud.updateOrderNoReply(writing);
				}
			}else{
				crud.updateOrderNoReply(writing);
				//기존의 출력순서를 1증가
			}
			
		}
		String uploadPath = getServletContext().getRealPath("upload_files");
		try{
			multiPart.savaFile("imagename", uploadPath+"/"+fileName);
		}catch(Exception e){}
		String tmpPath = uploadPath + "/small."+fileName;
		String orgPath = uploadPath + "/" + fileName;
		File orgFile = new File(orgPath);
		File newFile = new File(tmpPath);
		ImageUtility.resize(orgFile, newFile, 50, ImageUtility.RATIO);
		writing.setWritingdate(new Timestamp(System.currentTimeMillis()).toString());
		writing.setImagename(fileName);
		HttpSession session = request.getSession();
		writing.setWritername((String)session.getAttribute("ID"));
		writing.setTitle(multiPart.getParameter("title"));
		writing.setContent(multiPart.getParameter("content"));
		try{
			writing.setWritingid(SequenceManager.nextId("freeboard_info"));
		}catch(Exception e){}
		crud.insertWritingInfo(writing);
		crud.insertWritingContent(writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=free/write_result.jsp");
		rd.forward(request, response);
	}

}
