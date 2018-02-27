
import java.net.ConnectException;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	private String nombreBd="persona";
	private String usuario="root";
	private String password="";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd;

	Connection conn=null;
	//constructor de la clase
	public Conexion(){
		try {
			//obtener el driver
			Class.forName("com.mysql.jdbc.Driver");
			//obtener la conexion
			conn=DriverManager.getConnection(url,usuario,password);
			if (conn!=null) {
				System.out.println("Conexion Exitosa  a la BD: "+nombreBd);
			}else{
				System.out.println("******************NO SE PUDO CONECTAR "+nombreBd);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: "+e.getMessage());
			JOptionPane.showMessageDialog(null, "VERFIQUE QUE MYSQL ESTE INICIADO");
		}
	}
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
}

