package xuyihao.formatter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Author Xuyh created at 2016年11月4日 下午2:20:41
 *
 */
public class CommonUtils {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * <pre>
	 * 线程阻塞milliseconds时间
	 * 
	 * 简化线程等待时间的方法
	 * </pre>
	 * 
	 * @param milliseconds
	 */
	public static void threadWait(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将一个命令行字串转换成列表（不含空格）
	 * 
	 * @param command
	 * @return
	 */
	public static List<String> generateCommand(String command) {
		List<String> commands = new ArrayList<String>();
		String[] cmdArray = command.split(" ");
		for (String cmd : cmdArray) {
			if (!cmd.equals("") && !cmd.equals(" ")) {
				commands.add(cmd);
			}
		}
		return commands;
	}

	/**
	 * 控制台输入一行字串
	 * 
	 * @return
	 */
	public static String inputLine() {
		String message = "";
		try {
			message = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * 控制台输出一行字串
	 * 
	 * @param message
	 */
	public static void outputLine(String message) {
		System.out.println(message);
	}
}
