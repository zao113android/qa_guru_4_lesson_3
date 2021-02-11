package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FindJunit5Test {

    @Test
    void junit5ExistsInSelenideWiki() {
        // Open Github
        // Type Selenide in search
        // Find Selenide/Selenide
        open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $(".repo-list a").click();
        $("h1").shouldHave(text("selenide / selenide"));

        // Find Wiki on the page
        // Open Wiki
        $("nav", 1).$(byText("Wiki")).click();
        $("#wiki-wrapper").$("h1").shouldHave(text("Home"));

        // Find the Pages list
        // Find SoftAssertions
        // Open SoftAssertions
        $(("div.wiki-rightbar")).$(byText("SoftAssertions")).click();
        $("#wiki-wrapper").$("h1").shouldHave(text("SoftAssertions"));

        // Find any example of Junit5
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
