package dog.rescue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	
	private String buisnessName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  // "orphanRemoval" is a boolean method that acts upon orphan record; if you delete a parent row, then all the child rows become orphans, so you generally need to delete them as well
	private Set<Dog> dogs = new HashSet<>();
}
