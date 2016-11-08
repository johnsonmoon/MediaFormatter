package xuyihao.MediaFormatter.progress;

import java.util.List;

import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.util.CommonUtils;

/**
 * 测试Progress类的可行性
 * 
 * @Author Xuyh created at 2016年11月7日 下午3:18:35
 *
 */
public class ProgressTest {
	private static Progress progress = null;
	private static String input = "";

	public static void main(String[] args) throws Exception {
		testHeavy();
	}

	public static void testHeavy() {
		CommonUtils.outputLine("Input your command to start a sub-progress.");
		String cmd = CommonUtils.inputLine();
		List<String> commands = CommonUtils.generateCommand(cmd);
		progress = new Progress(commands);
		progress.startProcess();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					if (input.equals("quit")) {
						progress.stopProcess();
						break;
					}
					try {
						CommonUtils.outputLine(progress.getProcessMessage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		while(true) {
			CommonUtils.outputLine("Input \"exit\" to stop outputing message. Input \"quit\" to exit the program");
			input = CommonUtils.inputLine();
			if(input.equals("exit")){
				break;
			}
		}
	}
}
