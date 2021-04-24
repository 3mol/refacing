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

}
