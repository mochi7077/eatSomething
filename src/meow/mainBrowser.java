package meow;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;


public final class mainBrowser extends JFrame{
	public mainBrowser(){
		System.setProperty("jxbrowser.license.key", "1BNDHFSC1G3YR3GDVERNL2SZFZTXPQC7E0L106TS2XUP36P6BOZTIIV8QQIGMPA4MWZEGT");

        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1G3YR3GDVERNL2SZFZTXPQC7E0L106TS2XUP36P6BOZTIIV8QQIGMPA4MWZEGT").build();
        Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);

        Browser browser = engine.newBrowser();
        // Loading the required web page
        browser.navigation().loadUrl("https://www.ubereats.com/");

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame
            JFrame frame = new JFrame("Ubereats");
            // Closing the engine when app frame is about to close
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
		
	}
	
}
