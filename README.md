# Odyssey Travels (Online Bus Booking System)

## Document:
System Requirement Specification Document


## Team: 
Direct Customer, Indirect Customer, Architect, Business Analyst, Quality Assurance Team, System Analyst


## Objective 
The purpose of this document is to specify the requirements for Odyssey Travels bus booking system. Odyssey Travels bus booking system is a web-based application that enables users to book bus tickets online.

## Scope 
The system will allow admin to add, update and remove the buses, and routes. The system will allow users to search for available routes, view schedules and pricing, reserve seats. The system will also provide users with the ability to view their booking history and make changes to their reservations.

## Functional Requirements 
### Admin 
1.	User management: The admin should be able to manage users, including viewing, editing and deleting user accounts.
2.	Bus management: The admin should be able to manage the bus fleet, including adding new buses, editing existing buses and deleting buses that are no longer in service.
3.	Route management: The admin should be able to manage routes, including adding new routes, editing existing routes and deleting routes that are no longer in service.
4.	Schedule management: The admin should be able to manage schedules, including adding new schedules, editing existing schedules and deleting schedules that are no longer in service.
5.	Booking management: The admin should be able to manage bookings, including viewing, editing and cancelling bookings.
7.	Report generation: The admin should be able to generate various reports, such as sales reports, booking reports, and bus utilization reports.



### User 
1.	User registration and login: Users should be able to register for an account and log in to the system to make bookings.
2.	Search and browse routes: Users should be able to search and browse available routes by origin, destination, departure date.
3.	View schedules and pricing: Users should be able to view schedules and pricing for a selected route, and choose a departure time that works for them.
4.	Seat selection: Users should be able to select and reserve a seat on the bus.
5.	Booking confirmation: After making a booking, users should receive a confirmation email, including the details of their booking.
7.	View booking history: Users should be able to view their booking history, including past, current and future bookings.
8.	Cancel bookings: Users should be able to cancel a booking if needed.

## Non-Functional Requirements
### Security
Authentication: Users should be required to authenticate themselves before booking the tickets. This can be done through a login process that requires a username and password. <br/>
Authorization: The system should enforce access controls to ensure that only authorized users can access sensitive data and perform certain actions. <br/>
Password policy: The system should enforce a strong password policy that requires users to create passwords that are difficult to guess or crack.

### Reliability
The system will backup business data on regular basis and recover in short time duration to keep system operational Continuous updates are maintained, continuous Administration is done to keep system operational. During peak hours system will maintain same user experience by managing load balancing.

### Efficiency:
On peak timing, maximum number of users will visit website and book tickets with same response time. System will be able to manage all transactions with isolation.

### Modularity:
System will be designed and developed using reusable, independent or dependent business scenarios in the form of modules.

### Scalability:
System will be able to provide consistent user experience to irrespective of load.


