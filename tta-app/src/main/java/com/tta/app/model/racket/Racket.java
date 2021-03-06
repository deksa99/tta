package com.tta.app.model.racket;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tta.app.model.enums.RacketLevel;

@Entity
@Table(name = "racket")
public class Racket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Blade blade;
	@ManyToOne(fetch = FetchType.EAGER)
	private Rubber fhRubber;
	@ManyToOne(fetch = FetchType.EAGER)
	private Rubber bhRubber;
	private Double speed;
	private Double spin;
	private Double control;
	@Enumerated(EnumType.STRING)
	private RacketLevel racketLevel;

	public Racket() {
		super();
	}
	
	public Racket(Blade blade, Rubber fhRubber, Rubber bhRubber) {
		super();
		this.blade = blade;
		this.fhRubber = fhRubber;
		this.bhRubber = bhRubber;
	}

	public Blade getBlade() {
		return blade;
	}

	public void setBlade(Blade blade) {
		this.blade = blade;
	}

	public Rubber getFhRubber() {
		return fhRubber;
	}

	public void setFhRubber(Rubber fhRubber) {
		this.fhRubber = fhRubber;
	}

	public Rubber getBhRubber() {
		return bhRubber;
	}

	public void setBhRubber(Rubber bhRubber) {
		this.bhRubber = bhRubber;
	}

	public RacketLevel getRacketLevel() {
		return racketLevel;
		
	}

	public void setRacketLevel(RacketLevel racketLevel) {
		this.racketLevel = racketLevel;
		
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getSpin() {
		return spin;
	}

	public void setSpin(Double spin) {
		this.spin = spin;
	}

	public Double getControl() {
		return control;
	}

	public void setControl(Double control) {
		this.control = control;
	}
	
}
