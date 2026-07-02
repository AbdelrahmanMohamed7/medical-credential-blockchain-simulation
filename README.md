Medical Staff Credential Verification - Core Blockchain Simulation
A cryptographic, from-scratch simulation of a decentralized blockchain ledger architecture engineered to securely manage, verify, and audit healthcare staff operational records (such as doctor licenses, practice certifications, and institutional roles).
This system is built entirely in native Java to demonstrate fundamental cryptographic primitives, payload confidentiality, and distributed ledger integrity without relying on heavy third-party framework layers.
🏗️ Architectural Data Flow Breakdown
The application uses an immutable block structure combined with dual asymmetric and symmetric security utilities to guarantee that credential records remain verifiable and tamper-proof.
Plaintext
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
Component Breakdown:
MainApplication.java: The core runtime orchestrator that establishes the initial tracking state, constructs the genesis block, schedules record simulation events, and coordinates execution logs.
BlockRecord.java: Formulates the block data scheme (including timestamps, specific block indices, and previous block hashes) and processes the target hashing algorithm ensuring strict linear chaining.
MerkleRootCalculator.java: Simulates a binary Merkle Tree structure. It compresses batches of transaction entries down into a single top-tier root hash to optimize block data verification.
DigitalSignatureUtility.java: Manages secure asymmetric identity profiles using the RSA protocol (2048-bit keys paired with SHA256withRSA). Generates and verifies digital signatures to prove data authenticity.
AESUtility.java: Implements symmetric cryptography (AES-128) to securely mask sensitive medical identity data payloads prior to distributed storage exposure.
🚀 Getting Started
Prerequisites
Java Development Kit (JDK 8 or higher) installed on your local host system.
A standard terminal or command-line interface window.
1. Compile the Source Environment
Open your terminal application, navigate directly into the root directory containing your source code components, and compile the Java cluster:
Bash
javac *.java
2. Execute the Simulation Runtime
Launch the compiled main method sequence to display the real-time cryptographic verification log tree:
Bash
java MainApplication
📊 Automated Simulation Log Pipeline
Upon successful boot, the runtime logs trace the exact data-lifecycle mechanics directly within your terminal window:
Identity Key Generation: Safely produces the public/private RSA pair objects.
Genesis Chain Activation: Deploys Block 0 (the fixed network root anchor) and calculates its unique validation hash.
Linear Block Linking: Instantiates Block 1, dynamically baking Block 0's specific hash index into its pointer framework.
Chain State Auditing: Audits hash integrity between blocks to demonstrate immediate detection of unauthorized structural modifications.
Merkle Root Consolidation: Iterates through an experimental transactional array block and compiles a unified Merkle verification root signature.
Payload Confidentiality Check: Exercises the AES encrypt/decrypt lifecycle loop to prove medical record data obfuscation and recovery parameters.
Signature Authentication Loop: Signs the operational dataset with a secure private key and processes it against public key filters to return a standard programmatic boolean validity confirmation.
