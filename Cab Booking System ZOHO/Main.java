import java.util.*;


class Main {
    public static HashMap<String,Cab> cabList = new HashMap<>();
    public static HashMap<String,Customer> customersList = new HashMap();
    public static ArrayList<Book> bookings = new ArrayList<>();
    public static Locations loc = new Locations();
    public static void main(String[] args) {
        System.out.println("Cab Booking System");

        Cab c1 = new Cab("aaa","111",43,'M','D');
        Cab c2 = new Cab("bbb","222",31,'M','G');
        Cab c3 = new Cab("ccc","333",38,'F','H');
        Cab c4 = new Cab("ddd","444",28,'F','A');
        cabList.put(c1.getDriverName(),c1);
        cabList.put(c2.getDriverName(),c2);
        cabList.put(c3.getDriverName(),c3);
        cabList.put(c4.getDriverName(),c4);


        Customer cus1 = new Customer("zz","99",25,'F');
        Customer cus2 = new Customer("yy","88",61,'M');
        Customer cus3 = new Customer("xx","77",22,'M');
        Customer cus4 = new Customer("ww","66",36,'F');
        customersList.put(cus1.getCusName(),cus1);
        customersList.put(cus2.getCusName(),cus2);
        customersList.put(cus3.getCusName(),cus3);
        customersList.put(cus4.getCusName(),cus4);



        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n\n1) Driver Login\n2)customer Login\n3)Register Customer \n4))Exit Application");
            System.out.println("Enter the options :");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    DriverLogin(sc);
                    break;
                case 2:
                    customerLogin(sc);
                    break;
                case 3:
                    createCustomer(sc);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void CustomerOperations(Customer cus, Scanner sc) {
        outer:
        while(true){
            System.out.println("Customer Login:");
            System.out.println("1)Book a Cab\n2)Details of the Customers ride\n3)Exit");
            System.out.println("Enter the Options: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    bookCabByCustomers(cus,sc);
                    break ;
                case 2:
                    List<Book> customerRide = cus.getTravelDetails();
                    System.out.println("Customer id :"+cus.getCusId());
                    System.out.println("Customer Name :"+cus.getCusName());
                    System.out.println("source \t destination \t cabDetail \t amount");
                    for(Book ride:customerRide){
                        System.out.println(ride.getSource()+"\t"+ride.getDestination()+"\t"+ride.getCabId()+"\t"+ride.getAmount());
                    }
                    break;
                case 3:
                    break outer;
            }
        }
    }

    public static void bookCabByCustomers(Customer cus,Scanner sc){
        System.out.println("Enter the Source: ");
        char source = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the destination: ");
        char destinaiton = sc.next().toUpperCase().charAt(0);

        List<Cab> available = new ArrayList<>();
        HashMap<Character,Integer> locMap = loc.getMap();

        for(String c:cabList.keySet()){
//            int dist = Math.abs(locMap.get(cabList.get(c).getCurPos())- locMap.get(source));
            if(cabList.get(c).isAvailable() ){
                available.add(cabList.get(c));
            }
        }

        System.out.println("Available Cabs are :");
        System.out.println("Location\tCab Ids available");
        for(Cab c:available){
            System.out.println(c.getCurPos()+"\t\t\t"+c.getCabId());
        }

        List<Cab> filteredCab = new ArrayList<>();
        int max =Math.abs( locMap.get(available.get(0).getCurPos()) - locMap.get(source) );

        for(Cab c:available){
            int dist = Math.abs( locMap.get(c.getCurPos()) - locMap.get(source) );
            if(dist<=max){
                filteredCab.add(c);
            }
        }

        Cab selectedCab = filteredCab.get(0);

        for(Cab c:filteredCab){
            if(selectedCab.getTotalTrips() >= c.getTotalTrips() ){
                selectedCab =c;
            }
        }



        int amount =Math.abs(locMap.get(destinaiton)-locMap.get(source))*10;
        double zula = (30/100)*amount;

        selectedCab.setAvailable(false);

        int trips = selectedCab.getTotalTrips();
        selectedCab.setTotalTrips(trips+1);

        int totalEarnings = selectedCab.getTotalEarnings()+amount;
        selectedCab.setTotalEarnings(totalEarnings);

        Book booking = new Book(cus.getCusName(), cus.getCusId(),source,destinaiton,selectedCab.getCabId(),amount,zula);

        List<Book> cabBooking = selectedCab.getBookings();
        cabBooking.add(booking);

        List<Book> custBooking = cus.getTravelDetails();
        custBooking.add(booking);

        for(String cabs:cabList.keySet()){
            if(cabs.equals(selectedCab.getDriverName())){
                continue;
            }else{
                Cab temp = cabList.get(cabs);
                temp.setAvailable(true);
            }
        }
        selectedCab.setCurPos(destinaiton);
        System.out.println("Cab "+selectedCab.getCabId()+" Successfully");

    }



    public static void customerLogin(Scanner sc){
        System.out.println("\nCustomer Login Page :");
        System.out.println("Enter the Customer UserName");
        String userName = sc.next();
        System.out.println("Enter the Password: ");
        String password = sc.next();
        boolean f=false;
        boolean f1=false;
        for(String name:customersList.keySet()){
            if(name.equals(userName)){
                f=true;
                Customer cur = customersList.get(name);
                if(cur.getPassword().equals(password)){
                    f1=true;
                    System.out.println("Login Successful");
                    CustomerOperations(cur,sc);
                    break;
                }else{
                    System.out.println("Invalid Credentials");
                }
            }
        }
        if(!f){
            System.out.println("UserName Not Found");
        }
        if(f1){
            System.out.println("Logged out Successfully");
        }
    }

    public static void createCustomer(Scanner sc){

        System.out.println("Enter the Customer userName");
        String curName = sc.nextLine();
        System.out.println("Enter the Password");
        String password = sc.nextLine();
        System.out.println("Enter the age");
        int age = sc.nextInt();
        System.out.println("Enter the Gender");
        char gender = sc.nextLine().toUpperCase().charAt(0);
        boolean f=false;
        for(String name:customersList.keySet()){
            if(name.equals(curName)){
                f=true;
                System.out.println("Customer with username "+name+" already exists.");
                break;
            }
        }
        if(!f){
            Customer c = new Customer(curName,password,age,gender);
            customersList.put(curName, c);
        }

    }

    public static void DriverLogin(Scanner sc){
        System.out.println("\nDriver Login Page :");
        System.out.println("Enter the Driver UserName");
        String userName = sc.next();
        System.out.println("Enter the Password: ");
        String password = sc.next();
        boolean f=false;
        boolean f1=false;
        for(String name:cabList.keySet()){
            if(name.equals(userName)){
                f=true;
                Cab cur = cabList.get(name);
                if(cur.getPassword().equals(password)){
                    f1=true;
                    System.out.println("Login Successful");
                    DriverOperations(cur,sc);
                    break;
                }else{
                    System.out.println("Invalid Credentials");
                }
            }
        }
        if(!f){
            System.out.println("UserName Not Found");
        }
        if(f1){
            System.out.println("Logged out Successfully");
        }
    }

    public static void DriverOperations(Cab cur,Scanner sc){
        outer:
        while(true){
            System.out.println("Driver Login:");
            System.out.println("1)View History of Rides\n2)exit");
            System.out.println("Enter the Options: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    List<Book> rides = cur.getBookings();
                    System.out.println("Cab id :"+cur.getCabId());
                    System.out.println("Driver Name :"+cur.getDriverName());
                    System.out.println("source \t destination \t customerDetail \t amount \t zulaCommision");
                    for(Book ride:rides){
                        System.out.println(ride.getSource()+"\t"+ride.getDestination()+"\t"+ride.getCusId()+"\t"+ride.getAmount()+"\t"+ride.getZulaCommision());
                    }
                    break ;
                case 2:
                    break outer;

            }
        }
    }

}