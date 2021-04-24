package cheaper01.data;

public class Rental {
  /**
   * 租赁的电影
   */
  private Movie movie;
  /**
   * 租赁的时长
   */
  private int daysRented;

  public Rental(Movie movie, int daysRental) {
    this.movie = movie;
    this.daysRented = daysRental;
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }

  /**
   * 计算费用
   * 该函数都是与rental相关的, Customer相关性不强
   *
   * @return 金额
   */
  public double getCharge() {
    double result = 0;
    // 确定每一个租赁的金额
    switch (this.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (this.getDaysRented() > 2) {
          result += (this.getDaysRented() - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        result += this.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        result += 1.5;
        if (this.getDaysRented() > 3) {
          result += (this.getDaysRented() - 3) * 1.5;
        }
        break;
      default:
        break;

    }
    return result;
  }

  public int getFrequentRenterPoints() {
    // 客户租赁了新发布的电影且借期大于1, 添加多一个积分点
    if (getMovie().getPriceCode() == Movie.REGULAR && getDaysRented() > 1) {
      return 2;
    }
    return 1;
  }
}
