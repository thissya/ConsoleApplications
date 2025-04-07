class Book{
    private String title;
    private String bookType;
    private int bookCopies;
    private int bookId;
    private String author;

    public Book(String title,int bookId,String bookType,String author,int bookCopies){
        this.title=title;
        this.bookId=bookId;
        this.bookType=bookType;
        this.author=author;
        this.bookCopies=bookCopies;
    }

    public String getTitle(){
        return title;
    }

    public int getBookId(){
        return bookId;
    }

    public String getAuthor(){
        return author;
    }

    public String getBookType(){
        return bookType;
    }
    public int getBookCopies(){
        return bookCopies;
    }

    public void decreaseCopies(){
        if(bookCopies>0){
            bookCopies--;
        }
    }

    public void increaseCopies(){
        bookCopies++;
    }
    public boolean isAvailable(){
        if(bookCopies>0){
            return true;
        }
        return false;
    }

    public void toString(){
        return "[\nName : "+title+" \nId : "+bookId+"\nAuthor Name : "+author+"\nGenre : "+bookType+"\n]";
    }

}