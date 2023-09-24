package com.se.unit5;

import java.util.StringJoiner;

/**
 * @description: TODO
 * @author LTMAX
 * @date 2023/9/14 15:58
 * @version 1.0
 */
public class SystemException extends RuntimeException{

    private ExceptionCode code;
    private Object[] args;

	public SystemException(){

	}

	public SystemException(ExceptionCode code, Object... args){
		this.args = args;
        this.code = code;
	}

	public SystemException(ExceptionCode code){
        this.code = code;
	}

    public ExceptionCode getExceptionCode(){
		return code;
	}

	public String getCodeMsg() {
		if (code == null) {
			return null;
		}
		return String.format(code.getMsg(),this.args);
	}

	@Override
	public String getMessage() {
		return toString();
	}

	@Override
	public String toString() {
		return new StringJoiner(",")
				.add("["+this.getClass().getSimpleName()+"]")
				.add("code = ["+ code +"]")
				.add("Msg=["+String.format(code.getMsg(),this.args)+"]")
				.toString();
	}
}