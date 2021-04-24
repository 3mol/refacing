import cheaper01.data.Customer;
import cheaper01.data.Movie;
import cheaper01.data.Rental;

public class Main {
  public static void main(String[] args) {
    Customer kang = new Customer("kang");
    Customer jane = new Customer("jane");

    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);
    Movie kingKong = new Movie("金刚", Movie.REGULAR);
    Movie GodzillaVsKong = new Movie("哥斯拉大战金刚", Movie.NEW_RELEASE);
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDRENS);


    Rental godzilla3DaysRented = new Rental(godzilla, 3);
    Rental teletubbies3DaysRented = new Rental(teletubbies, 3);
    kang.addRental(godzilla3DaysRented);
    kang.addRental(teletubbies3DaysRented);
    System.out.println(kang.statement());
  }
}
