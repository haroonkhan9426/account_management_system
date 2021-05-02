package classes;

public class Transaction {
    public Float amount;
    public String date;
    public String time;

    public Transaction(Float amount, String date, String time){
        this.amount = amount;
        this.date = date;
        this.time = time;
    }
    
    public String covertToString(){
        return "Amount: " + amount + "\nDate:" + date + "\nTime: " + time;
    }
}
