package broker.share;

import java.util.ArrayList;

import broker.exception.DuplicateSSNException;
/*
 * status :: 
 * RecordNotFoundException : -1
 * InvalidTransactionException : -3    
 * DuplicateSSNException : -1
 * SQLException : -1
 */
public class Result extends ArrayList{
	private int status;
	
	public Result(){
		super(1);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
