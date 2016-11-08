package xuyihao.MediaFormatter.executor;

import junit.framework.TestCase;
import xuyihao.formatter.invoker.executer.Executor;
import xuyihao.formatter.invoker.progress.Progress;

public class ExecutorTest extends TestCase {
	private static String desktopPath = "C:\\Users\\Administrator\\Desktop\\";
	private static String videoPathName = "C:\\Users\\Administrator\\Desktop\\test.mp4";

	public void test() {
		Executor.splitVideo(videoPathName, desktopPath + "split.mp4").waitFor();
		Executor.splitAudio(videoPathName, desktopPath + "split.mp3").waitFor();
		Executor.compoundVideoAndAudio(desktopPath + "split.mp4", desktopPath + "split.mp3", desktopPath + "combine.mp4")
				.waitFor();

		Executor.convertFromat(videoPathName, desktopPath + "convert.flv").waitFor();

		Executor.cutoutVideoForSingleImage(videoPathName, desktopPath + "cutout.jpg", 13.23f).waitFor();
		Executor.cutoutVideoForImageArray(videoPathName, desktopPath + "array", ".jpg", 0.5f);
		Executor.cutoutVideo(videoPathName, desktopPath + "cutout.mp4", "00:01:03", "00:00:26").waitFor();
		Executor.generateGIFImage(videoPathName, 0, 13, 488, 488, desktopPath + "gifkk.gif").waitFor();
		Executor.recordScreenForImage(0, 0, 1440, 900, desktopPath + "recordScreen.jpg").waitFor();
		Progress progress = Executor.recordScreenForImage(0, 0, 1440, 900, desktopPath + "recordScreen.mp4");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		progress.setProcessInput("q");
	}
}
