package cheaper01.data;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  /**
   * 生成详情账单
   *
   * @return 结果
   */
  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = getName() + "的租赁记录\n";
    for (Rental rental : rentals) {
      double thisAmount = 0;
      // 确定每一个租赁的金额
      switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          thisAmount += 2;
          if (rental.getDaysRented() > 2) {
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
          }
          break;
        case Movie.NEW_RELEASE:
          thisAmount += rental.getDaysRented() * 3;
          break;
        case Movie.CHILDREN:
          thisAmount += 1.5;
          if (rental.getDaysRented() > 3) {
            thisAmount += (rental.getDaysRented() - 3) * 1.5;
          }
          break;
        default:
          throw new IllegalArgumentException("无效电影类型");
      }
      // 添加一个积分点
      frequentRenterPoints++;
      // 客户租赁了新发布的电影且借期大于1, 添加多一个积分点
      if (rental.getMovie().getPriceCode() == Movie.REGULAR && rental.getDaysRented() > 1) {
        frequentRenterPoints++;
      }
      // 显示当前租赁的
      result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
      totalAmount += thisAmount;
    }
    result += "您欠下的金额为" + totalAmount + "\n";
    result += "您获得了" + frequentRenterPoints + "积分点";
    return result;
  }
}
