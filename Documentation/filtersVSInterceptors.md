# Filters vs Interceptor

- Filters are part of the webserver and not the Spring framework. For incoming requests, we can use filters to
  manipulate and even block requests from reaching any servlet. Vice versa, we can also block responses from reaching
  the client.

- Spring Security is a great example of using filters for authentication and authorization. To configure Spring
  Security, we simply need to add a single filter, the DelegatingFilterProxy. Spring Security can then intercept all
  incoming and outgoing traffic. This is why Spring Security can be used outside of Spring MVC.

- HandlerInterceptors are part of the Spring MVC framework and sit between the DispatcherServlet and our Controllers. We
  can intercept requests before they reach our controllers, and before and after the view is rendered.

### Key Differences and Use cases:

![image](https://www.baeldung.com/wp-content/uploads/2021/05/filters_vs_interceptors.jpg)

Filters intercept requests before they reach the DispatcherServlet, making them ideal for coarse-grained tasks such as:

- Authentication
- Logging and auditing
- Image and data compression
- Any functionality we want to be decoupled from Spring MVC

HandlerIntercepors, on the other hand, intercepts requests between the DispatcherServlet and our Controllers. This is
done within the Spring MVC framework, providing access to the Handler and ModelAndView objects. This reduces duplication
and allows for more fine-grained functionality such as:

- Handling cross-cutting concerns such as application logging
- Detailed authorization checks
- Manipulating the Spring context or model

The key takeaway is that with Filters, we can manipulate requests before they reach our controllers and outside of
Spring MVC. 