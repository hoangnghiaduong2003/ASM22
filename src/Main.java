import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack messageStack = new MyStack();
        MyQueue messageQueue = new MyQueue();

        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("NHẬP LỰA CHỌN CỦA BẠN");
            System.out.println("1. NHẬP THÔNG ĐIỆP");
            System.out.println("2. GỬI THÔNG ĐIỆP");
            System.out.println("3. HIỂN THỊ THÔNG ĐIỆP");
            System.out.println("4. XÓA THÔNG ĐIỆP VỪA NHẬP");
            System.out.println("5. THOÁT");
            System.out.println("-----------------------------------------------------");
            System.out.print("Lựa chọn của bạn: ");

            if (scanner.hasNextInt()) {
                int luaChon = scanner.nextInt();
                scanner.nextLine(); // Đọc ký tự Enter sau khi nhập số

                switch (luaChon) {
                    case 1:
                        System.out.println("Nhập thông điệp và nhấn Enter để kết thúc nhập:");
                        String thongDiep = scanner.nextLine();
                        if (!thongDiep.isEmpty() && thongDiep.length() < 250) {
                            messageQueue.enqueue(thongDiep);
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
                        String poppedMessage = messageStack.pop();
                        if (poppedMessage != null) {
                            System.out.println("Một thông điệp đã được loại bỏ: " + poppedMessage + "\n");
                        } else {
                            System.out.println("Không có thông điệp nào ở đây!\n");
                        }
                        break;
                    case 5:
                        System.out.println("Chương trình đang đóng!");
                        System.out.println("Vui lòng đợi một chút...");
                        try {
                            Thread.sleep(3000);
                            System.exit(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
