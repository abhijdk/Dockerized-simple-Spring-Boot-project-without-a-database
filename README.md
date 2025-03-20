

### **1. Create a Spring Boot Project**
Use **Spring Initializr** or **Manually** create a Spring Boot project with Maven.

---

### **2. Update `pom.xml` to Set Final Name for JAR**
Modify the `<build>` section in `pom.xml`:

```xml
<build>
    <finalName>e_d</finalName>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
This ensures the generated JAR file will be named `e_d.jar`.

---

### **3. Create a `Dockerfile` in the Root of the Project**
Create a `Dockerfile` in the **same directory as `pom.xml`**:

```dockerfile
FROM openjdk:17
WORKDIR /app
COPY target/e_d.jar /app/e_d.jar
ENTRYPOINT ["java", "-jar", "e_d.jar"]
```

---

### **4. Open Command Prompt in the Project Root and Execute Commands**

#### **Step 1: Package the Spring Boot Application**
```
mvn clean package
```
- This will generate the JAR file inside the `target/` folder.

#### **Step 2: Build the Docker Image**
```
docker build -t e_d .
```
- This creates a Docker image named **`e_d`**.

#### **Step 3: Verify the Docker Image**
```
docker images
```
- This lists all available Docker images, ensuring **`e_d`** exists.

#### **Step 4: Run the Docker Container**
```
docker run -d -p 8080:8080 e_d
```
- **First `8080`** → Maps the Docker container port.
- **Second `8080`** → Maps the host system port (your local machine).
- The `-d` flag runs it in detached mode (in the background).

#### **Step 5: Verify the Running Container**
```
docker ps
```
- This checks if the container is running.

---

### **Final Notes**
1. **Access the Application**  
   Open your browser and go to:  
   **`http://localhost:8080`**
   
2. **Stopping the Container**  
   To stop the running container, first find the `CONTAINER_ID` from `docker ps`, then run:
   ```
   docker stop <CONTAINER_ID>
   ```
   
3. **Removing the Container and Image (Optional)**  
   ```
   docker rm <CONTAINER_ID>
   docker rmi e_d
   ```

This is the process for Dockerizing a Spring Boot application. 🚀
