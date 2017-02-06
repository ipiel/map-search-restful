package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Poi {

	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private Double latitude;
	@Column
	private Double longitude;
	@Column
	private String type;
	@Column
	private String newaddr;
	@Column
	private String oldaddr;
	@Column
	private String shared;
	@Column
	private Double mtoilet;
	@Column
	private Double murinal;
	@Column
	private Double mhtoilet;
	@Column
	private Double mhurinal;
	@Column
	private Double mctoilet;
	@Column
	private Double mcurinal;
	@Column
	private Double ftoilet;
	@Column
	private Double fhtoilet;
	@Column
	private Double fctoilet;
	@Column
	private String manager;
	@Column
	private String call;
	@Column
	private String workingtime;
	@Column
	private String installedyear;
	@Column
	private String lastupdated;

	public Poi() {

	}

	public Poi(String name, Double longitude, Double latitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String content) {
		this.name = content;
	}

	public String getNewaddr() {
		return newaddr;
	}

	public String getOldaddr() {
		return oldaddr;
	}

	public String getShared() {
		return shared;
	}

	public Long getMtoilet() {
		if (mtoilet == null) {
			return (long) 0;
		}
		return Math.round(mtoilet);
	}

	public Long getMurinal() {
		if (murinal == null) {
			return (long) 0;
		}
		return Math.round(murinal);
	}

	public Long getMhtoilet() {
		if (mhtoilet == null) {
			return (long) 0;
		}
		return Math.round(mhtoilet);
	}

	public Long getMhurinal() {
		if (mhurinal == null) {
			return (long) 0;
		}
		return Math.round(mhurinal);
	}

	public Long getMctoilet() {
		if (mctoilet == null) {
			return (long) 0;
		}
		return Math.round(mctoilet);
	}

	public Long getMcurinal() {
		if (mcurinal == null) {
			return (long) 0;
		}
		return Math.round(mcurinal);
	}

	public Long getFtoilet() {
		if (ftoilet == null) {
			return (long) 0;
		}
		return Math.round(ftoilet);
	}

	public Long getFhtoilet() {
		if (fhtoilet == null) {
			return (long) 0;
		}
		return Math.round(fhtoilet);
	}

	public Long getFctoilet() {
		if (fctoilet == null) {
			return (long) 0;
		}
		return Math.round(fctoilet);
	}

	public String getManager() {
		return manager;
	}

	public String getCall() {
		return call;
	}

	public String getWorkingtime() {
		return workingtime;
	}

	public String getInstalledyear() {
		return installedyear;
	}

	public String getLastupdated() {
		return lastupdated;
	}

	public Double getLatitude() {
		if (latitude == null) {
			return 0.0;
		}
		return latitude;
	}

	public Double getLongitude() {
		if (longitude == null) {
			return 0.0;
		}
		return longitude;
	}
}
