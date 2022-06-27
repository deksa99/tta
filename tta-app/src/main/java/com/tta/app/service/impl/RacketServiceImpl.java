package com.tta.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.tta.app.model.enums.Playstyle;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.model.racket.Rubber;
import com.tta.app.repository.BladeRepository;
import com.tta.app.repository.RubberRepository;
import com.tta.app.service.KieService;
import com.tta.app.service.RacketService;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RacketServiceImpl implements RacketService {
	
	private final BladeRepository bladeRepository;
	private final RubberRepository rubberRepository;
	private final KieService kieService;
	
	@Autowired
	public RacketServiceImpl(KieService kieService, BladeRepository bladeRepository, RubberRepository rubberRepository) {
		super();
		this.kieService = kieService;
		this.bladeRepository = bladeRepository;
		this.rubberRepository = rubberRepository;
	}

	@Override
	public Racket getRecommendation(RacketForm form) {
		RacketParams rp = new RacketParams();
		rp.setFormId(form.getId());
		KieSession kieSession = kieService.getDefaultKieSession();
		kieSession.insert(form);
		kieSession.insert(rp);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return findOptimalRacket(rp);
	}

	private Racket findOptimalRacket(RacketParams rp) {
		List<Blade> blades = bladeRepository.findAll();
		List<Rubber> rubbers = rubberRepository.findAll();
		
		blades = blades.stream()
				.filter(b -> b.getPrice() < rp.getBladePrice().getMax())
				.filter(b -> b.getPrice() > rp.getBladePrice().getMin())
				.filter(b -> b.getControl() < rp.getControlRange().getMax())
				.filter(b -> b.getControl() > rp.getControlRange().getMin())
				.filter(b -> b.getSpeed() < rp.getBladeSpeed().getMax())
				.filter(b -> b.getSpeed() > rp.getBladeSpeed().getMin())
				.filter(b -> b.getGrip() == rp.getGrip())
				.filter(b -> b.getGripType() == rp.getGripType())
				.collect(Collectors.toList());
		
		rubbers = rubbers.stream()
				.filter(r -> r.getPrice() < rp.getRubberPrice().getMax())
				.filter(r -> r.getPrice() > rp.getRubberPrice().getMin())
				.filter(r -> r.getControl() < rp.getControlRange().getMax())
				.filter(r -> r.getControl() > rp.getControlRange().getMin())
				.filter(r -> r.getSpeed() < rp.getRubberSpeed().getMax())
				.filter(r -> r.getSpeed() > rp.getRubberSpeed().getMin())
				.filter(r -> r.getSpin() < rp.getRubberSpin().getMax())
				.filter(r -> r.getSpin() > rp.getRubberSpin().getMin())
				.collect(Collectors.toList());
		
		final Double offCoef = 1.10;
		final Double defCoef = 0.90;
		final Double coef = 1.00;
		
		rubbers.sort((r1, r2) -> {
			if (rp.getPlaystyle() == Playstyle.OFFENSIVE) {
				return calculateRubberGrade(r1, offCoef) > calculateRubberGrade(r2, offCoef) ? 1 : -1;
			}
			if (rp.getPlaystyle() == Playstyle.DEFENSIVE) {
				return calculateRubberGrade(r1, defCoef) > calculateRubberGrade(r2, defCoef) ? 1 : -1;
			}
			return calculateRubberGrade(r1, coef) > calculateRubberGrade(r2, coef) ? 1 : -1;
		});
		
		blades.sort((b1, b2) -> {
			if (rp.getPlaystyle() == Playstyle.OFFENSIVE) {
				return calculateBladeGrade(b1, offCoef) > calculateBladeGrade(b2, offCoef) ? 1 : -1;
			}
			if (rp.getPlaystyle() == Playstyle.DEFENSIVE) {
				return calculateBladeGrade(b1, defCoef) > calculateBladeGrade(b2, defCoef) ? 1 : -1;
			}
			return calculateBladeGrade(b1, coef) > calculateBladeGrade(b2, coef) ? 1 : -1;
		});
		 		
		return new Racket(blades.get(0), rubbers.get(0), rubbers.get(0));
	}
	
	private Double calculateBladeGrade(Blade b, Double coef) {
		return b.getConsistency() + 
				b.getControl() / coef + 
				b.getHardness() * coef + 
				b.getSpeed() * coef + 
				b.getStiffness() * coef;
	}
	
	private Double calculateRubberGrade(Rubber r, Double coef) {
		return r.getConsistency() + 
				r.getControl() / coef + 
				r.getSpeed() * coef + 
				r.getSpin() * coef + 
				r.getTackiness();
	}
}
