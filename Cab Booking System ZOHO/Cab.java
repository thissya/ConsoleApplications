import java.util.*;


public class Cab {
    private int cabId;
    private String driverName;
    private String password;
    private int age;
    private char gender;

    private char curPos;
//    private int freeTime;
    private int totalEarnings;
    private List<Book> bookings;

    //    static HashMap<String,Cab> = new HashMap<>();
//    private Locations loc = new Locations();
    private boolean isAvailable;

    private static int count = 0;
    private int totalTrips=0;

    public Cab(String driverName,String password,int age,char gender,char curPos){
        this.cabId= ++count;
        this.driverName=driverName;
        this.password=password;
        this.age=age;
        this.gender=gender;
        this.curPos=curPos;
        this.bookings= new ArrayList<>();
        this.totalEarnings= 0;
        this.isAvailable=true;
    }

    public void setCurPos(char curPos) {
        this.curPos = curPos;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTotalEarnings(int totalEarnings){
        this.totalEarnings=totalEarnings;
    }

    public void setTotalTrips(int totalTrips) {
        this.totalTrips = totalTrips;
    }

    public int getCabId() {
        return cabId;
    }

    public List<Book> getBookings(){
        return bookings;
    }

    public String getPassword() {
        return password;
    }

    public String getDriverName() {
        return driverName;
    }

//    public int getFreeTime() {
//        return freeTime;
//    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public char getCurPos(){
        return curPos;
    }

    public int getTotalTrips() {
        return totalTrips;
    }

    public boolean isAvailable(){

        return isAvailable;
    }



}
