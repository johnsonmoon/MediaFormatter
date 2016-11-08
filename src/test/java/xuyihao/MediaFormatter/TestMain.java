package xuyihao.MediaFormatter;

import xuyihao.formatter.invoker.executer.Executor;
import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.util.CommonUtils;

/**
 * 
 * @Author Xuyh created at 2016年11月8日 下午4:19:22
 *
 */
public class TestMain {
	private static Progress progress = null;
	private static int result = -1;

	public static void main(String... strings) {
		progress = Executor.cutoutVideo("C:\\Users\\Administrator\\Desktop\\test.mp4",
				"C:\\Users\\Administrator\\Desktop\\output.mp4", "00:01:36", "00:00:13");
		new Thread(new Runnable() {
			public void run() {
				while (result == -1) {
					CommonUtils.outputLine(progress.getProcessMessage());
				}
			}
		}).start();
		result = progress.waitFor();
	}
}
