package architecture.controller;

import architecture.presenter.ImagePresenter;

public class PrevCommand implements Command{
    
    private final ImagePresenter imagePresenter;

    public PrevCommand(ImagePresenter imagePresenter) {
        this.imagePresenter = imagePresenter;
    }
    
    @Override
    public void execute() {
        this.imagePresenter.setCurrentImage(this.imagePresenter.currentImage().getPrev());
    }
    
}
