import javax.faces.bean.ManagedBean;

@ManagedBean
public class Saludo {
	
	private String nombre;
	private String saludo;
	
	public String getMensaje(){
		return "Ingrese su nombre";
	}
	
	public void saludar(){
		String mensaje="Hola "+getNombre()+" Bienvenido al Sistema";
		
		setSaludo(mensaje);		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
}
