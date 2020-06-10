package tinhdoan.DAO;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

public class CallTheLib {
	
	public static void main(String[] args) {
		CallTheLib callTheLib = new CallTheLib();
		callTheLib.begin();
		callTheLib.answerHuman("phí giữ chỗ là bao nhiêu?");
	}
	private static final boolean TRACE_MODE = false;
	Bot bot; 
	Chat chatSession ;
	public void begin() {
		String botname="javid"; 
		String path="D:/ab"; 
		
		try {
			MagicBooleans.trace_mode = TRACE_MODE;
			bot = new Bot(botname, path);
			chatSession = new Chat(bot);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
		
	}
	public String  answerHuman(String human) {
		// TODO Auto-generated method stub
		String response = "" ;
		System.out.println(human);
		try {
				if ((human == null) || (human.length() < 1))
					human = MagicStrings.null_input;
				if (human.equals("q")) {
					System.exit(0);
				} else if (human.equals("wq")) {
					bot.writeQuit();
					System.exit(0);
				} else {
					if (MagicBooleans.trace_mode)
					System.out.println("STATE=" + human + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
					response = chatSession.multisentenceRespond(human);
					while (response.contains("&lt;"))
						response = response.replace("&lt;", "<");
					while (response.contains("&gt;"))
						response = response.replace("&gt;", ">");
					System.out.println("Robot : " + response);
					
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response ;
	}

}
