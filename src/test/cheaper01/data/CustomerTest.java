package cheaper01.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
  Customer kang;

  @Before
  public void before() {
    kang = new Customer("kang");
  }

  @Test
  public void statement1() {
    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);
    Movie kingKong = new Movie("金刚", Movie.REGULAR);
    Movie GodzillaVsKong = new Movie("哥斯拉大战金刚", Movie.NEW_RELEASE);
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDREN);

    Rental godzilla3DaysRented = new Rental(godzilla, 3);
    Rental teletubbies3DaysRented = new Rental(teletubbies, 3);
    kang.addRental(godzilla3DaysRented);
    kang.addRental(teletubbies3DaysRented);
    assertEquals("kang的租赁记录\n" +
      "\t哥斯拉\t3.5\n" +
      "\t天线宝宝\t1.5\n" +
      "您欠下的金额为5.0\n" +
      "您获得了2积分点", kang.statement());
  }

  @Test
  public void statement_regularMovie3DaysRental() {
    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);

    Rental teletubbies3DaysRented = new Rental(godzilla, 3);
    kang.addRental(teletubbies3DaysRented);
    String statement = kang.statement();
    System.out.println(statement);
    assertEquals("kang的租赁记录\n" +
      "\t哥斯拉\t3.5\n" +
      "您欠下的金额为3.5\n" +
      "您获得了2积分点", statement);
  }

  @Test
  public void statement_regularMovie1DaysRental() {
    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);

    Rental teletubbies3DaysRented = new Rental(godzilla, 1);
    kang.addRental(teletubbies3DaysRented);
    String statement = kang.statement();
    System.out.println(statement);
    assertEquals("kang的租赁记录\n" +
      "\t哥斯拉\t2.0\n" +
      "您欠下的金额为2.0\n" +
      "您获得了1积分点", statement);
  }

  @Test
  public void statement_childrenMovie3DaysRental() {
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDREN);

    Rental teletubbies3DaysRented = new Rental(teletubbies, 3);
    kang.addRental(teletubbies3DaysRented);
    String statement = kang.statement();
    System.out.println(statement);
    assertEquals("kang的租赁记录\n" +
      "\t天线宝宝\t1.5\n" +
      "您欠下的金额为1.5\n" +
      "您获得了1积分点", statement);
  }

  @Test
  public void statement_childrenMovie4DaysRental() {
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDREN);

    Rental teletubbies3DaysRented = new Rental(teletubbies, 4);
    kang.addRental(teletubbies3DaysRented);
    String statement = kang.statement();
    System.out.println(statement);
    assertEquals("kang的租赁记录\n" +
      "\t天线宝宝\t3.0\n" +
      "您欠下的金额为3.0\n" +
      "您获得了1积分点", statement);
  }

  @Test
  public void statement_newReleaseMovie3DaysRental() {
    Movie GodzillaVsKong = new Movie("哥斯拉大战金刚", Movie.NEW_RELEASE);

    Rental GodzillaVsKong3DaysRented = new Rental(GodzillaVsKong, 3);
    kang.addRental(GodzillaVsKong3DaysRented);
    String statement = kang.statement();
    System.out.println(statement);
    assertEquals("kang的租赁记录\n" +
      "\t哥斯拉大战金刚\t9.0\n" +
      "您欠下的金额为9.0\n" +
      "您获得了1积分点", statement);
  }

  @Test(expected = IllegalArgumentException.class)
  public void statement_withoutMovieType() {
    Movie teletubbies = new Movie("无效电影", 4);

    Rental teletubbies3DaysRented = new Rental(teletubbies, 4);
    kang.addRental(teletubbies3DaysRented);
    kang.statement();
  }
  @Test
  public void statement_html() {
    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);
    Movie kingKong = new Movie("金刚", Movie.REGULAR);
    Movie GodzillaVsKong = new Movie("哥斯拉大战金刚", Movie.NEW_RELEASE);
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDRENS);

    Rental godzilla3DaysRented = new Rental(godzilla, 3);
    Rental teletubbies3DaysRented = new Rental(teletubbies, 3);
    kang.addRental(godzilla3DaysRented);
    kang.addRental(teletubbies3DaysRented);
    assertEquals("<h1>kang的租赁记录</h1>\n" +
      "哥斯拉:3.5<br>\n" +
      "天线宝宝:1.5<br>\n" +
      "<p>您欠下的金额为5.0</p>\n" +
      "<p>您获得了2积分点</p>", kang.statementHtml());
  }

  @Test
  public void statement_newRelease() {
    Movie godzilla = new Movie("哥斯拉", Movie.REGULAR);
    Movie kingKong = new Movie("金刚", Movie.REGULAR);
    Movie GodzillaVsKong = new Movie("哥斯拉大战金刚", Movie.NEW_RELEASE);
    Movie teletubbies = new Movie("天线宝宝", Movie.CHILDRENS);

    Rental godzilla3DaysRented = new Rental(godzilla, 3);
    Rental teletubbies3DaysRented = new Rental(teletubbies, 3);
    Rental godzillaVsKong3DayRented = new Rental(GodzillaVsKong, 3);
    kang.addRental(godzilla3DaysRented);
    kang.addRental(teletubbies3DaysRented);
    kang.addRental(godzillaVsKong3DayRented);
    System.out.println(kang.statement());
    assertEquals("kang的租赁记录\n" +
      "\t哥斯拉\t3.5\n" +
      "\t天线宝宝\t1.5\n" +
      "\t哥斯拉大战金刚\t9.0\n" +
      "您欠下的金额为14.0\n" +
      "您获得了4积分点", kang.statement());
  }
}