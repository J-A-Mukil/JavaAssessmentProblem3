import java.util.*;

class fishMeetThread{
    static List<Integer> l = new ArrayList<>(Arrays.asList(0,0,1,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,0,1));
    synchronized void fun() {
        Random r = new Random();

        int x = 0;
        int y = 0;

        x = r.nextInt(l.size());
        y = r.nextInt(l.size());

        while(x == y) {
            y = r.nextInt(l.size());
        }

        System.out.println("Random positions generated: "+x+" & "+y);

        if (l.get(x) == 0 && l.get(y) == 0) {
            l.remove(x);
            l.remove(y);
            System.out.println("Two male fishes met: "+l);
            System.out.println("The array size: "+l.size());
        }
        else if (l.get(x) == 1 && l.get(y) == 1) {
            int d = new Random().nextBoolean() ? x : y;
            l.remove(d);
            System.out.println("Two Female Fishes met: "+l);
            System.out.println("The array size: "+l.size());
        }
        else if ((l.get(x) == 0 && l.get(y) == 1)||(l.get(x) == 1 && l.get(y) == 0)) {
            int z1 = r.nextInt(2);
            int z2 = r.nextInt(2);
            l.add(z1);
            l.add(z2);
            System.out.println("A male and Female fish met: "+l);
            System.out.println("The array size: "+l.size());
        }
    }
}

class Demo extends Thread{

    fishMeetThread t;
    Demo(fishMeetThread t){
        this.t=t;
    }
    public void run() {
        t.fun();
    }
}

public class Problem3 {
    public static void main(String args[]) {
        fishMeetThread t = new fishMeetThread();
        Demo d0 = new Demo(t);
        d0.start();
        Demo d1 = new Demo(t);
        d1.start();
        Demo d2 = new Demo(t);
        d2.start();
        Demo d3 = new Demo(t);
        d3.start();
        Demo d4 = new Demo(t);
        d4.start();
    }
}