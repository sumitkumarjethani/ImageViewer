package View;

import Model.Image;

public interface ImageDisplay {
    public Image current();
    public void display(Image image);
}
