package model;

public class Mentor 
{
	private int mid;
	private String mname;
	private String memail;
	private String maddress;
	private String mno;
	
	
	public Mentor() {
		super();
	}
	public Mentor(String mname, String memail, String maddress, String mno) {
		super();
		this.mname = mname;
		this.memail = memail;
		this.maddress = maddress;
		this.mno = mno;
	}
	public Mentor(int mid, String mname, String memail, String maddress, String mno) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.memail = memail;
		this.maddress = maddress;
		this.mno = mno;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	
	
}
