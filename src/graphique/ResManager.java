package graphique;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mvincent on 19/12/16.
 */
public class ResManager {
    public Map<String, BufferedImage> getMapResources() {
        return mapResources;
    }

    private Map<String, BufferedImage> mapResources = new HashMap<String, BufferedImage>();
    private static ResManager ourInstance = new ResManager();

    public static ResManager getInstance() {
        //loadResources(pathname);
        return ourInstance;
    }

    private ResManager() {

    }
    public void loadResources(String pathToResources) throws IOException {
        File folder = new File(pathToResources);
        for (File fileEntry : folder.listFiles()){
            if(!fileEntry.isDirectory()){
                String pathfile = "res"+File.separator+"pictogrammes"+File.separator+fileEntry.getName();
                File img = new File(pathfile);
                BufferedImage image = new BufferedImage(ImageIO.read(img).getWidth(), ImageIO.read(img).getHeight(), BufferedImage.TYPE_INT_ARGB);
                image = ImageIO.read(img);
                mapResources.put(fileEntry.getName().replaceFirst("[.][^.]+$", ""), image);
            }
        }
    }

    public void parseMap(){
        for(Map.Entry<String, BufferedImage> entry : mapResources.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public BufferedImage getIcon(String Key){
        return mapResources.get(Key);
    }
}