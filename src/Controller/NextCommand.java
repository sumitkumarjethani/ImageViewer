package Controller;

import View.ImageDisplay;

public class NextCommand implements Command{

    private ImageDisplay imageDisplay;

    public NextCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.current().getNext());
    }
    
}
