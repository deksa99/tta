package com.tta.app.model.training;

import java.util.List;
import java.util.UUID;

import com.tta.app.model.User;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.TrainingLevel;
import com.tta.app.model.enums.HitType;
import com.tta.app.model.racket.Racket;

public class Training {
	
	private UUID id;
	private RacketOrientation racketOrientation;
	private HitType type;
	private TrainingLevel level;
	private String name;
	private Long date;
	
	private String ballType;
	private Double expectedAngle;
	private Double expectedSpeed;
	
	private User user;
	private TrainingRequest trainingRequest;
	private Racket racket;
	private List<Hit> hits;
	
	private Boolean successful = null;
	private Boolean finished = false;
	
	public Training() {
		super();
		this.setId(UUID.randomUUID());
	}

	public RacketOrientation getRacketOrientation() {
		return racketOrientation;
	}

	public void setRacketOrientation(RacketOrientation racketOrientation) {
		this.racketOrientation = racketOrientation;
	}

	public HitType getType() {
		return type;
	}

	public void setType(HitType type) {
		this.type = type;
	}

	public TrainingLevel getLevel() {
		return level;
	}

	public void setLevel(TrainingLevel level) {
		this.level = level;
	}

	public String getBallType() {
		return ballType;
	}

	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	public Double getExpectedAngle() {
		return expectedAngle;
	}

	public void setExpectedAngle(Double expectedAngle) {
		this.expectedAngle = expectedAngle;
	}

	public Double getExpectedSpeed() {
		return expectedSpeed;
	}

	public void setExpectedSpeed(Double expectedSpeed) {
		this.expectedSpeed = expectedSpeed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Racket getRacket() {
		return racket;
	}

	public void setRacket(Racket racket) {
		this.racket = racket;
	}

	public List<Hit> getHits() {
		return hits;
	}

	public void setHits(List<Hit> hits) {
		this.hits = hits;
	}

	public UUID getId() {
		return id;
		
	}

	public void setId(UUID id) {
		this.id = id;
		
	}

	public Boolean getSuccessful() {
		return successful;
		
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
		
	}

	public Long getDate() {
		return date;
		
	}

	public void setDate(Long date) {
		this.date = date;
		
	}

	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
		
	}

	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
		
	}

	public Boolean getFinished() {
		return finished;
		
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
		
	}

	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
		
	}
	
	
}
