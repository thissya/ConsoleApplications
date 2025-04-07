class User extends Person{

    private List<Book> borrowedBooks;

    public User(String name,int id){
        super(name,id);
        this.borrowedBooks =  new ArrayList<>();
    }
    
    public void borrowBooks(Book book){
        if(book.isAvailable()){
            borrowedBooks.add(book);
            book.decreaseCopies();
            System.out.println(name + " borrows the Book " +book.getTitle());
        }else{
            System.out.println("Book is Not Available Currently... You can try with Some other Books.");
        }
    }

    public void returnBooks(Book book){
        if(borrowBooks.contains(book)){
            borrowBooks.remove(book);
            book.increaseCopies();
            System.out.println(name+ " returned the Book "+book.getTitle());
        }
        else{
            System.out.println("You Did not borrowed the Book yet...");
        }
    }

    public void displayInfo(){
        System.out.println("Name : "+name +"\nId : "+id);
        System.out.println("Borrowed Books : "+borrowBooks);
    }
}