import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack messageStack = new MyStack();
        MyQueue messageQueue = new MyQueue();

        while (true) {
            System.out.println("**********************************************");
            System.out.println("Nhập lự chọn của bạn");
            System.out.println("1. nhập tin nhắn");
            System.out.println("2. gửi tin nhắn");
            System.out.println("3. hiển thị tin nhắn");
            System.out.println("4. xóa tin nhắn");
            System.out.println("5. thoát");
            System.out.println("*******************************************");
            System.out.print("Lựa chọn của bạn: ");

            if (scanner.hasNextInt()) {
                int luaChon = scanner.nextInt();
                scanner.nextLine(); // Đọc ký tự Enter sau khi nhập số

                switch (luaChon) {
                    case 1:
                        System.out.println("Nhập tin nhắn bạn muốn gửi, (nhập 'ok' để kết thúc):");
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
                            System.out.println("Chưa có thông điệp nào được gửi!\n");
                        } else {
                            while (!messageQueue.isEmpty()) {
                                messageStack.push(messageQueue.dequeue());
                            }
                            System.out.println("Thông điệp đã được gửi!\n");
                        }
                        break;
                    case 3:
                        System.out.println("Các thông điệp đã nhận là:");
                        messageStack.display();
                        System.out.println();
                        break;
                    case 4:
                        if (!messageStack.isStackEmpty()) {
                            System.out.println("Danh sách các tin nhắn hiện tại:");
                            messageStack.display();

                            System.out.print("Nhập chuỗi bạn muốn tìm kiếm trong tin nhắn: ");
                            String searchString = scanner.nextLine();
                            String deletedMessage = messageStack.deleteMessage(searchString);

                            if (deletedMessage != null) {
                                System.out.println("Tin nhắn đã được xóa: " + deletedMessage + "\n");
                            } else {
                                System.out.println("Không có tin nhắn nào phù hợp!\n");
                            }
                        } else {
                            System.out.println("Không có tin nhắn nào ở đây!\n");
                        }
                        break;
                    case 5:
                        System.out.println("Chương trình đang đóng!");
                        System.out.println("Vui lòng đợi một chút...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Khóa sai, vui lòng nhập lại!\n");
                        break;
                }
            } else {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số!\n");
                scanner.next();
            }
        }
    }
}
