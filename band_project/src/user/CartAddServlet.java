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
		
		boolean cartre = false;
		
		ArrayList<Cart> list = (ArrayList<Cart>)session.getAttribute("CP");

		if(list != null) { //장바구니가 비어있지않으면,
			
			listsize = list.size(); //장바구니에 얼마나 들어있는지 확인
			
			for(int cnt = 0; cnt < listsize; cnt++) { //장바구니 크기만큼 for
				
				Cart cart = list.get(cnt); //장바구니의 아이템을 가져옴
				
				aid = cart.getAlbum().getAlbum_id(); //장바구니의 앨범아이디 체크
				
				if(Integer.parseInt(album_id) == aid) { //중복된 물건이 있음
					System.out.println("장바구니에 중복된 물건이 있을 경우"+cnt);
					cart.setNumber(cart.getNumber()+1); //중복된 아이템의 갯수를 1증가
					list.set(cnt, cart); //다시 넣음
					cartre = true;
					break;
					
				}else if(Integer.parseInt(album_id) != aid){ //중복된 물건이 아니면 계속 증가
					
				}
				
			}
			//장바구니의 크기만큼 반복하고 나왔지만 물건이 없다.
			if(cartre == false) {
				Cart scart = new Cart();
				System.out.println("장바구니에 다른 물건이 있는 경우");
				Album album = crud.selectOneAlbumInfo(album_id);
				scart.setAlbum(album);
				scart.setNumber(1);
				list.add(scart);
			}
			
		}else { //장바구니가 비어있으면
			
			System.out.println("장바구니에 아무것도 없는 경우");
			Cart cart = new Cart();
			Album album = crud.selectOneAlbumInfo(album_id);
			cart.setAlbum(album);
			cart.setNumber(1);
			list = new ArrayList<Cart>();
			list.add(0, cart);
			
		}
		
		
		session.setAttribute("CP", list);
		
		if(move.equals("no")) {
			response.sendRedirect("index.jsp?MAIN=albumlist.do?BID="+BID);
		}else if(move.equals("yes")) {
			response.sendRedirect("index.jsp?MAIN=user/cart.jsp");
		}
	}

}
