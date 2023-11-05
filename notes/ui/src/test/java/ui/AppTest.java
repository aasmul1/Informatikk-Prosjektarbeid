package ui;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;

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
}
