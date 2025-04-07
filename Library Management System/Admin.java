class Admin extends User{
    private static final String Admin_UserName = "Admin";
    private static final String Admin_Password = "Admin@123";
    public Admin(name,id){
        super(name,id);
    }

    public boolean Authenticate(String userName,String password){
        if(Admin_UserName.equals(userName) && Admin_Password.equals(password)){
            return true;
        }
        return false;
    }

    public void displayInfo(){
        System.out.println("Admin Name : "+name + "\nId : "+id);
    }
    
}