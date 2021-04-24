package cheaper01.data;

public class Movie {
  private String title;
  private int priceCode;

  /**
   * 类型 常规电影
   */
  public static final int REGULAR = 0;
  /**
   * 类型 儿童电影
   */
  public static final int CHILDREN = 2;
  /**
   * 类型 新发布
   */
  public static final int NEW_RELEASE = 1;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPriceCode() {
    return priceCode;
  }

  public void setPriceCode(int priceCode) {
    this.priceCode = priceCode;
  }
}

