package dev.mike;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages tasks or todos
 */
public class TaskManager {

    private static List<Task> manager;

    public TaskManager(){
        manager = Loader.loadTasks();
        if (manager == null){
            manager = new ArrayList<>();
        }
    }

    /**
     * Adds a task to the manager
     * @param t task
     * @return if the task has been successfully added
     */
    public boolean addTask(Task t){
        boolean added = false;
        if (t != null) {
            manager.add(t);
            added = true;
        }
        return added;
    }

    /**
     * Deletes a task by index from the manager
     * @param index of task
     * @return if task has been deleted
     */
    public boolean deleteTask(int index){
        boolean deleted = false;
        if (indexInRange(index)){
            manager.remove(index);
            deleted = true;
        }
        return deleted;
    }

    /**
     * Prints the list of tasks
     */
    public void printTasks(){
        if (manager.isEmpty()){
            System.out.println("No Tasks Found\n");
        }
        else{
            for (int i = 0; i < manager.size(); i++){
                System.out.println("#" + i + ". " + manager.get(i).toString());
            }
            System.out.print("\n");
        }
    }


    /**
     * Saves the list of tasks to the file
     */
    public void saveTasksToFile(){
        Saver.saveTasks(manager);
    }

    /**
     * Marks the task as completed
     * @param index of task
     * @return if task has been marked
     */
    public boolean markTaskAsCompleted(int index){
        if (indexInRange(index)){
            manager.get(index).setCompleted();
            return true;
        }

        return false;
    }

    /**
     * Marks the task as favorite
     * @param index of task
     * @return if task has been marked
     */
    public boolean markTaskAsFavorite(int index){
        if (indexInRange(index)){
            manager.get(index).setFavorite();
            return true;
        }

        return false;
    }

    /**
     * Edits the title of a task
     * @param newTitle of the task
     * @param index of task
     * @return if the title has been edited
     */
    public boolean editTaskTitle(String newTitle, int index){
        if (indexInRange(index)){
            manager.get(index).setTitle(newTitle);
            return true;
        }

        return false;
    }

    /**
     * Edits the description  of a task
     * @param newDescription of the task
     * @param index of task
     * @return if the description has been edited
     */
    public boolean editTaskDescription(String newDescription, int index){
        if (indexInRange(index)){
            manager.get(index).setDescription(newDescription);
            return true;
        }

        return false;
    }

    /**
     * Checks if the index given is in range of the list
     * @param index to check
     * @return if index is in range
     */
    public boolean indexInRange(int index){
        return index >= 0 && index < manager.size();
    }

}
