package xuyihao.formatter.invoker.progress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * 执行外部进程输入流获取外部进程进度信息类
 * 
 * @Author Xuyh created at 2016年11月7日 上午9:45:43
 *
 */
public class Progress {
	private ProcessBuilder builder = null;
	private Process process = null;
	private BufferedReader reader = null;
	private BufferedReader errorReader = null;
	private OutputStreamWriter writer = null;

	public Progress(List<String> cmds) {
		this.builder = new ProcessBuilder(cmds);
	}

	/**
	 * 开启进程
	 * 
	 * @return
	 */
	public boolean startProcess() {
		boolean flag = true;
		if (builder != null && process == null) {
			try {
				process = builder.start();
			} catch (IOException e) {
				e.printStackTrace();
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * 停止子进程
	 *
	 * @return
	 */
	public boolean stopProcess() {
		boolean flag = true;
		if (process != null) {
			process.destroy();
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * 阻塞等待
	 *
	 * @return 0 代表子进程正常退出
	 */
	public int waitFor() {
		int result = -1;
		try {
			if (process != null) {
				result = process.waitFor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 关闭与子进程的输入输出流
	 *
	 * @return
	 */
	public boolean closeStream() {
		boolean flag = true;
		try {
			if (reader != null) {
				reader.close();
			}
			if (errorReader != null) {
				errorReader.close();
			}
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	/**
	 * 获取进程输入流并返回信息
	 * 
	 * @return
	 */
	public String getProcessMessage() {
		String message = "";
		if (process != null) {
			if (reader == null) {
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			}
			try {
				message = reader.readLine();
				if (message == null || message.equals("null")) {
					message = "Sub process output null.";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	/**
	 * 获取子进程错误信息并返回
	 *
	 * @return
	 */
	public String getErrorMessage() {
		String message = "";
		if (process != null) {
			if (errorReader == null) {
				errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			}
			try {
				message = errorReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	/**
	 * 向子进程输入信息
	 *
	 * @param message
	 */
	public boolean setProcessInput(String message) {
		boolean flag = true;
		if (process != null) {
			if (writer == null) {
				writer = new OutputStreamWriter(process.getOutputStream());
			}
			try {
				writer.write(message);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
}
