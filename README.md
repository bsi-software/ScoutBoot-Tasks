# Tasks - [Scout Boot] Integration Example -  <img src="https://travis-ci.org/boardend/SpringBoot-and-EclipseScout.svg">

**Please Note**: This is work in progress and has not (yet) been tested for productive usage.

## Application Description
Minimal but fully functioning business application
* Business use case: Task management
* Administration use case: User, role and permission management
* Interfaces: Both UI and REST API

### Application Login
When running from within Eclipse, open your browser at [localhost](http://localhost:8080). The login dialog then appears as shown below. You may use root/eclipse as login/password for the development environment. The other default users are alice/test and bob/test.

![Login Screen](/screenshots/console_login_form.png)

### Task Management

In the **Tasks** outline you may add new tasks and/or edit existing tasks. Mandatory fields for tasks are title, responsible and due date. When tasks

![Add a new Task](/screenshots/ui_new_task.png)

### User and Role Management

Users that have the **root** role assigned may manage roles and users in the **Administration** outline. Editing a user is shown in the screenshot below.

![Edit a User](/screenshots/ui_edit_user.png)

In the dev setup only user root has admin priviledges, users alice and bob do not have root access and therefore don't see the admin outline.

Users with the root role may also add/change roles and defining its associted permissions.

![Edit Roles](/screenshots/ui_edit_role.png)

## Docker Setup

In order to run the application using docker you first have to build a suitable docker image. You can accomplish this using the maven integration by executing the "docker:build" goal from the project's root directory:
<pre>
$ mvn install docker:build
</pre>
When the build is finished the docker image will have been created in the context of your locally running docker daemon:
<pre>
$ docker images
REPOSITORY  TAG                        IMAGE ID        CREATED             SIZE
tasks       standalone_0.1.0-SNAPSHOT  12b5ccbd8a51    About an hour ago   690 MB
</pre>

### Launch using the built-in h2 database

In order to launch the application and access it with your browser you have to bind the container port 8080 to a free port of one of your local interfaces:
<pre>
$ docker run -d -p 8080:8080 tasks:standalone_0.1.0-SNAPSHOT
</pre>
Now you can access the application as mentioned before at http://localhost:8080 from your browser. The container will use a h2 database living inside of the container, which means your data will survive container restarts but will be gone as soon as you remove the container. In order to keep the data even if you remove the container you have to create a volume and mount it at the appropriate location:
<pre>
$ docker volume create tasks_data
$ docker run -d -p 8080:8080 -v tasks_data:/root tasks:standalone_0.1.0-SNAPSHOT
</pre>

### Launch with an external database using docker-compose

In order to launch the application an have it run against an external database (postgres in this case) you can use the provided docker-compose.yaml file. From the project's root directory issue the following commands:
<pre>
$ cd org.eclipse.scout.boot.tasks/standalone
$ docker-compose up -d
</pre>
This will yield the following:

* Spin up a PostgreSQL database container using the official postgres image.
* Spin up the application container as before except that it does no longer use the built in h2 database.
* Both containers will be linked with a network called "standalone_tasks".
* The PostgreSQL container will write its data into a volume called "standalone_pgdata".
* The application container will listen on port 8080 on all local interfaces.
* The PostgreSQL container will not bind to any interfaces and will therefore just be reachable through the mentioned docker network.

## Technologies per Component
* Main frameworks: Spring Boot and Eclipse Scout
* Authentication and authorization: Servlet filters, java.security, Eclipse Scout
* Internationalization: Eclipse Scout
* Persistence: javax.persistence, Spring Data JPA, Hibernate, H2
* Validation: javax.validation
* Business logic: Plain Java: Independent of Spring and Scout
* User interface: Eclipse Scout
* REST API: Spring

## Implemented Features / Status
* Spring and Scout integration
* Business logic
* Persistences for tasks, users and roles
* User interface for tasks and admin
* REST API (readonly so far)
* Authorization and authentication by Spring Security
* Dockerized application with multi-container setup: Data, DB, Application
* Minimal Maven archetype based on this application

## Roadmap
* Add OAuth2 authentification