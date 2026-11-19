package ca.hccis.squash.rest;

import ca.hccis.squash.bo.SkillsAssessmentSquashTechnicalBO;
import ca.hccis.squash.bo.SquashMatchBO;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;
import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.repositories.SkillsAssessmentSquashTechnicalRepository;
import ca.hccis.squash.repositories.SquashMatchRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for accessing using REST.
 *
 * @author BJM
 * @since 20261110
 */
@RestController
@RequestMapping("/api/SquashMatchService/v1/squashMatches")
public class SquashMatchService {

    private final SquashMatchRepository repo;

    @Autowired
    public SquashMatchService(SquashMatchRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<SquashMatch>> getAll() {

        Iterable<SquashMatch> squashMatchesIterable = repo.findAll();
        List<SquashMatch> squashMatches = new ArrayList<>();
        squashMatchesIterable.forEach(squashMatches::add);

        if (squashMatches == null || squashMatches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(squashMatches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SquashMatch> getById(@PathVariable Integer id) {

        Optional<SquashMatch> theMatch = repo.findById(id);
        Gson gson = new Gson();
        String matchJson = gson.toJson(theMatch.get());
        System.out.println();
        System.out.println(matchJson);
        System.out.println();

        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        return repo.findById(id)
                .map(entity -> {
                    repo.delete(entity);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<SquashMatch> create(
            @RequestBody SquashMatch obj) {

        obj.setWinnerName(SquashMatchBO.determineWinner(obj));

        if(obj.getId() != null && obj.getId().equals(0)){
            obj.setId(null);
        }

        SquashMatch saved = repo.save(obj);

        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SquashMatch> update(
            @PathVariable Integer id,
            @RequestBody SquashMatch obj) {

        obj.setId(id);
        obj.setWinnerName(SquashMatchBO.determineWinner(obj));
        return ResponseEntity.ok(repo.save(obj));
    }
}