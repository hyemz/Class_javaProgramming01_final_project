public class Member
{
	private String name;
	private double height;
	private double weight;
	private String address;
	private String phone;
	
	public Member(){}
	public Member(String name,
				  double height,
				  double weight,
				  String address,
				  String phone)
	{
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName(){ return name;}
	public double getHeight(){ return height;}
	public double getWeight(){ return weight;}
	public String getAddress(){ return address;}
	public String getPhone(){ return phone;}
	
	/*
	public void setName(String name){ this.name = name;}
	public void setHeight(double height){ this.height = height;}
	public void setWeight(double weight){ this.weight = weight;}
	public void setAddress(String address){ this.address = address;}
	public void setPhone(String phone){ this.phone = phone;}
	*/
}
