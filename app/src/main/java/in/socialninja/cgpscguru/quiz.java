package in.socialninja.cgpscguru;

public class quiz {
    private  String Qhead;
    private  int NoQ;


    public quiz() {

    }

    public quiz(String qhead,int noQ) {
        Qhead = qhead;
        NoQ = noQ;

    }



    public String getQhead() {
        return Qhead;
    }

    public void setQhead(String qhead) {
        Qhead = qhead;
    }

    public int getNoQ() {
        return NoQ;
    }

    public void setNoQ(int noQ) {
        NoQ = noQ;
    }
}
