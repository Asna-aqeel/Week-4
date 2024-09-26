import java.util.Scanner;

public class Shop {
    private Product productList[]= new Product[500];
    private Personn owner;
    private String address;
    private static int productCount=0;


    private static double revenue;

    public Shop(Personn owner, String address) {
        
        this.owner = owner;
        this.address = address;
        this.productList = new Product[100];

    }

    public void addProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product details:");
        System.out.println("name");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        Product product = new Product(name, price, quantity);
        productList[productCount++]=product;
        System.out.println("Product added");

    }

    public void sale() {
        Scanner sc2 = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = sc2.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (productList[i].getId().equals(id)) {
                productList[i].setQuantity(productList[i].getQuantity() - 1);
                revenue += productList[i].getPrice();
                System.out.println("Sale successful");
            } else {
                System.out.println("Product not found");
            }

        }
    }

	public void displayproduct(){
	if(productCount == 0){
	System.out.println("no products");
        return;
	}
	System.out.println("product list");
	for(int i =0; i < productCount; i++){
	System.out.println(productList[i]);
		}
	}

	public void remove(){
	Scanner s = new Scanner(System.in);
	System.out.println("enter product you wnat to remove");
	String id = s.nextLine();
	
	for(int i = 0; i<productCount; i++){
	if(productList[i].getId().equals(id)){
		for(int j = i; j < productCount - 1; j++){
		productList[j] = productList[j+1];
	}
		productList[--productCount] = null;
	System.out.println("product removed");
		return;
	}
}
	System.out.println("product not found");
	}	
	
}
