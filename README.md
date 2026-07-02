# Medical Staff Credential Verification - Core Blockchain Simulation

A cryptographic, from-scratch simulation of a decentralized blockchain ledger architecture engineered to securely manage, verify, and audit healthcare staff operational records (such as doctor licenses, practice certifications, and institutional roles).

This system is built entirely in native Java to demonstrate fundamental cryptographic primitives, payload confidentiality, and distributed ledger integrity without relying on heavy third-party framework layers.

---

## 🏗️ Architectural Data Flow Breakdown

The application uses an immutable block structure combined with dual asymmetric and symmetric security utilities to guarantee that credential records remain verifiable and tamper-proof.

```text
[ Raw Credential Data ] ──► Encrypted via AES-128 (AESUtility)
                                   │
                                   ▼
[ Batch Transaction Entries ] ──► Compressed into Binary Hash Tree (MerkleRootCalculator)
                                   │
                                   ▼
[ Unique Merkle Root Hash ] ──► Signed with Private RSA-2048 Key (DigitalSignatureUtility)
                                   │
                                   ▼
[ Immutable Data Payload ] ──► Anchored into Appending Chain Pointers (BlockRecord)

```

---

## 📋 Component Breakdown

* **`MainApplication.java`**: The core runtime orchestrator that establishes the initial tracking state, constructs the genesis block, schedules record simulation events, and coordinates execution logs.
* **`BlockRecord.java`**: Formulates the block data scheme (including timestamps, specific block indices, and previous block hashes) and processes the target hashing algorithm ensuring strict linear chaining.
* **`MerkleRootCalculator.java`**: Simulates a binary Merkle Tree structure. It compresses batches of transaction entries down into a single top-tier root hash to optimize block data verification.
* **`DigitalSignatureUtility.java`**: Manages secure asymmetric identity profiles using the RSA protocol (2048-bit keys paired with `SHA256withRSA`). Generates and verifies digital signatures to prove data authenticity.
* **`AESUtility.java`**: Implements symmetric cryptography (AES-128) to securely mask sensitive medical identity data payloads prior to distributed storage exposure.

---

## 🚀 Getting Started

### Prerequisites

* **Java Development Kit (JDK 8 or higher)** installed on your system.
* A standard terminal or command-line interface window.

### 1. Compile the Source Code

Navigate to the project root directory containing the source files and compile the entire cluster:

```bash
javac *.java

```

### 2. Run the Simulation

Launch the main application sequence to observe the real-time cryptographic verification logs:

```bash
java MainApplication

```

---

## 📊 Automated Simulation Log Pipeline

Upon successful execution, the runtime logs trace the data-lifecycle mechanics within your terminal:

1. **Identity Key Generation**: Safely produces the public/private RSA pair objects.
2. **Genesis Chain Activation**: Deploys the root anchor block and calculates its unique validation hash.
3. **Linear Block Linking**: Instantiates subsequent blocks, dynamically baking the previous hash index into the new pointer framework.
4. **Chain State Auditing**: Audits hash integrity between blocks to detect structural modifications.
5. **Merkle Root Consolidation**: Compiles a unified verification signature from a transaction array.
6. **Payload Confidentiality**: Exercises the AES encrypt/decrypt cycle to prove medical record data obfuscation.
7. **Signature Authentication**: Processes the dataset through public/private key filters to return a programmatic validity confirmation.

---

## 📄 Documentation

For an exhaustive exploration of the data-management methodology, underlying industry problems solved, and structural flow charts governing this approach, please refer to the **`Proposal Report.pdf`** document included in the repository.
