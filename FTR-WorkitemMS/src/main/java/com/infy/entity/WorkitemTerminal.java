package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.WorkitemTerminalDTO;

@Entity
@Table(name="ftr_workitem_terminal")
public class WorkitemTerminal {
	@Id
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
	public WorkitemTerminal() {
		// TODO Auto-generated constructor stub
	}
	public static WorkitemTerminalDTO toDTO(WorkitemTerminal w) {
		return new WorkitemTerminalDTO(w.getWorkitemId(),w.getTerminalId());
	}
	public WorkitemTerminal(String workitemId, String terminalId) {
		super();
		this.workitemId = workitemId;
		this.terminalId = terminalId;
	}
	@Override
	public String toString() {
		return "WorkitemTerminal [workitemId=" + workitemId + ", terminalId=" + terminalId + "]";
	}
}
