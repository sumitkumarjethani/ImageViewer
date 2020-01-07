package Main;

import Controller.CutCommand;
import Controller.ExitCommand;
import Controller.NextCommand;
import Controller.PrevCommand;
import Model.Persistence.File.FileImageLoader;
import Model.Persistence.ImageLoader;
import View.ImageDisplay;
import View.MainFrame;
import View.SwingImageDisplay;
import java.io.File;

public class Main {
    
    public static void main(String args[]){
        ImageLoader imageLoader = new FileImageLoader(new File("fotos"));
        ImageDisplay swingImageDisplay = new SwingImageDisplay();
        swingImageDisplay.display(imageLoader.load());
        MainFrame mainFrame = new MainFrame();
        mainFrame.addSwingImageDisplay((SwingImageDisplay)swingImageDisplay);
        mainFrame.addCommand("Next", new NextCommand(swingImageDisplay));
        mainFrame.addCommand("Prev", new PrevCommand(swingImageDisplay));
        mainFrame.addCommand("Cut", new CutCommand(swingImageDisplay));
        mainFrame.addCommand("Exit", new ExitCommand());
        mainFrame.execute();
    }
}
