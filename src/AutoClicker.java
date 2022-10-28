import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public final class AutoClicker {

    final int click = InputEvent.BUTTON1_DOWN_MASK;

    private AutoClicker() {
        String url = "https://cookieclicker.one/cookie-clicker";

        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Robot bot = new Robot();
            int xi, yi;
            int x = 1032;
            int y = 425;
            Point p = MouseInfo.getPointerInfo().getLocation();
            xi = p.x;
            yi = p.y;
            int i = xi;
            int j = yi;
            while(i != x || j != y) {
                bot.mouseMove(i, j);
                if (i < x)
                    i++;
                if (j < y)
                    j++;
                if (i > x)
                    i--;
                if (j > y)
                    j--;
                Thread.sleep(3);
            }

            int t = 0;
            while(t < 1000){
                bot.mousePress(click);
                bot.mouseRelease(click);
                t++;
                Thread.sleep(15);
            }

        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new AutoClicker();
    }
}
