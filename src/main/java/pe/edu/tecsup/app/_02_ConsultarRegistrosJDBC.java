package pe.edu.tecsup.app;

import static pe.edu.tecsup.app.Parametros.PASSWORD;
import static pe.edu.tecsup.app.Parametros.URL;
import static pe.edu.tecsup.app.Parametros.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _02_ConsultarRegistrosJDBC {

	
	/**
	 *   
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			// Conectarme a la BD
			Connection con 
				= DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// Preparar la sentencia SQL
			String sql = "SELECT id, nombre, descripcion FROM categorias WHERE id = ? AND nombre = ? ";
			
			
			PreparedStatement stmt = con.prepareStatement(sql);
			//        ( posicion del signo interrogacion, valor que quieres asignar)
			stmt.setInt(1, 1);               // posicion del 1er signo de interrogacion
			stmt.setString(2, "Procesador"); // posicion del 2do signo de interrogacion
			
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				
				String nombre = rs.getString("nombre");

				String descripcion = rs.getString("descripcion");

				System.out.printf(">>> id = %d , nombre=%s, descripcion=%s \n", id, nombre, descripcion);
				
				//System.out.println(">>> id = " + id + ", nombre=" +nombre + ", descripcion="+ descripcion );
			
			}
			
			rs.close(); 
			
			stmt.close();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}

}
