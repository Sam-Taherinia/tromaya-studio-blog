# Tromaya Studio Blog

A modern, full-stack blog application built with Spring Boot backend and React frontend. This project features a robust content management system with user authentication, rich text editing, and responsive design.

## 🚀 Features

- **User Authentication & Authorization** with Spring Security and JWT
- **Rich Text Editor** using TipTap for creating and editing blog posts
- **Responsive Design** with TailwindCSS and NextUI components
- **Database Support** for PostgreSQL (production) and H2 (testing)
- **RESTful API** architecture with comprehensive CRUD operations
- **Modern UI/UX** with smooth animations using Framer Motion
- **Content Sanitization** with DOMPurify for security
- **Database Management** interface with Adminer
- **Category and Tag Management** for content organization
- **Draft System** for post management
- **Protected Routes** with authentication guards

## 🏗️ Architecture

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.5.6
- **Java Version**: 21
- **Database**: PostgreSQL (production) / H2 (testing)
- **Security**: Spring Security with JWT authentication
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Additional Libraries**: 
  - Lombok for boilerplate reduction
  - MapStruct for object mapping
  - JWT (io.jsonwebtoken) for token management

### Frontend (React)
- **Framework**: React 18 with TypeScript
- **Build Tool**: Vite
- **UI Framework**: NextUI with TailwindCSS
- **Rich Text Editor**: TipTap
- **Routing**: React Router DOM v7
- **HTTP Client**: Axios
- **Animations**: Framer Motion
- **Security**: DOMPurify for content sanitization

## 📋 Prerequisites

Before you begin, ensure you have the following installed:
- **Java 21** or higher
- **Node.js 18** or higher
- **npm** or **yarn**
- **Docker** and **Docker Compose** (for database)
- **Git**

## 🛠️ Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/Sam-Taherinia/tromaya-studio-blog.git
cd tromaya-studio-blog
```

### 2. Database Setup
Start the PostgreSQL database and Adminer using Docker Compose:

```bash
cd backend
docker-compose up -d
```

This will start:
- PostgreSQL database on port `5432`
- Adminer (database management) on port `8888`

**Database Connection:**
- **Host**: localhost:5432
- **Database**: postgres
- **Username**: postgres  
- **Password**: makeSureToReplaceYourPasswords

### 3. Backend Setup
```bash
cd backend
# Install dependencies and run the application
./mvnw spring-boot:run
```

The backend API will be available at `http://localhost:8080`

### 4. Frontend Setup
```bash
cd app-ui
# Install dependencies
npm install

# Start the development server
npm run dev
```

The frontend application will be available at `http://localhost:5173`

## 🔧 Available Scripts

### Backend (Maven)
```bash
# Run the application
./mvnw spring-boot:run

# Run tests
./mvnw test

# Package the application
./mvnw clean package

# Clean build artifacts
./mvnw clean
```

### Frontend (npm)
```bash
# Start development server
npm run dev

# Build for production
npm run build

# Preview production build
npm run preview

# Lint code
npm run lint

# Clean project (removes node_modules, dist, etc.)
npm run clean
```

## 📁 Project Structure

```
tromaya-studio-blog/
├── backend/                           # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/tromayastudio/blog/
│   │   │   │   ├── config/            # Security configuration
│   │   │   │   ├── controllers/       # REST controllers
│   │   │   │   ├── domain/
│   │   │   │   │   ├── dtos/          # Data Transfer Objects
│   │   │   │   │   └── entities/      # JPA entities
│   │   │   │   ├── mappers/           # MapStruct mappers
│   │   │   │   ├── repositories/      # JPA repositories
│   │   │   │   ├── security/          # JWT and security components
│   │   │   │   └── services/          # Business logic services
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                      # Test files
│   ├── target/                        # Build output (ignored)
│   ├── pom.xml                        # Maven configuration
│   └── docker-compose.yml             # Database setup
├── app-ui/                            # React frontend
│   ├── src/
│   │   ├── components/                # Reusable React components
│   │   ├── pages/                     # Page components
│   │   ├── services/                  # API service layer
│   │   └── assets/                    # Static assets
│   ├── public/                        # Public assets
│   ├── dist/                          # Build output (ignored)
│   ├── node_modules/                  # Dependencies (ignored)
│   ├── package.json                   # npm configuration
│   ├── vite.config.ts                 # Vite configuration
│   └── tailwind.config.js             # TailwindCSS configuration
└── README.md
```

