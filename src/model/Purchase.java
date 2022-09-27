package model;

public class Purchase 
{
	private int pid;
	private String pname;
	private String pmno;
	
	
	public Purchase() {
		super();
	}
	public Purchase(String pname, String pmno) {
		super();
		this.pname = pname;
		this.pmno = pmno;
	}
	public Purchase(int pid, String pname, String pmno) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pmno = pmno;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPmno() {
		return pmno;
	}
	public void setPmno(String pmno) {
		this.pmno = pmno;
	}
	
	
}
