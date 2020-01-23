package main;

import architecture.controller.ExitCommand;
import architecture.controller.NextCommand;
import architecture.controller.PrevCommand;
import architecture.model.Image;
import files.FileImageLoader;
import architecture.view.persistence.ImageLoader;
import architecture.presenter.ImagePresenter;
import architecture.view.ImageDisplay;
import swing.SwingImageDisplay;
import java.io.File;

public class Main {
    
    public static void main(String args[]){
        //Model
        ImageLoader imageLoader = new FileImageLoader(new File("fotos"));
        Image image = imageLoader.load();
        //View
        ImageDisplay imageDisplay = new SwingImageDisplay();
        MainFrame mainFrame = new MainFrame();
        mainFrame.addSwingImageDisplay((SwingImageDisplay)imageDisplay);
        //Presenter
        ImagePresenter imagePresenter = new ImagePresenter(image,imageDisplay);
        //Controller
        mainFrame.addCommand("Prev", new PrevCommand(imagePresenter));
        mainFrame.addCommand("Next", new NextCommand(imagePresenter));
        mainFrame.addCommand("Exit", new ExitCommand());
        mainFrame.execute();
    }
}
