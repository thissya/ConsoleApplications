abstract class Person{
    private String name;
    private String id;

    public Person(String name,Int id){
        this.name = name;
        this.id = id;
    }
    public abstract void displayInfo();
}