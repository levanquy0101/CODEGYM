package _17_binary_file_serialization.exercise.e1_product_manager;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Test {
    private static final ProductService productService = new ProductService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        do{
            System.out.println("1. Add New Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Products");
            System.out.println("5. Search By Name");
            System.out.println("6. Search From Price");
            System.out.println("7. Sort By Price");
            System.out.println("8. Exit");

            int choice;
            do {
                System.out.print("Please input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            } while (choice <= 0 || choice > 8);

            try {
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        show();
                        break;
                    case 5:
                        searchByName();
                        break;
                    case 6:
                        searchFromPrice();
                        break;
                    case 7:
                        sort();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (true);

//        backMainMenu();
    }

    private static void backMainMenu() {
        System.out.print("Do you back to main menu (Y/N): ");
        String answer = scanner.nextLine();
        if ("Y".equalsIgnoreCase(answer)) displayMenu();
        else System.exit(0);
    }

    private static void add() throws IOException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Description: ");
        String des = scanner.nextLine();

        Product product = new Product(0, name, brand, price, des);
        productService.add(product);
//        productService.save(product);
        System.out.printf("Add new product %s successful\n", name);
    }

    private static void show() {
        List<Product> products = productService.getAll();
        display(products);
    }

    private static void searchByName() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        List<Product> products = productService.searchByName(name);
        display(products);
    }

    private static void searchFromPrice() {
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        List<Product> products = productService.searchFromPrice(price);
        display(products);
    }

    private static void delete() {
        System.out.print("Input product name to delete: ");
        String name = scanner.nextLine();
        int id = productService.deleteByName(name);
        System.out.println(id > 0 ? "Delete producct " + name + " successful" : "Not found to delete");
    }

    private static void update() throws IOException {
        System.out.println("List all product:");
        show();
        System.out.print("Choice id of product to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name to edit: ");
        String name = scanner.nextLine();
        System.out.print("Brand to edit: ");
        String brand = scanner.nextLine();
        System.out.print("Price to edit: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Description to edit: ");
        String des = scanner.nextLine();
        Product product = new Product(id, name, brand, price, des);
        productService.update(product);
        System.out.println("Update is successful");
    }

    private static void sort(){
        List<Product> products= productService.sortByPrice();
        display(products);
    }

    private static void display(List<Product> products) {
        System.out.println(products.size() + " results");
        products.stream().forEach(System.out::println);
    }
}
