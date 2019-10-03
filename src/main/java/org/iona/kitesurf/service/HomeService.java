package org.iona.kitesurf.service;

import java.io.IOException;
import java.util.List;

import org.iona.kitesurf.model.Carousel;
import org.iona.kitesurf.model.ImageFile;
import org.iona.kitesurf.model.Menu;
import org.iona.kitesurf.repository.CarouselRepository;
import org.iona.kitesurf.repository.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HomeService {
	@Autowired
	private CarouselRepository carouselRepository;

	@Autowired
	private ImageFileRepository imageFileRepository;

	public void saveCarousel(String caption, Long menuId, MultipartFile file) {

		try {
			ImageFile imageFile = new ImageFile();
			imageFile.setContent(file.getBytes());
			imageFile.setName(file.getOriginalFilename());

			Menu menu = Menu.findById(menuId);
			Carousel carousel = carouselRepository.findByMenu(menu);

			if (carousel == null) {
				carousel = new Carousel();
				carousel.setMenu(menu);
			}

			carousel.setCaption(caption);
			carousel.setImage(imageFile);

			carouselRepository.save(carousel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Carousel> getCarouselImages(){
		return  carouselRepository.findAll();

	}

	public void deleteCarouselImage(Long id) {
		carouselRepository.delete(id);
		
	}

}
