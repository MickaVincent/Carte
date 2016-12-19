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
    public Map<String, ImageIcon> mapResources = new HashMap<>();
    private static resManager ourInstance = new resManager();

    public static resManager getInstance() {
        return ourInstance;
    }

    public resManager() {

    }
    public void loadResources(String pathToResources){
        File folder = new File(pathToResources);

        for (File fileEntry : folder.listFiles()){
            if(fileEntry.isDirectory()){

            }else{
                System.out.println(fileEntry.getName().replaceFirst("[.][^.]+$", ""));
                String pathfile = "res"+File.separator+fileEntry.getName().replaceFirst("[.][^.]+$", "");
                ImageIcon icon = new ImageIcon(pathfile);
                System.out.println("Vars created");
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