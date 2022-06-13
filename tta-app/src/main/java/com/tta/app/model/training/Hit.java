package com.tta.app.model.training;

import com.tta.app.model.enums.HitResult;

public class Hit {
	
	private Long trainingId;
	private Double angle;
	private Double speed;
	private Double startPosition;
	private Double endPosition;
	private Training training;
	
	private HitResult result;
	
	public Hit() {
		super();
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Double startPosition) {
		this.startPosition = startPosition;
	}

	public Double getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Double endPosition) {
		this.endPosition = endPosition;
	}

	public HitResult getResult() {
		return result;
	}

	public void setResult(HitResult result) {
		this.result = result;
	}

	public Long getTrainingId() {
		return trainingId;
		
	}

	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
		
	}

	public Training getTraining() {
		return training;
		
	}

	public void setTraining(Training training) {
		this.training = training;
		
	}
	
	
}
