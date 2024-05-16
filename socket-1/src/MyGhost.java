import java.io.Serializable;

public class MyGhost implements Serializable {
    private String from;
    private String to;
    private String ghostType;

    public MyGhost(String from, String to, String ghostType) {
        this.from = from;
        this.to = to;
        this.ghostType = ghostType;
    }

    public void printGhoastInfo() {
        System.out.println("From: " + from + ", To: " + to + ", Ghost Type: " + ghostType);
    }

    public void changeGhoastType(String newType) {
        this.ghostType = newType;
    }

    public void swapFromTo() {
        String temp = this.from;
        this.from = this.to;
        this.to = temp;
    }

    // Getters and setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getGhostType() {
        return ghostType;
    }

    public void setGhostType(String ghostType) {
        this.ghostType = ghostType;
    }
}
