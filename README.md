Automated IGA JML Lifecycle Engine
📌 Project Overview
This project is a Java-based Identity Governance and Administration (IGA) engine designed to automate the Joiner-Mover-Leaver (JML) lifecycle. It mimics the core functionality of enterprise IGA platforms like Saviynt and SailPoint by synchronizing identity data from a "Source of Truth" (HR System) to downstream "Target Applications."

Key Problem Solved:
Manual access management leads to "Access Creep" and "Orphaned Accounts." This engine ensures that access is automatically granted, updated, or revoked based on real-time HR events, maintaining a Least Privilege security model.

🚀 Key Features
Automated Joiner Process: Detects new hires in HR data and automatically provisions accounts in a target SQL database.

Mover Workflow: Monitors department changes and updates user attributes in target systems using SQL MERGE logic.

Leaver (De-provisioning): Immediately disables access for "Inactive" users to prevent unauthorized access after termination.

Audit Logging: Generates time-stamped security events for every access change, ensuring a clear audit trail for compliance (SOX/GDPR).

Manager Notifications: Simulates automated alerts to management upon high-risk events like user terminations.

🛠️ Technical Stack
Language: Java 17+

Build Tool: Maven

Database: H2 (In-Memory SQL)

Libraries: OpenCSV (Data Parsing), JDBC (Database Connectivity)

🏗️ Architecture
The engine follows a modular architecture:

Source Connector: Parses hr_data.csv (Simulated HR System).

Identity Logic Engine: Compares incoming data against existing identity states.

Target Adapter: Communicates with the H2 SQL Database to perform CRUD operations.

🚦 How to Run
Prerequisites: Ensure you have Java 17+ and Maven installed.

Setup: Place your hr_data.csv in the root directory.

Compile:

PowerShell

mvn clean compile
Execute:

PowerShell

mvn exec:java "-Dexec.mainClass=com.iga.App"
📊 Sample Output
Plaintext

[DB] Target System Initialized Successfully.
--- Starting IGA Reconciliation Cycle ---
[SQL] Provisioned/Updated account for: E001
[AUDIT LOG] ACTION: PROVISIONING | TARGET: E001 | DETAILS: Access granted to IT
[SQL] Revoked access (Leaver) for: E002
[NOTIFICATION] Alert sent to Manager: User E002 has been TERMINATED
--- Cycle Complete ---
