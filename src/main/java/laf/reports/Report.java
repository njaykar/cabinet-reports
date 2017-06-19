package laf.reports;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="certificate_no")
	private String certificateNo;

	@Column(name="aerosol_generator_pressure")
	private float aerosolGeneratorPressure;

	@Column(name="alarm_conditions_inspected")
	private String alarmConditionsInspected;

	@Column(name="blowers_inspected")
	private String blowersInspected;

	@Column(name="cabinet_fumigated")
	private String cabinetFumigated;

	@Temporal(TemporalType.DATE)
	@Column(name="date_revised")
	private Date dateRevised;

	@Column(name="gas_fitting_solenoid_checked")
	private String gasFittingSolenoidChecked;

	@Temporal(TemporalType.DATE)
	@Column(name="next_test_date")
	private Date nextTestDate;

	@Column(name="parts_used")
	private String partsUsed;

	@Column(name="power_outlet_checked")
	private String powerOutletChecked;

	@Column(name="prefilter_serviced")
	private String prefilterServiced;

	@Column(name="remarks_and_recommendations")
	private String remarksAndRecommendations;

	@Temporal(TemporalType.DATE)
	@Column(name="test_date")
	private Date testDate;

	private String version;

	//bi-directional one-to-one association to AirBarrierContainment
	@OneToOne(mappedBy="report")
	private AirBarrierContainment airBarrierContainment;

	//bi-directional one-to-one association to AirVelocityProfile
	@OneToOne(mappedBy="report")
	private AirVelocityProfile airVelocityProfile;

	//bi-directional one-to-one association to FilterIntegrity
	@OneToOne(mappedBy="report")
	private FilterIntegrity filterIntegrity;

	//bi-directional one-to-one association to IlluminanceTest
	@OneToOne(mappedBy="report")
	private IlluminanceTest illuminanceTest;

	//bi-directional one-to-one association to InstallationGaugePressure
	@OneToOne(mappedBy="report")
	private InstallationGaugePressure installationGaugePressure;

	//bi-directional many-to-many association to Instrument
	@ManyToMany
	@JoinTable(
		name="instrument_has_report"
		, joinColumns={
			@JoinColumn(name="report_certificate_no")
			}
		, inverseJoinColumns={
			@JoinColumn(name="instrument_instrument_id")
			}
		)
	private Set<Instrument> instruments;

	//bi-directional many-to-one association to Equipment
	@ManyToOne
	private Equipment equipment;

	//bi-directional many-to-one association to Technician
	@ManyToOne
	private Technician technician;

	//bi-directional one-to-one association to SoundLevel
	@OneToOne(mappedBy="report")
	private SoundLevel soundLevel;

	//bi-directional one-to-one association to UvRadiationIntensity
	@OneToOne(mappedBy="report")
	private UvRadiationIntensity uvRadiationIntensity;

	//bi-directional one-to-one association to WorkZoneIntegrity
	@OneToOne(mappedBy="report")
	private WorkZoneIntegrity workZoneIntegrity;

	public Report() {
	}

	public String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public float getAerosolGeneratorPressure() {
		return this.aerosolGeneratorPressure;
	}

	public void setAerosolGeneratorPressure(float aerosolGeneratorPressure) {
		this.aerosolGeneratorPressure = aerosolGeneratorPressure;
	}

	public String getAlarmConditionsInspected() {
		return this.alarmConditionsInspected;
	}

	public void setAlarmConditionsInspected(String alarmConditionsInspected) {
		this.alarmConditionsInspected = alarmConditionsInspected;
	}

	public String getBlowersInspected() {
		return this.blowersInspected;
	}

	public void setBlowersInspected(String blowersInspected) {
		this.blowersInspected = blowersInspected;
	}

	public String getCabinetFumigated() {
		return this.cabinetFumigated;
	}

	public void setCabinetFumigated(String cabinetFumigated) {
		this.cabinetFumigated = cabinetFumigated;
	}

	public Date getDateRevised() {
		return this.dateRevised;
	}

	public void setDateRevised(Date dateRevised) {
		this.dateRevised = dateRevised;
	}

	public String getGasFittingSolenoidChecked() {
		return this.gasFittingSolenoidChecked;
	}

	public void setGasFittingSolenoidChecked(String gasFittingSolenoidChecked) {
		this.gasFittingSolenoidChecked = gasFittingSolenoidChecked;
	}

	public Date getNextTestDate() {
		return this.nextTestDate;
	}

	public void setNextTestDate(Date nextTestDate) {
		this.nextTestDate = nextTestDate;
	}

	public String getPartsUsed() {
		return this.partsUsed;
	}

	public void setPartsUsed(String partsUsed) {
		this.partsUsed = partsUsed;
	}

	public String getPowerOutletChecked() {
		return this.powerOutletChecked;
	}

	public void setPowerOutletChecked(String powerOutletChecked) {
		this.powerOutletChecked = powerOutletChecked;
	}

	public String getPrefilterServiced() {
		return this.prefilterServiced;
	}

	public void setPrefilterServiced(String prefilterServiced) {
		this.prefilterServiced = prefilterServiced;
	}

	public String getRemarksAndRecommendations() {
		return this.remarksAndRecommendations;
	}

	public void setRemarksAndRecommendations(String remarksAndRecommendations) {
		this.remarksAndRecommendations = remarksAndRecommendations;
	}

	public Date getTestDate() {
		return this.testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public AirBarrierContainment getAirBarrierContainment() {
		return this.airBarrierContainment;
	}

	public void setAirBarrierContainment(AirBarrierContainment airBarrierContainment) {
		this.airBarrierContainment = airBarrierContainment;
	}

	public AirVelocityProfile getAirVelocityProfile() {
		return this.airVelocityProfile;
	}

	public void setAirVelocityProfile(AirVelocityProfile airVelocityProfile) {
		this.airVelocityProfile = airVelocityProfile;
	}

	public FilterIntegrity getFilterIntegrity() {
		return this.filterIntegrity;
	}

	public void setFilterIntegrity(FilterIntegrity filterIntegrity) {
		this.filterIntegrity = filterIntegrity;
	}

	public IlluminanceTest getIlluminanceTest() {
		return this.illuminanceTest;
	}

	public void setIlluminanceTest(IlluminanceTest illuminanceTest) {
		this.illuminanceTest = illuminanceTest;
	}

	public InstallationGaugePressure getInstallationGaugePressure() {
		return this.installationGaugePressure;
	}

	public void setInstallationGaugePressure(InstallationGaugePressure installationGaugePressure) {
		this.installationGaugePressure = installationGaugePressure;
	}

	public Set<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Technician getTechnician() {
		return this.technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public SoundLevel getSoundLevel() {
		return this.soundLevel;
	}

	public void setSoundLevel(SoundLevel soundLevel) {
		this.soundLevel = soundLevel;
	}

	public UvRadiationIntensity getUvRadiationIntensity() {
		return this.uvRadiationIntensity;
	}

	public void setUvRadiationIntensity(UvRadiationIntensity uvRadiationIntensity) {
		this.uvRadiationIntensity = uvRadiationIntensity;
	}

	public WorkZoneIntegrity getWorkZoneIntegrity() {
		return this.workZoneIntegrity;
	}

	public void setWorkZoneIntegrity(WorkZoneIntegrity workZoneIntegrity) {
		this.workZoneIntegrity = workZoneIntegrity;
	}

}