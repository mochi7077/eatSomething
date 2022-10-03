package maybe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;

public class map_st {

	public static void main(String[] args) {
		Engine engine = Engine.newInstance(
				EngineOptions.newBuilder(RenderingMode.OFF_SCREEN)
					.licenseKey("6P830J66YBR9UOVNIBPQSH0GKTC1IV0X3VD8V5436P1YPOV3HETIISY86XP07BWL24IC")
					.build());
		
		Browser browser = engine.newBrowser();
		
		browser.navigation().loadUrl("https://www.youtube.com/");
		
		System.setProperty("jxbrowser.license.key", "6P830J66YBR9UOVNIBPQSH0GKTC1IV0X3VD8V5436P1YPOV3HETIISY86XP07BWL24IC");
		
		engine.close();
		
//		SwingUtilities.invokeLater(() -> {
//			JFrame frame = new JFrame("mama");
//			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//			frame.setSize(1280,900);
//			frame.setLocationRelativeTo(null);
//			frame.setVisible(true);
//	});

}
}