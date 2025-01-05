# JwtInMemoryExample
Jwt implementation with In Memory store

1. To make your API secure first we need to add Spring security(implementation 'org.springframework.boot:spring-boot-starter-security') dependency in build.gradle file
2. To implement JWT secure we need to add below dependency in build.gradle file:
   1. implementation 'io.jsonwebtoken:jjwt-api:0.12.6'
   2. runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.6'
   3. runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.6'
3. Once this is done, then we need to create InMemoryConfigCode.java class and define UserDetailsService bean, in this bean we are defining username and password for each user, after starting the application using these users we will generate JWT token
4. Then under security package create JwtAuthenticationEntryPoint.java class, this class is called whenever as exception is thrown due to unauthenticated user trying to access the resource that required authentication.
5. Then under security package create JwtHelper.java class, this class is used to generate token, validate token and fetch details from token.
6. Then under security package create JwtAuthenticationFilter.java class which extends OncePerRequestFilter.java, in this class we validate request and checking the request contains valid token or not and if it contains valid token then in SecurityContext object we are setting UsernamePasswordAuthenticationToken object
7. Once above steps are done, in the config package we are creating SecurityConfig.java class, in this class we are creating SecurityFilterChain bean, in this bean which endpoint we need to secured and which doesn't, also defining other details like how to manage session, exception and filter.
8. After this we are creating below 2 controllers
   1. AuthController -> In this controller we are defining, /login endpoint, this endpoint is used to generate JWT token and return in response.
   2. HomeController -> In this controller we are defining all secured endpoints, and these APIs will work only when we will pass valid JWT tokens.
