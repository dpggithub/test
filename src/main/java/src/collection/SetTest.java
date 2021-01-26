package src.collection;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SetTest {
        public static void main(String[] args) {
            Message[] messages=new Message[]{
                    new Message(1, "Hello!"),
                    new Message(2, "发工资了吗？"),
                    new Message(2, "发工资了吗？"),
                    new Message(3, "去哪吃饭？"),
                    new Message(3, "去哪吃饭？"),
                    new Message(4, "Bye")};
            List<Message> received= Arrays.asList(messages);
            List<Message> displayMessages = process(received);
            for (Message message : displayMessages) {
                System.out.println(message.text);
            }
        }

        static List<Message> process(List<Message> received) {
            // 按sequence去除重复消息
            TreeSet<Integer> treeSet=new TreeSet<>();
            for(Message M:received){
                treeSet.add(M.sequence);
            }
            for(Integer I:treeSet){
                //received.add();
            }
            return received;
        }
    }

    class Message {
        public final int sequence;
        public final String text;
        public Message(int sequence, String text) {
            this.sequence = sequence;
            this.text = text;
        }
    }

