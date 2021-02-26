package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FilterElements {

    private String checkboxSelector = "[for=%s]";
    private SelenideElement filterIsActiveSelector = $(".filter-item.is-active");

    // Нажимаем на чекбокс фильтра по значению value
    public FilterElements clickValue(String value) {
        String checkbox = String.format(checkboxSelector, value);
        $(checkbox).click();
        return this;
    }

    // Проверяем, что чекбокс выделен
    public FilterElements ValueShouldBeChecked(String value) {
        $(By.id(value)).shouldBe(Condition.checked);
        return this;
    }

    // Проверяем, что фильтр активен (есть выбранный чекбокс)
    public FilterElements ShouldBeActive() {
        $(filterIsActiveSelector).shouldBe(Condition.enabled);
        return this;
    }
}