

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	@Resource(name = "jdbc/student_tracker")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		////
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		////
	

		try {
			//
			connection=miConexion.getConnection();
			

			String consulta = "SELECT * FROM usuario;";
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				result=statement.executeQuery();
				
				while(result.next()){
					
					String datos=result.getInt("documento")+" - "+result.getString("nombre");
					out.println(datos);
					System.out.println(datos);
				}		
				   miConexion.desconectar();
			}
		
			
			//
			

		} catch (Exception exc) {
			exc.printStackTrace();
			out.println(exc.getMessage());
		}
	}

}
