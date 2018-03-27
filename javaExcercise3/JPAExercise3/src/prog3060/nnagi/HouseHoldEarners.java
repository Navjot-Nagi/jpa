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
@Table(name="HOUSEHOLDEARNERS", schema="APP")
public class HouseHoldEarners 
{
	@Id
    @GeneratedValue
	@JoinColumn(name="ID", nullable = false)
	private int id;
	
	@OneToMany(targetEntity = HouseHold.class, mappedBy="houseHoldEarners")
	List<HouseHold> houseHold = new ArrayList<HouseHold>();
	
	@Column(name="DESCRIPTION", nullable = false)
	private String description;
	
	public HouseHoldEarners()
	{}

	public int getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
