package user;

import item_crud.CrudProcess;
import item_model.Album;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user_model.Cart;

/**
 * Servlet implementation class CartAddServlet
 */
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServlet() {
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
		CrudProcess crud = new CrudProcess();
		
		String BID = (String)session.getAttribute("BID");
		String album_id = request.getParameter("album_id");
		String move = request.getParameter("movecart");
		
		int aid;
		int listsize; 
		
		ArrayList<Cart> list = (ArrayList<Cart>)session.getAttribute("CP");

		if(list != null) {
			listsize = list.size();
			for(int cnt = 0; cnt < listsize; cnt++) {
				
				Cart cart = list.get(cnt);
				aid = cart.getAlbum().getAlbum_id();
				
				if(Integer.parseInt(album_id) == aid) {
					System.out.println("장바구니에 중복된 물건이 있을 경우"+cnt);
					cart.setNumber(cart.getNumber()+1);
					list.set(cnt, cart);
					session.setAttribute("CP", list);
					
				}else {
					Cart scart = new Cart();
					System.out.println("장바구니에 다른 물건이 있는 경우"+cnt);
					Album album = crud.selectOneAlbumInfo(album_id);
					scart.setAlbum(album);
					scart.setNumber(1);
					list.add(scart);
					session.setAttribute("CP", list);
					break;
				}
				
			}
		}else {
			
			System.out.println("장바구니에 아무것도 없는 경우");
			Cart cart = new Cart();
			Album album = crud.selectOneAlbumInfo(album_id);
			cart.setAlbum(album);
			cart.setNumber(1);
			list = new ArrayList<Cart>();
			list.add(0, cart);
			session.setAttribute("CP", list);
		}
		
		
		if(move.equals("no")) {
			response.sendRedirect("index.jsp?MAIN=albumlist.do?BID="+BID);
		}else if(move.equals("yes")) {
			response.sendRedirect("index.jsp?MAIN=user/cart.jsp");
		}
	}

}
