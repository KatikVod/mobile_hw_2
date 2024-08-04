package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class OnboardingTests extends TestBase {

    @Test
    @DisplayName("Проверка флоу онбординга")
    void onboardingFlowTest() {
        step("Проверить заголовок первой страницы онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia\n…in over 300 languages"));
        });
        step("Проверить, что на первой странице онбординга отображается кнопка Add or edit languages", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).shouldHave(text("Add or edit languages"));
        });
        step("Перейти на следующую страницу онбординга по кнопке Continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить заголовок второй страницы онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });
        step("Перейти на следующую страницу онбординга по кнопке Continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить заголовок третьей страницы онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        });
        step("Перейти на следующую страницу онбординга по кнопке Continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить заголовок четвертой страницы онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Data & Privacy"));
        });
        step("Проверить, что на четвертой странице онбординга отображается кнопка Get started", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).shouldHave(text("Get started"));
        });
    }
}
