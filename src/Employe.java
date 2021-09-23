public class Employe extends Thread{
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    Agenda agenda = new Agenda();
    public void run(){
        for (int i=0;i<11;i++){
            if (i%2!=0){
            System.out.println(i+" "+fname);
            agenda.createTask("Taches N "+i, i+1, true);
            }else {
                agenda.createTask("Taches N "+i, i+1, true);
            }
        }
    }



    public String fname;


}
