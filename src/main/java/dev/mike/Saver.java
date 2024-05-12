package dev.mike;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Saver {

    /**
     * Saves all tasks or todos to a file
     * @param allTasks containing all the todos a user has created
     */
    public static void saveTasks(List<Task> allTasks){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objects.ser"))){
            oos.writeObject(allTasks);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
