package org.example.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<LibraryUsers> usuarios = new ArrayList<>();
        usuarios.add(new LibraryUsers("Briceida",1L));
        usuarios.add(new LibraryUsers("Naruto",2L));
        usuarios.add(new LibraryUsers("Panzon",3L));

        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book(1L, "Los perros hambrientos", true, "Jose Arguedas"));
        libraryItems.add(new Book(2L, "Yawar Fiestao", true, "Mario Vargas Llosa"));
        libraryItems.add(new DVD(3L, "Harry Potter", true, "errrrrr", (short) 200));



        Scanner scanner=new Scanner(System.in);
        Library library = new Library( libraryItems, usuarios);

        // Mostrar detalles de los artículos y usuarios
        System.out.println("Detalles de los artículos:");

        Boolean operationContinue=true;
        while(operationContinue)
        {
            System.out.println("1. Agregar");
            System.out.println("2. Prestar");
            System.out.println("3. Devolver");
            System.out.println("4. Mostrar");
            System.out.println("5. Salir");

            System.out.print("Elija una opcion : ");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("1. Libro");
                System.out.println("2. DVD");

                System.out.print("Seleccione el articulo que agregar : ");

                int artOpcion = scanner.nextInt();
                if (artOpcion == 1) {
                    System.out.println("Ingrese el id del libro:");

                    Long idBook = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Ingrese el título ");

                    String title = scanner.nextLine();

                    System.out.println("Ingrese el autor ");
                    String author = scanner.nextLine();

                    System.out.println("Ingrese disponibilidad (true/false):");
                    boolean isLoaned = scanner.nextBoolean();

                    Book book = new Book(idBook, title, isLoaned,author);
                    library.addItem(book);
                    System.out.println("Libro agregado !");
                } else if (artOpcion == 2) {
                    System.out.println("Ingrese el id del DVD:");
                    Long idDVD = scanner.nextLong();

                    scanner.nextLine();

                    System.out.println("Ingrese el nombre del DVD ");
                    String title = scanner.nextLine();

                    System.out.println("Ingrese el director DEL DVD ");
                    String director = scanner.nextLine();

                    System.out.println("Ingrese la duracion ");
                    Short duration = scanner.nextShort();

                    System.out.println("Ingrese disponibilidad (true/false):");
                    boolean isLoaned = scanner.nextBoolean();

                    DVD dvd = new DVD(idDVD, title, isLoaned,director, duration);
                    library.addItem(dvd);
                    System.out.println("DVD agregado !");
                }
            }

            else if (option == 2) {
                System.out.println("Ingrese el id del usuario");
                Long idItem = scanner.nextLong();
                System.out.println("Ingrese el id del item");
                Long idUser = scanner.nextLong();

                library.loanItem(idItem, idUser);

            }
            else if (option == 3) {
                System.out.println("Ingrese el id del usuario");
                Long idItem = scanner.nextLong();
                System.out.println("Ingrese el id del item");
                Long idUser = scanner.nextLong();

                library.returnItem(idItem, idUser);
            }
            else if (option == 4) {
                library.showAllItems();
            }
            else if (option == 5) {
                operationContinue=false;
            }
        }

    }
}