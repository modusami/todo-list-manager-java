package dev.mike;

import java.util.Scanner;

public class TaskMenu {

    private final String[] menuListItems = new String[]{"Add Task", "Delete Task", "Toggle Task As Completed", "Toggle Task As Favorite", "Edit Title Of Task", "Edit Description Of Task", "View all Tasks", "Exit"};
    private static final TaskManager manager = new TaskManager();
    private static final Scanner scanner = new Scanner(System.in);

    public void runMenu(){
        displayMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleChoice(choice);
    }

    private void handleChoice(int choice){
        switch(choice){
            case 1:
                addTask();
                break;
            case 2:
                deleteTask();
                break;
            case 3:
                markTaskAsCompleted();
                break;
            case 4:
                markTaskAsFavorite();
                break;
            case 5:
                editTaskTitle();
                break;
            case 6:
                editTaskDescription();
                break;
            case 7:
                viewAllTasks();
                break;
            case 8:
                exitProgram();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Adds a task to the manager
     */
    private void addTask(){
        toConsole("Enter task title: ", false);
        String title = scanner.nextLine();
        toConsole("Enter task description: ", false);
        String desc = scanner.nextLine();
        Task task = new Task(title, desc);
        boolean added = manager.addTask(task);
        if (added){
            toConsole("Task Added Successfully", true);
        }
        else{
            toConsole("Failed to add task...", false);
        }
    }

    /**
     * Deletes a task from the manager
     */
    private void deleteTask(){
        manager.printTasks();
        toConsole("Enter the index of task to delete: ", false);
        int index = scanner.nextInt();
        scanner.nextLine();
        boolean deleted = manager.deleteTask(index);
        if (deleted){
            toConsole("Task Deleted Successfully", true);
        }
        else{
            toConsole("Invalid Task Index", true);
        }
    }

    /**
     * Marks a task as completed
     */
    private void markTaskAsCompleted(){
        manager.printTasks();
        toConsole("Enter the index of the task to toggle as completed: ", false);
        int index = scanner.nextInt();
        scanner.nextLine();
        boolean marked = manager.markTaskAsCompleted(index);
        if (marked){
            toConsole("Success", true);
        }
        else{
            toConsole("Invalid task index", true);
        }
    }

    /**
     * Marks a task as favorite
     */
    private void markTaskAsFavorite(){
        manager.printTasks();
        toConsole("Enter the index of the task to toggle as favorite: ", false);
        int index = scanner.nextInt();
        scanner.nextLine();
        boolean marked = manager.markTaskAsFavorite(index);
        if (marked){
            toConsole("Success", true);
        }
        else{
            toConsole("Invalid task index", true);
        }
    }

    /**
     * Edits the title of a task
     */
    private void editTaskTitle(){
        manager.printTasks();
        toConsole("Enter the index of the task to edit: ", false);
        int index = scanner.nextInt();
        scanner.nextLine();
        toConsole("Enter task title: ", false);
        String title = scanner.nextLine();
        boolean edited = manager.editTaskTitle(title, index);
        if (edited){
            toConsole("Title edited Successfully.", true);
        }
        else{
            toConsole("Invalid task index", true);
        }

    }

    /**
     * Edits the description of a task
     */
    private void editTaskDescription(){
        manager.printTasks();
        toConsole("Enter the index of the task to edit: ", false);
        int index = scanner.nextInt();
        scanner.nextLine();
        toConsole("Enter task description: ", false);
        String desc = scanner.nextLine();
        boolean edited = manager.editTaskDescription(desc, index);
        if (edited){
            toConsole("Description edited Successfully.", true);
        }
        else{
            toConsole("Invalid task index", true);
        }

    }

    /**
     * Prints all tasks
     */
    private void viewAllTasks() {
        toConsole(" ----Viewing All Tasks ----", true);
        manager.printTasks();
    }

    private void exitProgram(){
        manager.saveTasksToFile();
        toConsole("Exiting program. Goodbye.", true);
        System.exit(0);
    }

    /**
     * Displays the menu
     */
    private void displayMenu(){
        int len = menuListItems.length;
        for (int i = 0; i < len; i++){
            System.out.println((i+1) + ". " + menuListItems[i] + ".");
        }
    }


    /**
     * Utility printing method
     * @param value to print
     * @param newLine to add if true
     */
    private <T> void toConsole(T value, boolean newLine){
        if (newLine){
            System.out.println(value);
        }
        else{
            System.out.print(value);
        }

    }

}
