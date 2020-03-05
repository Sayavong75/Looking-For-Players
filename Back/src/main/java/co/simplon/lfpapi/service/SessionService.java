package co.simplon.lfpapi.service;

import co.simplon.lfpapi.model.Session;

import java.util.List;

public interface SessionService {

    List<Session> getSessions();
    Session getOneSession(Long idSession);
    List<Session> getSessionsOfOnePlayer(Long idPlayer);
    Session updateSession(Long idSession, Session session);
    Session createSession(Session session);
    void deleteSession(Long idSession);
}
