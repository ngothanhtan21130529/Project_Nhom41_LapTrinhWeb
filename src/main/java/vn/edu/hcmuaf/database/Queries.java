package vn.edu.hcmuaf.database;

public class Queries {
    public static final String GET_ALL_CATEGORIES = "SELECT categories.id, categories.category_name, categories.created_at, categories.updated_at, categories.deleted_at, categories.status, images.img_url FROM categories JOIN images ON categories.img_id = images.id";
    public static final String GET_CATEGORY_NAMES = "SELECT category_name FROM categories";
    public static final String GET_IMAGE_BY_ID = "SELECT img_url FROM images WHERE id = ?";
    public static final String GET_LIST_PRODUCTS_WITH_IMAGE = "SELECT p.id, p.category_id, p.product_name, p.price, p.status, i.img_url, p.sale, p.hot, p.description, p.created_at, p.updated_at, p.deleted_at, p.color, p.weight, p.opacity, p.size, p.cutting_grinding_type, p.material FROM products p JOIN images i ON p.thumbnail_id = i.id";
    public static final String GET_INVENTORIES = "SELECT id, product_id, quantity FROM inventories";
    public static final String GET_lIST_JEWELRY = "SELECT p.product_name, p.price, p.status, i.img_url, p.id FROM products p, categories c, images i WHERE p.category_id = c.id AND p.thumbnail_id = i.id AND c.category_name = 'Jewelry'";
    public static final String GET_PRODUCT_BY_ID = "SELECT p.id, p.category_id, p.product_name, p.price, p.status, i.img_url, p.sale, p.hot, p.description, p.created_at, p.updated_at, p.deleted_at, p.color, p.weight, p.opacity, p.size, p.cutting_grinding_type, p.material FROM products p JOIN images i ON p.thumbnail_id = i.id WHERE p.id = ?";
    public static final String GET_LIST_PRODUCT_IMAGE_BY_ID = "SELECT p.product_name, i.img_url, i.image_name FROM products p JOIN images i ON p.product_name = i.image_name WHERE p.id = ?";
    public static final String GET_PRODUCT_CATEGORY_NAME_BY_ID = "SELECT c.category_name FROM categories c JOIN products p ON p.category_id = c.id WHERE p.id = ?";
    public static final String GET_LIST_PRODUCT_WITH_IMAGE_BY_CATEGORY_ID = "SELECT p.category_id, i.img_url, p.id, p.product_name, p.price, p.status, i.img_url FROM products p JOIN images i ON p.thumbnail_id = i.id WHERE p.category_id = 2";
    public  static  final  String GETLISIST_PRODUCT_NOT_JEWELRY = "SELECT p.id, p.product_name, p.price, p.status, i.img_url FROM products p JOIN images i ON p.thumbnail_id = i.id WHERE p.category_id <> 1;";
    public static final String GET_CATEGORIES_WITH_IMAGES = "SELECT c.id as category_id, c.category_name, i.img_url FROM categories c JOIN images i ON c.img_id = i.id;";

}