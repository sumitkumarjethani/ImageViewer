package view;

public interface ImageDisplay {
    public void display(String name, byte[] data);
    public void addListener(ImageDisplay.Listener listener);
    
    public interface Listener{
        public void changeImage(boolean click);
    }
}
