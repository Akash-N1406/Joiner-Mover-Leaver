package com.iga.service;

import com.iga.model.Identity;
import com.iga.util.AuditLogger;
import com.iga.util.DbClient;
import java.sql.*;

public class JMLEngine {

    public void processIdentity(Identity incoming) {
        // Logic to determine action
        // For this demo, let's focus on the SQL execution for a Mover/Joiner
        if (incoming.getStatus().equalsIgnoreCase("Active")) {
            provisionOrUpdate(incoming);
        } else {
            revokeAccess(incoming.getEmployeeId());
        }
    }

    private void provisionOrUpdate(Identity i) {
        String sql = "MERGE INTO ACCOUNTS (EMP_ID, DEPT, STATUS) KEY(EMP_ID) VALUES (?, ?, ?)";
        try (Connection conn = DbClient.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, i.getEmployeeId());
            pstmt.setString(2, i.getDepartment());
            pstmt.setString(3, "ENABLED");
            pstmt.executeUpdate();
            System.out.println("[SQL] Provisioned/Updated account for: " + i.getEmployeeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AuditLogger.logSecurityEvent("PROVISIONING", i.getEmployeeId(), "Access granted to Department: " + i.getDepartment());
    }

    private void revokeAccess(String empId) {
        String sql = "UPDATE ACCOUNTS SET STATUS = 'DISABLED' WHERE EMP_ID = ?";
        try (Connection conn = DbClient.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empId);
            pstmt.executeUpdate();
            System.out.println("[SQL] Revoked access (Leaver) for: " + empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AuditLogger.logSecurityEvent("REVOKE_ACCESS", empId, "Account status set to DISABLED due to HR Termination.");
        AuditLogger.sendManagerAlert(empId, "TERMINATED");
    }
}