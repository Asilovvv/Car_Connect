Terms of Reference (TOR) for the CarConnect project
1. General information
Project name: CarConnect — Car rental platform.
Technologies: Java (Spring Boot), PostgreSQL.
Project goal: Create a web platform that will unite renters and lessees, providing a simple, secure and convenient car rental process.
2. Project goals and objectives
Goal:

Develop a platform that allows users to rent cars, giving renters the opportunity to post offers, and renters to select and book cars online.

Tasks:

Develop a user-friendly interface for searching and filtering cars.
Ensure secure user registration and authentication.
Implement functionality for posting car rental ads.
Implement a system of reviews and ratings to evaluate renters and cars.
Ensure secure payment and online booking.
Develop a 24/7 user support module.
3. Functional requirements
3.1. Registration and authentication
Registration of users (renters and renters) via email or social networks.
Login using authentication data.
Password recovery.
3.2. Profile management
Users can update their data (name, contact information, preferences).
Renters can add information about their cars (make, model, year, rental price).
3.3. Search and filter cars
Search by key parameters: make, model, price, rental location, availability.
Filtering results by price range, car type, rating.
3.4. Booking system
Users can book cars by specifying rental dates.
Calendar integration to display available days.
Automatic notification of the renter about the booking.
3.5. Payment
Integration with payment systems for secure payment (e.g. Stripe or PayPal).
Option of prepayment and full payment of the rent through the platform.
3.6. Car Management (for Renters)
Renters can add, edit and delete car rental listings.
Track the status of bookings, receive payments and receive feedback from renters.
3.7. Review and Rating System
Renters can leave reviews about cars and renters.
Rating system to rate the quality of the car and services.
3.8. User Support
Chatbot or feedback form to provide support to users.
FAQ and knowledge base for frequently asked questions.
4. Non-functional Requirements
4.1. Security
Protection of users' personal data using data encryption.
Security of authentication via JWT (JSON Web Token) or OAuth 2.0.
4.2. Performance
Response time to user requests should not exceed 1-2 seconds.
The platform should handle up to 10,000 users simultaneously.
4.3. Reliability
The platform should be available at least 99.9% of the time.
The system should save data in case of emergency failures via backup.
4.4. Scalability
The ability to easily add new features or increase the number of supported users.
5. System Architecture
Backend: Java Spring Boot with REST API for interaction with the client.
Frontend: React or Angular for creating a dynamic user interface.
Database: PostgreSQL for storing user, car and transaction data.
Payment systems: Integration with payment gateways (Stripe, PayPal).
Hosting: Hosting the server on a cloud platform (e.g. AWS, Google Cloud).
6. Development Plan
Requirements collection: 1-2 weeks.
Architecture design: 1 week.
Backend development: 4-5 weeks.
Frontend development: 4-5 weeks.
Integration with payment systems: 1 week.
Testing and debugging: 2 weeks.
Project launch: 1 week.
7. Testing
Functionality testing: checking the operation of all modules (search, booking, registration).
Security testing: checking for SQL injections, XSS attacks and data leaks.
Load testing: checking performance with a large number of users.
8. Scope
The platform will be useful for both tourists and locals who need to rent a car for a certain period. CarConnect can also become a valuable tool for small businesses engaged in car rental.

9. Risks and solutions
Risk: Problems with the payment system.

Solution: Implementation of alternative payment methods (bank transfers, cards).

Risk: Low user activity at the start.

Solution: Conducting marketing campaigns, discounts and promotions to attract the first users.

10. Additional
The project will be implemented taking into account the possibility of expansion. Possibilities of introducing new functions such as truck and motorcycle rentals or providing short-term insurance services for rented cars will be taken into account.

This project aims to improve the car rental process, creating a safe and convenient platform for all market participants.
