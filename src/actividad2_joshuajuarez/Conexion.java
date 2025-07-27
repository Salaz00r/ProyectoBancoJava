import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

/**
 *
 * @author josua
 */
public class Conexion {

    public Connection getConnection() {
        Connection con = null;
        
        String url = "jdbc:sqlserver://localhost:1433;databaseName=cajeroBD;encrypt=false;trustServerCertificate=true;";
     
        try {
            // Cargar el driver JDBC de SQL Server.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establecer la conexión
            con = DriverManager.getConnection(url);
            System.out.println("Conexión exitosa a la base de datos SQL Server.");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver JDBC de SQL Server no encontrado. Asegúrate de haberlo agregado a las librerías de tu proyecto.");
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos SQL Server:");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Mensaje: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza completa para depuración
        }
        return con;
    }

  
    public static void main(String[] args) {
        Conexion testConexion = new Conexion();
        Connection connection = testConexion.getConnection();
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión de prueba cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión de prueba: " + e.getMessage());
            }
        }
    }
}