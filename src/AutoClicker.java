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
    If the screen resolution is NOT 1920x1080, 1280x720, or 1366x768,
    only the website is opened and the script does not run.
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

        try {
            // Gets resolution
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            /*
            Initializes the correct x and y to the coordinates of
            the center of the cookie on the cookie clicker
            website for 1920x1080 resolution
            and moves the mouse cursor to the center
            of the cookie
            */
            if(screenSize.getWidth() == 1920 && screenSize.getHeight() == 1080) {
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
                    Thread.sleep(30);
                }

                /*
                Clicks 1000 times after the cursor reaches
                the specified x and y coordinate.
                Uses Thread.sleep() to ensure the script clicks
                exactly 1000 times. Without Thread.sleep() of around
                15-20 ms in between clicks, some clicks do not go through
                and can even cause lag due to how fast it is clicking.
                Can be changed to any amount of clicks.
                */
                int t = 0;
                while(t < 1000){
                    bot.mousePress(click);
                    bot.mouseRelease(click);
                    t++;
                    Thread.sleep(20);
                }
            }
            /*
            Initializes the correct x and y to the coordinates of
            the center of the cookie on the cookie clicker
            website for 1280x720 resolution
            and moves the mouse cursor to the center
            of the cookie
            */
            else if(screenSize.getWidth() == 1280 && screenSize.getHeight() == 720) {
                Robot bot = new Robot();
                int xi, yi;
                int x = 560;
                int y = 415;
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
                    Thread.sleep(30);
                }

                /*
                Clicks 1000 times after the cursor reaches
                the specified x and y coordinate.
                Uses Thread.sleep() to ensure the script clicks
                exactly 1000 times. Without Thread.sleep() of around
                15-20 ms in between clicks, some clicks do not go through
                and can even cause lag due to how fast it is clicking.
                Can be changed to any amount of clicks
                */

                int t = 0;
                while(t < 1000){
                    bot.mousePress(click);
                    bot.mouseRelease(click);
                    t++;
                    Thread.sleep(20);
                }
            }
            /*
            Initializes the correct x and y to the coordinates of
            the center of the cookie on the cookie clicker
            website for 1366x768 resolution
            and moves the mouse cursor to the center
            of the cookie
            */
            else if(screenSize.getWidth() == 1366 && screenSize.getHeight() == 768) {
                Robot bot = new Robot();
                int xi, yi;
                int x = 515;
                int y = 400;
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
                    Thread.sleep(30);
                }

                /*
                Clicks 1000 times after the cursor reaches
                the specified x and y coordinate.
                Uses Thread.sleep() to ensure the script clicks
                exactly 1000 times. Without Thread.sleep() of around
                15-20 ms in between clicks, some clicks do not go through
                and can even cause lag due to how fast it is clicking.
                Can be changed to any amount of clicks.
                */
                int t = 0;
                while(t < 1000){
                    bot.mousePress(click);
                    bot.mouseRelease(click);
                    t++;
                    Thread.sleep(20);
                }
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
