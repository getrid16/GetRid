package ObjectClasses;
public class Book {
	
private String BookTitle;
private String Author;
private int ISBN;
private double Price;
private String Condition;

public Book(String BookTitle, String Author, int ISBN, double Price, String Condition)
{
	this.BookTitle=BookTitle;
	this.Author=Author;
	this.ISBN=ISBN;
	this.Price=Price;
	this.Condition=Condition;
}

public void setBookTitle(String BookTitle)
{
	this.BookTitle=BookTitle;
}
public String getBookTitle()
{
	return BookTitle;
}

public void setAuthor(String Author)
{
	this.Author=Author;
}
public String getAuthor() {
	return Author;
}

public void setISBN(int ISBN) {
	this.ISBN = ISBN;
}
public int getISBN() {
	return ISBN;
}

public void setPrice(double Price) {
	this.Price = Price;
}
public double getPrice() {
	return Price;
}

public void setCondition(String Condition) {
	this.Condition = Condition;
}
public String getCondition() {
	return Condition;
}







}
