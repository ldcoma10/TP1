package conexionServidor;

import java.io.IOException;

/**
 * Clase que inicia la conexión con el servidor
 *
 */
public class LauncherServidor {

	public static void main(String[] args) throws IOException {
		ConexionServidor s=new ConexionServidor();
		s.conectar();

	}

}
