package prog3060.nnagi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CENSUSYEAR", schema="APP")
public class CensusYear 
{
	@Id
    @GeneratedValue
	@JoinColumn(name="CENSUSYEARID", nullable = false)
	private int censusYearID;
	
	@OneToMany(targetEntity = Age.class, mappedBy="censusYear")
	List<Age> age = new ArrayList<Age>();
	
	@OneToMany(targetEntity = Age.class, mappedBy="censusYear")
	List<HouseHold> houseHold = new ArrayList<HouseHold>();
	
	@Column(name="CENSUSYEAR", nullable = false)
	private int censusYear;
	
	public CensusYear() 
	{	
	}

	public int getCensusYearID() {
		return censusYearID;
	}

	public void setCensusYearID(int censusYearID) {
		this.censusYearID = censusYearID;
	}

	public int getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(int censusYear) {
		this.censusYear = censusYear;
	}
	
	
}
