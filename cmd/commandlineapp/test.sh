mvn install
mvn exec:java -Dexec.mainClass="commandlineapp.src.main.java.com.example.commandlineapp.App" -Dexec.args="get"
mvn exec:java -Dexec.mainClass="commandlineapp.src.main.java.com.example.commandlineapp.App" -Dexec.args="create firstname lastname 2000-01-10"