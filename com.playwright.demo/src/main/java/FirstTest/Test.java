package FirstTest;

import java.nio.file.Path;
import java.nio.file.Paths;
// import java.time.Duration;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		try(Playwright playwright = Playwright.create())
		{
			Browser browser = 
					playwright
					.chromium()
					.launch(
							new BrowserType
							.LaunchOptions()
							.setHeadless(false)
							.setArgs(List.of("--start-maximized"))
							);
			BrowserContext context = browser.newContext(
					new Browser
					.NewContextOptions()
					.setViewportSize(null)
					.setRecordVideoDir(Paths.get("./VideoPOT")));
//			BrowserContext context2 = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
//			Page page = context.newPage(); 
			Page page2 = context.newPage();
//			Page page3 = context.newPage();
//			Page page4 = context.newPage();
//					browser.newPage();
//			page.navigate("https://playwright.dev");
//			page.waitForLoadState();
			page2.navigate("https://qa.digitalclaims.nprd.aig.com/");
			page2.waitForLoadState();
			
			String title = page2.title();
			System.out.println("Title of the page: "+title);
			String url = page2.url();
			System.out.println("Url of the page: "+url);
			
			Locator heading = page2.locator("h1.title");
			String headingText = heading.innerText();
			System.out.println("Heading of the page: "+headingText);
			
			Locator logo = page2.getByAltText("AIG logo");
			System.out.println("AIG logo displayed?: "+logo.isVisible());
			System.out.println("AIG logo src: "+logo.getAttribute("src"));
			//			page3.navigate("https://www.facebook.com");
//			page.waitForLoadState();
//			page4.navigate("https://be.cognizant.com");
//			page.waitForLoadState();
//			Page page5 = browser.newPage();
//					page5.navigate("https://www.youtube.com");
//			page5.waitForLoadState();
//			Page page6 = context2.newPage();
//					page6.navigate("https://www.hyrtutorials.com");
//					page6.waitForLoadState();
			// Thread.sleep(Duration.ofSeconds(10));
		}
	}
}
