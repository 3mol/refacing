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
  public static final int CHILDRENS = 2;
  /**
   * 类型 新发布
   */
  public static final int NEW_RELEASE = 1;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  /**
   * 计算费用
   * 该函数都是与rental相关的, Customer相关性不强
   * 更新1: switch 的数据是与Movie相关, 应该移入到Movie
   *
   * @return 金额
   */
  public double getCharge(int daysRented) {
    double result = 0;
    // 确定每一个租赁的金额
    switch (this.getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (daysRented > 2) {
          result += (daysRented - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        result += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        result += 1.5;
        if (daysRented > 3) {
          result += (daysRented - 3) * 1.5;
        }
        break;
      default:
        break;

    }
    return result;
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

  public int getFrequentRenterPoints(int daysRented) {
    // 客户租赁了新发布的电影且借期大于1, 添加多一个积分点
    if (getPriceCode() == Movie.REGULAR && daysRented > 1) {
      return 2;
    }
    return 1;
  }
}

