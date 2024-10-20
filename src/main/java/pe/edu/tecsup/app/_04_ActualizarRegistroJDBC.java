package pe.edu.tecsup.app;

import static pe.edu.tecsup.app.Parametros.PASSWORD;
import static pe.edu.tecsup.app.Parametros.URL;
import static pe.edu.tecsup.app.Parametros.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _04_ActualizarRegistroJDBC {

	public static void main(String[] args) {

		try {

			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Preparar la sentencia SQL
			String sql = "UPDATE categorias SET nombre=? WHERE id=?";

			PreparedStatement stmt = con.prepareStatement(sql);
			int id = 12; // PK del registro que se va a cambiar

			// Configura el PK del registro a eliminar
			// Cambia los valores de los signos de interrogación : ?
			stmt.setString(1, "Portatiles Cambiado");
			stmt.setInt(2, id);

			// Ejecutar la actualizacion
			int estado = stmt.executeUpdate();
			System.out.println(estado);

			// Verificar el cambio
			if (estado != 1)
				throw new SQLException("No se pudo actualizar correctamente");

			System.out.printf("Se actualiza la categoria con id = %d \n", id);

			// Cerrar conexiones
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			// System.err.println(e.getMessage());
		}
	}

}
