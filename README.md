# Job Fair Booth Pre-Registration System

> **A full-stack web application built with Spring Boot and React**
>
> Users can pre-register for job fair booths, and administrators can manage and export the registration list to Excel.

---

## 📌 Project Overview

- A web platform for users to pre-register for job fair booths online
- Users fill out their name, date of birth, contact number, and select a booth/time
- Duplicate registration is prevented via validation logic
- Admins can download the full registration list as an Excel file

---

## 🎯 Core Features

### User Page
- Select from 5 available booths with hourly time slots
- Time slots available from 09:00 to 17:00 (1-hour intervals)
- Duplicate registration with the same name + phone + booth is blocked
- Multiple booth registrations at the same time are **not allowed**
- Multiple booth registrations at **different times** are **allowed**

### Admin Page
- Admin login (to be secured using Spring Security)
- View all registration entries
- Download registration data as an Excel file (via Apache POI)

---

## 🛠 Tech Stack

### Backend
- Java 17+
- Spring Boot 3.x
- Spring Web / Spring Data JPA / Spring Security
- MySQL / H2 (for development)
- Apache POI (for Excel export)

### Frontend
- React + Vite
- Tailwind CSS
- Axios (for API communication)

### Deployment
- AWS EC2 + RDS or local environment
- Docker (optional)

---

## 🗃 ERD Summary

### `Booth` Table

| Field        | Type   | Description   |
|--------------|--------|----------------|
| id           | Long   | PK, booth ID   |
| name         | String | Booth name     |
| description  | String | Optional       |

---

### `Application` Table

| Field        | Type          | Description                       |
|--------------|---------------|-----------------------------------|
| id           | Long          | PK, application ID                |
| name         | String        | Applicant name                    |
| birthDate    | LocalDate     | Date of birth                     |
| phone        | String        | Contact number                    |
| timeSlot     | LocalTime     | Requested time slot (09:00~17:00) |
| booth        | Booth         | Associated booth (FK)             |
| createdAt    | LocalDateTime | Registration timestamp            |

- Unique constraint on `(name, phone, booth_id)`
- Conflict check for overlapping time slots is handled in service logic

---

## 📝 Future Enhancements

- Allow admins to configure booths and time slots via UI
- Add email/SMS notifications for applicants
- Generate registration confirmation as PDF
- Optimize UI for mobile devices

---

## ⚙️ Getting Started

To be added soon