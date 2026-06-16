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

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- Docker & Docker Compose
- OpenRouter API Key (or OpenAI key)
- Stripe account (for billing features)

### 1. Start Infrastructure Services

```bash
docker-compose -f services.docker-compose.yml up -d
```

This spins up:
- **PostgreSQL** (pgvector) on port `9010`
- **MinIO** (Object Storage) on port `9000` (API) and `9001` (Console)

### 2. Configure Environment Variables

Create a `.env` file in the project root:

```env
OPENAI_API_KEY=your_openrouter_or_openai_key
JWT_SECRET_KEY=your_jwt_secret_key
STRIPE_SECRET_KEY=your_stripe_secret_key
STRIPE_WEBHOOK_SECRET=your_stripe_webhook_secret
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

The server starts on `http://localhost:8080`.

---

## 🗺️ API Endpoints (Overview)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/signup` | Register new user |
| POST | `/auth/login` | Login and get JWT |
| GET | `/auth/profile` | Get current user profile |
| GET/POST | `/projects` | List / Create projects |
| GET/DELETE | `/projects/{id}` | Get / Delete project |
| POST | `/projects/{id}/chat` | Send AI chat message |
| GET | `/projects/{id}/files` | Browse file tree |
| GET/PUT | `/projects/{id}/files/{path}` | Read / Write file |
| POST | `/projects/{id}/members` | Invite member |
| GET | `/billing/plans` | List subscription plans |
| POST | `/billing/checkout` | Start Stripe checkout |
| POST | `/billing/portal` | Open billing portal |
| GET | `/usage/today` | Get today's usage |

---

## 🐳 Docker Services

```yaml
# services.docker-compose.yml

PostgreSQL (pgvector):
  Port: 9010 → 5432
  DB: pgvector-test
  User: user / password

MinIO:
  API Port: 9000
  Console Port: 9001
  Credentials: minioadmin / minioadmin123
```
