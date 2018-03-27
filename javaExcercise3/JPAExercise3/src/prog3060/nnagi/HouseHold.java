package prog3060.nnagi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HOUSEHOLD", schema="APP")
public class HouseHold 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="GEOGRAPHICAREA", nullable = false)
	private GeographicArea geographicArea;
	
	@ManyToOne
	@JoinColumn(name="CENSUSYEAR", nullable = false)
	private CensusYear censusYear;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDTYPE", nullable = false)
	private HouseHoldType houseHoldType;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSIZE", nullable = false)
	private HouseHoldSize houseHoldSize;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSBYAGERANGE", nullable = false)
	private HouseHoldsByAgeRange houseHoldsByAgeRange;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDEARNERS", nullable = false)
	private HouseHoldEarners houseHoldEarners;
	
	@ManyToOne
	@JoinColumn(name="TOTALINCOME", nullable = false)
	private TotalIncome totalIncome;
	
	@Column(name="NUMBERREPORTED", nullable = false)
	private int numberReported;
	
	public HouseHold()
	{}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GeographicArea getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicArea) {
		this.geographicArea = geographicArea;
	}

	public CensusYear getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}

	public HouseHoldType getHouseHoldType() {
		return houseHoldType;
	}

	public void setHouseHoldType(HouseHoldType houseHoldType) {
		this.houseHoldType = houseHoldType;
	}

	public HouseHoldSize getHouseHoldSize() {
		return houseHoldSize;
	}

	public void setHouseHoldSize(HouseHoldSize houseHoldSize) {
		this.houseHoldSize = houseHoldSize;
	}

	public HouseHoldsByAgeRange getHouseHoldsByAgeRange() {
		return houseHoldsByAgeRange;
	}

	public void setHouseHoldsByAgeRange(HouseHoldsByAgeRange houseHoldsByAgeRange) {
		this.houseHoldsByAgeRange = houseHoldsByAgeRange;
	}

	public HouseHoldEarners getHouseHoldEarners() {
		return houseHoldEarners;
	}

	public void setHouseHoldEarners(HouseHoldEarners houseHoldEarners) {
		this.houseHoldEarners = houseHoldEarners;
	}

	public TotalIncome getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(TotalIncome totalIncome) {
		this.totalIncome = totalIncome;
	}

	public int getNumberReported() {
		return numberReported;
	}

	public void setNumberReported(int numberReported) {
		this.numberReported = numberReported;
	}
	
	
}
