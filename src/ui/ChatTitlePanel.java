package ui;

import java.util.Optional;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import util.MessageThread;

@SuppressWarnings("serial")
public class ChatTitlePanel extends JPanel implements MessageThreadObserver {
  private String chatTitle = "Chat Title";
  private String chatOwners = "";
  private LocalStorage localStorage;
  private JTextArea titleText;

  public ChatTitlePanel(LocalStorage localStorage) {
    this.localStorage = localStorage;
    this.titleText = new JTextArea(chatTitle + "\n Chat Owners: " + chatOwners);

    titleText.setOpaque(false);
    titleText.setEditable(false);
    titleText.setFocusable(false);
    titleText.setAlignmentX(CENTER_ALIGNMENT);

    add(titleText);
  }

  @Override
  public void addNewMessageThread(MessageThread newThread) {}

  @Override
  public void threadSwitched(long messageThreadId) {
    Optional<MessageThread> switchedToThread = localStorage.getMessageThread(messageThreadId);
    switchedToThread.ifPresent(thread -> {
      StringBuilder owners = new StringBuilder();
      chatTitle = thread.getName();
      thread.getOwners().forEach(owner -> owners.append(owner.getUsername() + " "));
      chatOwners = owners.toString();
      titleText.setText(chatTitle + "\n" + chatOwners);
    });
  }
}
