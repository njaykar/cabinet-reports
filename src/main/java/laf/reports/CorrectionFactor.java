package laf.reports;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the correction_factor database table.
 * 
 */
@Entity
@Table(name="correction_factor")
@NamedQuery(name="CorrectionFactor.findAll", query="SELECT c FROM CorrectionFactor c")
public class CorrectionFactor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="factor_eight")
	private float factorEight;

	@Column(name="factor_eleven")
	private float factorEleven;

	@Column(name="factor_fifteen")
	private float factorFifteen;

	@Column(name="factor_five")
	private float factorFive;

	@Column(name="factor_four")
	private float factorFour;

	@Column(name="factor_fourteen")
	private float factorFourteen;

	@Column(name="factor_nine")
	private float factorNine;

	@Column(name="factor_one")
	private float factorOne;

	@Column(name="factor_seven")
	private float factorSeven;

	@Column(name="factor_six")
	private float factorSix;

	@Column(name="factor_sixteen")
	private float factorSixteen;

	@Column(name="factor_ten")
	private float factorTen;

	@Column(name="factor_thirteen")
	private float factorThirteen;

	@Column(name="factor_three")
	private float factorThree;

	@Column(name="factor_twelve")
	private float factorTwelve;

	@Column(name="factor_two")
	private float factorTwo;

	//bi-directional one-to-one association to Instrument
	private Instrument instrument;

	public CorrectionFactor() {
	}

	public float getFactorEight() {
		return this.factorEight;
	}

	public void setFactorEight(float factorEight) {
		this.factorEight = factorEight;
	}

	public float getFactorEleven() {
		return this.factorEleven;
	}

	public void setFactorEleven(float factorEleven) {
		this.factorEleven = factorEleven;
	}

	public float getFactorFifteen() {
		return this.factorFifteen;
	}

	public void setFactorFifteen(float factorFifteen) {
		this.factorFifteen = factorFifteen;
	}

	public float getFactorFive() {
		return this.factorFive;
	}

	public void setFactorFive(float factorFive) {
		this.factorFive = factorFive;
	}

	public float getFactorFour() {
		return this.factorFour;
	}

	public void setFactorFour(float factorFour) {
		this.factorFour = factorFour;
	}

	public float getFactorFourteen() {
		return this.factorFourteen;
	}

	public void setFactorFourteen(float factorFourteen) {
		this.factorFourteen = factorFourteen;
	}

	public float getFactorNine() {
		return this.factorNine;
	}

	public void setFactorNine(float factorNine) {
		this.factorNine = factorNine;
	}

	public float getFactorOne() {
		return this.factorOne;
	}

	public void setFactorOne(float factorOne) {
		this.factorOne = factorOne;
	}

	public float getFactorSeven() {
		return this.factorSeven;
	}

	public void setFactorSeven(float factorSeven) {
		this.factorSeven = factorSeven;
	}

	public float getFactorSix() {
		return this.factorSix;
	}

	public void setFactorSix(float factorSix) {
		this.factorSix = factorSix;
	}

	public float getFactorSixteen() {
		return this.factorSixteen;
	}

	public void setFactorSixteen(float factorSixteen) {
		this.factorSixteen = factorSixteen;
	}

	public float getFactorTen() {
		return this.factorTen;
	}

	public void setFactorTen(float factorTen) {
		this.factorTen = factorTen;
	}

	public float getFactorThirteen() {
		return this.factorThirteen;
	}

	public void setFactorThirteen(float factorThirteen) {
		this.factorThirteen = factorThirteen;
	}

	public float getFactorThree() {
		return this.factorThree;
	}

	public void setFactorThree(float factorThree) {
		this.factorThree = factorThree;
	}

	public float getFactorTwelve() {
		return this.factorTwelve;
	}

	public void setFactorTwelve(float factorTwelve) {
		this.factorTwelve = factorTwelve;
	}

	public float getFactorTwo() {
		return this.factorTwo;
	}

	public void setFactorTwo(float factorTwo) {
		this.factorTwo = factorTwo;
	}
	
	@Id
	@OneToOne
	@JoinColumn(name = "instrument_id")
	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}