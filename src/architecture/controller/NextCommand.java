package architecture.controller;

import architecture.presenter.ImagePresenter;

public class NextCommand implements Command{

    private final ImagePresenter imagePresenter;
    
    public NextCommand(ImagePresenter imagePresenter) {
        this.imagePresenter = imagePresenter;
    }
    
    @Override
    public void execute() {
        this.imagePresenter.setCurrentImage(this.imagePresenter.currentImage().getNext());
    }
    
}
