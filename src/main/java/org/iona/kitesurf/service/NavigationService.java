package org.iona.kitesurf.service;

import java.io.IOException;

import org.iona.kitesurf.model.ImageFile;
import org.iona.kitesurf.repository.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NavigationService {

	@Autowired
	private ImageFileRepository imageFileRepository;

	@Value("${brandImageId:#{null}}")
	private Long brandImageId;

	public void updateBrand(MultipartFile file) {
		try {
			ImageFile brandImageFile = new ImageFile();
			brandImageFile.setContent(file.getBytes());
			//was previous uploaded.. so it should be updated
			if (brandImageId != null) {
				brandImageFile.setId(brandImageId);
			}

			ImageFile savedBrand = imageFileRepository.save(brandImageFile);
			brandImageId = savedBrand.getId();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImageFile getBrand() {
		return imageFileRepository.findOne(brandImageId);
	}

}
