package org.iona.kitesurf.repository;

import org.iona.kitesurf.model.Carousel;
import org.iona.kitesurf.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarouselRepository extends JpaRepository<Carousel, Long>{
	Carousel findByMenu(Menu menu);

}
