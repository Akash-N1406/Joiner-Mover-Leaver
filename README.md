# 🆔 Automated IGA JML Lifecycle Engine

A high-performance **Java-based backend engine** that automates **Identity Governance & Administration (IGA)** workflows.  
This project simulates core **User Lifecycle Management** capabilities found in enterprise platforms such as **Saviynt** and **SailPoint**.

---

## 🎯 Project Purpose

In modern enterprises, manual access management introduces serious security risks.  
This engine automates the **Joiner–Mover–Leaver (JML)** lifecycle to ensure **secure, compliant, and auditable access control**.

### Lifecycle Coverage

- **Joiners**
  - New employees are automatically provisioned with **Birthright Access** based on department and role.
- **Movers**
  - Department or role changes trigger automatic access updates to prevent **Access Creep**.
- **Leavers**
  - Terminated users have **all access revoked immediately**, eliminating **Orphaned Accounts**.

---

## 🛠️ Technical Implementation

- **Language:** Java 17  
- **Build Tool:** Maven  
- **Database:** H2 (In-memory SQL database simulating target applications)  
- **Libraries & Tools:**
  - **OpenCSV** – High-performance parsing of HR identity data
  - **JDBC** – Direct communication with downstream target systems

---

## 🏗️ Architecture & Core Features

### 1️⃣ Source Connector
- Acts as the **Source of Truth**
- Reads identity data from `hr_data.csv`
- Detects Joiner, Mover, and Leaver events

### 2️⃣ Lifecycle Logic Engine
- Compares current and previous identity states
- Applies business rules for:
  - Birthright provisioning
  - Access modification
  - De-provisioning

### 3️⃣ Target System Adapter
- Simulates enterprise applications using H2
- Executes SQL operations such as:
  - `MERGE`
  - `UPDATE`
  - `DISABLE`
- Ensures idempotent provisioning behavior

### 4️⃣ Audit & Compliance Layer
- Generates real-time **audit logs**
- Tracks provisioning and revocation actions
- Simulates **manager notifications**
- Aligns with **SOX and GDPR** compliance requirements

---

## 🚀 Installation & Execution

### Prerequisites
- Java JDK 17 or higher
- Apache Maven installed and added to `PATH`

---

### Setup Instructions

#### 1️⃣ Clone the Repository
```bash
git clone https://github.com/YOUR_USERNAME/IGA-JML-Engine.git
cd IGA-JML-Engine
2️⃣ Compile the Project
bash
Copy code
mvn clean compile
3️⃣ Run the Lifecycle Engine
bash
Copy code
mvn exec:java -Dexec.mainClass=com.iga.App
📊 Sample Audit Output
plaintext
Copy code
[DB] Target System Initialized Successfully.
--- Starting IGA Reconciliation Cycle ---
[SQL] Provisioned/Updated account for: E001
[AUDIT LOG] ACTION: PROVISIONING | TARGET: E001 | DETAILS: Access granted to IT
[SQL] Revoked access (Leaver) for: E002
[AUDIT LOG] ACTION: REVOKE_ACCESS | TARGET: E002 | DETAILS: Account disabled due to HR termination
[NOTIFICATION] Alert sent to Manager: User E002 has been TERMINATED
--- Cycle Complete ---
🛡️ Security & Compliance Focus
This project demonstrates hands-on expertise in:

Identity Lifecycle Management (ILM)

Automated Provisioning & De-provisioning

Audit Trail Generation

Least Privilege Enforcement

Access Creep Prevention

Orphan Account Elimination

📌 Key Learning Outcomes
Practical understanding of IGA platforms (Saviynt / SailPoint)

Real-world JML workflow automation

Secure backend design using Java and SQL

Compliance-oriented system architecture

👤 Author
[Your Name]
Focus Area: Identity Governance & Administration (IGA)
Target Roles: Saviynt Developer | IAM Engineer | Security Analyst
