package org.iona.kitesurf.service;

import java.io.IOException;

import org.iona.kitesurf.model.ImageFile;
import org.iona.kitesurf.repository.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NavigationService {
	
	@Autowired
	private ImageFileRepository imageFileRepository;

	public ImageFile updateBrand(MultipartFile file) {
//		try {
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	public ImageFile getBrand() {
		return null;
	}
	
	
}
