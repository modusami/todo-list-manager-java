package dev.mike;

import java.io.Serializable;

/**
 * Represents a single todo
 */
public class Task implements Serializable {
    private String title;
    private String description;
    private boolean isCompleted;
    private boolean isFavorite;

    /**
     * Constructs a Task Object
     * @param t title
     * @param d description
     */
    public Task(String t, String d){
        title = t;
        description = d;
        isCompleted = false; // task being created cannot be true at creation time
        isFavorite = false; // leave the task to be a favorite after completion
    }

    /**
     * Default constructor
     */
    public Task(){
        title = "Empty Todo";
        description = "";
        isCompleted = false;
        isFavorite = false;
    }

    // Setters & Getters


    /**
     * Sets the title var
     * @param title of todo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the description var
     * @param description of todo
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the completed var
     */
    public void setCompleted() {
        isCompleted = !isCompleted;
    }

    /**
     * Sets the favorite var
     */
    public void setFavorite() {
        isFavorite = !isFavorite;
    }

    /**
     * Gets the title
     * @return the title of the todo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description
     * @return the description of the todo
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the favorite status
     * @return the favorite status
     */
    public boolean isFavorite() {
        return isFavorite;
    }

    /**
     * Gets the completed status
     * @return the completed status
     */
    public boolean isCompleted() {
        return isCompleted;
    }


    /**
     * An Equals Method
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this == obj){
            return true;
        }
        if (this.getClass() == obj.getClass()){
            Task temp = (Task) obj;
            return this.title.equals(temp.getTitle()) && this.description.equals(temp.getDescription())
                    && this.isFavorite == temp.isFavorite()
                    && this.isCompleted == temp.isCompleted();
        }

        return false;
    }

    /**
     * To String method
     * @return string version of class
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Task: ").append(title);
        if (isFavorite){
            str.append(" ⭐");
        }
        str.append("\nDescription: ").append(description).append("\n");
        if (isCompleted){
            str.append("Status Of Completion:").append(" ✅");
        }
        else{
            str.append("Status Of Completion:").append(" ❌");
        }
        str.append("\n");
        return str.toString();
    }

}
