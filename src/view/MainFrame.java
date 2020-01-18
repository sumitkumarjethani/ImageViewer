package view;

import controller.Command;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private final Map<String,Command> commands;
    private final Map<String,String> labels;
    
    public MainFrame(){
        setTitle("Image Viewer");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        commands = new HashMap();
        labels = new HashMap();
        initLabels();
        this.add(toolbar(),BorderLayout.SOUTH);
    }

    private void initLabels() {
        labels.put("Prev", "<");
        labels.put("Next", ">");
        labels.put("Exit", "Exit");
    }

    private JPanel toolbar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button("Prev"));
        panel.add(button("Next"));
        panel.add(button("Exit"));
        return panel;
    }

    private JButton button(String name) {
        JButton button = new JButton(labels.get(name));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(name).execute();
            }
        });
        return button;
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
    public void addCommand(String name ,Command command){
        commands.put(name, command);
    }
    
    public void addSwingImageDisplay(SwingImageDisplay swingImageDisplay){
        this.add(swingImageDisplay,BorderLayout.CENTER);
    }
    
}
