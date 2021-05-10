package cloud.autotests.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static cloud.autotests.helpers.DriverHelper.getConsoleLogs;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTests extends TestBase {
    @Test
    @Description("Implemented by QA.GURU engineers")
    @DisplayName("Youtube search test")
    void generatedTest() {
        step("Open 'http://www.youtube.com/'", () -> {
            open("http://www.youtube.com/");
        });
        step("Input search query 'Selenide'", () -> {
            $("button[aria-label='Agree to the use of cookies and other data for the purposes described']").click();
            $("[name='search_query']").click();
            $("input[id = 'search']").setValue("selenide");
        });
        step("Press 'search' icon", () -> {
            $("#search-icon-legacy").click();
        });
        step("Verify that in URL exists search query", () -> {
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals(currentUrl, "https://www.youtube.com/results?search_query=selenide");
        });
    }
}