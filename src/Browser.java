import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browser extends Frame implements ActionListener {

    static Robot bot;

    static {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    static int mask = InputEvent.BUTTON1_DOWN_MASK;

    public Browser() {
        String url = "https://cookieclicker.one/cookie-clicker";

        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Browser();
        bot.mouseMove(100,100);
        bot.mouseMove(100, 0);
        bot.mouseMove(100, 0);
        bot.mouseMove(100, 0);
        bot.mouseMove(100, 0);
        bot.mouseMove(100, 0);
        bot.mouseMove(100, 0);
        bot.mousePress(mask);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
