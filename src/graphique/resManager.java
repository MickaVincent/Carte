package graphique;

import javax.swing.*;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by mvincent on 19/12/16.
 */
public class resManager {
    private Map<String, ImageIcon> mapResources = new Map<String, ImageIcon>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public ImageIcon get(Object key) {
            return null;
        }

        @Override
        public ImageIcon put(String key, ImageIcon value) {
            return null;
        }

        @Override
        public ImageIcon remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends ImageIcon> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<ImageIcon> values() {
            return null;
        }

        @Override
        public Set<Entry<String, ImageIcon>> entrySet() {
            return null;
        }
    };
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
                String pathfile = "res/" +fileEntry.getName().replaceFirst("[.][^.]+$", "");
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