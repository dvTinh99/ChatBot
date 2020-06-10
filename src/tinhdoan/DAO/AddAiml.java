package tinhdoan.DAO;

import org.alicebot.ab.Bot;
import org.alicebot.ab.MagicBooleans;

public class AddAiml {

	private static final boolean TRACE_MODE = false;
	static String botName = "javid";

	public static void main(String[] args) {
		try {

			String resourcesPath = "D:/ab";
			System.out.println(resourcesPath);
			MagicBooleans.trace_mode = TRACE_MODE;
			Bot bot = new Bot(botName, resourcesPath);
			bot.writeAIMLFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}