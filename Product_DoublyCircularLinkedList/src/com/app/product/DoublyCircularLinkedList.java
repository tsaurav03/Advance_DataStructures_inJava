package com.app.product;

public class DoublyCircularLinkedList {
	
	private Node head =null;
	private Node tail=null;
	
	// Add product in linked list at last node
	
	public void addProduct(Product product) {
		Node newNode = new Node(product);
		if(head==null) {
			head=newNode;
			tail=newNode;
			head.next=head;
			head.prev=head;
		}else {
			tail.next=newNode;
			newNode.prev=tail;
			newNode.next=head;
			head.prev=newNode;
			tail=newNode;
		}
	}
	
	// Display all products
	
	public void displayAllProducts() {
		if(head==null) {
			System.out.println("NO Products in the list");
			return;
		}
		
		Node current =head;
		do {
			System.out.println(current.data);
			current=current.next;
			
		}while(current!=head);
		
	}
	
	
	//Display specific product on the basis of Product id
	
	public void displayProductById(int productId) throws ProductNotFoundException{
		if(head==null ) {
			throw new ProductNotFoundException("No products in the list");
		}
		
		Node current = head;
		do {
			if(current.data.productId==productId) {
				System.out.println(current.data);
				return;
				
			}
			current=current.next;
		}while(current!=head);
		
		throw new ProductNotFoundException("Product with Id"+productId+"not found");
	}
	
	// Delete First Node in  the given list
	
	public void deleteFirstProduct()throws ProductNotFoundException{
		if(head==null) {
			throw new ProductNotFoundException("No products in the list");
		}
		
		if(head==tail) {
			head=null;
			tail=null;
			
		}else {
			tail.next=head.next;
			head.next.prev=tail;
			head=head.next;
		}
	}
	
	// Edit product by name
	public void editProductByName(String name, String newName, String newType, double newPrice) throws ProductNotFoundException{
        if (head == null) {
            throw new ProductNotFoundException("No products in the list.");
        }

        Node current = head;
        do {
            if (current.data.name.equals(name)) {
                current.data.name = newName;
                current.data.type = newType;
                current.data.price = newPrice;
                return;
            }
            current = current.next;
        } while (current != head);

        throw new ProductNotFoundException("Product with name " + name + " not found.");
    }
	

}
