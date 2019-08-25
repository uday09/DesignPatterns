package Structural;

import java.util.Date;

/*
 * Facad is used to define Simple Interface for a more complex Sub System
 * For User, Its simple to use, w/o worrying the background implementation details of the System
 * 
 * An Event Management Company, for example, can take away all complexities of organizing any event.
 * And as a client you may roam around free :)
 * */

class EventManagementCompany {

	String companyName;
	String email;
	String contatctNumber;

	public EventManagementCompany(String companyName, String email, String contatctNumber) {
		super();
		this.companyName = companyName;
		this.email = email;
		this.contatctNumber = contatctNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getEmail() {
		return email;
	}

	public String getContatctNumber() {
		return contatctNumber;
	}

	@Override
	public String toString() {
		return "EventManagementCompany [companyName=" + companyName + ", email=" + email + ", contatctNumber="
				+ contatctNumber + "]";
	}

	public void orgaizeEvent(Client client, EventDetail eventDetail) {
		EventExecutor eventExecutor = new EventExecutor(client, eventDetail);
		eventExecutor.execute();
	}
}

class EventExecutor {

	Client client;
	EventDetail eventDetail;

	public EventExecutor(Client client, EventDetail eventDetail) {
		this.client = client;
		this.eventDetail = eventDetail;
	}

	public void execute() {
		try {
			
			// Now these seems simple Sysout statements, but Idea is to  implement the complexities here ..... which could be anything you think of
			
			System.out.println("Lets celebrate : " + eventDetail.getEventName());

			Thread.sleep(1000l);

			System.out.println("Its happening at : " + eventDetail.getEventLocation());
			Thread.sleep(1000l);

			System.out.println("On Date : " + eventDetail.getEvenDate());
			Thread.sleep(1000l);
			
			System.out.println("As Mr " + client.getClientName() + "Got Promoted ...");
			Thread.sleep(1000l);
			
			
			System.out.println("Serving Drinks ...");
			Thread.sleep(1000l);

			System.out.println("Playing Music ...");
			Thread.sleep(1000l);

			System.out.println("Serving Dinner ...");
			Thread.sleep(1000l);

			System.out.println("Serving ...");
			Thread.sleep(1000l);

			System.out.println("Serving ...");
			Thread.sleep(1000l);

			System.out.println("Event is over ...");
			Thread.sleep(1000l);

			System.out.println("--------");
			Thread.sleep(1000l);

			System.out.println("Doing Final Settlement ...");
			Thread.sleep(1000l);

			System.out.println("Done ........... ");
		} catch (Exception e) {
			System.out.println("You broke!!!");
		}
	}
}

class Client {

	private String clientName;
	private String email;
	private String contatctNumber;

	public Client(String clientName, String email, String contatctNumber) {
		super();
		this.clientName = clientName;
		this.email = email;
		this.contatctNumber = contatctNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public String getEmail() {
		return email;
	}

	public String getContatctNumber() {
		return contatctNumber;
	}

	@Override
	public String toString() {
		return "Client [clientName=" + clientName + ", email=" + email + ", contatctNumber=" + contatctNumber + "]";
	}

}

class EventDetail {

	String eventName;
	int totalNumerOfGuests;
	Date evenDate;
	String eventLocation;

	public String getEventLocation() {
		return eventLocation;
	}

	public EventDetail(String eventName, int totalNumerOfGuests, Date evenDate, String eventLocation) {
		super();
		this.eventName = eventName;
		this.totalNumerOfGuests = totalNumerOfGuests;
		this.evenDate = evenDate;
		this.eventLocation = eventLocation;
	}

	public String getEventName() {
		return eventName;
	}

	public int getTotalNumerOfGuests() {
		return totalNumerOfGuests;
	}

	public Date getEvenDate() {
		return evenDate;
	}

}

public class Facad {

	public static void main(String[] args) {

		EventManagementCompany eventManagementCompany = new EventManagementCompany("Start Event Management Company",
				"star@gmail.com", "9999999999");
		Client client = new Client("ABC", "abc@gmail.com", "8888888888");
		EventDetail eventDetail = new EventDetail("Party for Promotion", 50, new Date(2019, 9, 31),
				"Some place on Outer ring road Bellandur");

		eventManagementCompany.orgaizeEvent(client, eventDetail); // This takes care of all the complexities, all we need to do is give client and event detail
	}
}
