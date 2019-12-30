package Controller;

import View.ImageDisplay;

public class PrevCommand implements Command{
    
    private ImageDisplay imageDisplay;

    public PrevCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.current().getPrev());
    }
    
}
