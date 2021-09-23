import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isEffectue() {
        return effectue;
    }

    public void setEffectue(boolean effectue) {
        this.effectue = effectue;
    }

    private String libele;

    public Task(String libele, int priorite, boolean effectue) {
        this.libele = libele;
        this.priorite = priorite;
        this.dateTime = new Date();
        this.effectue = effectue;
    }

    private int priorite;
    private Date dateTime;
    private boolean effectue;


}
