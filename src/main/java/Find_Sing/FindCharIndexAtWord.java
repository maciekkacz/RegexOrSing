package Find_Sing;

import java.util.*;

/**
 * Napisz program, który pokaże pozycje (indeksy) poszczególnych liter w napisie i
 * wydrukuje ich zestawienie. Przykładowy wynik dla napisu "Hello World":
 * {d=[9], o=[4, 6], r=[7], W=[5], H=[0], l=[2, 3, 8], e=[1]}
 */
public class FindCharIndexAtWord {

    public static void main(String[] args) {
        System.out.println("Prosze podac wyraz do analizy: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        //klucz to litera
        //wartosc to lista indeksow, gdzie wystepuje dana litera
        Map<Character, Set<Integer>> lettersMap = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(lettersMap.containsKey(c)) {
                Set<Integer> charPositions = lettersMap.get(c);
                charPositions.add(i);
                //lettersMap.put(c, charPositions); //nie trzeba bo mamy referencje
            }
            else {
                Set<Integer> charPositions = new HashSet<>();
                charPositions.add(i);
                lettersMap.put(c, charPositions);
            }
        }

        //wyswietlic informacje
        System.out.println(lettersMap);

    }

}
