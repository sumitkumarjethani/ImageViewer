package view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay{
    
    private byte[] data;
    private String name;
    private boolean pressed = false;
    private final List<ImageDisplay.Listener> listeners = new ArrayList<>();
    
    public SwingImageDisplay(){
        this.addMouseListener(mouseListener());
    }
    
    @Override
    public void display(String name, byte[] data) {
        this.name = name;
        this.data = data;
        System.out.println(this.name);
        this.repaint();
    }
    
    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        try {
            g.drawImage(awtImage(), 0, 0, this.getWidth(), this.getHeight(),null);
        } catch (IOException ex) {
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private java.awt.Image awtImage() throws IOException {
        return ImageIO.read(new ByteArrayInputStream(this.data));
    }    

    private MouseListener mouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for (Listener listener : listeners) {
                    listener.changeImage(checkClickPosition(me.getX()));
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                pressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        };
    }
    
    private boolean checkClickPosition(int x){
        if(x > this.getWidth()/2) return true;
        return false;
    }
}
