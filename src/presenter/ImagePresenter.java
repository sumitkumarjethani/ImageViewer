package presenter;

import model.Image;
import view.ImageDisplay;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ImageDisplay.Listener;

public class ImagePresenter{

    private Image image;
    private final ImageDisplay imageDisplay;
    
    
    public ImagePresenter(Image img, ImageDisplay imageDisplay){
        this.image = img;
        this.imageDisplay = imageDisplay;
        this.update();
        this.imageDisplay.addListener(new Listener() {
            @Override
            public void changeImage(boolean click) {
                if(click){
                    image = image.getNext();
                }else{
                    image = image.getPrev();
                }
                update();
            }
        });
    }
    
    public Image currentImage(){
        return this.image;
    }
    
    public void setCurrentImage(Image image){
        this.image = image;
        this.update();
    }
    
    public ImageDisplay getImageDisplay(){
        return this.imageDisplay;
    }
    
    private void update(){
        try {
            this.imageDisplay.display(this.image.getName(), this.image.getData());
        } catch (IOException ex) {
            Logger.getLogger(ImagePresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
