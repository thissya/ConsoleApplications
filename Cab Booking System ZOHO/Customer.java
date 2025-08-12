import  java.util.*;

public class Customer {
    private int cusId;
    private String cusName;
    private String password;
    private int age;
    private char gender;
    private List<Book>  travelDetails;
    private static int count=0;

    public Customer(String cusName,String password,int age,char gender){
        this.cusId = ++count;
        this.age=age;
        this.password=password;
        this.cusName=cusName;
        this.gender = gender;
        this.travelDetails = new ArrayList<>();
    }

    public int getCusId() {
        return cusId;
    }

    public List<Book> getTravelDetails() {
        return travelDetails;
    }

    public String getCusName() {
        return cusName;
    }

    public String getPassword() {
        return password;
    }
}
