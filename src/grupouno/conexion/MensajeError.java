package grupouno.conexion;

public class MensajeError extends Exception {

	private static final long serialVersionUID = 1L;

	public MensajeError() {
    }

    public MensajeError(String string) {
        super(string);
    }
}
