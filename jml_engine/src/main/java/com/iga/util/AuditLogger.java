package com.iga.util;

import java.time.LocalDateTime;

public class AuditLogger {
    public static void logSecurityEvent(String action, String empId, String details) {
        String timestamp = LocalDateTime.now().toString();
        System.out.println("--------------------------------------------------");
        System.out.println("[AUDIT LOG] " + timestamp);
        System.out.println("[ACTION] " + action);
        System.out.println("[TARGET] " + empId);
        System.out.println("[DETAILS] " + details);
        System.out.println("--------------------------------------------------");
    }

    public static void sendManagerAlert(String empId, String action) {
        // Simulating an Email/Slack notification
        System.out.println("[NOTIFICATION] Alert sent to Manager: User " + empId + " has been " + action);
    }
}