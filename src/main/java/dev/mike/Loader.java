package dev.mike;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Loader {

    /**
     * Loads the tasks from the file
     */
    @SuppressWarnings("unchecked")
    public static List<Task> loadTasks(){
        List<Task> loadedTasks = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objects.ser"))){
            loadedTasks = (List<Task>) ois.readObject();
        }
        catch(Exception e){
            return null;
        }

        return loadedTasks;
    }


}
