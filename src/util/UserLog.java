package util;

import java.util.HashMap;
import java.util.Map;

public class UserLog {

  public Map<String, User> users;

  public UserLog() {
    users = new HashMap<>();
  }

  public UserLog(Map<String, User> users) {
    this.users = users;
  }

  public Map<String, User> getMap() {
    return users;
  }

  public void putIfAbsent(String userName, User user) {
    users.putIfAbsent(userName, user);
  }
}
