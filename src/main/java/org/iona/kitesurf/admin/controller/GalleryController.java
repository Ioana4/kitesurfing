package org.iona.kitesurf.admin.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.iona.kitesurf.model.Gallery;
import org.iona.kitesurf.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/admin")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value = "/gallery", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam MultipartFile file, @RequestParam("order") Integer order) {
		if (!file.isEmpty()) {
			try {
				galleryService.save(order, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/#/admin/gallery");
	}

	@RequestMapping(value = "/gallery/all", method = RequestMethod.GET)
	public List<Gallery> findAll() {
		List<Gallery> gallery = galleryService.findAll();
		return gallery;
	}

	@RequestMapping(value = "/gallery/{id}", method = RequestMethod.GET)
	public HttpEntity<InputStreamResource> findById(@PathVariable("id") Long id) {
		Gallery gallery = galleryService.getOne(id);  
		InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(gallery.getImage().getContent()));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Disposition", "attachment;filename=\"" + gallery.getImage().getName() + "\"");
		headers.setContentLength(gallery.getImage().getContent().length);
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new HttpEntity<InputStreamResource>(inputStreamResource, headers);
	}
	
	
	@RequestMapping(value="/gallery/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam("imageId") Long id){
		galleryService.delete(id);
		return new ModelAndView("redirect:/#/admin/gallery");
	}
}
