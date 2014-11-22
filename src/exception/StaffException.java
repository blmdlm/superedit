package exception;

import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * 
 *@Project superedit 
 *@ClassName StaffException
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年11月22日 下午9:29:41
 */
public class StaffException extends RuntimeException{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StaffException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StaffException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StaffException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StaffException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StaffException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



}
