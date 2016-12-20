package graphique;

import javax.swing.*;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mvincent on 19/12/16.
 */
public class resManager {
    public Map<String, ImageIcon> mapResources = new HashMap<String, ImageIcon>();
    private static resManager ourInstance = new resManager();

    public static resManager getInstance() {
        //loadResources(pathname);
        return ourInstance;
    }

    private resManager() {

    }
    public void loadResources(String pathToResources){
        File folder = new File(pathToResources);

        for (File fileEntry : folder.listFiles()){
            if(!fileEntry.isDirectory()){
                String pathfile = "res"+File.separator+"pictogrammes"+File.separator+fileEntry.getName();
                ImageIcon icon = new ImageIcon(pathfile);
                mapResources.put(fileEntry.getName().replaceFirst("[.][^.]+$", ""), icon);
            }
        }
    }

    public void parseMap(){
        for(Map.Entry<String, ImageIcon> entry : mapResources.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}