package org.example.biblioteca;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class LibraryItem implements Serializable {
    private static final long serialVersionUID = -6713862971612034593L;

    private Long itemID;
    private String title;
    private Boolean isLoaned;

    public LibraryItem() {
    }

    public LibraryItem(Long itemID, String title, Boolean isLoaned) {
        this.itemID = itemID;
        this.title = title;
        this.isLoaned = isLoaned;
    }
}
