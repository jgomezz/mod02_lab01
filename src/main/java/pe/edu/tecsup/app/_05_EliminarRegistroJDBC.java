package pe.edu.tecsup.app;

import static pe.edu.tecsup.app.Parametros.PASSWORD;
import static pe.edu.tecsup.app.Parametros.URL;
import static pe.edu.tecsup.app.Parametros.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _05_EliminarRegistroJDBC {

	public static void main(String[] args) {

		try {

			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Preparar la sentencia SQL
			String sql = "DELETE FROM categorias WHERE id = ?";

			//
			PreparedStatement stmt = con.prepareStatement(sql);

			// Configura el PK del registro a eliminar
			int id = 12; // Id de la categoria a eliminar
			stmt.setInt(1, id); // EL registro con ID igual a 7 existe

			// Ejecutar la insercion
			int estado = stmt.executeUpdate();

			if (estado != 1)
				throw new SQLException("No se pudo eliminar");

			System.out.printf("Se elimino la categoria con id = %d \n", id);

			// Cerrar conexiones
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			// System.err.println(e.getMessage());
		}
	}

}
