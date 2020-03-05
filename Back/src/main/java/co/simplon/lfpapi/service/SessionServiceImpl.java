package co.simplon.lfpapi.service;

import co.simplon.lfpapi.exception.InvalidSessionException;
import co.simplon.lfpapi.model.Session;
import co.simplon.lfpapi.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> getSessions() {
        return this.sessionRepository.findAll();
    }

    @Override
    public Session getOneSession(Long idSession) {
        Optional<Session> oneSession = this.sessionRepository.findById(idSession);
        if (oneSession.isPresent()){
            return oneSession.get();
        } else {
            throw new InvalidSessionException();
        }
    }

    @Override
    public List<Session> getSessionsOfOnePlayer(Long idPlayer) {
        return this.sessionRepository.getSessionsByPlayerId(idPlayer);
    }

    @Override
    public Session updateSession(Long idSession, Session session) {
        Optional<Session> oneSession = this.sessionRepository.findById(idSession);
        if (oneSession.isPresent()){
            return this.sessionRepository.save(session);
        } else {
            throw new InvalidSessionException();
        }
    }

    @Override
    public Session createSession(Session session) {
        return this.sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Long idSession) {
        this.sessionRepository.deleteById(idSession);

    }


}
