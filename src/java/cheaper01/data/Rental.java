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
   * 更新1: switch 的数据是与Movie相关, 应该移入到Movie
   *
   * @return 金额
   */
  public double getCharge() {
    return movie.getCharge(daysRented);
  }

  /**
   * 更新1: 移动到movie相关的类中, 因为if中含有getMovie()#getPriceCode,导致该类的内聚度低
   * @return
   */
  public int getFrequentRenterPoints() {
    return movie.getFrequentRenterPoints(daysRented);
  }
}
