package com.atn.demo.mvc.module.family.service;

import java.util.List;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.family.entity.Family;
import com.atn.demo.mvc.module.file.entity.File;

public interface FamilyService extends MyService<Family, Long> {
	
	public Family createFamily(Family family, File file);
	public Family updateFamily(Family family);
	public Family getConnectedFamily();
	


}
