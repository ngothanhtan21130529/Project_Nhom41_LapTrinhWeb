package vn.edu.hcmuaf.database;

public class Queries {
    public static final String GET_ALL_CATEGORIES = "SELECT categories.id, categories.category_name, categories.created_at, categories.updated_at, categories.deleted_at, categories.status, images.img_url FROM categories JOIN images ON categories.img_id = images.id";
    public static final String GET_CATEGORY_NAMES = "SELECT category_name FROM categories";
    public static final String GET_IMAGE_BY_ID = "SELECT img_url FROM images WHERE id = ?";
    public static final String GET_LIST_PRODUCTS = "SELECT p.id, p.product_name, p.price, p.status, i.img_url, inv.quantity FROM products p JOIN images i ON p.thumbnail_id = i.id LEFT JOIN inventories inv ON p.id = inv.product_id";
}
