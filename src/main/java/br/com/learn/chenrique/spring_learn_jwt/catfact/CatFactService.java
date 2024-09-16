package br.com.learn.chenrique.spring_learn_jwt.catfact;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.learn.chenrique.spring_learn_jwt.services.Query;

@Service
public class CatFactService implements Query<Integer, CatFactDTO> {

    private final RestTemplate restTemplate;
    private final String url = "https://catfact.ninja/fact";

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Integer input) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("max_length", input)
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();

        headers.set("Accept", "application/json");

        HttpEntity<String> header = new HttpEntity<>(headers);

        try {
            ResponseEntity<CatFactResponse> response = restTemplate.exchange(uri, HttpMethod.GET, header,
                    CatFactResponse.class);

            CatFactDTO catFactDTO = new CatFactDTO(response.getBody().getFact());
            return ResponseEntity.ok(catFactDTO);

        } catch (Exception e) {
            throw new RuntimeException("Cat Facts API is down");
        }
    }

}
