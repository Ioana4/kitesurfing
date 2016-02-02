package org.iona.kitesurf.service;

import java.util.List;

import org.iona.kitesurf.model.Gallery;
import org.iona.kitesurf.model.ImageFile;
import org.iona.kitesurf.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryRepository galleryRepository;

	public void save(Integer order, byte[] imageContent) {
		ImageFile imageFile = new ImageFile();
		imageFile.setContent(imageContent);

		Gallery gallery = new Gallery();
		gallery.setDisplayOrder(order);
		gallery.setImage(imageFile);

		galleryRepository.save(gallery);
	}

	public List<Gallery> findAll() {
		Sort sort = new Sort(Sort.Direction.ASC, "displayOrder");
		return galleryRepository.findAll(sort);		
	}

	public Gallery getOne(Long id) {
		return galleryRepository.findOne(id);
	}

	public void delete(Long id) {
		galleryRepository.delete(id);		
	}
}
