package xuyihao.formatter;

import xuyihao.formatter.util.CommonUtils;

/**
 * 
 * @Author Xuyh created at 2016年11月4日 下午3:30:37
 *
 */
public class App {
	public static void main(String[] args) {
		String command = CommonUtils.inputLine();
		for (String cmd : CommonUtils.generateCommand(command)) {
			CommonUtils.outputLine(cmd);
		}
	}
}
