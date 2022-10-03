package meow;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

public class mainMap extends JFrame{

//    private static final int MIN_ZOOM = 0;
//    private static final int MAX_ZOOM = 21;
//    private static final double lng = 24.156848810260875;
//    private static final double lat = 120.64589564646003;
//    private static final String setMarkerScript =
//            "var myLatlng = new google.maps.LatLng(" + lng + ", " + lat + ");\n" +
//                    "var marker = new google.maps.Marker({\n" +
//                    "    position: myLatlng,\n" +
//                    "    map: map,\n" +
//                    "    title: 'Hello World!'\n" +
//                    "});";
    private int MIN_ZOOM;
    private int MAX_ZOOM;
    private double lng;
    private double lat;
    private String setMarkerScript;

    /**
     * In map.html file default zoom value is set to 4.
     */
    private static int zoomValue = 4;

    public mainMap(double lng, double lat) {
    	MIN_ZOOM = 0; MAX_ZOOM = 21;
//    	lng = 24.156848810260875;
//    	lat = 120.64589564646003;
    	this.lng = lng;
    	this.lat = lat;
    	String setMarkerScript =
                "var myLatlng = new google.maps.LatLng(" + lng + ", " + lat + ");\n" +
                        "var marker = new google.maps.Marker({\n" +
                        "    position: myLatlng,\n" +
                        "    map: map,\n" +
                        "    title: 'Hello World!'\n" +
                        "});";
    	

//    	setSize(640, 480);
//        this.setVisible(true);
        
        System.setProperty("jxbrowser.license.key", "1BNDHFSC1G3YR3GDVERNL2SZFZTXPQC7E0L106TS2XUP36P6BOZTIIV8QQIGMPA4MWZEGT");

        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1G3YR3GDVERNL2SZFZTXPQC7E0L106TS2XUP36P6BOZTIIV8QQIGMPA4MWZEGT").build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JButton zoomInButton = new JButton("Zoom In");
            zoomInButton.addActionListener(e -> {
                if (zoomValue < MAX_ZOOM) {
                    browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript("map.setZoom(" +
                                    ++zoomValue + ")"));
                }
            });

            JButton zoomOutButton = new JButton("Zoom Out");
            zoomOutButton.addActionListener(e -> {
                if (zoomValue > MIN_ZOOM) {
                    browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript("map.setZoom(" +
                                    --zoomValue + ")"));
                }
            });

            JButton setMarkerButton = new JButton("Set Marker");
            setMarkerButton.addActionListener(e ->
                    browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript(setMarkerScript)));

            JPanel toolBar = new JPanel();
            toolBar.add(zoomInButton);
            toolBar.add(zoomOutButton);
            toolBar.add(setMarkerButton);

            JFrame frame = new JFrame("Google Maps");
            frame.add(toolBar, BorderLayout.SOUTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setVisible(true);

//            browser.navigation().loadUrl("C:\\Users\\minim\\eclipse-workspace\\Food\\src\\meow\\mainMaps.html");
//            System.out.println(System.getProperty("user.dir"));  
            browser.navigation().loadUrl(System.getProperty("user.dir") + "\\src\\meow\\mainMaps.html");
            
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        });
    }


//    public static void main(String[] args) {
//        new mainMap();
//        //license_key replace to your license key
//	
//        
//    }
}