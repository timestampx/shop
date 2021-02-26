package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;


public class CollectionPage {

    private final ElementsCollection elements = $$(".product_card--shadow");

    public CollectionPage open() {
        Selenide.open("/all");
        return this;
    }

    public CollectionPage shouldHaveSize(int size) {
        elements.shouldHaveSize(size);
        return this;
    }

    public CollectionPage shouldHaveText(String text) {
        elements.shouldHave(texts(text));
        return this;
    }
}