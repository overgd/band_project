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

		if(list != null) { //��ٱ��ϰ� �������������,
			
			listsize = list.size(); //��ٱ��Ͽ� �󸶳� ����ִ��� Ȯ��
			
			for(int cnt = 0; cnt < listsize; cnt++) { //��ٱ��� ũ�⸸ŭ for
				
				Cart cart = list.get(cnt); //��ٱ����� �������� ������
				
				aid = cart.getAlbum().getAlbum_id(); //��ٱ����� �ٹ����̵� üũ
				
				if(Integer.parseInt(album_id) == aid) { //�ߺ��� ������ ����
					System.out.println("��ٱ��Ͽ� �ߺ��� ������ ���� ���"+cnt);
					cart.setNumber(cart.getNumber()+1); //�ߺ��� �������� ������ 1����
					list.set(cnt, cart); //�ٽ� ����
					cartre = true;
					break;
					
				}else if(Integer.parseInt(album_id) != aid){ //�ߺ��� ������ �ƴϸ� ��� ����
					
				}
				
			}
			//��ٱ����� ũ�⸸ŭ �ݺ��ϰ� �������� ������ ����.
			if(cartre == false) {
				Cart scart = new Cart();
				System.out.println("��ٱ��Ͽ� �ٸ� ������ �ִ� ���");
				Album album = crud.selectOneAlbumInfo(album_id);
				scart.setAlbum(album);
				scart.setNumber(1);
				list.add(scart);
			}
			
		}else { //��ٱ��ϰ� ���������
			
			System.out.println("��ٱ��Ͽ� �ƹ��͵� ���� ���");
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
