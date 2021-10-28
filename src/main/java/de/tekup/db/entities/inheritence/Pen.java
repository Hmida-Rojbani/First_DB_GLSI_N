package de.tekup.db.entities.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Pen extends Product{
	
	private String color;

}
