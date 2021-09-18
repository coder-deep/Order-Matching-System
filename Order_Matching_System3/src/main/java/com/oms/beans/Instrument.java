package com.oms.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="instrument")
public class Instrument {
	@Id
	String instrument_id;
	String instrument_name;
	@Column(nullable=true)
	Double face_value;
	@Column(nullable=true)
	Date expiry_date;
	int min_quantity;
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getInstrument_name() {
		return instrument_name;
	}
	public void setInstrument_name(String instrument_name) {
		this.instrument_name = instrument_name;
	}
	public Double getFace_value() {
		return face_value;
	}
	public void setFace_value(Double face_value) {
		this.face_value = face_value;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getMin_quantity() {
		return min_quantity;
	}
	public void setMin_quantity(int min_quantity) {
		this.min_quantity = min_quantity;
	}
	@Override
	public String toString() {
		return "Instrument [instrument_id=" + instrument_id + ", instrument_name=" + instrument_name + ", face_value="
				+ face_value + ", expiry_date=" + expiry_date + ", min_quantity=" + min_quantity + "]";
	}
	public Instrument(String instrument_id, String instrument_name, Double face_value, Date expiry_date,
			int min_quantity) {
		super();
		this.instrument_id = instrument_id;
		this.instrument_name = instrument_name;
		this.face_value = face_value;
		this.expiry_date = expiry_date;
		this.min_quantity = min_quantity;
	}
	public Instrument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
