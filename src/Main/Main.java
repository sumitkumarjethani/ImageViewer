package Main;

import Model.Persistence.File.FileImageLoader;
import Model.Persistence.ImageLoader;
import View.ConsoleImageDisplay;
import View.ImageDisplay;
import java.io.File;

public class Main {
    
    public static void main(String args[]){
        
        ImageLoader imageLoader = new FileImageLoader(new File("fotos"));
        ImageDisplay consoleImageDisplay = new ConsoleImageDisplay();
        consoleImageDisplay.display(imageLoader.load());
        consoleImageDisplay.display(consoleImageDisplay.current().getNext());
        consoleImageDisplay.display(consoleImageDisplay.current().getNext());
        consoleImageDisplay.display(consoleImageDisplay.current().getNext());
        consoleImageDisplay.display(consoleImageDisplay.current().getNext());
        consoleImageDisplay.display(consoleImageDisplay.current().getNext());
        
        //FALTA IMPLEMNTACIÓN DE SWINGIMAGEDISPLAY
    }
}
