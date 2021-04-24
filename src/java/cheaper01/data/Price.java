package cheaper01.data;

abstract class Price {
  abstract int getPriceCode();

  /**
   * 计算费用
   * 该函数都是与rental相关的, Customer相关性不强
   * 更新1: switch 的数据是与Movie相关, 应该移入到Movie
   * 更新2: 移动到Price类中
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
}

class NewReleasePrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }
}

class RegularPrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.REGULAR;
  }
}

class ChildrenPrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.CHILDRENS;
  }
}
