package xuyihao.formatter.invoker.executer;

import java.io.File;

import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.util.AppPropertiesLoader;
import xuyihao.formatter.util.CommonUtils;

/**
 * 封装各项操作命令
 * 
 * @Author Xuyh created at 2016年11月8日 下午2:49:03
 *
 */
public class Executor {
	public static final String ffmpegExecutorPathName = AppPropertiesLoader.getProperty("FFMPEG_EXECUTOR_PATHNAME");

	/**
	 * 分离视频中的视频
	 * 
	 * @param inputVideoPathName 需要分离视频的路径名
	 * @param outputVideoPathName 分离之后视频的路径名
	 * @return
	 */
	public static Progress splitVideo(String inputVideoPathName, String outputVideoPathName) {
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -vcodec copy -an " + outputVideoPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 分离视频中的音频
	 * 
	 * @param inputVideoPathName 需要分离的视频路径名
	 * @param outputAudioPathName 分离之后的音频路径名
	 * @return
	 */
	public static Progress splitAudio(String inputVideoPathName, String outputAudioPathName) {
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -vcodec copy -vn " + outputAudioPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 简单地转换视频格式
	 * 
	 * @param inputVideoPathName 输入视频路径名
	 * @param outputVideoPathName 输出视频路径名
	 * @return
	 */
	public static Progress convertFromat(String inputVideoPathName, String outputVideoPathName) {
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -ac 2 -r 29.97 " + outputVideoPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 截取视频中的某时间图像
	 * 
	 * @param inputVideoPathName 输入视频路径名
	 * @param outputImagePathName 输出图片路径名
	 * @param cutTime 截取时间
	 * @return
	 */
	public static Progress cutoutVideoForSingleImage(String inputVideoPathName, String outputImagePathName,
			float cutTime) {
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -y -f image2 -ss " + String.valueOf(cutTime)
				+ " " + outputImagePathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 截取视频图像（大量）
	 * 
	 * @param inputVideoPathName 输入视频路径名
	 * @param outputImagePath 输出图片的目录
	 * @param outputImageType 输出图片的后缀（如.jpg）
	 * @param cutoutRate 截图频率
	 * @return
	 */
	public static Progress cutoutVideoForImageArray(String inputVideoPathName, String outputImagePath,
			String outputImageType, float cutoutRate) {
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -r " + String.valueOf(cutoutRate)
				+ " -f image2 " + outputImagePath + File.separator + "image-%3d" + outputImageType;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 剪切视频
	 * 
	 * @param inputVideoPathName 输入视频路径名
	 * @param outputVideoPathName 输出视频路径名
	 * @param beginTime 开始时间（格式：00:00:00）
	 * @param lastTime 持续时间（格式：00:00:00）
	 * @return
	 */
	public static Progress cutoutVideo(String inputVideoPathName, String outputVideoPathName, String beginTime,
			String lastTime) {
		if (!beginTime.contains(":") || !lastTime.contains(":")) {
			return null;
		}
		String cmd = ffmpegExecutorPathName + " -ss " + beginTime + " -t " + lastTime + " -i " + inputVideoPathName
				+ " -vcodec copy -acodec copy " + outputVideoPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 合成视频
	 * 
	 * @param inputVideoPathName 输入视频路径名
	 * @param inputAudioPathName 输入音频路径名
	 * @param outputVideoPathName 输出视频路径名
	 * @return
	 */
	public static Progress compoundVideoAndAudio(String inputVideoPathName, String inputAudioPathName,
			String outputVideoPathName) {
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -i " + inputAudioPathName
				+ " -vcodec copy -acodec copy " + outputVideoPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 截屏
	 * 
	 * @param offsetX 屏幕开始位置坐标
	 * @param offsetY 屏幕开始位置坐标
	 * @param sizeX 截取屏幕大小
	 * @param sizeY 截取屏幕大小
	 * @param outputImagePathName 输出图片路径名
	 * @return
	 */
	public static Progress recordScreenForImage(int offsetX, int offsetY, int sizeX, int sizeY,
			String outputImagePathName) {
		String cmd = ffmpegExecutorPathName + " -f gdigrab -offset_x " + String.valueOf(offsetX) + " -offset_y "
				+ String.valueOf(offsetY) + " -video_size " + String.valueOf(sizeX) + "*" + String.valueOf(sizeY)
				+ " -i desktop " + outputImagePathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 屏幕录制
	 * 
	 * @param frameRate 帧率
	 * @param offsetX 屏幕开始位置坐标
	 * @param offsetY 屏幕开始位置坐标
	 * @param sizeX 截取屏幕大小
	 * @param sizeY 截取屏幕大小
	 * @param outputVideoPathName 输出视频路径名
	 * @return
	 */
	public static Progress recordScreenForVideo(int frameRate, int offsetX, int offsetY, int sizeX, int sizeY,
			String outputVideoPathName) {
		String cmd = ffmpegExecutorPathName + " -f gdigrab -framerate " + frameRate + " -offset_x "
				+ String.valueOf(offsetX) + " -offset_y " + String.valueOf(offsetY) + " -video_size " + String.valueOf(sizeX)
				+ "*" + String.valueOf(sizeY) + " -i desktop " + outputVideoPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}

	/**
	 * 截取制作GIF动图
	 * 
	 * @param inputVideoPathName 输入视频路径名
	 * @param beginTime 开始时间（s）
	 * @param lastTime 持续时间（s）
	 * @param sizeX 截取尺寸
	 * @param sizeY 截取尺寸
	 * @param outputGIFPathName 输出GIF路径名
	 * @return
	 */
	public static Progress generateGIFImage(String inputVideoPathName, int beginTime, int lastTime, int sizeX, int sizeY,
			String outputGIFPathName) {
		if (!outputGIFPathName.endsWith(".gif")) {
			return null;
		}
		String cmd = ffmpegExecutorPathName + " -i " + inputVideoPathName + " -ss " + String.valueOf(beginTime) + " -t "
				+ String.valueOf(lastTime) + " -s " + String.valueOf(sizeX) + "*" + String.valueOf(sizeY) + " -pix_fmt rgb24 "
				+ outputGIFPathName;
		return CommonExecutor.executeAndReturn(CommonUtils.generateCommand(cmd));
	}
}
