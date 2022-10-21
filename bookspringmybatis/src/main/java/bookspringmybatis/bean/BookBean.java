package bookspringmybatis.bean;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class BookBean {
	
	@NotEmpty
	private String bookCode;
	@NotEmpty
	private String bookTitle;
	@NotEmpty
	private String bookAuthor;
	@Range(min=1000, max=10000)
	private double bookPrice;
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
}
