package console;

import java.util.ArrayList;
import java.util.List;
import view.ImageDisplay;

public class ConsoleImageDisplay implements ImageDisplay {

    private byte[] data;
    private String name;
    private final List<ImageDisplay.Listener> listeners = new ArrayList<>();
    
    @Override
    public void display(String name, byte[] data) {
        this.name = name;
        this.data = data;
        System.out.println("Image name: " + this.name);
        System.out.println("Image size: " + this.data.length);
    }

    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }
}
