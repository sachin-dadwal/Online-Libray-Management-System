package DTO;


public class PurchaseDTO
{
	private int CartNo;
	private int UID;
	private int BookID;
	private String Date;
	private String Status;
	public int getCartNo() {
		return CartNo;
	}
	public void setCartNo(int cartNo) {
		CartNo = cartNo;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
