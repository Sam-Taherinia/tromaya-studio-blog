# Tromaya Studio Blog

A modern, full-stack blog application built with Spring Boot backend and React frontend. This project features a robust content management system with user authentication, rich text editing, and responsive design.

## 🚀 Features

- **User Authentication & Authorization** with Spring Security
- **Rich Text Editor** using TipTap for creating and editing blog posts
- **Responsive Design** with TailwindCSS and NextUI components
- **Database Support** for both PostgreSQL (production) and H2 (testing)
- **RESTful API** architecture
- **Modern UI/UX** with smooth animations using Framer Motion
- **Content Sanitization** with DOMPurify for security
- **Database Management** interface with Adminer

## 🏗️ Architecture

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.5.6
- **Java Version**: 21
- **Database**: PostgreSQL (production) / H2 (testing)
- **Security**: Spring Security with JWT authentication
- **ORM**: Spring Data JPA
- **Build Tool**: Maven
- **Additional Libraries**: Lombok for boilerplate reduction

### Frontend (React)
- **Framework**: React 18 with TypeScript
- **Build Tool**: Vite
- **UI Framework**: NextUI with TailwindCSS
- **Rich Text Editor**: TipTap
- **Routing**: React Router DOM
- **HTTP Client**: Axios
- **Animations**: Framer Motion

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
- **Password**: 123456

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

# Clean project
npm run clean
```

## 📁 Project Structure

```
tromaya-studio-blog/
├── backend/                 # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/        # Java source code
│   │   │   └── resources/   # Configuration files
│   │   └── test/           # Test files
│   ├── pom.xml             # Maven configuration
│   └── docker-compose.yml  # Database setup
├── app-ui/                 # React frontend
│   ├── src/
│   │   ├── components/     # React components
│   │   ├── pages/          # Page components
│   │   ├── hooks/          # Custom hooks
│   │   ├── services/       # API services
│   │   └── utils/          # Utility functions
│   ├── package.json        # npm configuration
│   ├── vite.config.ts      # Vite configuration
│   └── tailwind.config.js  # TailwindCSS configuration
└── README.md
```

## 🔑 Environment Variables

### Backend
Create `application.properties` in `backend/src/main/resources/`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update

# Security Configuration
jwt.secret=your-jwt-secret-key
jwt.expiration=86400000
```

### Frontend
Create `.env` in `app-ui/`:

```env
VITE_API_BASE_URL=http://localhost:8080/api
```

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

## 📝 API Documentation

The backend provides RESTful APIs for:
- User authentication (`/api/auth`)
- Blog post management (`/api/posts`)
- User management (`/api/users`)
- Comments system (`/api/comments`)

API documentation will be available at `http://localhost:8080/swagger-ui.html` (if Swagger is configured).

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Sam Taherinia**
- GitHub: [@Sam-Taherinia](https://github.com/Sam-Taherinia)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- React community for the amazing ecosystem
- TipTap for the rich text editor
- NextUI for the beautiful components
- All contributors and supporters of this project

## 📞 Support

If you have any questions or need support, please:
1. Check the existing issues
2. Create a new issue if needed
3. Contact the maintainer

---

**Happy Blogging! 🎉**