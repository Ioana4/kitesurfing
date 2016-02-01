package org.iona.kitesurf.service;

import java.io.IOException;

import org.iona.kitesurf.model.ImageFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NavigationService {
	private ImageFile brand;

	public ImageFile updateBrand(MultipartFile file) {
		try {
			if (brand == null) {
				brand = new ImageFile();
			}
			brand.setContent(file.getBytes());
			return brand;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ImageFile getBrand() {
		return brand;
	}
	
	
}
