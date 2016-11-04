package xuyihao.formatter.invoker.executer.common;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @Author Xuyh created at 2016年11月4日 下午4:14:07
 *
 */
public class CommonExecutor {
	/**
	 * 调用进程执行操作
	 * 
	 * @param commands
	 * @return
	 */
	public static boolean execute(List<String> commands) {
		boolean flag = true;
		ProcessBuilder builder = new ProcessBuilder(commands);
		try {
			builder.start();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
