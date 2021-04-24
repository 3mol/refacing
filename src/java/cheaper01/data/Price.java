package cheaper01.data;

abstract class Price {
  abstract int getPriceCode();

  /**
   * 计算费用
   * 该函数都是与rental相关的, Customer相关性不强
   * 更新1: switch 的数据是与Movie相关, 应该移入到Movie
   * 更新2: 移动到Price类中
   * @param daysRented 借期
   * @return 金额
   */
  public abstract double getCharge(int daysRented);
}

class NewReleasePrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3;
  }
}

class RegularPrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.REGULAR;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2) {
      result += (daysRented - 2) * 1.5;
    }
    return result;
  }
}

class ChildrenPrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.CHILDRENS;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }
}
