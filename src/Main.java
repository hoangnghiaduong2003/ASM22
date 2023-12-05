import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack messageStack = new MyStack();
        MyQueue messageQueue = new MyQueue();

        while (true) {
            System.out.println("**********************************************");
            System.out.println("Enter your selection");
            System.out.println("1. enter message");
            System.out.println("2. send Message");
            System.out.println("3. display message");
            System.out.println("4. delete message");
            System.out.println("5. exit");
            System.out.println("*******************************************");
            System.out.print("Your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Read the Enter character after entering the number

                switch (choice) {
                    case 1:
                        System.out.println("Enter the message you want to send, (enter 'ok' to finish):");
                        String message = "";
                        while (true) {
                            String line = scanner.nextLine();
                            if (line.equals("ok")) {
                                break;
                            }
                            message += line + "\n";
                        }
                        if (!message.isEmpty() && message.length() < 250) {
                            messageQueue.enqueue(message.trim());
                        }
                        break;

                    case 2:
                        if (messageQueue.isEmpty()) {
                            System.out.println("No messages have been sent!\n");
                        } else {
                            while (!messageQueue.isEmpty()) {
                                messageStack.push(messageQueue.dequeue());
                            }
                            System.out.println("Messages have been sent!\n");
                        }
                        break;
                    case 3:
                        System.out.println("Received messages are:");
                        messageStack.display();
                        System.out.println();
                        break;
                    case 4:
                        if (!messageStack.isStackEmpty()) {
                            System.out.println("Current list of messages:");
                            messageStack.display();

                            System.out.print("Enter the string you want to search for in the messages: ");
                            String searchString = scanner.nextLine();
                            String deletedMessage = messageStack.deleteMessage(searchString);

                            if (deletedMessage != null) {
                                System.out.println("Message deleted: " + deletedMessage + "\n");
                            } else {
                                System.out.println("No matching messages found!\n");
                            }
                        } else {
                            System.out.println("No messages here!\n");
                        }
                        break;
                    case 5:
                        System.out.println("The program is closing!");
                        System.out.println("Please wait a moment...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid key, please try again!\n");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number!\n");
                scanner.next();
            }
        }
    }
}
