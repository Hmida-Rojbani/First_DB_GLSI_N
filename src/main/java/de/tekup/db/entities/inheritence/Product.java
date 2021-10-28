package de.tekup.db.entities.inheritence;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.INTEGER)
public class Product {
	
	@Id
	private long id;
	
	private String name;

}
