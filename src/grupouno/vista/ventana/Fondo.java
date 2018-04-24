package grupouno.vista.ventana;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class Fondo implements Border{
	
    public BufferedImage back;
    public Fondo() throws MalformedURLException, IOException{
        try {
            URL imagePatch = new URL(getClass().getResource("/grupouno/utils/fondo.jpg").toString());
            back = ImageIO.read(imagePatch);
        } catch (Error e) {
            throw new Error("No se ha podido cargar la imágen de fondo");
        }
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    	 g.drawImage(back, 0, 0, width, height, null);
    }

    @Override
    public Insets getBorderInsets(Component cmpnt) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

}
