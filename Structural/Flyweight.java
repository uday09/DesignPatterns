package Structural;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * The flyweight pattern is used to reduce the memory and resource usage for complex models containing 
 * many hundreds, 
 * thousands or 
 * hundreds of thousands of similar objects. 
 * 
 * Example can be online trading for Bond Trading(Below Example) in Finance world, where similar product could be traded multiple times in a Day, now this product is something which is gonna to remain same throuh out the Day
 * Create a hash map, to store the details of it as kep value pair
 * */

/* This could be a Bond for example, receiving from some system. Now don't call other systems web service, if its already cached in your application
<Bond>
	<BondId> 12345678</BondId>
	<CountryOfIssue>India</CountryOfIssue>
	<MaturityDate> 2025-09-23</MaturityDate>
	<IssueDate> 2011-09-22</IssueDate>
	<Currency>INR</Currency>
	<Description>Medium Term GOvt Bonds</Description>
</Bond>
 */

class Bond { //
	private String bondId;
	private String countryOfIssue;
	private Date maturityDate;
	private Date issueDate;
	private String currency;
	private String description;

	public Bond(String bondId, String countryOfIssue, Date maturityDate, Date issueDate, String currency,
			String description) {
		super();
		this.bondId = bondId;
		this.countryOfIssue = countryOfIssue;
		this.maturityDate = maturityDate;
		this.issueDate = issueDate;
		this.currency = currency;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bond [bondId=" + bondId + ", countryOfIssue=" + countryOfIssue + ", maturityDate=" + maturityDate
				+ ", issueDate=" + issueDate + ", currency=" + currency + ", description=" + description + "]";
	}

	public String getBondId() {
		return bondId;
	}

	public String getCountryOfIssue() {
		return countryOfIssue;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public String getDescription() {
		return description;
	}
}

class BondProvider {
	Map<String, Bond> bondCache = new HashMap<>();
	private int count = 0;

	public Bond getBond(String bondId) {
		if (bondCache.containsKey(bondId)) {
			return bondCache.get(bondId);
		} else {
			++count;
			populateCahe(bondId);
			return bondCache.get(bondId);
		}
	}

	private void populateCahe(String bondId) {
		// It could be a web service call as well. For simplicity creating new Object
		// here it self
		Bond bond = new Bond(bondId, "Indiaaaaaaa", new Date(2029,10,21), new Date(2019,10,21), "INR",
				"Some Description");
		bondCache.put(bondId, bond);
	}

	public int getCount() {
		return count;
	}
}

public class Flyweight {

	public static void main(String[] args) {
		try {
			BondProvider bondProvider = new BondProvider();
			Bond bond;
			bond = bondProvider.getBond("101");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("201");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("303");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("404");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("505");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("101");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("101");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("101");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("101");
			System.out.println(bond);
			Thread.sleep(1000l);
			
			bond = bondProvider.getBond("101");
			System.out.println(bond);
			
			Thread.sleep(1000l);
			
			System.out.println("=======================================================================");
			System.out.println("How many times got result from cache : " + bondProvider.getCount());
			System.out.println("=======================================================================");
		} catch (Exception e) {

		}
	}

}
