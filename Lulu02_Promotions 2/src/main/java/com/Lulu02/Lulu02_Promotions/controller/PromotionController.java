package com.Lulu02.Lulu02_Promotions.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lulu02.Lulu02_Promotions.entity.Promotion;
import com.Lulu02.Lulu02_Promotions.repo.PromotionRepo;

@RestController
@RequestMapping("/promo1")
public class PromotionController{
	@Autowired
	PromotionRepo repo;
	
	
	@GetMapping("/Promotion")
	public List<Promotion> getJPQL()
	{
		return repo.findAll();
	}
	 
	@PostMapping("/Promotion")
	public Promotion createuser(@RequestBody Promotion promo) {
		return repo.save(promo);
	 
	 
	}
	@DeleteMapping("/Promotion/{promoid}")
	 
	 
	public void delete(@PathVariable ("promoid") Integer promoid) {
	 
		repo.deleteById(promoid);
	 
	}
	 
	 
	@PatchMapping("/Promotion/{promoid}")
	 
		public Promotion updateProductInfo (@PathVariable ("promoid") Integer promoid) {
		Promotion newPromotion= repo.findById(promoid)
					.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + promoid));
	 
			newPromotion.setCode("GOCode123");
			return repo.save(newPromotion);
		}
	
		@PatchMapping("/Promotion/{promoid}/{newInfo}")
		public Promotion updatePromotion2patch (@PathVariable ("promoid") Integer promoid, @PathVariable ("newInfo") String newInfo) {
			Promotion newPromotion = repo.findById(promoid)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + promoid));
			newPromotion.setCode(newInfo);
			return repo.save(newPromotion);
		}
		
		@PutMapping("/Promotion/{promoid}")
		public Promotion updatePromotion (@PathVariable ("promoid") Integer promoid, @RequestBody Promotion productBody) { //userbody - information comes from postman.
			Promotion newPromotion = repo.findById(promoid) //old data
					.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + promoid));
			newPromotion.setCode(productBody.getCode()); //the new data replaces the old data.
			return repo.save(newPromotion);
		} 
	}
	 
	
	
	
	
	
