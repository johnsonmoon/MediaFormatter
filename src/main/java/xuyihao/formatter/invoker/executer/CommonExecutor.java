package xuyihao.formatter.invoker.executer;

import java.util.List;

import xuyihao.formatter.invoker.progress.Progress;

/**
 * 
 * @Author Xuyh created at 2016年11月4日 下午4:14:07
 *
 */
public class CommonExecutor {
	/**
	 * 调用进程执行操作(阻塞)
	 * 
	 * @param commands
	 * @return
	 */
	public static boolean execute(List<String> commands) {
		Progress progress = new Progress(commands);
		progress.startProcess();
		int result = progress.waitFor();
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 调用进程执行并返回进程对象
	 * 
	 * @param commands
	 * @return
	 */
	public static Progress executeAndReturn(List<String> commands) {
		Progress progress = new Progress(commands);
		progress.startProcess();
		return progress;
	}
}
