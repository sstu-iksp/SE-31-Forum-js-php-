package com.company.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private Map<String, SessionData> authenticatedUsers = new HashMap<>();

    @Override
    public Long getUserIdByToken(String token) {
        SessionData sessionData = authenticatedUsers.get(token);

        if (sessionData == null || sessionData.expiresAt.before(new Date())) {
            return null;
        }

        return sessionData.userId;
    }

    @Override
    public String startSession(Long userId) {
        String token = RandomStringUtils.randomAlphabetic(20);

        Date expiresAt = DateUtils.addHours(new Date(), 2);
        SessionData sessionData = new SessionData(userId, expiresAt);

        authenticatedUsers.put(token, sessionData);
        return token;
    }

    @Override
    public void stopSession(String token) {
        authenticatedUsers.remove(token);
    }


    static class SessionData {
        private Long userId;
        private Date expiresAt;

        public SessionData(Long userId, Date expiresAt) {
            this.userId = userId;
            this.expiresAt = expiresAt;
        }
    }
}
