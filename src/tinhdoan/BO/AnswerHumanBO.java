package tinhdoan.BO;

import tinhdoan.DAO.CallTheLib;

public class AnswerHumanBO {
	static CallTheLib callTheLib = new CallTheLib();
	public static String answerHuman(String human) {
		return callTheLib.answerHuman(human);
	}
	public static void start() {
		callTheLib.begin();
	}

}
