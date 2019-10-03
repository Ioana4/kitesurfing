package org.iona.kitesurf.service;

import org.iona.kitesurf.model.Module;
import org.iona.kitesurf.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonsService {
	
	@Autowired
	private LessonRepository lessonRepository;

	public void save(Module module) {
		lessonRepository.save(module);
	}

}
