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
    String result = getName() + "的租赁记录\n";
    for (Rental rental : rentals) {
      // 显示当前租赁所需的金额
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
    }
    result += "您欠下的金额为" + getTotalCharge() + "\n";
    result += "您获得了" + getFrequentRenterPoints() + "积分点";
    return result;
  }

  private int getFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental rental : rentals) {
      // 添加一个积分点
      frequentRenterPoints += rental.getFrequentRenterPoints();
    }
    return frequentRenterPoints;
  }

  /**
   * 以查询替换临时变量
   *
   * @return 总金额
   */
  private double getTotalCharge() {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += rental.getCharge();
    }
    return totalAmount;
  }

}
