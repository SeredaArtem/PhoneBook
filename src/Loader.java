import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Loader {
    public static void main(String[] args) {
        TreeMap<String , String > phoneBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String text = new String();
        String name = new String();
        String number = new String();

        for (;;){
            System.out.println("Вы хотите ввести имя или номер?");
            text = scanner.nextLine();
            if (text.equalsIgnoreCase("номер")){
                System.out.println("Введите номер");
                number = scanner.nextLine();
                if (phoneBook.containsKey(number)){
                    System.out.println(phoneBook.ceilingEntry(number));
                } else {
                    System.out.println("Такого номера нет в телефонной книге! Напишите имя владельца номера,чтобы добавить в справочник");
                    name = scanner.nextLine();
                    phoneBook.put(number, name);
                }
            }else if (text.equalsIgnoreCase("list")){
                list(phoneBook);
            }else if (text.equalsIgnoreCase("имя")){
                System.out.println("Введите имя");
                name = scanner.nextLine();
                if (phoneBook.containsValue(name)){
                    for (Map.Entry entry : phoneBook.entrySet()){
                        if (entry.getValue().equals(name)){
                            System.out.println("Номер: " + entry.getKey() + " Имя: "
                                    + entry.getValue());
                        }
                    }
                }else {
                    System.out.println("Такого имени нет в телефонной книге! Напишите номер ,чтобы добавить в справочник");
                    number = scanner.nextLine();
                    phoneBook.put(number, name);
                }
            }
        }
    }

    public static void list(Map<String , String> maps){
        for (String map : maps.keySet()){
            System.out.println(map + " " + maps.get(map));
        }
    }
}
