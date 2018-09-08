package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="loctab")
public class Location {
@Id
@Column(name="lid")
private int locId;
@Column(name="lname")
private String locName;
@Column(name="lcode")
private String locCode;
@Column(name="lType")
private String locType;
@Column(name="ldesc")
private String locDesc;

public Location() {
	super();
}
public Location(int locId, String locName, String locCode, String locType,
		String locDesc) {
	super();
	this.locId = locId;
	this.locName = locName;
	this.locCode = locCode;
	this.locType = locType;
	this.locDesc = locDesc;
}
@Override
public String toString() {
	return "Location [locId=" + locId + ", locName=" + locName + ", locCode="
			+ locCode + ", locType=" + locType + ", locDesc=" + locDesc + "]";
}
public int getLocId() {
	return locId;
}
public void setLocId(int locId) {
	this.locId = locId;
}
public String getLocName() {
	return locName;
}
public void setLocName(String locName) {
	this.locName = locName;
}
public String getLocCode() {
	return locCode;
}
public void setLocCode(String locCode) {
	this.locCode = locCode;
}
public String getLocType() {
	return locType;
}
public void setLocType(String locType) {
	this.locType = locType;
}
public String getLocDesc() {
	return locDesc;
}
public void setLocDesc(String locDesc) {
	this.locDesc = locDesc;
}
public Location(int locId) {
	super();
	this.locId = locId;
}


}	