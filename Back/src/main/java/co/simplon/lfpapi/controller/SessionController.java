package co.simplon.lfpapi.controller;

import co.simplon.lfpapi.model.Session;
import co.simplon.lfpapi.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<Session> getSessions (){
        return this.sessionService.getSessions();
    }

    @GetMapping("/{idSession}")
    public Session getOneSession (@PathVariable Long idSession){
        return this.sessionService.getOneSession(idSession);
    }

    @GetMapping("/{idPlayer}")
    public List<Session> getAllSessionsOFOnePlayer(@PathVariable Long idPlayer){
        return this.sessionService.getSessionsOfOnePlayer(idPlayer);
    }

    @PutMapping("/{idSession}")
    public ResponseEntity<Session> updateOneSession(@PathVariable Long idSession, @RequestBody Session session){
        try {
            return ResponseEntity.ok(this.sessionService.updateSession(idSession, session));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public Session createSession(Session session){
        return this.sessionService.createSession(session);
    }

    @DeleteMapping("{/idSession}")
    public void deleteSession(@PathVariable Long idSession){
        this.sessionService.deleteSession(idSession);
    }


}
