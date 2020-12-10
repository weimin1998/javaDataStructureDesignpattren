package datastructure.tree;

import java.io.*;
import java.util.*;

public class HuffmanCodeFile {



    private static byte[] filezip(String src, String dir) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(src);


        byte[] bytes = new byte[fileInputStream.available()];

        fileInputStream.read(bytes);
        fileInputStream.close();

        List<Byte> byteList = new ArrayList<>();
        for (Byte b:bytes){
            byteList.add(b);
        }

        ByteList = byteList;

        Map<Byte, Integer> map = new HashMap<>();
        Set<Byte> keySet = map.keySet();


        for (Byte b : byteList) {
            if (!keySet.contains(b)) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b) + 1);
            }
        }

        System.out.println("每个字符对应ASCII码的出现次数：" + map);

        List<Node> nodeList = new ArrayList<>();
        Set<Map.Entry<Byte, Integer>> entries = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entries) {
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }

        //System.out.println("节点列表：" + nodeList);

        Node huffman = huffmanTree(nodeList);

        huffmanTable(huffman,"",new StringBuilder());
        System.out.println("哈夫曼编码表："+huffmanTable);

        byte[] zip = zip(ByteList, huffmanTable);

        FileOutputStream fileOutputStream = new FileOutputStream(dir);

        fileOutputStream.write(zip);

        fileOutputStream.close();

        return zip;

    }



    public static void main(String[] args) throws Exception {
        /*byte[] bytes = huffmanZip("huffmancode.txt");
        byte[] unzip = unzip(bytes, huffmanTable);
        System.out.println(new String(unzip));*/


        byte[] filezip = filezip("bg.png", "bg.rar");

        fileunzip(filezip,huffmanTable);
    }


    public static byte[] huffmanZip(String file) throws Exception {
        List<Node> nodeList = getTXTNodeList(file);

        System.out.println("压缩前的："+ByteList);
        Node huffman = huffmanTree(nodeList);

        huffmanTable(huffman,"",new StringBuilder());
        System.out.println("哈夫曼编码表："+huffmanTable);

        return zip(ByteList, huffmanTable);
    }




    //
    private static List<Byte> ByteList;
    /**
     * 读取文件中的字符，统计每个字符出现的次数，创建节点的list
     *
     * @param file 文件
     * @return 节点结合
     * @throws Exception 异常
     */
    private static List<Node> getTXTNodeList(String file) throws Exception {
        FileReader fileReader = new FileReader(file);
        List<Byte> byteList = new ArrayList<>();
        int read = 0;
        while ((read = fileReader.read()) > 0) {
            byteList.add((byte) read);
        }
        System.out.println("文件中字符对应的ASCII码：" + byteList);
        ByteList = byteList;

        Map<Byte, Integer> map = new HashMap<>();
        Set<Byte> keySet = map.keySet();


        for (Byte b : byteList) {
            if (!keySet.contains(b)) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b) + 1);
            }
        }

        System.out.println("每个字符对应ASCII码的出现次数：" + map);

        List<Node> nodeList = new ArrayList<>();
        Set<Map.Entry<Byte, Integer>> entries = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entries) {
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }

        System.out.println("节点列表：" + nodeList);

        return nodeList;
    }


    /**
     * 根据节点列表构建huffman树，
     * @param nodeList 节点集合
     * @return 树的根节点
     */
    private static Node huffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);

            Node left = nodeList.get(0);
            Node right = nodeList.get(1);

            Node parent = new Node(null, left.count + right.count);
            parent.left = left;
            parent.right = right;

            nodeList.add(parent);
            nodeList.remove(right);
            nodeList.remove(left);
        }

        return nodeList.get(0);
    }

    // huffman编码表
    private static Map<Byte,String> huffmanTable = new HashMap<>();
    private static void huffmanTable(Node huffman,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(huffman!=null){
            if(huffman.data==null){
                huffmanTable(huffman.left,"0",stringBuilder1);
                huffmanTable(huffman.right,"1",stringBuilder1);
            }else {
                huffmanTable.put(huffman.data,stringBuilder1.toString());
            }

        }
    }

    private static byte[] zip(List<Byte> byteList, Map<Byte,String> huffmanTable){
        StringBuilder stringBuilder = new StringBuilder();

        for (Byte b:byteList){
            stringBuilder.append(huffmanTable.get(b));
        }
        System.out.println("压缩后的："+stringBuilder.toString());

        // 转为Byte[]

        int len;
        if(stringBuilder.length()%8==0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8+1;
        }

        // 最后存储 "最后一个字节中前缀0的个数"
        byte[] bytes = new byte[len+1];
        int thelast = 0;

        int index = 0;
        for (int i = 0;i<stringBuilder.length();i=i+8){

            String s;
            if((i+8)>stringBuilder.length()){
                s = stringBuilder.substring(i);
                System.out.println("最后一组："+s);

                if(s.startsWith("0")){
                    for (int j = 0;j<s.length();j++){
                        if(s.length()==1){
                            break;
                        }
                        if(s.charAt(j)=='0'){
                            thelast++;
                        }else {
                            break;
                        }
                    }
                }
            }else {
                s = stringBuilder.substring(i,i+8);
                //System.out.println(s);
            }

            bytes[index] = (byte) Integer.parseInt(s,2);
            index++;

        }


        bytes[bytes.length-1] = (byte) thelast;
        System.out.println("压缩后的："+Arrays.toString(bytes));

        return bytes;

    }



    private static String byteTobitString(boolean flag,byte b,Integer req){
        int temp = b;
        if(!flag){
            temp |= 256;
            String s = Integer.toBinaryString(temp);
            return s.substring(s.length()-8);
        }else {

            String s = Integer.toBinaryString(temp);
            for (int i = 0;i<req;i++){
                s = "0"+s;
            }
            return s;
        }

    }

    private static void fileunzip(byte[] zip, Map<Byte,String> huffmanTable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < zip.length-1; i++) {
            boolean flag = (i==zip.length-2);
            if(flag){
                stringBuilder.append(byteTobitString(flag,zip[i],(int)zip[i+1]));
            }else {
                stringBuilder.append(byteTobitString(flag,zip[i],0));
            }
        }

        System.out.println("还原："+stringBuilder.toString());


        // 和huffman编码表 键值相反
        Map<String,Byte> map = new HashMap<>();
        Set<Map.Entry<Byte, String>> entries = huffmanTable.entrySet();
        for (Map.Entry<Byte, String> entry : entries) {
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> resultList = new ArrayList<>();

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
            resultList.add(b);
            i+=count;
        }

        byte[] result = new byte[resultList.size()];
        for (int i = 0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }


        FileOutputStream fileOutputStream = new FileOutputStream("unzip.png");

        fileOutputStream.write(result);
        fileOutputStream.close();

    }


    private static void pre(Node node) {
        System.out.println(node);
        if (node.left != null) {
            pre(node.left);
        }
        if (node.right != null) {
            pre(node.right);
        }
    }

    static class Node implements Comparable<Node> {
        // 数据
        Byte data;
        // 数据出现的次数
        int count;

        Node left;
        Node right;

        Node(Byte data, int count) {
            this.count = count;
            this.data = data;
        }

        @Override
        public int compareTo(Node node) {
            return this.count - node.count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", count=" + count +
                    '}';
        }
    }
}
