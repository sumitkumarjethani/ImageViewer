package files;

import model.Image;
import persistence.ImageLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class FileImageLoader implements ImageLoader {
    private final File[] files;
    
    public FileImageLoader(File root){
        files = root.listFiles(imageType());
    }
    
    
    @Override
    public Image load() {
        return imageAt(0);
    }

    private FileFilter imageType(){
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.getName().endsWith(".png") || pathname.getName().endsWith(".jpg"));
            }
        };
    }
    
    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String getName() {
                return files[i].getName();
            }

            @Override
            public byte[] getData() throws IOException {
                return dataOf(file());
            }
            
            private File file(){
                return files[(i+files.length)%files.length];
            }
            
            private byte[] dataOf(File file) throws IOException {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                try(BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
                    BufferedOutputStream os = new BufferedOutputStream(result)) {
                    while(true){
                        int read = is.read(buffer);
                        if(read < 0) break;
                        os.write(buffer, 0, read);
                    }
                    os.flush();
                }
                return result.toByteArray();
            }

            @Override
            public Image getPrev() {
                return imageAt((i-1+files.length)%files.length);
            }

            @Override
            public Image getNext() {
                return imageAt((i+1)%files.length);
            }
        };
    }
}
