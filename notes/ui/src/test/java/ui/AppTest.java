package ui;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;

public class AppTest extends ApplicationTest {

    @Start
    public void start(Stage stage) throws Exception {
        new App().start(stage);
    }

    @Test
    public void testLoginScreenLoaded() {
        assertThat(lookup("#loginButton").tryQuery()).isPresent();
        assertThat(lookup("#createUserButton").tryQuery()).isPresent();
        assertThat(lookup("#usernameInput").tryQuery()).isPresent();
        assertThat(lookup("#passwordInput").tryQuery()).isPresent();
        assertThat(lookup("#errorMessage").tryQuery()).isPresent();


    }

    @Test
    void testSupportHeadlessWhenHeadlessIsTrue() {
        // Arrange
        System.setProperty("headless", "true");

        // Act
        App.supportHeadless();

        // Assert
        assertEquals("glass", System.getProperty("testfx.robot"));
        assertEquals("true", System.getProperty("testfx.headless"));
        assertEquals("sw", System.getProperty("prism.order"));
        assertEquals("t2k", System.getProperty("prism.text"));
        assertEquals("true", System.getProperty("java.awt.headless"));

    }


    @AfterEach
    void tearDown() {
        System.clearProperty("testfx.robot");
        System.clearProperty("testfx.headless");
        System.clearProperty("prism.order");
        System.clearProperty("prism.text");
        // Be cautious about clearing "java.awt.headless" as it might affect other parts of the test suite.
    }
}
