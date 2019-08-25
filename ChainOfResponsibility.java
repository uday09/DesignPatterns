package Behavioural;
/*
The chain of responsibility pattern is used to process varied requests, 
each of which may be dealt with by a different handler.
*/

class ProductToPurchase {
	private int price;
	private String description;

	ProductToPurchase(int price,String description){
		this.description = description;
		this.price = price;
	} 

	
	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

}

class PurchaseRequest {

	ProductToPurchase productToPurchase;

	PurchaseRequest(ProductToPurchase productToPurchase){
		this.productToPurchase = productToPurchase;	
	}


	public ProductToPurchase getProductToPurchase() {
		return productToPurchase;
	}

}

abstract class Approver {
	protected Approver nextApprover;

	public void approveRequest(PurchaseRequest purchaseRequest) {
		nextApprover.approveRequest(purchaseRequest);
	}

	public void setNext(Approver approver) {
		this.nextApprover = approver;
	}
}

class SuperVisor extends Approver {

	@Override
	public void approveRequest(PurchaseRequest request) {

		if (request.getProductToPurchase().getPrice() <= 500) {
			System.out.println("approved for " + request.getProductToPurchase().getPrice() + " by Supervisor");
		} else {
			super.approveRequest(request);
		}

	}
}

class Manager extends Approver {

	@Override
	public void approveRequest(PurchaseRequest request) {

		if (request.getProductToPurchase().getPrice() <= 2000) {
			System.out.println("approved for " + request.getProductToPurchase().getPrice() + " by manager");
		} else {
			super.approveRequest(request);
		}

	}
}

public class ChainOfResponsibility {

	public static void main(String[] args) {
		
		Approver supervisor = new SuperVisor();
		Approver manager = new Manager();
		supervisor.setNext(manager);
		
		supervisor.approveRequest(new PurchaseRequest(new ProductToPurchase(400,"Table")));
		supervisor.approveRequest(new PurchaseRequest(new ProductToPurchase(600,"Chair")));
		supervisor.approveRequest(new PurchaseRequest(new ProductToPurchase(700,"Rack")));

	}

}
