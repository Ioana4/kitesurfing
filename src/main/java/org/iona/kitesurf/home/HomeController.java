package org.iona.kitesurf.home;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.iona.kitesurf.bean.CarouselDTO;
import org.iona.kitesurf.model.Carousel;
import org.iona.kitesurf.repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private CarouselRepository carouselRepository;

	@RequestMapping("/carousel")
	public List<CarouselDTO> getCarousel() {
		List<CarouselDTO> carouselsDTO = new ArrayList<>();

		List<Carousel> carousels = carouselRepository.findAll();
		for (Carousel carousel : carousels) {
			carouselsDTO.add(new CarouselDTO(carousel.getId(), carousel.getCaption(), carousel.getMenu().getTargetUrl()));
		}

		return carouselsDTO;
	}

	@RequestMapping("/carousel/content/{id}")
	public HttpEntity<InputStreamResource> download(@PathVariable("id") Long id) {

		Carousel carousel = carouselRepository.getOne(id); 
		InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(carousel.getImage().getContent()));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Disposition", "attachment;filename=\"" + carousel.getImage().getName() + "\"");
		headers.setContentLength(carousel.getImage().getContent().length);
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new HttpEntity<InputStreamResource>(inputStreamResource, headers);
	}
}
