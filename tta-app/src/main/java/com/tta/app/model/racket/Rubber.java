package com.tta.app.model.racket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rubber")
public class Rubber {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Double speed;
	private Double spin;
	private Double control;
	private Double tackiness;
	private Double weight;
	private Double hardness;
	private Double consistency;
	private Double price;
	
	public Rubber() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getControl() {
		return control;
	}

	public void setControl(Double control) {
		this.control = control;
	}

	public Double getTackiness() {
		return tackiness;
	}

	public void setTackiness(Double stickness) {
		this.tackiness = stickness;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSpin() {
		return spin;
	}

	public void setSpin(Double spin) {
		this.spin = spin;
	}

	public Double getHardness() {
		return hardness;
	}

	public void setHardness(Double hardness) {
		this.hardness = hardness;
	}

	public Double getConsistency() {
		return consistency;
	}

	public void setConsistency(Double consistency) {
		this.consistency = consistency;
	}

	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
		
	}

}
