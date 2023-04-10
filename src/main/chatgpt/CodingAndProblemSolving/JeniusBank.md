> What is difference between GraphQL vs Rest

| Features | GraphQL | REST |
| --- | --- | --- |
| Data Fetching | GraphQL allows fetching only the required data by specifying the required fields in the query | REST API fetches the entire data of a resource |
| Multiple Endpoints | GraphQL has a single endpoint for all the queries and mutations | REST API has multiple endpoints for each resource |
| Schema Definition | GraphQL has a schema that defines the data types and relationships between them | REST API does not have a defined schema |
| Versioning | GraphQL does not require versioning since it uses a schema | REST API requires versioning to maintain backward compatibility |
| Caching | GraphQL does not have built-in caching | REST API has built-in caching for faster data retrieval |
| Security | GraphQL supports query validation and authorization using directives | REST API uses tokens and cookies for authentication and authorization |
| Error Handling | GraphQL returns a structured error object with error code and message | REST API returns an HTTP status code and error message |
| Performance | GraphQL fetches only the required data, thus reducing network usage and improving performance | REST API fetches the entire data, even if it is not required, leading to network overhead and poor performance |
| Mobile Development | GraphQL is more suitable for mobile development since it allows fetching only the required data | REST API may not be suitable for mobile development due to network overhead and performance issues |
| Tooling | GraphQL has extensive tooling support for client and server development | REST API has limited tooling support compared to GraphQL |



