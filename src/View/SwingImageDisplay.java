package View;

import Model.Image;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay{
    
    private Image image;

    @Override
    public Image current() {
        return this.image;
    }

    @Override
    public void display(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        try {
            g.drawImage(awtImage(), 250, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private java.awt.Image awtImage() throws IOException {
        return ImageIO.read(new ByteArrayInputStream(this.image.getData()));
    }
    
}
