package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class findCodeJunit5Test {

    @Test
    void junit5EsixtsInSelenideWiki() {

        // Open Github
        // Type Selenide in search
        // Find Selenide/Selenide
        open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h1").shouldHave(text("selenide / selenide"));

        // Find Wiki on the page
        // Open Wiki
        $("nav", 1).$("ul").$("li", 4).$("a").click();
        $("#wiki-wrapper").$("h1").shouldHave(text("Home"));

        // Find the Pages list
        // Find SoftAssertions
        // Open SoftAssertions
        $(("div.wiki-rightbar")).$("ul").$$("li").filterBy(text("SoftAssertions")).first().click();
        $("#wiki-wrapper").$("h1").shouldHave(text("SoftAssertions"));

        // Find any example of Junit5
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
