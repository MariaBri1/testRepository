package org.example.biblioteca;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Book extends LibraryItem{
    //COMENTARIO DE PRUEBA

    private String author;

    public Book() {
        super();
    }

    public Book(Long itemID, String title, Boolean isLoaned, String author) {
        super(itemID, title, isLoaned);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "itemID='" + super.getItemID() + '\'' +
                "title='" + super.getTitle() + '\'' +
                "isLoaned='" + super.getIsLoaned() + '\'' +
                "author='" + author + '\'' +
                '}';
    }
}
