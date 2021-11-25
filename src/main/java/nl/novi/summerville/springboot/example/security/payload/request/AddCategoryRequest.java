package nl.novi.summerville.springboot.example.security.payload.request;

public class AddCategoryRequest {
    private long categoryId;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
