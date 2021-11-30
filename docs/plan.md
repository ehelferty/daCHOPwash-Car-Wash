# General Overview
## Main Application
### User Controller OR Employee Controller and Customer Controller
Handles everything to do with users. If there is a separate Roles table for the employees, that will also be handled by the User Controller.
### Wash Controller
Handles everything to do with Washes. When a wash is completed, calls the Invoice Controller to create an invoice.
### Invoice Controller
Handles everything to do with invoices. Conceptually, processes payment using a third party service.

## November 30th
In lab today, hammer out the system diagram. Schedule a meeting with Colin to discuss our progress.
Meeting Notes:
 - Can we use a CSS framework like bootstrap or whatever? (If yes, does it have to be Bootstrap?)
 - 
 -