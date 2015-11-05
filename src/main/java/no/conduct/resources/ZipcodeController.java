package no.conduct.resources;

import no.conduct.domain.ZipcodeRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ZipcodeController {

    @Autowired
    private ZipcodeRegistry registry;

    @RequestMapping(
            value = "/registrering/{zipcode}",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public
    @ResponseBody
    String getZipcode(@PathVariable("zipcode") final String zipcode)
            throws IOException {

        return registry.getPlace(zipcode);

    }

}
