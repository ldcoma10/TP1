package conexionServidor;

import java.io.IOException;

public class LauncherServidor {

	public static void main(String[] args) throws IOException {
		ConexionServidor s=new ConexionServidor();
		s.conectar();

	}

}
