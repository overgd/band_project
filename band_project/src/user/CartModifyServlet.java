package user;

import item_model.Album;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user_model.Cart;

/**
 * Servlet implementation class CartModifyServlet
 */
public class CartModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartModifyServlet() {
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
		
		ArrayList<Cart> list = (ArrayList<Cart>)session.getAttribute("CP");
		String fun = request.getParameter("function");
		String album_id = request.getParameter("aid");
				
		int listsize = list.size(); //��ٱ��Ͽ� �󸶳� ����ִ��� Ȯ��
		int aid;
		
		String RESULT = "FALSE";
		
		for(int cnt = 0; cnt < listsize; cnt++) { //��ٱ��� ũ�⸸ŭ for
			
			Cart cart = list.get(cnt); //��ٱ����� �������� ������
			aid = cart.getAlbum().getAlbum_id(); //��ٱ����� �ٹ����̵� üũ
			
			if(Integer.parseInt(album_id) == aid) { //���� ���� Ȯ��
		
				if(fun.equals("plus")) cart.setNumber(cart.getNumber()+1); 
				else if(fun.equals("minus")) cart.setNumber(cart.getNumber()-1); 
				
				if(cart.getNumber() <= 0 || fun.equals("remove")) { //0���� �۾����� ����
					list.remove(cnt);
					RESULT = "0���� �۾Ƽ� ����";
				}else if(cart.getNumber() > 0) { //0���� ũ��
					list.set(cnt, cart); //�ٽ� ����
					RESULT = "TRUE";
				}
				break;
				
			}else if(Integer.parseInt(album_id) != aid){ //���� ������ ������
				if(fun.equals("remove")) { //0���� �۾����� ����
					list.clear();
					RESULT = "REMOVE";
					break;
				}
			}
			
		}
		
		session.setAttribute("CP", list);
		response.sendRedirect("index.jsp?MAIN=user/cart.jsp");
		
	}

}
