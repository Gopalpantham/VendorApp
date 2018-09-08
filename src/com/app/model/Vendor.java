package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventab")
public class Vendor {
	@Id
	@Column(name="vid")
	private int venId;
	@Column(name="vcode")
	private String venCode;
	@Column(name="vname")
	private String venName;
	@Column(name="vtype")
	private String venType;
	@Column(name="vaddr")
	private String venAddr;
	@Column(name="vidtype")
	private String venIdType;
	@Column(name="vidnum")
	private String venIdNum;
    @Column(name="vDsc")
	private String venDsc;
	public Vendor() {
		super();
	}
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenType() {
		return venType;
	}
	public void setVenType(String venType) {
		this.venType = venType;
	}
	public String getVenAddr() {
		return venAddr;
	}
	public void setVenAddr(String venAddr) {
		this.venAddr = venAddr;
	}
	public String getVenIdType() {
		return venIdType;
	}
	public void setVenIdType(String venIdType) {
		this.venIdType = venIdType;
	}
	public String getVenIdNum() {
		return venIdNum;
	}
	public void setVenIdNum(String venIdNum) {
		this.venIdNum = venIdNum;
	}
	public String getVenDsc() {
		return venDsc;
	}
	public void setVenDsc(String venDsc) {
		this.venDsc = venDsc;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName="
				+ venName + ", venType=" + venType + ", venAddr=" + venAddr
				+ ", venIdType=" + venIdType + ", venIdNum=" + venIdNum
				+ ", venDsc=" + venDsc + "]";
	}
    
    
}