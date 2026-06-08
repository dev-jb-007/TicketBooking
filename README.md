# TicketBooking

Minimal Java 17 Maven project skeleton for a Ticket Booking system.

Build & test

```bash
mvn -v
mvn -DskipTests=false test
```

Run the application (prints a message):

```bash
mvn -q -DskipTests=true exec:java -Dexec.mainClass="com.example.ticketbooking.Application"
```

Notes

- Requires Java 17 and Maven installed on PATH.
