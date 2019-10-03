package org.iona.kitesurf.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploaderController {

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody
	String upload(@RequestParam String filename, @RequestParam MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filename)));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				
			}
		} else {

		}

		return filename;
	}

}
