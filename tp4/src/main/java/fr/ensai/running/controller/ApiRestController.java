package fr.ensai.running.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.service.AthleteService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private AthleteService athleteService;

    /**
     * Get all athletes
     */
    @GetMapping("/athlete")
    public List<Athlete> allAthletes() {

        return athleteService.findAll();
    }

    @GetMapping("/athlete/{id_athlete}")
    public ResponseEntity<Athlete> getAthleteById(@PathVariable Long id_athlete) {
        Athlete athlete = athleteService.findById(id_athlete);
        if (athlete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(athlete);
    }

    @DeleteMapping("/athlete/{id_athlete}")
    public ResponseEntity<Athlete> deleteAthleteById(@PathVariable Long id_athlete) {
        Athlete athlete = athleteService.findById(id_athlete);
        if (athlete == null) {
            return ResponseEntity.notFound().build();
        }
        athleteService.deleteById(id_athlete);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/athlete")
    public ResponseEntity<Athlete> createAthlete(@RequestBody Athlete athlete) {
        Athlete createdAthlete = athleteService.save(athlete);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAthlete);
    }

}