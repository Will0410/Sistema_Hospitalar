package Model;


    public class user extends userFunc {



        public String username;
        public String email;
        public String age;
        public String password;

        public int user_id;
        public String proced;

        public String getProced() {
            return proced;
        }

        public void setProced(String proced) {
            this.proced = proced;
        }


        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public String getAge() {
            return age;
        }
        public void setAge(String age) {
            this.age = age;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }



    }
