package sch_servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sch_crud.CrudProcess;
import sch_model.Writing;
import util.ImageUtility;
import util.MultipartUploading;

/**
 * Servlet implementation class UpdateWritingServlet
 */
public class SchUpdateWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchUpdateWritingServlet() {
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
		MultipartUploading multiPart = null;
		try{
			multiPart = new MultipartUploading(request);
		}catch(Exception e){}
		Writing writing = new Writing();//변경 정보를 저장할 빈
		String writeId = multiPart.getParameter("id");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		CrudProcess crud = new CrudProcess();
		Writing oldWriting = crud.selectOneWritingInfo(
				Integer.parseInt(writeId));//변경전 정보 검색
		writing.setWritingid(Integer.parseInt(writeId));
		if(oldWriting.getWriterid().equals(id)){
			String fileName = multiPart.getFileName("image_name");
			if(fileName.equals("")){//이미지를 변경하지 않는 경우
				writing.setImagename(oldWriting.getImagename());
			}else {//이미지를 변경하는 경우
				String path = getServletContext().getRealPath("upload_files");
				String newPath = path + "/" + fileName;
				try{
					multiPart.saveFile("image_name", newPath);
				}catch(Exception e){}
				String smallPath = path + "/small." + fileName;
				File orgFile = new File(newPath);
				File thumbFile = new File(smallPath);
				ImageUtility.resize(orgFile,thumbFile,50,ImageUtility.RATIO);
				writing.setImagename(fileName);
			}
			writing.setTitle(multiPart.getParameter("title"));
			writing.setLocation(multiPart.getParameter("location"));
			writing.setContent(multiPart.getParameter("content"));
			crud.updateWritingInfo(writing);
			crud.updateWritingContent(writing);
		}else{
			request.setAttribute("RESULT", "FAIL");
		}
		request.setAttribute("id", writeId);
		RequestDispatcher rd = request.getRequestDispatcher(
			"index.jsp?MAIN=sch/schupdate_result.jsp");
		rd.forward(request, response);
	}

}














