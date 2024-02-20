import java.util.Arrays;

class Solution {
    public String solution(String s) {
        Object[] answer = Arrays.stream(s.split(" ")).
            mapToInt(Integer::parseInt).sorted().boxed().toArray();

        return answer[0] + " " + answer[answer.length - 1];
    }
}