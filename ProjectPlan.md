# Tattoo AI Suggestion App - Project Plan

## Week 2: Project Initialization ✅
- [x] Create project repository on GitHub
- [x] Set up project structure in IntelliJ and push to GitHub
- [x] Add link to the list of indie projects in the student repo
- [x] Complete **Problem Statement**
- [x] Document **User Stories** and identify **MVP stories**
- [x] Research Web Services/APIs to use (OpenAI API)
- [x] List **technologies and versions** (Java, Hibernate, JSP, AWS, MySQL, etc.)
- [x] Plan **database schema** (users, suggestions, styles)
- [x] Weekly reflection/time log

---

## Week 4: Planning & UI Design ✅
- [x] Write full **Project Plan**
- [x] Confirm MVP stories align with **Enterprise Java indie project objectives**
- [x] **Design UI screens**
- [x] Review **database schema**, ensure **one-to-many relationships** are correct
- [x] Create **database schema draft** (tables, constraints)
- [x] **Triple-check** everything for **Checkpoint 1**
- [x] Weekly reflection

---

## Week 5: Database Setup & API Integration
- [X] **Set up database locally** using MySQL
- [X] Write **DDL (schema creation) scripts**
- [X] Implement **DAO classes** for CRUD operations (Users, Suggestions, Styles)
- [X] Write **unit tests for DAOs**
- [X] Connect to OpenAI API:
    - [X] Create **API connector class**
    - [X] Implement **method for sending user queries and receiving suggestions**
    - [X] Handle **error responses & API rate limits**
- [X] **Set up logging** using Log4J
- [X] Weekly reflection

---

## Week 6: Suggestion Storage & Styling Feature
- [X] Implement **suggestion saving functionality**
- [X] Implement **suggestion editing functionality**
- [X] Allow users to **delete their saved suggestions**
- [X] Implement **style selection (dropdown of styles)**
- [X] Weekly reflection

---

## Week 7: Backend Implementation - Authentication & User Management
- [X] Deploy to AWS
- [X] Implement **user authentication** using cognito
    - [X] User **registration, login, logout**
    - [X] Role-based access (user, admin)
- [X] Create **JSP pages for login, registration, dashboard**
- [X] Weekly reflection

---

## Week 7.5: Checkpoint 2 – Database & CRUD Operations
- [X] **Double-check all items for Checkpoint 2**
    - [X] **Database schema finalized & implemented**
    - [X] At least **one DAO with full CRUD implemented using Hibernate**
    - [X] DAO is **fully unit tested**
    - [X] Log4J **replaces all System.out.println() statements**
- [X] **Set up AWS RDS instance for the database**
- [X] **Deploy project to AWS**
- [X] Update journal

---

## Week 8: Admin Dashboard & Security Enhancements
- [X] Implement **admin authentication**
- [X] Create **Admin JSP dashboard** to manage users
- [X] Implement **admin ability to delete users & their associated data**
- [X] Add **role-based access** to restrict admin pages
- [X] Improve **error handling and form validation**
- [X] Weekly reflection

---

## Week 9: Checkpoint 3 – Deployed App & Authentication Complete
- [X] **Verify Checkpoint 3 requirements:**
    - [X] **Authentication implemented** (user/admin)
    - [X] **At least one JSP page displaying database data**
    - [X] **AWS deployment successful & accessible**
- [X] Add **AWS link** to indie project list
- [X] Weekly reflection

---

## Week 10: User Experience & Feedback Collection
- [X] Conduct **user testing** (ask people to test app, note issues)
- [X] Improve **UI based on user feedback**
- [X] Optimize **database queries** for performance
- [X] Weekly reflection

---

## Week 11-12: Advanced Features & Refinements
- [X] Weekly reflection

---

## Week 13: Security & Performance Checks
- [X] Improve **database indexing** for faster queries
- [X] Weekly reflection

---

## Week 14: Pre-Final Review & Final Testing
- [X] Conduct **full code review**
- [X] Write **final unit tests**
- [ ] Prepare **final documentation**
- [X] Weekly reflection

---

## Week 15: Final Presentation & Documentation
- [X] Implement **feedback from review**
- [X] **Prepare final presentation**
- [ ] Create **demo video** and add link to `README.md`
- [ ] Finalize **all documentation**
- [X] Perform **code quality check**
- [ ] Weekly journal entry

---

## Week 16: Final Touches & Submission
- [X] **Final bug fixes**
- [X] Ensure **code is production-ready**
- [ ] **Submit project**
- [ ] Weekly journal entry  

## Version 2 Features
- [ ] Allow users to ***add custom styles***
- [ ] Implement **API caching** (to prevent excessive API calls)
- [ ] Optimize **page loading times**
- [ ] Implement DALL-E api for ***image generation***
- [ ] Perform **security audit** (check for vulnerabilities)
- [ ] Implement **password reset functionality**