package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filter_integrity database table.
 * 
 */
@Entity
@Table(name="filter_integrity")
@NamedQuery(name="FilterIntegrity.findAll", query="SELECT f FROM FilterIntegrity f")
public class FilterIntegrity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="exhaust_filter_depth")
	private int exhaustFilterDepth;

	@Column(name="exhaust_filter_height")
	private int exhaustFilterHeight;

	@Column(name="exhaust_filter_quantity")
	private int exhaustFilterQuantity;

	@Column(name="exhaust_filter_width")
	private int exhaustFilterWidth;

	@Column(name="exhaust_max_air_velocity")
	private float exhaustMaxAirVelocity;

	@Column(name="exhaust_max_air_velocity_location")
	private String exhaustMaxAirVelocityLocation;

	@Column(name="exhaust_scan_chart_leaks")
	private String exhaustScanChartLeaks;

	@Column(name="hepa_filter_screen_removed_exhaust")
	private String hepaFilterScreenRemovedExhaust;

	@Column(name="hepa_filter_screen_removed_final")
	private String hepaFilterScreenRemovedFinal;

	@Column(name="laf_filter_depth")
	private int lafFilterDepth;

	@Column(name="laf_filter_height")
	private int lafFilterHeight;

	@Column(name="laf_filter_quantity")
	private int lafFilterQuantity;

	@Column(name="laf_filter_width")
	private int lafFilterWidth;

	@Column(name="laf_max_air_velocity")
	private float lafMaxAirVelocity;

	@Column(name="laf_max_air_velocity_location")
	private String lafMaxAirVelocityLocation;

	@Column(name="laf_scan_chart_leaks")
	private String lafScanChartLeaks;

	@Column(name="no_of_nozzles_used")
	private int noOfNozzlesUsed;

	@Column(name="sparge_arrangement_used")
	private String spargeArrangementUsed;

	@Column(name="test_liquid")
	private String testLiquid;

	//bi-directional one-to-one association to Report
	private Report report;

	public FilterIntegrity() {
	}

	public int getExhaustFilterDepth() {
		return this.exhaustFilterDepth;
	}

	public void setExhaustFilterDepth(int exhaustFilterDepth) {
		this.exhaustFilterDepth = exhaustFilterDepth;
	}

	public int getExhaustFilterHeight() {
		return this.exhaustFilterHeight;
	}

	public void setExhaustFilterHeight(int exhaustFilterHeight) {
		this.exhaustFilterHeight = exhaustFilterHeight;
	}

	public int getExhaustFilterQuantity() {
		return this.exhaustFilterQuantity;
	}

	public void setExhaustFilterQuantity(int exhaustFilterQuantity) {
		this.exhaustFilterQuantity = exhaustFilterQuantity;
	}

	public int getExhaustFilterWidth() {
		return this.exhaustFilterWidth;
	}

	public void setExhaustFilterWidth(int exhaustFilterWidth) {
		this.exhaustFilterWidth = exhaustFilterWidth;
	}

	public float getExhaustMaxAirVelocity() {
		return this.exhaustMaxAirVelocity;
	}

	public void setExhaustMaxAirVelocity(float exhaustMaxAirVelocity) {
		this.exhaustMaxAirVelocity = exhaustMaxAirVelocity;
	}

	public String getExhaustMaxAirVelocityLocation() {
		return this.exhaustMaxAirVelocityLocation;
	}

	public void setExhaustMaxAirVelocityLocation(String exhaustMaxAirVelocityLocation) {
		this.exhaustMaxAirVelocityLocation = exhaustMaxAirVelocityLocation;
	}

	public String getExhaustScanChartLeaks() {
		return this.exhaustScanChartLeaks;
	}

	public void setExhaustScanChartLeaks(String exhaustScanChartLeaks) {
		this.exhaustScanChartLeaks = exhaustScanChartLeaks;
	}

	public String getHepaFilterScreenRemovedExhaust() {
		return this.hepaFilterScreenRemovedExhaust;
	}

	public void setHepaFilterScreenRemovedExhaust(String hepaFilterScreenRemovedExhaust) {
		this.hepaFilterScreenRemovedExhaust = hepaFilterScreenRemovedExhaust;
	}

	public String getHepaFilterScreenRemovedFinal() {
		return this.hepaFilterScreenRemovedFinal;
	}

	public void setHepaFilterScreenRemovedFinal(String hepaFilterScreenRemovedFinal) {
		this.hepaFilterScreenRemovedFinal = hepaFilterScreenRemovedFinal;
	}

	public int getLafFilterDepth() {
		return this.lafFilterDepth;
	}

	public void setLafFilterDepth(int lafFilterDepth) {
		this.lafFilterDepth = lafFilterDepth;
	}

	public int getLafFilterHeight() {
		return this.lafFilterHeight;
	}

	public void setLafFilterHeight(int lafFilterHeight) {
		this.lafFilterHeight = lafFilterHeight;
	}

	public int getLafFilterQuantity() {
		return this.lafFilterQuantity;
	}

	public void setLafFilterQuantity(int lafFilterQuantity) {
		this.lafFilterQuantity = lafFilterQuantity;
	}

	public int getLafFilterWidth() {
		return this.lafFilterWidth;
	}

	public void setLafFilterWidth(int lafFilterWidth) {
		this.lafFilterWidth = lafFilterWidth;
	}

	public float getLafMaxAirVelocity() {
		return this.lafMaxAirVelocity;
	}

	public void setLafMaxAirVelocity(float lafMaxAirVelocity) {
		this.lafMaxAirVelocity = lafMaxAirVelocity;
	}

	public String getLafMaxAirVelocityLocation() {
		return this.lafMaxAirVelocityLocation;
	}

	public void setLafMaxAirVelocityLocation(String lafMaxAirVelocityLocation) {
		this.lafMaxAirVelocityLocation = lafMaxAirVelocityLocation;
	}

	public String getLafScanChartLeaks() {
		return this.lafScanChartLeaks;
	}

	public void setLafScanChartLeaks(String lafScanChartLeaks) {
		this.lafScanChartLeaks = lafScanChartLeaks;
	}

	public int getNoOfNozzlesUsed() {
		return this.noOfNozzlesUsed;
	}

	public void setNoOfNozzlesUsed(int noOfNozzlesUsed) {
		this.noOfNozzlesUsed = noOfNozzlesUsed;
	}

	public String getSpargeArrangementUsed() {
		return this.spargeArrangementUsed;
	}

	public void setSpargeArrangementUsed(String spargeArrangementUsed) {
		this.spargeArrangementUsed = spargeArrangementUsed;
	}

	public String getTestLiquid() {
		return this.testLiquid;
	}

	public void setTestLiquid(String testLiquid) {
		this.testLiquid = testLiquid;
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