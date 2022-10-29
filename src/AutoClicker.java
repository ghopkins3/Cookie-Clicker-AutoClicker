import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public final class AutoClicker {

    // click value set to mouse button 1
    final int click = InputEvent.BUTTON1_DOWN_MASK;

    /*
    Checks if Desktop class is supported on the
    current platform. If it is, the url
    is opened in the default browser.
     */
    private AutoClicker() {
        String url = "https://cookieclicker.one/cookie-clicker";

        // Opens default browser
        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        /*
        Initializes the x and y to the coordinates of
        the center of the cookie on the cookie clicker
        website and moves the mouse cursor to the center
        of the cookie
         */
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
            /*
            Clicks 1000 times after the cursor reaches
            the specified x and y coordinate.
            Uses Thread.sleep() to ensure the script clicks
            exactly 1000 times. Without Thread.sleep() of around
            <15 ms in between clicks, some clicks do not go through
            and can even cause lag due to how fast it is clicking.
             */
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

    // Instantiates AutoClicker and runs the script
    public static void main(String[] args) {
        new AutoClicker();
    }
}
