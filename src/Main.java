import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main
{
    static void game(Stack<Integer> first, Stack<Integer> second)
    {
        int step = 0;
        while (!first.isEmpty() && !second.isEmpty() && step < 106)
        {
            step++;
            var pl1 = first.pop();
            var pl2 = second.pop();
            if (pl1 > pl2)
            {
                second.push(pl1);
                second.push(pl2);
            }
            else if (pl1 < pl2)
            {
                first.push(pl1);
                first.push(pl2);
            }
            else
            {
                first.push(pl1);
                second.push(pl2);
            }
        }

        if (first.isEmpty()) System.out.println("first " + step);
        else if (second.isEmpty()) System.out.println("second " + step);
        else System.out.println("botva");
    }

    public static void main(String[] args) throws Exception
    {
        var first  = new Stack<Integer>();
        var second = new Stack<Integer>();
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var input = reader.readLine();
        var splited = input.split(" ");
        for (var t : splited)
        {
            first.push(Integer.parseInt(t));
        }
        input = reader.readLine();
        splited = input.split(" ");
        for (var t : splited)
        {
            second.push(Integer.parseInt(t));
        }
        game(first, second);
        main(args);
    }
}

/*
1 9 8 3 4
5 3 7 3 1
botva
3 5 7 4 0
8 5 3 6 7
second 15
7 5 4 1 5
5 6 4 0 6
first 7
 */
