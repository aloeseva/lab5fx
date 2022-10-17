package com.vsu.labs.lab8;

public class Lab8Service {
    public static String getTest(int testNumber) {
        String input = Lab8Files.getInput("");
        String output = Lab8Files.getOutput("");
        return "Тест №" + testNumber + input + output;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        // Auto-generated method stub
//        LinkedList <Integer> List1 = new LinkedList<>();
//        LinkedList <Integer> List2 = new LinkedList<>();
//        LinkedList <Integer> List3 = new LinkedList<>();
//        File file = new File("C:\\Users\\1\\Desktop\\first.txt");
//        File file1 = new File("C:\\Users\\1\\Desktop\\output.txt");
//        Scanner scan = new Scanner(file);
//        String str = scan.nextLine();
//        String[] val = str.split(" ");
//
//        for(int i = 0;i<val.length;i++) {
//            List1.add(Integer.valueOf(val[i]));
//        }
//        while(scan.hasNext()) {
//            List2.add(scan.nextInt());
//        }
//        scan.close();
//        inList1XorInList2(List1,List2,List3);
//        System.out.println(List3.toString());
//        scan.close();
//        PrintWriter pw = new PrintWriter(file1);
//        for(int i = 0;i<List3.size();i++) {
//            pw.write(" "+List3.get(i));
//        }
//        pw.close();
//    }
//
//    static LinkedList<Integer> inList1XorInList2(
//            LinkedList<Integer> List1, LinkedList<Integer> List2, LinkedList<Integer>List3){
//        for(int i = 0;i<List1.size();i++) {
//            if(indexOf(List2,List1.get(i)) == -1 && !(List3.contains(List1.get(i)))) {
//                List3.add(List1.get(i));
//            }
//        }
//        for(int i = 0;i<List2.size();i++) {
//            if(indexOf(List1,List2.get(i)) == -1 && !(List3.contains(List2.get(i)))) {
//                List3.add(List2.get(i));
//            }
//        }
//        return List3;
//    }
//    static int indexOf(LinkedList<Integer> list, int value) {
//        return list.indexOf(value);
//    }
}
