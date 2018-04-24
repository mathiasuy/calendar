package grupouno.dto;

import java.util.Date;

public class Usuario {

	private String usuarioID;
	private String contrasena;
	private Date fecha_de_registro;
	
    private static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }	
	
	
    /**
     * Encripta la pass para la bd
     */
    private static String SHA1(String pass){
    	return getHash(pass, "SHA1");
    }

	public Usuario(String usuarioID, String contrasena, Date fecha_de_registro) {
		super();
		this.usuarioID = usuarioID;
		this.contrasena = SHA1(contrasena);
		this.fecha_de_registro = fecha_de_registro;
	}

	public String getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = SHA1(contrasena);
	}

	public Date getFecha_de_registro() {
		return fecha_de_registro;
	}

	public void setFecha_de_registro(Date fecha_de_registro) {
		this.fecha_de_registro = fecha_de_registro;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioID=" + usuarioID + ", contrasena=" + contrasena + ", fecha_de_registro="
				+ fecha_de_registro + "]";
	}
    
    
}
