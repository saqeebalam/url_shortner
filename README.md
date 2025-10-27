# 🔗 URL Shortener

A simple and efficient **URL Shortener Web Application** built using **Java, Spring Boot, MongoDB Atlas**, and a minimal **HTML/CSS/JavaScript frontend**.  
This app allows users to input a long URL and generate a short, shareable version instantly.

---

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-1.0.0-green.svg)

## 🚀 Features

- ✂️ Shorten long URLs instantly  
- 🔁 Redirect short URLs to their original destination  
- 🌐 Stores URL mappings in **MongoDB Atlas**  
- 💡 REST API built with **Spring Boot**  
- 🎨 Simple and responsive frontend using **HTML, CSS, and JS**  
- ☁️ Deployed on **Railway**

---

## 🏗️ Tech Stack

**Backend:**  
- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data MongoDB  

**Frontend:**  
- HTML  
- CSS  
- JavaScript  

**Database:**  
- MongoDB Atlas (Cloud-based NoSQL)

**Deployment:**  
- Railway

---

## ⚙️ Setup and Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/saqeebalam/url_shortner.git
   cd url_shortner

2. **Configure MongoDB Atlas:**
    --Create a cluster on MongoDB Atlas
    --Add your database URI in application.properties:
        --spring.data.mongodb.uri=YOUR_MONGODB_ATLAS_URI

3. ## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|-----------|--------------|
| **POST** | `/api/shorten?url=<longURL>` | Generates a short URL and returns it |
| **GET** | `/{shortCode}` | Redirects to the original long URL |


---


🧠 Learning Highlights

    *Hands-on with RESTful API development using Spring Boot
    *Integration with MongoDB Atlas for cloud data storage
    *Understanding of URL encoding & decoding logic
    *Frontend-backend connectivity using Fetch API
    *Deployment via Railway

🎯 Future Enhancements

    *📈 Track total clicks for each shortened URL
    *👤 Add user authentication for personalized URLs
    *🕒 Set URL expiry time
    *📊 Dashboard for analytics    


## 🔄 How It Works

```text
┌────────────────────────┐
│  User enters long URL  │
└────────────┬───────────┘
             │
             ▼
┌────────────────────────────┐
│ Request sent to Spring     │
│ Boot API (POST /shorten)   │
└────────────┬───────────────┘
             │
             ▼
┌────────────────────────────┐
│ Generate unique short ID   │
│ and save mapping to DB     │
│ { shortId → longUrl }      │
└────────────┬───────────────┘
             │
             ▼
┌────────────────────────────┐
│ Return short URL to user   │
│ (e.g. https://sho.rt/Ab12) │
└────────────┬───────────────┘
             │
             ▼
┌────────────────────────────┐
│ User visits short URL      │
│ (GET /Ab12)                │
└────────────┬───────────────┘
             │
             ▼
┌────────────────────────────┐
│ Backend looks up long URL  │
│ and redirects the browser  │
└────────────────────────────┘

