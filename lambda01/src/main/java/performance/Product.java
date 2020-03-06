package performance;

class Product {
    String name;    // 名称
    Integer stock;  // 库存
    Integer hot;    // 热度

    public Product(String name, Integer stock, Integer hot) {
        this.name = name;
        this.stock = stock;
        this.hot = hot;
    }
}