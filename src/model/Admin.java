package model;
//pojo class
public class Admin 
{
	private int cid;
	private String cname;
	private String cauthor;
	private String ccertificate; 
	private String cprice;
		
	public Admin() {
		super();
	}
	public Admin(String cname, String cauthor, String ccertificate, String cprice) {
		super();
		this.cname = cname;
		this.cauthor = cauthor;
		this.ccertificate = ccertificate;
		this.cprice = cprice;
	}
	public Admin(int cid, String cname, String cauthor, String ccertificate, String cprice) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cauthor = cauthor;
		this.ccertificate = ccertificate;
		this.cprice = cprice;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	public String getCcertificate() {
		return ccertificate;
	}
	public void setCcertificate(String ccertificate) {
		this.ccertificate = ccertificate;
	}
	public String getCprice() {
		return cprice;
	}
	public void setCprice(String cprice) {
		this.cprice = cprice;
	}
	
	
}
