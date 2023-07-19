package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class ProductItemsList {

    private SelenideElement objectRoot;

    public ElementsCollection productList = objectRoot == null
            ? $$x(".//div[@class = 'inventory_list']//div[@class = 'inventory_item']")
            : objectRoot.$$x(".//div[@class = 'inventory_list']//div[@class = 'inventory_item']");


    public ProductItemsList() {

    }

    public ProductItemsList(@Nonnull SelenideElement objectRoot) {
        this.objectRoot = objectRoot;
    }

    /**
     * Список товаров на странице
     *
     * @return
     */
    public ArrayList<ProductItem> productItemsList() {//productItem список
        ArrayList<ProductItem> items = new ArrayList<>();

        ElementsCollection elements = $$x(".//div[@class = 'inventory_list']//div[@class = 'inventory_item']");
        for (SelenideElement el : elements) {
            items.add(new ProductItem(el));
        }

        return items;
    }


    public ProductItem selectRandItem() {
        return new ProductItem(productList.get(new Random().nextInt(productList.size())));
    }

    public List<ProductItem> selectFewRandomItems(int count) {
        if (count > productList.size()) {
            throw new IllegalArgumentException("Превышено количество запрашиваемых карточек на странице");
        }
        ArrayList<SelenideElement> result = new ArrayList<>(productList);

        while (result.size() != count) {
            result.remove(new Random().nextInt(result.size()));
        }

        return result.stream()
                .map(ProductItem::new)
                .collect(Collectors.toList());
    }
}
