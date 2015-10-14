package no.conduct.resources;

import no.conduct.domain.News;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public News getNews() {
        return new News("Nothing","New");
    }

}