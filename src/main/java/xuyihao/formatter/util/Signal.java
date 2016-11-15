package xuyihao.formatter.util;

/**
 * <pre>
 * 信号量
 * 
 * 判断线程是否执行完成
 * </pre>
 * 
 * @Author Xuyh created at 2016年11月15日 下午12:48:56
 *
 */
public class Signal {
	/**
	 * 状态码:就绪
	 */
	public static int STATE_READY = 1;

	/**
	 * 状态码:执行中
	 */
	public static int STATE_RUNNING = 2;

	/**
	 * 状态码:发生错误
	 */
	public static int STATE_ERROR = -1;

	/**
	 * 状态码:正常结束
	 */
	public static int STATE_END = 0;

	private int state;

	public Signal() {
		state = STATE_READY;
	}

	/**
	 * 就绪
	 */
	public void ready() {
		state = STATE_READY;
	}

	/**
	 * 执行中
	 */
	public void running() {
		state = STATE_RUNNING;
	}

	/**
	 * 发生错误
	 */
	public void error() {
		state = STATE_ERROR;
	}

	/**
	 * 正常结束
	 */
	public void end() {
		state = STATE_END;
	}

	/**
	 * 设置结果
	 * 
	 * <pre>
	 * 如果结果码与正常结束码不同就是error
	 * </pre>
	 * 
	 * @param result 结果编码
	 * @param normalEndCode 正常结束的编码
	 */
	public void setResult(int result, int normalEndCode) {
		if (result == normalEndCode) {
			end();
		} else {
			error();
		}
	}

	/**
	 * 获取现在的状态
	 * 
	 * @return
	 */
	public int getState() {
		return state;
	}
}
