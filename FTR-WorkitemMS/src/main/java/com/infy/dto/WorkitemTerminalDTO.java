package com.infy.dto;

import com.infy.entity.WorkitemTerminal;

public class WorkitemTerminalDTO {
	String workitemId;
	String terminalId;
	public String getWorkitemId() {
		return workitemId;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public WorkitemTerminalDTO() {
		// TODO Auto-generated constructor stub
	}
	public static WorkitemTerminal toEntity(WorkitemTerminalDTO w) {
		return new WorkitemTerminal(w.getWorkitemId(),w.getTerminalId());
	}
	public WorkitemTerminalDTO(String workitemId, String terminalId) {
		super();
		this.workitemId = workitemId;
		this.terminalId = terminalId;
	}
	@Override
	public String toString() {
		return "WorkitemTerminal [workitemId=" + workitemId + ", terminalId=" + terminalId + "]";
	}
}
