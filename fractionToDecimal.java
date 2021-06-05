class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";
        StringBuilder res=new StringBuilder();
        res.append((numerator>0)^(denominator>0)?"-":"");
        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        
        // integral part
        res.append(num/denom);
        num %= denom;
        if (num==0) return res.toString();
        
        // decimal part
        res.append(".");
        Map<Long,Integer> map = new HashMap<>();
        map.put(num,res.length());
        while (num!=0) {
            num *= 10;
            res.append(num/denom);
            num %= denom;
            if (map.containsKey(num)) {
                int idx = map.get(num);
                res.insert(idx,"(");
                res.append(")");
                break;
            } else map.put(num,res.length());
        }
        return res.toString();
    }
}
