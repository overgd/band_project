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
				
		int listsize = list.size(); //장바구니에 얼마나 들어있는지 확인
		int aid;
		
		String RESULT = "FALSE";
		
		for(int cnt = 0; cnt < listsize; cnt++) { //장바구니 크기만큼 for
			
			Cart cart = list.get(cnt); //장바구니의 아이템을 가져옴
			aid = cart.getAlbum().getAlbum_id(); //장바구니의 앨범아이디 체크
			
			if(Integer.parseInt(album_id) == aid) { //같은 물건 확인
		
				if(fun.equals("plus")) cart.setNumber(cart.getNumber()+1); 
				else if(fun.equals("minus")) cart.setNumber(cart.getNumber()-1); 
				
				if(cart.getNumber() <= 0 || fun.equals("remove")) { //0보다 작아지면 삭제
					list.remove(cnt);
					RESULT = "0보다 작아서 삭제";
				}else if(cart.getNumber() > 0) { //0보다 크면
					list.set(cnt, cart); //다시 넣음
					RESULT = "TRUE";
				}
				break;
				
			}else if(Integer.parseInt(album_id) != aid){ //같은 물건이 없으면
				if(fun.equals("remove")) { //0보다 작아지면 삭제
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
