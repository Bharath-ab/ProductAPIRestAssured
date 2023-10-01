package productapi;

import productapi.pojo.Login;

public class Runner {
    public static void main(String[] args) {
        LoginRequest lr = new LoginRequest();
        lr.loginRequest("jatinvsharma@gmail.com","123123123");
        AddProduct ap = new AddProduct();
        ap.addProduct();
        SearchProduct sp =new SearchProduct();
        sp.searchProduct(ap.getId());
        UpdateProduct up = new UpdateProduct();
        up.updateProduct(ap.getId());
        sp.searchProduct(ap.getId());
        DeleteProduct dp = new DeleteProduct();
        dp.deleteProduct(ap.getId());

    }
}
