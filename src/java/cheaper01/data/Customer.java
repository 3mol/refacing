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
      // 添加一个积分点
      frequentRenterPoints += rental.getFrequentRenterPoints();
      // 显示当前租赁的
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
      totalAmount += rental.getCharge();
    }
    result += "您欠下的金额为" + totalAmount + "\n";
    result += "您获得了" + frequentRenterPoints + "积分点";
    return result;
  }

}
