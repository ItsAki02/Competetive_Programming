class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long start = 1;
        list.add((int) start);
        for(int i = 0; i < rowIndex; i++){
            start *= (rowIndex - i);
            start /= (i + 1);
            list.add((int) start);
        }
        return list;
    }
}