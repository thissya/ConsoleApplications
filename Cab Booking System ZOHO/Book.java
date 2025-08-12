public class Book {
    private int  bookingId;
    private String customerName;
    private int cusId;
    private char source;
    private char destination;
    private int cabId;
    private int amount;
    private double zulaCommision;
    private static int bookCount= 0;


    public Book(String customerName,int cusId,char source,char destination,int cabId,int amount,double zulaCommision){
        this.bookingId = ++bookCount;
        this.customerName=customerName;
        this.source=source;
        this.destination=destination;
        this.cabId=cabId;
        this.amount=amount;
        this.cusId=cusId;
        this.zulaCommision=zulaCommision;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCusId() {
        return cusId;
    }

    public char getSource() {
        return source;
    }

    public char getDestination() {
        return destination;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public int getAmount() {
        return amount;
    }

    public double getZulaCommision() {
        return zulaCommision;
    }

    public int getCabId() {
        return cabId;
    }

    public String toString(){
        return customerName+"\t"+source+"\t"+destination+"\t"+cabId+"\t"+amount+"\t"+zulaCommision;
    }

}
