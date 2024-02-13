package org.example.biblioteca;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.io.Serializable;

public class Library implements Serializable {
    private static final long serialVersionUID = 6567116577800412533L;

    ArrayList<LibraryItem> libraryItems;
    ArrayList<LibraryUsers> libraryUsers;

    //metodos
    //agregar Item


    public Library(ArrayList<LibraryItem> libraryItems, ArrayList<LibraryUsers> libraryUsers) {
        this.libraryItems = libraryItems;
        this.libraryUsers = libraryUsers;
    }

    public boolean addItem(LibraryItem item) {

        if (!Objects.isNull(getItemLibrary(item.getItemID()))) {
            return false;
        }

        libraryItems.add(item);
        return true;

    }

    public void showAllItems() {
        libraryItems.forEach(System.out::println);

    }

    public boolean loanItem(Long idItem, Long idUser) {
        LibraryItem foundItem = getItemLibrary(idItem);
        LibraryUsers userFound = getItemUser(idUser);

        if (Objects.isNull(foundItem) || Objects.isNull(userFound)) {
            return false;
        }

        if (foundItem.getIsLoaned()) {
            return false;
        }
        foundItem.setIsLoaned(true);

        List<LibraryItem> itemPurchased=new ArrayList<>();
        itemPurchased.add(foundItem);
        userFound.setItemsPurchased(itemPurchased);

        return true;
    }


    public boolean returnItem(Long idItem, Long idUser) {
        LibraryItem foundItem = getItemLibrary(idItem);
        LibraryUsers userFound = getItemUser(idUser);

        if (Objects.isNull(foundItem) || Objects.isNull(userFound) || !foundItem.getIsLoaned()) {
            return false;
        }

        foundItem.setIsLoaned(false);//el estado es no prestado

        //remover item de la lista de prestados
        List<LibraryItem> userPurchased= userFound.getItemsPurchased();
        userPurchased.remove(foundItem);
        userFound.setItemsPurchased(userPurchased);


        return true;
    }

    private LibraryItem getItemLibrary(Long idItem) {
        LibraryItem itemFound = null;
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getItemID().equals(idItem)) {
                itemFound = libraryItem;
                break;
            }
        }
        return itemFound;
    }

    private LibraryUsers getItemUser(Long idUser) {
        LibraryUsers userFound = null;
        for (LibraryUsers libraryUser : libraryUsers) {
            if (libraryUser.getUserID().equals(idUser)) {
                userFound = libraryUser;
                break;
            }
        }
        return userFound;
    }

}
