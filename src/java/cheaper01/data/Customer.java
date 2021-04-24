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
   * 生成详情账单(文字)
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


  /**
   * 生成详情账单(html)
   *
   * @return 结果
   */
  public String statementHtml() {
    String result = "<h1>" + getName() + "的租赁记录" + "</h1>\n";
    for (Rental rental : rentals) {
      // 显示当前租赁所需的金额
      result += rental.getMovie().getTitle() + ":" + rental.getCharge() + "<br>\n";
    }
    result += "<p>您欠下的金额为" + getTotalCharge() + "</p>\n";
    result += "<p>您获得了" + getFrequentRenterPoints() + "积分点</p>";
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
