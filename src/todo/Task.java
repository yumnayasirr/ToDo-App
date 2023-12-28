
package todo;


public class Task {
       private String description;
    private boolean completed;

    public Task() {
    }
     
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
       @Override
    public String toString(){
        return String.format("%s,%b%n",description, completed);
    }
}
