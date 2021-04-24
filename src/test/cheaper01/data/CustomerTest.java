package cheaper01.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
  Customer kang;
  Customer jane;

  @Before
  public void before() {
    kang = new Customer("kang");
    jane = new Customer("jane");
  }

  @Test
  public void statement() {
    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);
    Movie kingKong = new Movie("金刚", Movie.REGULAR);
    Movie GodzillaVsKong = new Movie("哥斯拉大战金刚", Movie.NEW_RELEASE);
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDRENS);

    Rental godzilla3DaysRented = new Rental(godzilla, 3);
    Rental teletubbies3DaysRented = new Rental(teletubbies, 3);
    kang.addRental(godzilla3DaysRented);
    kang.addRental(teletubbies3DaysRented);
    assertEquals("kang的租赁记录\n" +
      "\t哥斯拉\t3.5\n" +
      "\t天线宝宝\t1.5\n" +
      "您欠下的金额为5.0\n" +
      "您获得了3积分点", kang.statement());
  }

}