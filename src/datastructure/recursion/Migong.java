package datastructure.recursion;

/**
 * @Author weimin
 * @Date 2020/10/14 0014 14:45
 */
public class Migong {
    public static void main(String[] args) {
        int[][] map = new int[11][11];

        map[3][1] = 1;
        map[3][2] = 1;
        /*map[1][2] = 1;
        map[2][2] = 1;*/
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(i==0||j==0||i==map[i].length-1||j==map[i].length-1){
                    map[i][j]=1;
                }
            }
        }


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
                if(j==map[i].length-1){
                    System.out.println();
                }
            }
        }


        System.out.println("===========================");
        test(map,1,1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
                if(j==map[i].length-1){
                    System.out.println();
                }
            }
        }

    }

    public static boolean test(int[][] map,int i,int j){
        if(map[map.length-2][map.length-2]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j] = 2;
                if(test(map,i+1,j)){
                    return true;
                }else if (test(map,i,j+1)){
                    return true;
                }else if(test(map,i-1,j)){
                    return true;
                }else if(test(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
