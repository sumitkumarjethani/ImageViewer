package View;

import Model.Image;
import java.io.IOException;

public class ConsoleImageDisplay implements ImageDisplay {

    private Image image;
    
    @Override
    public Image current() {
        return image;
    }

    @Override
    public void display(Image image) {
        try {
            this.image = image;
            System.out.println("Image name: " + image.getName());
            System.out.println("Image size: " + image.getData().length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
