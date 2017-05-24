package com.rxx.spring.bean;

import java.util.Date;

/**
 * @Title      :Book
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年2月9日 上午9:55:29
 */
public class Book {

	private String bookId;
	private String bookName;
	private String author;
	private String price;
	private Date date;
	
	
	public Book(String bookId, String bookName, String author, String price, Date date) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", date=" + date + "]";
	}
}
