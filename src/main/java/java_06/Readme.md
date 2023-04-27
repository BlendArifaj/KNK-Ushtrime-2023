# Add library:
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.27</version>
        </dependency>

# Create util connection class:

    public class ConnectionUtil {
    
        private static Connection connection;
    
        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/knk2023";
                String user = "root";
                String password = "root";
                connection = DriverManager.getConnection(url, user, password);
            }
            return connection;
        }
    }


# Use connection class:

        String sql = "SELECT * FROM users WHERE id=?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

# Create Model:

    public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    
        // Constructors
        public User() {}
    
        public User(int id, String firstName, String lastName, int age) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    
        // Getters and Setters
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getFirstName() {
            return firstName;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public String getLastName() {
            return lastName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    }


# Create Repository:

    public class UserRepository {

        public static void insert(User user) throws SQLException {
            String sql = "INSERT INTO users (firstname, lastname, age) VALUES (?, ?, ?)";
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAge());
                statement.executeUpdate();
            }
        }
    
        public static User getById(int id) throws SQLException {
            String sql = "SELECT * FROM users WHERE id=?";
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    int age = resultSet.getInt("age");
                    return new User(id, firstName, lastName, age);
                } else {
                    return null;
                }
            }
        }
    
        public static void update(User user) throws SQLException {
            String sql = "UPDATE users SET firstname=?, lastname=?, age=? WHERE id=?";
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAge());
                statement.setInt(4, user.getId());
                statement.executeUpdate();
            }
        }
    
        public static void delete(int id) throws SQLException {
            String sql = "DELETE FROM users WHERE id=?";
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        }
        
        public static void getAll() throws SQLException {
    
        }
    }

# Use repository:
    
    public class Main {
        public static void main(String[] args) throws SQLException {
        // Create a new user repository
    
            // Insert a new user into the database
            User newUser = new User(1, "John", "Doe", 25);
            UserRepository.insert(newUser);
    
            // Retrieve user with id from db
            User user = UserRepository.getById(1);
    
            user.setAge(20)
            UserRepository.update(user);
    
            // Print the retrieved user
            System.out.println(user);
        }
    }
