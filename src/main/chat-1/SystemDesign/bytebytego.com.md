> How does Docker work?

A comparison of Docker-based and non-Docker-based development is shown below.
With Docker, we can develop, package, and run apps quickly:

```text
🔹 The developers can write code locally and then build a Docker image 
and push it to a dev environment. In this way, the development work is shared within the team. 
The tests are run automatically in the dev env.
```

```text
An image is a read-only template with instructions for creating a Docker container. 
We use a Dockerfile to define the steps to create the image and run it.

🔹 The above process can run incrementally when bugs are found or improvements are needed.

🔹 When dev testing is complete, the Docker image is pushed to the production environment (often on the cloud).
```
```text
Compared with traditional development without Docker, 
Docker is quite lightweight and fast, because only the changed part of Dockerfile is rebuilt 
every time we make a change.
```
![How docker works](https://media.licdn.com/dms/image/D5622AQG9VcygwLWhiw/feedshare-shrink_1280/0/1682650266922?e=1685577600&v=beta&t=VvieNpdlHaWp0I-9X__7n5utJVnomIG11CSgk8zuGX4)

> Types of Databases

```text
Relational databases are based on the relational model, 
which organizes data into tables with rows and columns. 
These databases have been the standard choice for many applications due to their robust 
consistency, support for complex queries, and adherence to ACID properties 
(Atomicity, Consistency, Isolation, Durability)
```
![Database Types](https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2Fcb5bb38f-5383-495d-aed8-cf1d0a44e03b_1600x1600.png)

![Comparing SQL DB Characteristics](https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2Fb5d5235c-260c-4cf6-969b-efa2af2265bb_1600x402.png)

> SOLID Design Principles With Examples

![SOLID Principle](https://media.licdn.com/dms/image/D5622AQEedo4e1mnAnA/feedshare-shrink_800/0/1682649390161?e=1685577600&v=beta&t=uYsp7mgtDog7Vtpp1dUm6TzyjfQNncf6tPz663gcLnc)


