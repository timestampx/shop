import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import elements.FilterElements;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CollectionPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CatalogFilter_Tests {

    CollectionPage collection = new CollectionPage();
    FilterElements filter = new FilterElements();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://shop.1-ofd.ru/collection";
    }

    @Test
    public void singleSearchResult_withPageObject() {
        String firstValue = "filter-value-15607579";

        collection.open();

        filter.clickValue(firstValue);
        filter.valueShouldBeChecked(firstValue);
        filter.shouldBeActive();

        collection.shouldHaveSize(1);
        collection.shouldHaveText("Фискальный накопитель на 15 месяцев");
    }

    @Test
    public void singleSearchResult_withoutPageObject() {
        open("https://shop.1-ofd.ru/collection/all");

        // Выбираем фильтр, проверяем чекбокс
        $("[for='filter-value-15607579']").click();
        $("[id='filter-value-15607579']").shouldBe(Condition.checked);
        $(".filter-item.is-active").shouldBe(Condition.enabled);

        // Проверяем результаты работы фильтра
        $$(".product_card--shadow").shouldHaveSize(1);
        $(".product_card--shadow").shouldHave(text("Фискальный накопитель на 15 месяцев"));
    }
}