package interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;

public class Gui_hola {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Gui_hola window = new Gui_hola();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Configuración Servidor");
		shell.setLayout(null);
		
		Label lblPuerto = new Label(shell, SWT.NONE);
		lblPuerto.setBounds(10, 41, 55, 15);
		lblPuerto.setText("Puerto");
		
		Label lblDuracin = new Label(shell, SWT.NONE);
		lblDuracin.setBounds(10, 89, 55, 15);
		lblDuracin.setText("Duraci\u00F3n");
		
		Button btnAceptar = new Button(shell, SWT.NONE);
		btnAceptar.setBounds(79, 138, 75, 25);
		btnAceptar.setText("Aceptar");
		
		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(78, 38, 76, 22);
		
		Spinner spinner_1 = new Spinner(shell, SWT.BORDER);
		spinner_1.setBounds(78, 86, 76, 22);
		
		Label lblMin = new Label(shell, SWT.NONE);
		lblMin.setBounds(160, 89, 55, 15);
		lblMin.setText("min");

	}
}
