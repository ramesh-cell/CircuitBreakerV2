Using Circuit Breaker Without a Fallback Method:

While specifying a fallback method in Resilience4j provides a way to handle failures gracefully, it's not mandatory. If no fallback method is defined and the Circuit Breaker is open (meaning it prevents calls to a failing service), the library will throw a CallNotPermittedException. This exception indicates that the Circuit Breaker is open and the call was not permitted.

Handling CallNotPermittedException:

To manage scenarios where no fallback method is provided, and you want to handle the CallNotPermittedException globally, you can implement an exception handler within your application. Here's an example using Spring Boot's @ControllerAdvice:
