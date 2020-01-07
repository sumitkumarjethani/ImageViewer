package Controller;

import View.ImageDisplay;

//FALTA TODAVIA IMPLEMENTACION

public class CutCommand implements Command{

    private ImageDisplay imageDisplay;
    
    public CutCommand(ImageDisplay imageDisplay){
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        
    }
    
}
