package com.app.product;

public class ProductOperations {
	public static void main(String[] args) {
        try {
            DoublyCircularLinkedList productList = new DoublyCircularLinkedList();

            productList.addProduct(new Product(1, "Laptop", "Electronics", 1000.0));
            productList.addProduct(new Product(2, "Smartphone", "Electronics", 500.0));
            productList.addProduct(new Product(3, "Shirt", "Clothing", 30.0));

            System.out.println("All Products:");
            productList.displayAllProducts();

            System.out.println("\nDisplaying Product with ID 2:");
            productList.displayProductById(2);

            System.out.println("\nDeleting First Product:");
            productList.deleteFirstProduct();
            productList.displayAllProducts();

            System.out.println("\nEditing Product with Name 'Shirt':");
            productList.editProductByName("Shirt", "T-Shirt", "Clothing", 25.0);
            productList.displayAllProducts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
