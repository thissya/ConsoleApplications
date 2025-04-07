class Library{
    private HashMap<Integer,Book> books;
    private List<Integer> ids;
    public Library(){
        this.books = new HashMap<>();
        this.ids = new ArrayList<>();
    } 

    public void addBook(book){
        if(ids.contains(book.getBookId())){
            System.out.println("Error Occured : The Book Id "+book.getBookId()+" has been already Exists.");
            return ;
        }
        books.put(book.getBookId(),book);
        System.out.println(book.getTitle()+" has been added sucessfully!");
    }

    public void removeBook(int id){
        if(books.containsKey(id)){
            System.out.println("Removed Book is : "+books.get(id));
            books.remove(id);
            ids.remove(id);
        }else{
            System.out.println("The Book is Already Doesnt exists");
        }
    }

    public void displayBooks(){
        for(List<Book> disp:books.Values()){
            System.out.println(disp);
        }
    }

    public Book getBookById(int id){
        if(books.containsKey(id)){
            return books.get(id);
        }else{
            return null;
        }
    }

}