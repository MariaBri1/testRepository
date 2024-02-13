package org.example.biblioteca;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class LibraryUsers implements Serializable {
    private static final long serialVersionUID = 4220551328353690541L;

    private Long userID;
    private String userName;
    private List<LibraryItem> itemsPurchased;

    public LibraryUsers( String userName , Long userID) {
        this.userID = userID;
        this.userName = userName;
        itemsPurchased = new ArrayList<>();
    }

    public LibraryUsers() {

    }


}
