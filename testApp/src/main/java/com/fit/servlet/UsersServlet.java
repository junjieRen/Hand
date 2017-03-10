package com.fit.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;



import com.fit.bean.Users;
import com.fit.service.UsersService;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UsersServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String path=request.getServletPath();
		if(path.equals("/login.do")){
			String u_id=request.getParameter("u_id");
			String u_pwd=request.getParameter("u_pwd");
			Users u=new Users(u_id,u_pwd);
			UsersService s=new UsersService();
			if(s.isExit(u)==true){
				response.sendRedirect("index.jsp");
			}else{
				PrintWriter out =response.getWriter();
				out.print("<script>alert('账号或密码不正确');top.location.href='login.jsp'</script>");
			}
		}
		else if(path.equals("/xiazai.do")){
			String photo = request.getParameter("photo");
			String real_path = this.getServletContext().getRealPath("photo");
			String str_file_path = real_path + photo;
			OutputStream out = null;
			FileInputStream in = null;
			byte[] b = new byte[1024];
			int i=0;
			
			while ((i = in.read(b)) > 0) {
				out.write(b, 0, i);
				}
			in.close();
			out.close();
		}
	}

}
