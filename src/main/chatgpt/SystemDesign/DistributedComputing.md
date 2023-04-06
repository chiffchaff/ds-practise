
> Cap Theoram

CAP theorem states that a distributed system can't provide more than two of these three guarantees simultaneously.

𝐂𝐨𝐧𝐬𝐢𝐬𝐭𝐞𝐧𝐜𝐲: consistency means all clients see the same data at the same time no matter which node they connect to.

𝐀𝐯𝐚𝐢𝐥𝐚𝐛𝐢𝐥𝐢𝐭𝐲: availability means any client which requests data gets a response even if some of the nodes are down.

𝐏𝐚𝐫𝐭𝐢𝐭𝐢𝐨𝐧 𝐓𝐨𝐥𝐞𝐫𝐚𝐧𝐜𝐞: a partition indicates a communication break between two nodes. Partition tolerance means the system continues to operate despite network partitions.

![Cap Theoram Explained](https://pbs.twimg.com/media/FdwPJtlUoAAQMEd?format=jpg&name=4096x4096)

> How do we design effective and safe APIs?

![Effective and safe API](https://pbs.twimg.com/media/FsepJq3aYAEDYLf?format=jpg&name=small)

> what is the difference between post and patch in REST API

  | Feature | POST | PATCH |
      | --- | --- | --- |
  | Purpose | Create a new resource | Update an existing resource |
  | Idempotent | No | No (in general) |
  | Request Body | Required | Optional |
  | Request Body Content | Full representation of the resource | Only the updated fields or partial representation of the resource |
  | Response Status | 201 Created | 200 OK (or 204 No Content if no response body) |
  | Cacheable | No | Yes |
  | Use Case Example | Creating a new user account | Updating the email address of an existing user account |

  The main difference between POST and PATCH methods in REST API is the purpose and the nature of the request body. POST is used to create a new resource and requires a request body containing the full representation of the resource being created. On the other hand, PATCH is used to update an existing resource and only requires a request body containing the updated fields or a partial representation of the resource.

  In addition, POST requests are not idempotent, which means that sending the same request multiple times may result in multiple resources being created. PATCH requests are also not idempotent in general, but they can be made idempotent by adding a unique identifier in the request body.

  POST requests are typically used when creating a new user account, adding a new item to a shopping cart, or submitting a form. PATCH requests are used when updating the email address of an existing user account, changing the status of an order, or modifying a single field of a resource.
  
> Algorithms you should know before taking system design interview

![Algorithms](https://pbs.twimg.com/media/Fr4hT9kaAAMXALD?format=jpg&name=small)

> HTTP Status Codes

The response codes for HTTP are divided into five categories:

Informational (100-199)
Success (200-299)
Redirection (300-399)
Client Error (400-499)
Server Error (500-599)

![HTTP STATUS CODES](https://pbs.twimg.com/media/Fr1cbdvaEAA55AC?format=jpg&name=small)

> Difference between forward and reverse proxy

A forward proxy, or just proxy, is a server that shields user devices from the internet.

Use it to:
1️⃣ Protect your online identity
2️⃣ Sidestep browsing restrictions
3️⃣ Block access to unwanted content

A reverse proxy server forwards requests to web servers and returns results as if it processed the request.

Use it to:
1️⃣ Shield against DDoS attacks
2️⃣ Load balancing
3️⃣ Cache static contents
4️⃣ Offload TLS termination

![Forward and reverse proxy](https://pbs.twimg.com/media/FrZmmFbaMAAQylH?format=jpg&name=small)

> What is Cloud native

![Cloud native](https://pbs.twimg.com/media/FqrQSSraQAAKuLR?format=jpg&name=small)

> What is SSO, or Single Sign-On?

With SSO, users can access many apps, such as Gmail, Slack, and Workday, without having to log in each time.
SAR => SAML Assertion Request
![SSO](https://pbs.twimg.com/media/FqRyDgWaYAArZIA?format=jpg&name=small)

> Git Commands

![Git](https://pbs.twimg.com/media/FqJgykFaUAArpJE?format=jpg&name=small)

> What are the API architectural styles?

1. REST
   Proposed in 2000, REST is the most used style. It is often used between front-end clients and back-end services. It is compliant with 6 architectural constraints. The payload format can be JSON, XML, HTML, or plain text.
2. GraphQL
   GraphQL was proposed in 2015 by Meta. It provides a schema and type system, suitable for complex systems where the relationships between entities are graph-like.
For example, in the diagram below, GraphQL can retrieve user and order information in one call, while in REST this needs multiple calls.
GraphQL is not a replacement for REST. It can be built upon existing REST services.
3. Web socket is a protocol that provides full-duplex communications over TCP. The clients establish web sockets to receive real-time updates from the back-end services. Unlike REST, which always “pulls” data, web socket enables data to be “pushed”.
4. Webhook
   Webhooks are usually used by third-party asynchronous API calls. In the diagram below, for example, we use Stripe or Paypal for payment channels and register a webhook for payment results.
   When a third-party payment service is done, it notifies the payment service if the payment is successful or failed. Webhook calls are usually part of the system’s state machine.
5. gRPC
   Released in 2016, gRPC is used for communications among microservices.
6. SOAP stands for Simple Object Access Protocol. Its payload is XML only, suitable for communications between internal systems

![API Architectural Styles](https://pbs.twimg.com/media/Fp_Nn49aQAcbuFv?format=jpg&name=900x900)

> How does foreign exchange in payments work? 

![Image](https://pbs.twimg.com/media/FpjUkUEaYAEmmuy?format=jpg&name=small)

> What are the differences between a load balancer and an API gateway?

1️⃣ NLB (Network Load Balancer) is usually deployed before the API gateway, handling traffic routing based on IP. It does not parse the HTTP requests.
2️⃣ ALB (Application Load Balancer) routes requests based on HTTP header or URL and thus can provide richer routing rules. We can choose the load balancer based on routing requirements. For simple services with a smaller scale, one load balancer is enough.
3️⃣ The API gateway performs tasks more on the application level. So it has different responsibilities from the load balancer.

they are used in combination to provide a scalable and secure architecture for modern web apps.
- ALB is used to distribute requests among different services. Due to the fact that the services implement their own rating limitation, authentication, etc., this approach is more flexible but requires more work at the service level.
- An API gateway takes care of authentication, rate limiting, caching, etc., so there is less work at the service level. However, this option is less flexible compared with the ALB approach.

![LB vs API Gateway](https://pbs.twimg.com/media/FpgTclzaIAA2GYb?format=jpg&name=small)

> What are the common load-balancing algorithms?

Static Algorithms
1. Round robin
   The client requests are sent to different service instances in sequential order. The services are usually required to be stateless.
2. Sticky round-robin
   This is an improvement of the round-robin algorithm. If Alice’s first request goes to service A, the following requests go to service A as well.
3. Weighted round-robin
   The admin can specify the weight for each service. The ones with a higher weight handle more requests than others.
4. Hash
   This algorithm applies a hash function on the incoming requests’ IP or URL.
Dynamic Algorithms
1. Least connections
   A new request is sent to the service instance with the least concurrent connections.
2. Least response time
   A new request is sent to the service instance with the fastest response time.
![Load Balancing Algorithms](https://pbs.twimg.com/media/Fo8Q-QaaIAENiYX?format=jpg&name=small)

> Generic system design framework

Here is a simple but powerful, step-by-step framework we put together to help you crack system design interviews.
![Step by Step](https://pbs.twimg.com/media/FoiePgAagAUEK4m?format=jpg&name=small)

> High volume payment processing system in Paypal

Paypal payments handles around 10k transaction per second. 4 to 5 sec. 

```plantuml
@startuml

actor Customer
participant "Load Balancer"
participant "Application Server"
participant "Payment Gateway"
database "Transaction Log"

Customer -> "Load Balancer": Sends payment request
"Load Balancer" -> "Application Server": Routes payment request
"Application Server" -> "Payment Gateway": Forwards payment request
"Payment Gateway" -> "Application Server": Returns payment response
"Application Server" -> "Load Balancer": Sends payment response
"Load Balancer" -> Customer: Returns payment response
"Payment Gateway" -> "Transaction Log": Stores payment transaction

@enduml

```

This architecture consists of the following components:

1. **Customer:** The user who initiates the payment request.
2. **Load Balancer:** Distributes incoming payment requests across multiple application servers to ensure high availability and scalability.
3. **Application Server:** Receives payment requests from the load balancer and forwards them to the payment gateway for processing.
4. **Payment Gateway:** Processes payment requests and returns payment responses to the application server.
5. **Transaction Log:** Stores payment transactions for auditing and reconciliation purposes.

To handle high volumes of transactions, the system can have multiple instances of the application server and payment gateway running in parallel, with each instance capable of processing a subset of the total load. The load balancer can distribute incoming requests evenly across the available instances, and new instances can be added dynamically to handle spikes in traffic. The payment gateway can also use caching and other optimization techniques to minimize the processing time for each transaction.
In addition, the system can employ various security measures to ensure the safety of transactions and user data, such as SSL/TLS encryption, two-factor authentication, and fraud detection algorithms. The transaction log can be replicated across multiple data centers to ensure data redundancy and disaster recovery.
