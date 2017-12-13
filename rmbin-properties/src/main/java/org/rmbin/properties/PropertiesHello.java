package org.rmbin.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="properties")
public class PropertiesHello {
	
	@Autowired
	private SpaceModel space;
	
	@RequestMapping(value="/getSpace",method=RequestMethod.GET,produces={"application/xml;chrset=UTF-8"})
	public SpaceModel getSpaceModel()
	{
		return space;
	}

}