## 🔑 Environment Configuration

### Backend Configuration
The `application.properties` file contains:

```properties
# Application
spring.application.name=blog

# JWT Configuration
jwt.secret=your-256-bit-secret-key-here-make-it-at-least-32-bytes-long

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=makeSureToReplaceYourPasswords

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Security Configuration
spring.security.user.name=admin
spring.security.user.password=makeSureToReplaceYourPasswords
```

### Frontend Configuration
The Vite configuration includes proxy setup for API calls:

```typescript
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      }
    }
  }
})
```

## 🔌 API Endpoints

### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration (if implemented)

### Posts
- `GET /api/posts` - Get all published posts
- `GET /api/posts/{id}` - Get post by ID
- `POST /api/posts` - Create new post (authenticated)
- `PUT /api/posts/{id}` - Update post (authenticated)
- `DELETE /api/posts/{id}` - Delete post (authenticated)
- `GET /api/posts/drafts` - Get user's draft posts (authenticated)

### Categories
- `GET /api/categories` - Get all categories
- `POST /api/categories` - Create category (authenticated)
- `PUT /api/categories/{id}` - Update category (authenticated)
- `DELETE /api/categories/{id}` - Delete category (authenticated)

### Tags
- `GET /api/tags` - Get all tags
- `POST /api/tags` - Create tags (authenticated)
- `PUT /api/tags/{id}` - Update tag (authenticated)
- `DELETE /api/tags/{id}` - Delete tag (authenticated)

## 🚀 Deployment

### Backend Deployment
```bash
cd backend
./mvnw clean package
java -jar target/blog-0.0.1-SNAPSHOT.jar
```

### Frontend Deployment
```bash
cd app-ui
npm run build
# Deploy the dist/ folder to your hosting service
```

### Docker Deployment (Optional)
You can containerize both applications using Docker for easier deployment.

## 🧪 Testing

### Backend Tests
```bash
cd backend
./mvnw test
```

### Frontend Tests
```bash
cd app-ui
npm run test
```

## 🔒 Security Features

- **JWT Authentication**: Secure token-based authentication
- **Content Sanitization**: DOMPurify prevents XSS attacks
- **Protected Routes**: Authentication guards for sensitive operations
- **CORS Configuration**: Proper cross-origin resource sharing setup
- **Input Validation**: Server-side validation for all inputs

## 🎨 UI/UX Features

- **Responsive Design**: Works on desktop, tablet, and mobile
- **Dark Mode Support**: Built-in dark mode with NextUI
- **Rich Text Editor**: Full-featured editor with TipTap
- **Smooth Animations**: Framer Motion for enhanced user experience
- **Modern Components**: NextUI component library
- **Accessible Design**: WCAG compliant components

## 🛠️ Development Tools

- **Hot Reload**: Both frontend and backend support hot reload
- **Code Formatting**: ESLint for frontend code quality
- **Type Safety**: TypeScript for frontend development
- **Database Management**: Adminer for easy database administration
- **Build Optimization**: Vite for fast frontend builds
- **Annotation Processing**: Lombok and MapStruct for cleaner code

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨💻 Author

**Sam Taherinia**
- GitHub: [@Sam-Taherinia](https://github.com/Sam-Taherinia)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- React community for the amazing ecosystem
- TipTap for the rich text editor
- NextUI for the beautiful components
- MapStruct for object mapping
- All contributors and supporters of this project

## 📞 Support

If you have any questions or need support, please:
1. Check the existing issues
2. Create a new issue if needed
3. Contact the maintainer

---

**Happy Blogging! 🎉**
