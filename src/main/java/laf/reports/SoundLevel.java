package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sound_level database table.
 * 
 */
@Entity
@Table(name="sound_level")
@NamedQuery(name="SoundLevel.findAll", query="SELECT s FROM SoundLevel s")
public class SoundLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="adverse_room_effects")
	private int adverseRoomEffects;

	@Column(name="ambient_level")
	private int ambientLevel;

	@Column(name="corrected_level")
	private int correctedLevel;

	@Column(name="operating_level")
	private int operatingLevel;

	//bi-directional one-to-one association to Report
	private Report report;

	public SoundLevel() {
	}

	public int getAdverseRoomEffects() {
		return this.adverseRoomEffects;
	}

	public void setAdverseRoomEffects(int adverseRoomEffects) {
		this.adverseRoomEffects = adverseRoomEffects;
	}

	public int getAmbientLevel() {
		return this.ambientLevel;
	}

	public void setAmbientLevel(int ambientLevel) {
		this.ambientLevel = ambientLevel;
	}

	public int getCorrectedLevel() {
		return this.correctedLevel;
	}

	public void setCorrectedLevel(int correctedLevel) {
		this.correctedLevel = correctedLevel;
	}

	public int getOperatingLevel() {
		return this.operatingLevel;
	}

	public void setOperatingLevel(int operatingLevel) {
		this.operatingLevel = operatingLevel;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "certificate_no")
	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}