package sch_servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sch_crud.CrudProcess;
import sch_model.SequenceManager;
import sch_model.Writing;
import util.ImageUtility;
import util.MultipartUploading;

/**
 * Servlet implementation class WriteServlet
 */
public class SchWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchWriteServlet() {
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
		try{multiPart = new MultipartUploading(request);
		}catch(Exception e){ }
		String fileName = multiPart.getFileName("imagename");
		String parentId = multiPart.getParameter("parentid");
		String groupId = multiPart.getParameter("groupid");
		String orderNo = multiPart.getParameter("orderno");
		CrudProcess crud = new CrudProcess();
		if(parentId == null || parentId.equals("")){//�θ���̾��°��
			writing.setParentid(0);
			writing.setOrderno(0);
			int maxGroup = crud.selectMaxGroupId();
			maxGroup++;
			writing.setGroupid(maxGroup);
		}else {//����� ���
			writing.setParentid(Integer.parseInt(parentId));
			writing.setGroupid(Integer.parseInt(groupId));
			writing.setOrderno(Integer.parseInt(orderNo));
			int ordering = crud.selectMaxGroupIdReply(writing);
			System.out.println("����� ���,ordering:["+ordering+"]");
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
		String uploadPath = getServletContext().getRealPath("upload_files");
		try{
			multiPart.saveFile("imagename", uploadPath+"/"+fileName);
		}catch(Exception e){}
		String tmpPath = uploadPath + "/small."+fileName;
		String orgPath = uploadPath + "/" + fileName;
		File orgFile = new File(orgPath);
		File newFile = new File(tmpPath);
		ImageUtility.resize(orgFile, newFile, 50, ImageUtility.RATIO);
		System.out.println("��¥:["+multiPart.getParameter("writingdate")+"]");
		writing.setWritingdate(multiPart.getParameter("writingdate"));
		writing.setImagename(fileName);
		writing.setWriterid(multiPart.getParameter("writerid"));
		writing.setTitle(multiPart.getParameter("title"));
		writing.setLocation(multiPart.getParameter("location"));
		writing.setContent(multiPart.getParameter("content"));
		try{
			writing.setWritingid(SequenceManager.nextId("sch_info"));
		}catch(Exception e){}
		//writing_info�� ����.writing_content�� ����
		crud.insertWritingInfo(writing);
		crud.insertWritingContent(writing);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?MAIN=sch/schwrite_result.jsp");
		rd.forward(request, response);
	}

}
///////�̿ϼ� ���̵� �������� �޾ƿ��� �κ� ������ ��