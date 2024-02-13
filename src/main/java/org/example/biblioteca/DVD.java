package org.example.biblioteca;

import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
public class DVD extends LibraryItem{
    private String director;
    private Short duration;

    public DVD() {
        super();
    }

    public DVD(Long itemID, String title, Boolean isLoaned, String director, Short duration) {
        super(itemID, title, isLoaned);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "itemID='" + super.getItemID() + '\'' +
                "title='" + super.getTitle() + '\'' +
                "isLoaned='" + super.getIsLoaned() + '\'' +
                "director='" + director + '\'' +
                ", duration=" + duration +
                '}';
    }
}
