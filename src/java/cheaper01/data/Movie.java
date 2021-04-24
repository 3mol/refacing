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
  public static final int CHILDREN = 2;
  /**
   * 类型 新发布
   */
  public static final int NEW_RELEASE = 1;

  public Movie(String title, int priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  /**
   * 计算费用
   * 该函数都是与rental相关的, Customer相关性不强
   * 更新1: switch 的数据是与Movie相关, 应该移入到Movie
   * 更新2: 移动到Price类当中
   * @return 金额
   */
  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
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

  private Price price;

  public void setPriceCode(int priceCode) {
    switch (priceCode) {
      case REGULAR:
        price = new RegularPrice();
        break;
      case NEW_RELEASE:
        price = new NewReleasePrice();
        break;
      case CHILDRENS:
        price = new ChildrenPrice();
        break;
      default:
        throw new IllegalArgumentException("无效参数");
    }
  }

  public int getFrequentRenterPoints(int daysRented) {
    // 客户租赁了新发布的电影且借期大于1, 添加多一个积分点
    return price.getFrequentRenterPoints(daysRented);
  }
}

