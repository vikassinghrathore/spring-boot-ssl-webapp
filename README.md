### Spring Boot SSL WelApp
### when enter local host 8080(http) redirect to 8443(https)

### Enter http:8080
![img.png](img.png)
### redirect To https:8443
![img_1.png](img_1.png)



### Key Generatation based on properties file

### E:\SSL>keytool -genkey -alias selfsigned -storetype PKCS12 -keyalg RSA -keysize 2048 -keyStore mykeystore.jks -validity 365
![img_2.png](img_2.png)