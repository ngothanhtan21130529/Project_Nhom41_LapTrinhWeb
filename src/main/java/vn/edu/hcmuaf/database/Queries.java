package vn.edu.hcmuaf.database;

public class Queries {
    public static final String GET_ALL_CATEGORIES = "SELECT categories.id, categories.category_name, categories.created_at, categories.updated_at, categories.deleted_at, categories.status, images.img_url FROM categories JOIN images ON categories.img_id = images.id";
    public static final String GET_CATEGORY_NAMES = "SELECT category_name FROM categories";
    public static final String GET_IMAGE_BY_ID = "SELECT img_url FROM images WHERE id = ?";
    public static final String GET_LIST_PRODUCTS_WITH_IMAGE = "SELECT p.id, p.category_id, p.product_name, p.price, p.status, i.img_url, p.sale, p.hot, p.description, p.created_at, p.updated_at, p.deleted_at, p.color, p.weight, p.opacity, p.size, p.cutting_grinding_type, p.material FROM products p JOIN images i ON p.thumbnail_id = i.id";
    public static final String GET_INVENTORIES = "SELECT id, product_id, quantity FROM inventories";

}
