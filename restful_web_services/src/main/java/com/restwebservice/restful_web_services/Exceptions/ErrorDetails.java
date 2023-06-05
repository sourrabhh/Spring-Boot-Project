
package com.restwebservice.restful_web_services.Exceptions;
import java.time.LocalDateTime;

public class ErrorDetails 
{
    // Custome Exception Details
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) 
    {  
        // super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
  
}
