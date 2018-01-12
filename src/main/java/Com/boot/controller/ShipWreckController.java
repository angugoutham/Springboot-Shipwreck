package Com.boot.controller;

import java.util.List;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Com.boot.model.Shipwreck;
import Com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipWreckController {
	@Autowired
	private ShipwreckRepository shipWreckRepository;
	
	@RequestMapping(value="shipwrecks",method= RequestMethod.GET)
	public List<Shipwreck> list(){
		return shipWreckRepository.findAll();
		
		
	}
	
	@RequestMapping(value="shipwrecks",method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck){
		System.out.println("angugoutham"+shipwreck.getYearDiscovered());
		System.out.println("angugoutham"+shipwreck.getLongitude());
		return shipWreckRepository.saveAndFlush(shipwreck);	
	}
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		return shipWreckRepository.findOne(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.POST)
	public Shipwreck update(@PathVariable Long id,@RequestBody Shipwreck shipwreck ){
		Shipwreck ExistingShipwreck=shipWreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, ExistingShipwreck);
		return shipWreckRepository.saveAndFlush(ExistingShipwreck);
		
	}
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck ExistingShipwreck=shipWreckRepository.findOne(id);
		shipWreckRepository.delete(ExistingShipwreck);
		return ExistingShipwreck;
	}
}
