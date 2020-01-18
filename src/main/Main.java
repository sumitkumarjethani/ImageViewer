package main;

import controller.ExitCommand;
import controller.NextCommand;
import controller.PrevCommand;
import model.Image;
import files.FileImageLoader;
import persistence.ImageLoader;
import presenter.ImagePresenter;
import view.ImageDisplay;
import view.MainFrame;
import view.SwingImageDisplay;
import java.io.File;

public class Main {
    
    public static void main(String args[]){
        //Model
        ImageLoader imageLoader = new FileImageLoader(new File("fotos"));
        Image image = imageLoader.load();
        //View
        ImageDisplay swingImageDisplay = new SwingImageDisplay();
        MainFrame mainFrame = new MainFrame();
        mainFrame.addSwingImageDisplay((SwingImageDisplay)swingImageDisplay);
        //Presenter
        ImagePresenter imagePresenter = new ImagePresenter(image,swingImageDisplay);
        //Controller
        mainFrame.addCommand("Prev", new PrevCommand(imagePresenter));
        mainFrame.addCommand("Next", new NextCommand(imagePresenter));
        mainFrame.addCommand("Exit", new ExitCommand());
        mainFrame.execute();
    }
}
