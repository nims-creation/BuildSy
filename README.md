# BuildSy 🚀

**An AI-powered code generation platform — similar to Lovable.dev — built from scratch.**

BuildSy lets users create, manage, and collaborate on software projects through a conversational AI interface. Describe what you want to build, and BuildSy generates the code for you — stored, versioned, and ready to preview.

---

## 🧠 What is BuildSy?

BuildSy is a full-stack backend platform that powers an AI-driven development experience. Users can:

- **Create projects** and manage their files in the cloud
- **Chat with an AI** to generate, edit, and refactor code
- **Invite team members** and assign roles within projects
- **Subscribe to plans** with usage-based billing via Stripe
- **Preview generated code** directly from the platform
- **Upload and store files** using MinIO (S3-compatible storage)

---

## ⚙️ Tech Stack

| Layer | Technology |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Boot 4.0.2 |
| **AI / LLM** | Spring AI + OpenRouter (GPT-4o-mini) |
| **Database** | PostgreSQL (via pgvector) |
| **ORM** | Spring Data JPA + Hibernate |
| **Security** | Spring Security + JWT (JJWT 0.12.6) |
| **Payments** | Stripe Java SDK 28.4.0 |
| **File Storage** | MinIO (S3-compatible) |
| **Object Mapping** | MapStruct 1.6.3 |
| **Boilerplate Reduction** | Lombok |
| **Build Tool** | Maven |
| **Containerization** | Docker Compose |

---

## 📁 Project Structure

```
BuildSy/
├── src/main/java/com/nims_creation/projects/BuildSy/
│   ├── Config/             # AiConfig, PaymentConfig, StorageConfig
│   ├── Controller/         # REST API controllers
│   │   ├── AuthController
│   │   ├── BillingController
│   │   ├── ChatController
│   │   ├── FileController
│   │   ├── ProjectController
│   │   ├── ProjectMemberController
│   │   └── UsageController
│   ├── Dto/                # Data Transfer Objects
│   │   ├── Auth/           # Login, Signup, UserProfile
│   │   ├── Chat/           # ChatRequest, ChatResponse, ChatEventResponse
│   │   ├── Member/         # InviteMember, MemberResponse, UpdateRole
│   │   ├── Project/        # FileNode, FileContent, ProjectRequest/Response
│   │   └── Subscription/   # Plans, Checkout, Portal, Usage
│   ├── Entity/             # JPA Entities
│   │   ├── Enum/           # ChatEventType, MessageRole, ProjectRole, etc.
│   │   ├── User, Project, ProjectFile, ProjectMember
│   │   ├── ChatSession, ChatMessage, ChatEvent
│   │   ├── Plan, Subscription, UsageLog, Preview
│   ├── Error/              # Global Exception Handling
│   ├── LLM/                # AI integration layer
│   │   ├── Advisors/       # FileTreeContextAdvisor
│   │   ├── Tools/          # CodeGenerationTools
│   │   ├── LlmResponseParser
│   │   └── PromptUtils
│   ├── Mapper/             # MapStruct mappers
│   ├── Repository/         # Spring Data JPA repositories
│   ├── Security/           # JWT Auth Filter, Web Security Config
│   └── Service/            # Business logic (Interface + Impl)
│       └── Impl/
├── src/main/resources/
│   ├── application.yaml    # Main config (DB, AI, Stripe, MinIO)
│   └── application.properties
├── services.docker-compose.yml   # PostgreSQL + MinIO containers
└── pom.xml
```
