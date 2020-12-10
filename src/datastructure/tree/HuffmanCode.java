package datastructure.tree;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Author weimin
 * @Date 2020/10/20 0020 10:01
 * 哈夫曼编码解码
 */
public class HuffmanCode {
    public static void main(String[] args) throws IOException {

        Map<Byte, Integer> count = getCount("huffman.txt");
        List<Node> list = new ArrayList<>();

        Set<Map.Entry<Byte, Integer>> set = count.entrySet();
        for (Map.Entry<Byte, Integer> next : set) {
            list.add(new Node(next.getKey(), next.getValue()));
        }

        // 生成赫夫曼树
        Node huffman = toHuffman(list);

        //pre(huffman);

        // huffman 编码表
        huffmanTable(huffman,"",new StringBuilder());
        System.out.println(huffmanTable);


        byte[] zip = zip(byteList, huffmanTable);
        System.out.println(Arrays.toString(zip));


        byte[] decode = decode(huffmanTable, zip);
        System.out.println(new String(decode));

    }
    public static byte[] decode(Map<Byte,String> huffmanTable,byte[] bytes){

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <bytes.length ; i++) {
            boolean flag = (i==bytes.length-1);
            String bytetobitstring = bytetobitstring(!flag, bytes[i]);
            stringBuilder.append(bytetobitstring);
        }
        System.out.println(stringBuilder.toString());


        Map<String,Byte> map = new HashMap<>();

        Set<Map.Entry<Byte, String>> entries = huffmanTable.entrySet();
        for (Map.Entry<Byte,String> entry:entries){
            map.put(entry.getValue(),entry.getKey());
        }
        System.out.println(map);

        List<Byte> list = new ArrayList<>();


        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag){
                String key = stringBuilder.substring(i,i+count);
                if(map.containsKey(key)){
                    b = map.get(key);
                    flag = false;
                }else {
                    count++;
                }
            }
            list.add(b);
            i+=count;
        }

        System.out.println(list);


        byte[] result = new byte[list.size()];
        for (int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static String bytetobitstring(boolean flag,byte b){
        int temp = b;
        if(flag){
            temp |= 256;
        }

        String string = Integer.toBinaryString(temp);
        if(flag){
            return string.substring(string.length()-8);
        }else {
            return string;
        }
    }


    // 原字符的字节
    static List<Byte> byteList;
    public static byte[] zip(List<Byte> byteList, Map<Byte,String> huffmanTable){
        StringBuffer stringBuffer = new StringBuffer();

        for (byte b:byteList){
            stringBuffer.append(huffmanTable.get(b));
        }
        // System.out.println(stringBuffer);

        //
        int len;
        if(stringBuffer.length()%8==0){
            len = stringBuffer.length()/8;
        }else {
            len = stringBuffer.length()/8+1;
        }
        byte[] result = new byte[len];


        int index = 0;
        for (int i = 0;i<stringBuffer.length();i=i+8){

            String s;
            if((i+8)>stringBuffer.length()){
                s = stringBuffer.substring(i);
            }else {
                s = stringBuffer.substring(i,i+8);
            }
            System.out.println(s);

            result[index] = (byte) Integer.parseInt(s,2);
            index++;

        }
        //System.out.println(result.length);
        return result;
    }


    static Map<Byte,String> huffmanTable = new HashMap<>();

    //huffman table
    public static void huffmanTable(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node!=null){
            if(node.data==null){
                huffmanTable(node.left,"0",stringBuilder1);
                huffmanTable(node.right,"1",stringBuilder1);
            }else {
                huffmanTable.put(node.data,stringBuilder1.toString());
            }
        }
    }


    //
    private static Node toHuffman(List<Node> list) {
        while (list.size()>1){
            Collections.sort(list);

            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            Node parent = new Node(null,leftNode.count+rightNode.count);
            parent.left = leftNode;
            parent.right = rightNode;

            list.add(parent);

            list.remove(leftNode);
            list.remove(rightNode);
        }
        return list.get(0);
    }

    public static void pre(Node node){
        System.out.println(node);
        if(node.left!=null){
            pre(node.left);
        }
        if(node.right!=null){
            pre(node.right);
        }
    }

    // 统计次数
    public static Map<Byte,Integer> getCount(String file) throws IOException {
        List<Byte> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        int read;
        while ((read = fileReader.read())>0){
            list.add((byte) read);
        }
        System.out.println(list);
        byteList = list;

        HashMap<Byte, Integer> hashMap = new HashMap<>();
        Set<Byte> keySet = hashMap.keySet();

        for (Byte aByte : list) {
            if (!keySet.contains(aByte)) {
                hashMap.put(aByte, 1);
            } else {
                hashMap.put(aByte, hashMap.get(aByte) + 1);
            }
        }
        System.out.println(hashMap);
        return hashMap;
    }

    static class Node implements Comparable<Node>{
        Byte data;
        int count;
        Node left;
        Node right;

        public Node(Byte data, int count) {
            this.data = data;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", count=" + count +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.count-o.count;
        }
    }
}
